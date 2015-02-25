package com.careworkstech.movietix

import grails.transaction.Transactional

@Transactional(readOnly = true)
class MovieController {
    static defaultAction = 'listAll'

    def listAll() {
        [movies:Movie.list(sort:'title')]
    }
}
