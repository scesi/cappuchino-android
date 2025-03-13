package org.scesi.cappuchino.data.server.models

import com.google.gson.annotations.SerializedName

data class CareerResponse (

    @SerializedName("code"     ) var code     : Int,
    @SerializedName("name"     ) var name     : String,
    @SerializedName("madeIn"   ) var madeIn   : String,
    @SerializedName("semester" ) var semester : String,
    @SerializedName("support"  ) var support  : String,
    @SerializedName("path"     ) var path     : String

)