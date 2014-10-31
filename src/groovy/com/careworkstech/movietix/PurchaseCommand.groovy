package com.careworkstech.movietix

import grails.validation.Validateable

@Validateable
class PurchaseCommand {
    Integer numberOfTickets
    Long showtimeId

    static constraints = {
        showtimeId nullable: true
        numberOfTickets nullable: true, validator: { value, command ->

            value <= Showtime.get(command.showtimeId).seatsAvailable
        }
    }
}
