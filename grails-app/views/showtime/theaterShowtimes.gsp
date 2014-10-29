<head>
    <meta name='layout' content='main'/>
    <title>MovieTix Showtimes</title>
</head>

<body>
<div class="title">${theater.name} : Showtimes</div>

<table class="table">
    <tr>
        <th>Movie</th>
        <th>Showtimes</th>
    </tr>
    <g:each var="movie" status="movieIndex" in="${showtimesByMovie.keySet().sort{it.title}}">
        <tr>
            <td class="movie_name_cell">
                <g:link controller="movie" action="show" id="${movie.id}">${movie.title}</g:link>
            </td>
            <td>
                <g:each var="showtime" status="showtimeIndex" in="${showtimesByMovie[movie].sort{it.time}}">
                    <g:if test="${showtimeIndex != 0}">,</g:if>
                    <span class="<g:if test="${showtime.seatsAvailable > 0 && showtime.seatsAvailable < 10}">running_out</g:if>
                    <g:elseif test="${showtime.seatsAvailable > 0}">available</g:elseif>
                    <g:else>sold_out</g:else>">
                        <g:link elementId="showtime_${movieIndex+1}_${showtimeIndex+1}" controller="showtime" action="show" id="${showtime.id}">${showtime.time}</g:link>
                    </span>
                </g:each>
            </td>
        </tr>
    </g:each>
</table>
</body>