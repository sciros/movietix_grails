package com.careworkstech.movietix

class Movie {
    String title
    String synopsis
    Integer runningTime
    Integer rating

    static hasMany = [showtimes: Showtime]

    static constraints = {
        synopsis maxSize: 4000
    }

    List<Theater> retrieveTheaters () {
        this.showtimes.collect{ Showtime showtime ->
            showtime.theater
        }.unique()
    }
}
