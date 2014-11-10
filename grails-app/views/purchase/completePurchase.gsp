<head>
    <meta name='layout' content='main'/>
</head>

<body>
<div class="title">You got tix!</div>

<g:if test='${flash.message}'>
    <div class='flash'>${flash.message}</div>
</g:if>

<g:renderErrors bean="purchaseCommand"/>

<p>
    ${numberOfTickets} to <strong>${showtime.movie.title}</strong> at
    ${showtime.time} p.m. at ${showtime.theater.name}
</p>
</body>