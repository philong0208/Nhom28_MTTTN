(function ($) {
    "use strict";
    $.fn.menumaker = function (options) {

        var nav = $(this),

            settings = $.extend({
                format: "dropdown",
                sticky: false
            }, options);

        return this.each(function () {

            $(this).find(".navbar-toggler").on('click', function () {
                $(this).toggleClass('menu-opened');
                var mainmenu = $(this).next('ul');
                if (mainmenu.hasClass('open')) {
                    mainmenu.slideToggle().removeClass('open');
                } else {
                    mainmenu.slideToggle().addClass('open');
                    if (settings.format === "dropdown") {
                        mainmenu.find('ul').show();
                    }
                }
            });

            nav.find('.navbar-nav li ul').parent().addClass('has-sub');
            nav.find('.navbar-nav li ul li').parent().addClass('sub-menu');
            var multiTg = function () {

                // For First Level
                nav.find(".has-sub").prepend('<span class="submenu-button"></span>');
                nav.find('.navbar-nav > li.has-sub > .submenu-button').on('click', function () {
                    $(this).next('.sub-menu').slideToggle();
                    $(this).siblings('ul').addClass('open').slideToggle();
                    $(this).parents('.navbar-nav > li.has-sub').toggleClass('active').siblings('.has-sub').children('.sub-menu').slideUp().removeClass('open').parents('li').removeClass('active');
                });

                // For Second Level
                nav.find('.sub-menu > li.has-sub > .submenu-button').on('click', function () {
                    $(this).next('.sub-menu').slideToggle();
                    $(this).siblings('ul').addClass('open').slideToggle();
                    $(this).parents('.sub-menu > li').toggleClass('active').siblings('.has-sub').children('.sub-menu').slideUp().removeClass('open').parents('li').removeClass('active');
                    if ($(this).siblings('ul').hasClass('open')) {
                        $(this).parents('li').eq(1).addClass('active');
                    }
                });

            };

            if (settings.format === 'multitoggle') multiTg();
            else nav.addClass('dropdown');
            if (settings.sticky === true) nav.css('position', 'fixed');
            var resizeFix = function () {
                var mediasize = 991;
                if ($(window).width() > mediasize) {
                    nav.find('ul').show();
                }
            };

            resizeFix();
            return $(window).on('resize', resizeFix);

        });
    };

    function initMenu() {
        $("nav").menumaker({
            format: "multitoggle"
        });

        /*------------------------------------
            Menu Selector
        --------------------------------------*/

        var urlparam = window.location.pathname.split('/');
        var menuselctor = window.location.pathname;
        if (urlparam[urlparam.length - 1].length > 0) menuselctor = urlparam[urlparam.length - 1];
        else menuselctor = urlparam[urlparam.length - 2];
        $('.navbar-nav li').find('a[href="' + menuselctor + '"]').closest('li').addClass('active').parents().eq(1).addClass('current');
        $('.navbar-nav li.has-sub ul li').find('a[href="' + menuselctor + '"]').parents().eq(4).addClass('current');
    }

    $(document).ready(function () {
        // Make API call to retrieve menus
        $.ajax({
            url: "/api/admin/menu",
            method: "GET",
            dataType: "json",
            success: function (response) {
                // Handle the API response and render menus in HTML
                renderHeaderMenus(response);
                renderFooterMenus(response);
            },
            error: function (error) {
                console.log("Error occurred: ", error);
            }
        });
    });

    function renderHeaderMenus(menus) {
        var menuContainer = $("#nav");
        const HEADER = 1;
        menuContainer.html("");

        // Loop through each menu item
        $.each(menus, function (index, menu) {
            if (menu.position !== HEADER) return
            const hasSub = menu.children && menu.children.length > 0
            var menuItem = $("<li>").addClass(hasSub ? "has-sub" : "");
            var menuTitle = $("<a>").text(menu.name).attr("href", menu.url === "" ? "#" : menu.url);
            if (menu.newTab === true) {
                menuTitle.attr("target", "_blank");
            }
            if (hasSub) {
                menuItem.append("<span class='submenu-button'></span>");
            }
            menuItem.append(menuTitle);

            // Check if menu has children
            if (hasSub) {
                var submenuContainer = $("<ul>").addClass("submenu");
                // Loop through each submenu item
                $.each(menu.children, function (subIndex, submenu) {
                    if (submenu.position !== HEADER) return
                    var submenuItem = $("<li>");
                    var submenuLink = $("<a>").attr("href", submenu.url).attr("target", "_blank").text(submenu.name);
                    if (submenu.newTab === true) {
                        submenuLink.attr("target", "_blank");
                    }
                    submenuItem.append(submenuLink);
                    submenuContainer.append(submenuItem);
                });

                menuItem.append(submenuContainer);
            }
            menuContainer.append(menuItem);
        });
        initMenu()
    }

    function renderFooterMenus(menus) {
        let firstRowFooter = $("#f-menu");
        const FOOTER = 2;
        let menuItems = []
        let row
        let kIndex = 0
        // Loop through each menu item
        $.each(menus, function (index, menu) {
            if (menu.position !== FOOTER) return
            kIndex++
            let submenuContainer = $("<div></div>")
            // Check if menu has children
            if (menu.children && menu.children.length > 0) {
                submenuContainer = $("<ul>").addClass("footer-list no-margin-bottom");
                // Loop through each submenu item
                $.each(menu.children, function (subIndex, submenu) {
                    if (submenu.position !== FOOTER) return
                    var submenuItem = $("<li>");
                    var submenuLink = $("<a>").addClass('font-size14').attr("href", submenu.url).text(submenu.name);
                    if (submenu.newTab === true) {
                        submenuLink.attr("target", "_blank");
                    }
                    submenuItem.append(submenuLink);
                    submenuContainer.append(submenuItem);
                });
            }
            let menuItem = `<div class="col-lg-3 col-sm-6 sm-margin-25px-bottom mobile-margin-20px-bottom">
                    <div class="padding-70px-left md-padding-50px-left sm-no-padding-left">
                        <h4 class="mobile-margin-10px-bottom">` + menu.name + `</h4>
                         ` + submenuContainer.html() + `
                    </div>
                </div>`
            menuItems.push(menuItem)
            if (kIndex <= 2) {
                // for first row -> only 2 columns +  2 column default
                firstRowFooter.html("")
                for (let i = 0; i < menuItems.length ; i++) {
                    firstRowFooter.append(menuItems[i])
                }
               setTimeout(function (){  firstRowFooter.replaceWith(firstRowFooter.contents()); }, 0)
            }
            if (kIndex === 2){
                row = $("<div>").addClass("row")
                menuItems = []
            }
        });
        if (kIndex > 2) {
            row.append(menuItems.join(""));
            $("#footer-menu").append(row);
        }
    }

    /*------------------------------------
            Toggle Search
    --------------------------------------*/

    $(".navbar-default .attr-nav").each(function () {
        $("li.search > a", this).on("click", function (e) {
            e.preventDefault();
            $(".top-search").slideToggle();
        });
    });

    $(".input-group-addon.close-search").on("click", function () {
        $(".top-search").slideUp();
    });

})(jQuery);
