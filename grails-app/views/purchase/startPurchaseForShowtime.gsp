<head>
    <meta name='layout' content='main'/>
</head>

<body>
<div class="title">Buy Tix</div>

<g:if test='${flash.message}'>
    <div class='flash'>${flash.message}</div>
</g:if>

<g:renderErrors bean="purchaseCommand"/>

<p>
    <strong>${showtime.movie.title}</strong><br/>
    ${showtime.time} p.m. at ${showtime.theater.name}
</p>

<p>
    <g:form action="reserveTickets">
        <g:hiddenField name="showtimeId" value="${showtime.id}"/>
        <g:if test="${showtime.seatsAvailable < 1}">
            Sold out.
        </g:if>
        <g:else>
        Number of tix: <g:textField type="number" name="numberOfTickets"/>
        <g:submitButton name="reserve-tickets" value="Continue"/>
        </g:else>
    </g:form>
</p>
</body>


