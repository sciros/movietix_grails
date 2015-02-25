$(function() {
    var headers = $('.accordion-header');
    var contentAreas = $('.ui-accordion-content').hide();

    // add the accordion functionality
    headers.click(function() {
        var panel = $(this).next();
        var isOpen = panel.is(':visible');

        // open or close as necessary
        panel[isOpen? 'slideUp': 'slideDown']()
            // trigger the correct custom event
            .trigger(isOpen? 'hide': 'show');

        // stop the link from causing a pagescroll
        return false;
    });

    // when panels open or close, mess with them
    contentAreas.on({
        // whenever we open a panel
        show: function(){
            var link = $(this).find('.showtime_link');
            link.hide();
            setTimeout(function() { link.show(); }, 3000);
        },
        // whenever we close a panel
        hide: function(){

        }
    });
});