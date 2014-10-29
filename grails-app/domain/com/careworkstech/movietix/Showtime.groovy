package com.careworkstech.movietix

class Showtime {
    String time
    Integer seatsAvailable
    Integer ticketsSold

    static belongsTo = [movie: Movie, theater: Theater]

    static constraints = {
    }
}
