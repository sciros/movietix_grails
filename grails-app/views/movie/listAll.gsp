<head>
    <meta name='layout' content='main'/>
    <title>MovieTix Now Playing</title>
</head>

<body>
<div class="title">Now Playing</div>
<br/>
<div id="movies_accordion">
    <g:each status="movieIndex" var="movie" in="${movies}">
        <h3 id="movie_heading_${movieIndex+1}">
            <a href="#" class="accordion_heading">${movie.title}</a>
        </h3>
        <div>
            <g:link elementId="movie_showtimes_${movieIndex+1}"
                    class="showtime_link"
                    controller="showtime"
                    action="movieShowtimes"
                    id="${movie.id}">Click for Showtimes</g:link>
            <hr/>
            <div class="movie_now_playing">
                <span style="color:#999999">Now playing at</span><br/>
                <g:each var="theater" in="${movie.retrieveTheaters()}">
                    ${theater.name}<br/>
                </g:each>
            </div>
            <div class="movie_synopsis">
                ${movie.synopsis}
            </div>
            <div class="movie_info">
                Running time: ${movie.runningTime} min<br/>
                Rating: <g:each var="star" in="${ (0..<movie.rating) }">*</g:each>
            </div>
        </div>
    </g:each>
</div>
<br/>
</body>
