package com.careworkstech.movietix

import grails.transaction.Transactional

@Transactional
class PurchaseService {
    def springSecurityService

    def processPurchase(PurchaseCommand purchaseCommand) {
        Showtime showtime = Showtime.get(purchaseCommand.showtimeId)
        showtime.seatsAvailable -= purchaseCommand.numberOfTickets
        showtime.ticketsSold += purchaseCommand.numberOfTickets
        showtime.save(failOnError: true, flush: true)

        Purchase purchase = new Purchase()
        purchase.numberOfTickets = purchaseCommand.numberOfTickets
        purchase.showtime = showtime
        purchase.user = springSecurityService.currentUser as User
        purchase.save(failOnError: true, flush: true)

        [showtime,purchase]
    }
}
