package com.careworkstech.movietix

import grails.transaction.Transactional

@Transactional(readOnly = true)
class MovieController {
    static defaultAction = 'listAll'

    //retrieve one movie
    def show(Movie movie) {
        [movie:movie]
    }

    def listAll() {
        [movies:Movie.list(sort:'title')]
    }
}
