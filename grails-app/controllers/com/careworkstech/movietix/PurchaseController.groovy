package com.careworkstech.movietix

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class PurchaseController {
    def purchaseService

    def completePurchase (PurchaseCommand purchaseCommand) {
        def showtime, purchase = purchaseService.processPurchase(purchaseCommand)

        [showtime: showtime, numberOfTickets: purchase.numberOfTickets]
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
