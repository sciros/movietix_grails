package com.careworkstech.movietix

import grails.validation.Validateable

@Validateable
class PurchaseCommand {
    Integer numberOfTickets
    Long showtimeId

    static constraints = {
        numberOfTickets nullable: true, validator: { value, command ->
            Integer availableSeats = Showtime.get(command.showtimeId).seatsAvailable
            if (value > availableSeats) {
                return false
            }
            return true
        }
    }
}
//testing pull request template
