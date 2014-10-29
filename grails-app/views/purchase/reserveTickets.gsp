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

<p>
    <strong>${showtime.movie.title}</strong><br/>
    ${showtime.time} p.m. at ${showtime.theater.name}
</p>

<p>
    <g:form action="completePurchase">
        <g:hiddenField name="showtimeId" value="${showtimeId}"/>
        Number of tix: <g:textField type="number" name="numberOfTickets"/>
        <g:submitButton name="reserve-tickets" value="Continue"/>
    </g:form>
</p>
</body>


<%= form_tag finish_tix_purchase_path(@showtime), :method=>'post', :multipart => true do %>
<%= hidden_field_tag :tix, @num_tix %>
<p>You are purchasing <span class="info"><%= @num_tix %></span> ticket<%= @num_tix.to_i > 1 ? 's' : '' %>
to <span class="info"><%= @movie.name %></span> at
    <span class="info"><%= @showtime.time %> p.m.</span> at
    <span class="info"><%= @theater.name %></span>.</p>

<p>Your total comes to: <span class="info"><%= number_to_currency(@num_tix.to_i * @theater.ticket_price) %></span></p>

<a id="billingInfoAnchor" href="#" onclick="displayBillingInfo();">Purchase Tix</a>

<div id="billingInfoDiv" class="billing_info ui-corner-all">
    <span class="sub_heading">Credit Card Information</span><br/>
    <table>
        <tr>
            <td><%= label_tag "name", "Name" %></td>
            <td><%= text_field_tag :name %></td>
        </tr>
        <tr>
            <td><%= label_tag "cc_number", "CC Number" %></td>
            <td><%= text_field_tag :cc_number %></td>
        </tr>
        <tr>
            <td>Expiration</td>
            <td><%=select_month(Date.today, :add_month_numbers => true) %><%= select_year(Date.today) %></td>
        </tr>
    </table>
    <br/><span class="sub_heading">Billing Address</span><br/>
    <table>
        <tr>
            <td><%= label_tag "street_address", "Street Address" %></td>
            <td><%= text_field_tag :street_address %></td>
        </tr>
        <tr>
            <td><%= label_tag "city", "City" %></td>
            <td><%= text_field_tag :city %></td>
        </tr>
        <tr>
            <td><%= label_tag "state", "State" %></td>
            <td><%= text_field_tag :state %></td>
        </tr>
        <tr>
            <td><%= label_tag "zip", "Zip" %></td>
            <td><%= text_field_tag :zip %></td>
        </tr>
    </table>
    <%= submit_tag 'Complete Purchase' %>
</div>
<% end %>
<% end %>