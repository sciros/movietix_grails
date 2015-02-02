<%@ page import="java.text.DateFormatSymbols" %>
<head>
    <meta name='layout' content='main'/>
    <script>
        function displayBillingInfo () {
            $("#billingInfoDiv").show()
        }
    </script>
</head>

<body>
<div class="title">Confirm Your Purchase</div>

<g:if test='${flash.message}'>
    <div class='flash'>${flash.message}</div>
</g:if>

<g:renderErrors bean="purchaseCommand"/>

<p>
    You are purchasing ${numberOfTickets} ticket${numberOfTickets > 1 ? 's' : ''} to
    ${showtime.movie.title} at ${showtime.time} p.m. at ${showtime.theater.name}.
</p>

<p>
    Your total comes to
    <span class="info">
        <g:formatNumber number="${numberOfTickets * showtime.theater.ticketPrice}" type="currency" currencyCode="USD" />
    </span>
</p>

<g:form action="completePurchase">
    <a id="billingInfoAnchor" href="#" class="button" onclick="displayBillingInfo();">Purchase Tix</a>
    <g:hiddenField name="numberOfTickets" value="${numberOfTickets}"/>
    <g:hiddenField name="showtimeId" value="${showtime.id}"/>

    <div id="billingInfoDiv" class="billing_info ui-corner-all" style="display:none;">
        <span class="sub_heading">Credit Card Information</span><br/>
        <table>
            <tr>
                <td>Name</td>
                <td><g:textField id="name" name="name"/></td>
            </tr>
            <tr>
                <td>CC Number</td>
                <td><g:textField id="cc_number" name="cc_number"/></td>
            </tr>
            <tr>
                <td>Expiration</td>
                <g:set var="months" value="${new DateFormatSymbols().months}"/>
                <td>
                    <g:select id="date_month" name="date_month" from="${months as List}"/>
                    <g:select id="date_year" name="date_year" from="${2014..2024}" value="2014" />
                </td>
            </tr>
        </table>
        <br/><span class="sub_heading">Billing Address</span><br/>
        <table>
            <tr>
                <td>Street Address</td>
                <td><g:textField id="street_address" name="street_address"/></td>
            </tr>
            <tr>
                <td>City</td>
                <td><g:textField id="city" name="city"/></td>
            </tr>
            <tr>
                <td>State</td>
                <td><g:textField id="state" name="state"/></td>
            </tr>
            <tr>
                <td>Zip</td>
                <td><g:textField id="zip" name="zip"/></td>
            </tr>
        </table>
        <g:submitButton name="commit" value="Complete Purchase"/>
    </div>
</g:form>
</body>


