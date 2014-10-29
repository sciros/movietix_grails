<head>
    <meta name='layout' content='main'/>
</head>

<body>
<div class="title">
    <sec:ifLoggedIn>Purchase tickets</sec:ifLoggedIn>
    <sec:ifNotLoggedIn>Showtime info</sec:ifNotLoggedIn>
</div>

<p>
    <strong>Movie:</strong>
    <span style="color: orange;">${showtime.movie.title}</span>
</p>

<p>
    <b>Playing at </b><span style="color: orange;">${showtime.theater.name}</span>
    at <span style="color: orange;">${showtime.time} p.m.</span>
</p>

<p>
    <g:if test="${showtime.seatsAvailable > 0}">
        <b>Tix available</b>
        <sec:ifLoggedIn> <!-- spring-security-redirect -->
            <g:link class="button" controller="purchase" action="startPurchaseForShowtime" id="${showtime.id}">Buy Tix</g:link>
        </sec:ifLoggedIn>
        <sec:ifNotLoggedIn>
            <g:link controller="login" params='["spring-security-redirect" : "/showtime/show/${showtime.id}"]'>Log in to buy tix</g:link>
        </sec:ifNotLoggedIn>
    </g:if>
    <g:else>
        <b>Sold out</b>
    </g:else>
</p>
</body>


