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
//                errors.rejectValue(
//                        "numberOfTickets",
//                        "purchase.numberOfTickets.validator.error",
//                        "Only ${availableSeats} seat(s) available for this showtime."
//                )
                return false
            }
            return true
        }
    }
}
