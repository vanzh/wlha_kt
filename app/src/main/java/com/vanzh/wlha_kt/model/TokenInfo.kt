package com.vanzh.wlha_kt.model

import java.io.Serializable

/**
 * Created by youke on 2017/1/3.
 * 登录返回数据模型
 */
class TokenInfo : Serializable {

    /**
     * id : fTkcgv0OpmaZozgV68voVYxDcVSCJW1mKT8FRUOW9xeOIHgHV1ABW9aM3ajl39OG
     * ttl : 1209600
     * created : 2017-01-03T08:17:38.316Z
     * userId : 203308f0-bdb3-11e6-ad6e-95b9d95e3980
     */

    var id: String? = null
    var ttl: Int = 0
    var created: String? = null
    var userId: String? = null
}
