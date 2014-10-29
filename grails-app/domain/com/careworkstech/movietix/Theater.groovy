package com.careworkstech.movietix

class Theater {
    String name
    String zip
    String description
    BigDecimal ticketPrice

    static hasMany = [showtimes: Showtime]

    static constraints = {
        description maxSize: 4000
    }

    List<Movie> retrieveMovies () {
        showtimes.collect{it.movie}.unique()
    }
}
