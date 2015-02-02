package com.careworkstech.movietix

class SiteFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }

        notLogin(controller: '*', action: '*') {
            before = {
                if (controllerName != 'login' && controllerName != 'assets') {
                    def currentPage = "$request.forwardURI"
                    println currentPage
                    request.session.putAt('currentPage', currentPage)
                }
            }
        }
    }
}
