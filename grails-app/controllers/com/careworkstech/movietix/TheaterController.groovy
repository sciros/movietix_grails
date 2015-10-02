package com.careworkstech.movietix

class TheaterController {
    static defaultAction = 'listAll'

    def listAll() {
        [theaters:Theater.list(sort:'name')]
    }
}
