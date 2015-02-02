<head>
    <meta name='layout' content='main'/>
    <title>MovieTix Login</title>
</head>

<body>
<div class='title'>Log In</div>
<g:if test='${flash.message}'>
    <div class='flash'>${flash.message}</div>
</g:if>

<g:set var="redirect" value="${request.session.getAt('currentPage') ?: '/account'}"/>

<form action='${redirect ? postUrl+'?spring-security-redirect='+redirect : postUrl}' method='POST' id='loginForm' autocomplete='off'>
    <div class="form_container ui-corner-all">
        <table>
            <tr>
                <td><label for='username'>Login</label></td>
                <td><input type='text' class='text_' name='j_username' id='username'/></td>
            </tr>
            <tr>
                <td><label for='password'>Password</label></td>
                <td><input type='password' class='text_' name='j_password' id='password'/></td>
            </tr>
        </table>
    </div>
    <input name="commit" type="submit" value="Log in"role="button" aria-disabled="false">
</form>
<script type='text/javascript'>
    <!--
    (function () {
        document.forms['loginForm'].elements['j_username'].focus();
    })();
    // -->
</script>
</body>
