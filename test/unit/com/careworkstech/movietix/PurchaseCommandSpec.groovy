package com.careworkstech.movietix

import grails.buildtestdata.mixin.Build
import spock.lang.Specification

@Build([Showtime])

class PurchaseCommandSpec extends Specification {
    def 'validate should enforce max value for numberOfTickets relative to seatsAvailable for showtime' () {
        given: 'showtime with 10 seats available and PurhaseCommand asking for 20 tickets'
            Showtime showtime = Showtime.build(seatsAvailable: 10).save(flush:true)
            PurchaseCommand command = new PurchaseCommand(showtimeId: showtime.id, numberOfTickets: 20)

        when: 'validate is invoked on the PurchaseCommand'
            def errors = command.validate()

        then: 'errors are returned'
            assert(errors != null)
    }
}
