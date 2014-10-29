package com.careworkstech.movietix

class TheaterController {
    static defaultAction = 'listAll'

    def listAll(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [theaters:Theater.list(params)]
    }
}
