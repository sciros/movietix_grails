// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree jquery-ui
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
                $(this).fadeOut();
        });


        function setSizes() {
            windowHeight = $(window).height();
            $("#content").height(windowHeight - 100);
        }

        $(window).resize(setSizes());
        setSizes();

        $(".title").first().addClass("ui-corner-top");
        $(".table").first().addClass("ui-corner-top");
        var tableHeaders = $(".table th");
        tableHeaders.each(function(index) {
            $(this).addClass("ui-state-hover");
        });
        tableHeaders.first().addClass("ui-corner-tl");
        tableHeaders.last().addClass("ui-corner-tr");
        $(".table td").each(function(index) {
            $(this).addClass("ui-widget-content");
        });
        $("input:submit, button").button();
        $("a[class='button']").button();
    })(jQuery);
}
