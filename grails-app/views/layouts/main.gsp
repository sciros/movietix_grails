<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="MovieTix"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>

<body>
<header>
    <div class="login_container ui-corner-all ui-widget-content">
        <sec:ifLoggedIn>
          <g:link controller="account" id="${sec.loggedInUserInfo(field: 'id')}">My Account</g:link>
          <strong>|</strong>
          <g:link controller="logout">Logout</g:link>
          <br/>
          Welcome, ${sec.loggedInUserInfo(field: 'username')}<br/>
        </sec:ifLoggedIn>
        <sec:ifNotLoggedIn>
            <g:link controller="login" params='["spring-security-redirect" : "${request.forwardURI.substring(request.getContextPath().length())}"]'>Log In</g:link>
            <strong>|</strong>
            <g:link controller="user" action="create">Register</g:link>
        </sec:ifNotLoggedIn>
        <g:if test='${flash.message}'>
            <div class='flash'>${flash.message}</div>
        </g:if>
    </div>
</header>

<div id="content" class="ui-widget-content">
    <g:layoutBody/>
    <hr/>
    Browse

    <footer>
        <g:link controller="movie" action="listAll">Movies</g:link> |
        <g:link controller="theater" action="listAll">Theaters</g:link>
    </footer>
</div>

<asset:javascript src="application.js"/>
</body>
</html>
