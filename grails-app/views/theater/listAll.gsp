<head>
    <meta name='layout' content='main'/>
    <title>MovieTix Theaters</title>
</head>

<body>
<div class="title">Local Theaters</div>
<br/>
<div id="theaters_accordion" class="ui-accordion ui-widget ui-helper-reset">
    <g:each status="theaterIndex" var="theater" in="${theaters}">
        <h3 id="theater_heading_${theaterIndex+1}"
            class="accordion-header ui-accordion-header ui-helper-reset ui-state-default ui-accordion-icons ui-corner-all">
            <span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-e"></span>
            <a href="#" class="accordion_heading">${theater.name}</a>
        </h3>
        <div class="theater_info ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom">
            <g:link elementId="theater_showtimes_${theaterIndex+1}"
                    class="showtime_link"
                    controller="showtime"
                    action="theaterShowtimes"
                    id="${theater.id}">Click for Showtimes</g:link>
            <hr/>
            <div class="theater_now_playing">
                <span style="color:#999999">Now playing</span><br/>
                <g:each var="movie" in="${theater.retrieveMovies().sort{it.title}}">
                    ${movie.title}<br/>
                </g:each>
            </div>
            <div class="theater_info">
                ${theater.description}
            </div>
            <div class="theater_location">
                Zip Code ${theater.zip} <br/><br/>
            </div>
        </div>
    </g:each>
</div>
<br/>
</body>
