package com.careworkstech.movietix

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import spock.lang.Specification

@Build([Movie])
@TestFor(MovieController)
class MovieControllerSpec extends Specification {

    def "show should return map with movie object given movie" () {
        given: "persisted movie object"
            Movie movie = Movie.build(title: "Duplo Batman").save(flush: true)

        when: "show is invoked with the movie object"
            def result = controller.show(movie)

        then: "a map is returned with the movie object as a value"
            assertEquals(movie, result['movie'])
    }
}
