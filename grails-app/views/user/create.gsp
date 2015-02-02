<head>
    <meta name='layout' content='main'/>
    <title>MovieTix New Account</title>
</head>

<body>
<div class='title'>Create an Account</div>
<g:if test='${flash.message}'>
    <div class='flash'>${flash.message}</div>
</g:if>

<form action='save' method='POST' id='registrationForm' autocomplete='off'>
    <div class="form_container ui-corner-all">
        <table>
            <tr>
                <td><label for='username'>Username</label></td>
                <td><input type='text' class='text_' name='username' id='username'/></td>
                <td><g:if test="${userInstance.hasErrors()}"><g:renderErrors bean="${userInstance}" as="list" field="username"/></g:if></td>
            </tr>
            <tr>
                <td><label for='password'>Password</label></td>
                <td><input type='text' class='text_' name='password' id='password'/></td>
                <td><g:if test="${userInstance.hasErrors()}"><g:renderErrors bean="${userInstance}" as="list" field="password"/></g:if></td>
            </tr>
            <tr>
                <td><label for='passwordConfirmation'>Confirm Password</label></td>
                <td><input type='text' class='text_' name='passwordConfirmation' id='passwordConfirmation'/></td>
                <td><g:if test="${userInstance.hasErrors()}"><g:renderErrors bean="${userInstance}" as="list" field="password"/></g:if></td>
            </tr>
        </table>
    </div>
    <input name="commit" type="submit" value="Register" role="button" aria-disabled="false">
</form>
<script type='text/javascript'>
    <!--
    (function () {
        document.forms['registrationForm'].elements['j_username'].focus();
    })();
    // -->
</script>
</body>
