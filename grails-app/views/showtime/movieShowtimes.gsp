<head>
    <meta name='layout' content='main'/>
    <title>MovieTix Showtimes</title>
</head>

<body>
<div class="title">${movie.title} : Showtimes</div>

<table class="table">
    <tr>
        <th>Theater</th>
        <th>Showtimes</th>
    </tr>
    <g:each var="theater" status="theaterIndex" in="${showtimesByTheater.keySet().sort{it.name}}">
        <tr>
            <td class="theater_name_cell">
               <g:link controller="theater" action="show" id="${theater.id}">${theater.name}</g:link>
            </td>
            <td>
                <g:each var="showtime" status="showtimeIndex" in="${showtimesByTheater[theater].sort{it.time}}">
                    <g:if test="${showtimeIndex != 0}">,</g:if>
                    <span class="<g:if test="${showtime.seatsAvailable > 0 && showtime.seatsAvailable < 10}">running_out</g:if>
                                 <g:elseif test="${showtime.seatsAvailable > 0}">available</g:elseif>
                                 <g:else>sold_out</g:else>">
                        <g:link elementId="showtime_${theaterIndex+1}_${showtimeIndex+1}" controller="showtime" action="show" id="${showtime.id}">${showtime.time}</g:link>
                    </span>
                </g:each>
            </td>
        </tr>
    </g:each>
</table>
</body>