package com.careworkstech.movietix

import grails.validation.Validateable

@Validateable
class PurchaseCommand {
    Integer numberOfTickets
    Long showtimeId

    static constraints = {
        numberOfTickets validator: { value, command ->
            value <= Showtime.get(showtimeId).seatsAvailable
        }
    }
}
