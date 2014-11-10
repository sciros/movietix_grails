<head>
    <meta name='layout' content='main'/>
</head>

<body>
<div class="title">This is your account</div>

<g:if test='${flash.message}'>
    <div class='flash'>${flash.message}</div>
</g:if>

<g:renderErrors bean="purchaseCommand"/>

<p>
    <strong>Purchases made:</strong><br/><br/>

    <g:each var='purchase' in="${purchases}">
        ${purchase.numberOfTickets} to ${purchase.showtime.movie.title}
        at ${purchase.showtime.theater.name} at ${purchase.showtime.time}
        <br/>
    </g:each>
</p>
</body>