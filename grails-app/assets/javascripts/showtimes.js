$(".table tr").hover(function() {
        $(this).children("td[class~='movie_name_cell']").addClass("ui-state-active");
        $(this).children("td[class~='theater_name_cell']").addClass("ui-state-active");
        $(this).children("td").addClass("hover_row");
    }, function () {
        $(this).children("td[class~='movie_name_cell']").removeClass("ui-state-active");
        $(this).children("td[class~='theater_name_cell']").removeClass("ui-state-active");
        $(this).children("td").removeClass("hover_row");
    }
);
$("#billingInfoDiv").hide();
$("#billingInfoAnchor").button();