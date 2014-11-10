package com.careworkstech.movietix

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class AccountController {
    def index (User user) {
        List<Purchase> purchases = Purchase.findAllByUser(user)

        [user: user, purchases: purchases]
    }
}
