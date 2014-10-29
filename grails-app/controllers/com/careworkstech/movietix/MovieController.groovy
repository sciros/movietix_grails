package com.careworkstech.movietix

import grails.transaction.Transactional

@Transactional(readOnly = true)
class MovieController {
    static defaultAction = 'listAll'

    def listAll(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [movies:Movie.list(params)]
    }
}
