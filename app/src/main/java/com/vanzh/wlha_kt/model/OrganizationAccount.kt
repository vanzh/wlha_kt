package com.vanzh.wlha_kt.model

import java.io.Serializable

class OrganizationAccount : Serializable {

    /**
     * visibility : 1
     * id : 58ae94640ab7eb74ec89a171
     * accountId : a882a250-f71b-11e6-9bfd-15b36ba89534
     * createdAt : 2017-02-23T07:51:00.460Z
     * updatedAt : 2017-02-23T07:51:00.460Z
     * organizationId : /地球村/中国/重庆市/南岸区/A小区/#staff
     */

    var visibility: Int = 0
    var id: String? = null
    var accountId: String? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var organizationId: String? = null
    var name: String? = null
    var organizationAccountProfile: OrganizationAccountProfile? = null

}
