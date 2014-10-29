import com.careworkstech.movietix.Movie
import com.careworkstech.movietix.Role
import com.careworkstech.movietix.Showtime
import com.careworkstech.movietix.Theater
import com.careworkstech.movietix.User
import com.careworkstech.movietix.UserRole

class BootStrap {

    def init = { servletContext ->
        createUsers()

        List<Movie> movies = createMovies()

        List<Theater> theaters = createTheaters()

        createShowtimes(movies, theaters)
    }

    def destroy = {
    }

    void createUsers () {
        def userRole = new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

        def user1 = new User(
                username: 'user1',
                password: 'P4ssw0rd',
                enabled: true).save(failOnError: true)

        def adminUser = new User(
                username: 'admin',
                password: 'P4ssw0rd',
                enabled: true).save(failOnError: true)

        UserRole.create user1, userRole
        UserRole.create adminUser, adminRole
    }

    List<Movie> createMovies () {
        String revengersSynopsis = 'When a malicious entity with dubious motivations threatens Earth with epic CG explosions, an unlikely band of heroes teams up to shatter previous box-office records.'
        String arachnidmanSynopsis = 'When Harry Horker got bitten by a radioactive spider, he had no idea that he\'d grow four more arms, six more eyes, and spin webbing from somewhere in his nether regions. And that because this made him hideous rather than cool looking, he\'d have to play the villain against the more visually appealing Geckoman in an epic role-reversal. But like Harry\'s uncle once said, \'With a great number of limbs comes great responsibility.\''
        String twoDArraySynopsis = 'Ted thinks he has it all figured out, hacking his way through rubbish movie ticketing sites all day long, right up until he hacks the wrong one and ends up being chased by goons in nice suits and cool shades. That\'s when an idiot tells him that the real world isn\'t actually real, but is something called the 2D Array which is created by robots to fool humans into remaining perpetually asleep while these robots spoon with the humans for warmth.'
        String hungryGamesSynopsis = 'Ripped off a Japanese story about kids having to eat bizarre sushi, this is a tale of a dystopian future where colonies find the hungriest, craziest kids they can to enter into a hot dog eating contest. The losers get turned into hot dogs to be used for future contests.'
        String gameOfChairsSynopsis = 'In a world where a giant wall is all that separates the civilized world from beings that raise the undead, where dragons are returning to burn kingdoms to ashes, where a decade-long winter threatens to wipe out half of the population, the biggest concern is to show the audience as much nudity as physically possible.'

        Movie movie1 = new Movie(title: 'The Revengers', runningTime: 135, rating: 2, synopsis: revengersSynopsis).save(failOnError: true)
        Movie movie2 = new Movie(title: 'Arachnidman', runningTime: 110, rating: 3, synopsis: arachnidmanSynopsis).save(failOnError: true)
        Movie movie3 = new Movie(title: 'The 2D Array', runningTime: 120, rating: 2, synopsis: twoDArraySynopsis).save(failOnError: true)
        Movie movie4 = new Movie(title: 'The Hungry Games', runningTime: 90, rating: 1, synopsis: hungryGamesSynopsis).save(failOnError: true)
        Movie movie5 = new Movie(title: 'Game of Chairs', runningTime: 115, rating: 4, synopsis: gameOfChairsSynopsis).save(failOnError: true)

        [movie1,movie2,movie3,movie4,movie5]
    }

