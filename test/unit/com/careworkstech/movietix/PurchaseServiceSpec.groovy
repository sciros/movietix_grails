package com.careworkstech.movietix

import grails.buildtestdata.mixin.Build
import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

@Build([Showtime,Purchase,User])
@TestFor(PurchaseService)
class PurchaseServiceSpec extends Specification {
    @Shared def mockSpringSecurityService
    @Shared User testUser

    def setup () {
        mockSpringSecurityService = Mock(SpringSecurityService)
        testUser = User.build(username: 'test_user')
        service.springSecurityService = mockSpringSecurityService
    }

    def 'processPurchase should update Showtime to reflect number of purchased tickets' () {
        given: 'a PurchaseCommand for 5 tickets to an existing Showtime'
        Showtime showtime = Showtime.build(seatsAvailable: 100, ticketsSold: 0).save(flush: true)
        PurchaseCommand command = new PurchaseCommand(numberOfTickets: 5, showtimeId: showtime.id)

        when: 'processPurchase is invoked with that command'
        service.processPurchase(command)

        then: 'the Showtime record is updated to reflect 5 tickets sold'
        mockSpringSecurityService.getCurrentUser() >> testUser
        assertEquals(95, showtime.seatsAvailable)
        assertEquals(5, showtime.ticketsSold)
    }

    def 'processPurchase should create a new Purchase record to record tickets purchased by current user' () {
        given: 'a PurchaseCommand for 5 tickets to an existing Showtime'
        Showtime showtime = Showtime.build(seatsAvailable: 100, ticketsSold: 0).save(flush: true)
        PurchaseCommand command = new PurchaseCommand(numberOfTickets: 5, showtimeId: showtime.id)

        when: 'processPurchase is invoked with that command'
        service.processPurchase(command)

        then: 'a Purchase record is created to reflect 5 tickets sold by current user'
        mockSpringSecurityService.getCurrentUser() >> testUser
        Purchase purchase = Purchase.findByShowtime(showtime)
        assertEquals(5, purchase.numberOfTickets)
        assertEquals('test_user', purchase.user.username)
    }
}