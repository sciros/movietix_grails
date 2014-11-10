package com.careworkstech.movietix

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.validation.ObjectError

@Secured(['ROLE_USER'])
class PurchaseController {
    def springSecurityService

    def completePurchase (PurchaseCommand purchaseCommand) {
        Showtime showtime = Showtime.get(purchaseCommand.showtimeId)
        showtime.seatsAvailable -= purchaseCommand.numberOfTickets
        showtime.ticketsSold += purchaseCommand.numberOfTickets
        showtime.save(failOnError: true, flush: true)

        Purchase purchase = new Purchase()
        purchase.numberOfTickets = purchaseCommand.numberOfTickets
        purchase.showtime = showtime
        purchase.user = springSecurityService.currentUser as User
        purchase.save(failOnError: true, flush: true)
    }

    def startPurchaseForShowtime (Showtime showtime) {
        [showtime: showtime]
    }

    def reserveTickets (PurchaseCommand purchaseCommand) {
        Showtime showtime = Showtime.get(purchaseCommand.showtimeId)
        if (purchaseCommand.hasErrors()) {
            flash.message = "Sorry, there are only ${showtime.seatsAvailable} tickets available for this showtime."
            redirect action: 'startPurchaseForShowtime', id: purchaseCommand.showtimeId
        } else {
            [showtime: showtime, numberOfTickets: purchaseCommand.numberOfTickets]
        }
    }
}
