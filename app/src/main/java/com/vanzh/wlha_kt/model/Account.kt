package com.vanzh.wlha_kt.model

import java.io.Serializable
import java.util.*

/**
 * 账户模型
 */
class Account : Serializable {

    var id: String? = null
    var mobile: String? = null
    var mobileVerified: Boolean? = null
    var name: String? = null
    var username: String? = null
    var email: String? = null
    var defaultOrganizationId: String? = null
    var realm: String? = null
    var isEmailVerified: Boolean? = null
    var status: String? = null
    var clientId: String? = null
    var image: String? = null
    var certificateLicense: ArrayList<String>? = null
    var visibility: String? = null
    var location: String? = null
    var defaultContactId: String? = null
    var password: String? = null
    var isCustomer: Boolean? = null
    var roles: List<String>? = null
    var defaultOrganization: OrganizationAccount? = null
}