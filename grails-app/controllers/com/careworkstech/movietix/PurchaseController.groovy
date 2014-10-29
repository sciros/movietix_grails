package com.careworkstech.movietix

class PurchaseController {
    def submitPaymentInformation () {

    }

    def processPayment (PurchaseCommand purchaseCommand) {
        Showtime showtime = Showtime.get(purchaseCommand.showtimeId)


    }
}
