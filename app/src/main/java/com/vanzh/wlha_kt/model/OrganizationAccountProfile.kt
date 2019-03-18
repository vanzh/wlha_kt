package com.vanzh.wlha_kt.model

import java.io.Serializable

class OrganizationAccountProfile : Serializable {
    var id: String? = null
    var name: String? = null
    var title: String? = null
    var contextType: Int = 0
    var remark: String? = null
    var organizationAccountId: String? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var creatorId: String? = null
    var creatorName: String? = null
    var updatorId: String? = null
    var updatorName: String? = null
    var organizationId: String? = null
    var image: String? = null
    var context: String? = null
}