    List<Theater> createTheaters () {
        String abc24Description = 'This theater boasts 24 screens, stadium seating, and eye-watering concession prices. It has an IMAX screen, although you can barely tell. It also shows 3D movies if you\'re in the mood for spending more money in return for severely reduced image brightness and the opportunity to put some extra strain on your eyes. Most of the new releases play here.'
        String rage18Description = 'Rage is a relatively new theater, using higher-quality projectors than most others. Their seats aren\'t that comfortable, though, and the screens are quite small. Also there\'s frequently an automobile in the theater lobby for some contest or other.'
        String abc30Description = 'This theater has a weird concessions area where you gather everything and then check out at a register the way you would at a cafeteria. But it has booze, which gives it an edge over others. It also has 30 screens, one of which is an IMAX.'
        String studio36Description = 'A gathering place for hipsters and Big Leboswki fans, this theater is a relic from the 1700s, when movies were just drawings on paper that people would quickly thumb through to create the illusion of animation. It serves alcohol and has just one screen. For some reason, the floor of the theater tilts down as you get further from the screen rather than up.'

        Theater theater1 = new Theater(name: 'ABC IMAX 24', zip: '43210', description: abc24Description, ticketPrice: 9.00).save(failOnError: true)
        Theater theater2 = new Theater(name: 'Rage Motion Pictures 18', zip: '43240', description: rage18Description, ticketPrice: 8.00).save(failOnError: true)
        Theater theater3 = new Theater(name: 'ABC IMAX 30', zip: '43219', description: abc30Description, ticketPrice: 9.00).save(failOnError: true)
        Theater theater4 = new Theater(name: 'Studio 36', zip: '43209', description: studio36Description, ticketPrice: 5.00).save(failOnError: true)

        [theater1,theater2,theater3,theater4]
    }

    void createShowtimes (List<Movie> movies, List<Theater> theaters) {
        new Showtime(movie: movies[0], theater: theaters[0], time: '6:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[0], theater: theaters[0], time: '9:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[1], theater: theaters[0], time: '4:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[1], theater: theaters[0], time: '6:30', seatsAvailable: 0, ticketsSold: 300).save(failOnError: true)
        new Showtime(movie: movies[1], theater: theaters[0], time: '9:00', seatsAvailable: 2, ticketsSold: 298).save(failOnError: true)
        new Showtime(movie: movies[2], theater: theaters[0], time: '6:00', seatsAvailable: 1, ticketsSold: 299).save(failOnError: true)
        new Showtime(movie: movies[2], theater: theaters[0], time: '8:30', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[3], theater: theaters[0], time: '5:30', seatsAvailable: 0, ticketsSold: 300).save(failOnError: true)
        new Showtime(movie: movies[3], theater: theaters[0], time: '7:30', seatsAvailable: 0, ticketsSold: 300).save(failOnError: true)
        new Showtime(movie: movies[4], theater: theaters[0], time: '9:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[0], theater: theaters[1], time: '6:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[0], theater: theaters[1], time: '8:30', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[0], theater: theaters[1], time: '11:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[1], theater: theaters[1], time: '5:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[1], theater: theaters[1], time: '8:00', seatsAvailable: 0, ticketsSold: 300).save(failOnError: true)
        new Showtime(movie: movies[2], theater: theaters[1], time: '5:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[2], theater: theaters[1], time: '7:30', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[2], theater: theaters[1], time: '10:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[3], theater: theaters[1], time: '4:30', seatsAvailable: 0, ticketsSold: 300).save(failOnError: true)
        new Showtime(movie: movies[3], theater: theaters[1], time: '6:30', seatsAvailable: 5, ticketsSold: 295).save(failOnError: true)
        new Showtime(movie: movies[3], theater: theaters[1], time: '8:30', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[0], theater: theaters[2], time: '6:15', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[0], theater: theaters[2], time: '9:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[1], theater: theaters[2], time: '5:30', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[1], theater: theaters[2], time: '8:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[1], theater: theaters[2], time: '10:30', seatsAvailable: 0, ticketsSold: 300).save(failOnError: true)
        new Showtime(movie: movies[2], theater: theaters[2], time: '7:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[2], theater: theaters[2], time: '10:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[3], theater: theaters[2], time: '5:00', seatsAvailable: 0, ticketsSold: 300).save(failOnError: true)
        new Showtime(movie: movies[3], theater: theaters[2], time: '7:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[3], theater: theaters[2], time: '9:00', seatsAvailable: 0, ticketsSold: 300).save(failOnError: true)
        new Showtime(movie: movies[2], theater: theaters[3], time: '6:45', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[4], theater: theaters[3], time: '6:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
        new Showtime(movie: movies[4], theater: theaters[3], time: '9:00', seatsAvailable: 300, ticketsSold: 0).save(failOnError: true)
    }
}
