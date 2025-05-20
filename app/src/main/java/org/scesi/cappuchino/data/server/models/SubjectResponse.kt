package org.scesi.cappuchino.data.server.models

import com.google.gson.annotations.SerializedName

data class SubjectResponse (

    @SerializedName("madeIn"     ) var madeIn    : String?           = null,
    @SerializedName("semester"   ) var semester  : String?           = null,
    @SerializedName("support"    ) var support   : String?           = null,
    @SerializedName("path"       ) var path      : String?           = null,
    @SerializedName("code"       ) var code      : Int?              = null,
    @SerializedName("name"       ) var name      : String?           = null,
    @SerializedName("url"        ) var url       : String?           = null,
    @SerializedName("updatet_at" ) var updatetAt : String?           = null,
    @SerializedName("levels"     ) var levels    : ArrayList<LevelsResponse> = arrayListOf()
)
data class LevelsResponse (

    @SerializedName("code"     ) var code     : String?             = null,
    @SerializedName("subjects" ) var subjects : ArrayList<SubjectsResponse> = arrayListOf()

)

data class SubjectsResponse (

    @SerializedName("code"   ) var code   : Int?              = null,
    @SerializedName("name"   ) var name   : String?           = null,
    @SerializedName("groups" ) var groups : ArrayList<GroupsResponse> = arrayListOf()
)
data class GroupsResponse (

    @SerializedName("code"     ) var code     : String?             = null,
    @SerializedName("schedule" ) var schedule : ArrayList<ScheduleResponse> = arrayListOf(),
    @SerializedName("teacher"  ) var teacher  : String?             = null
)

data class ScheduleResponse (

    @SerializedName("day"      ) var day      : String?  = null,
    @SerializedName("start"    ) var start    : String?  = null,
    @SerializedName("end"      ) var end      : String?  = null,
    @SerializedName("duration" ) var duration : Int?     = null,
    @SerializedName("room"     ) var room     : String?  = null,
    @SerializedName("teacher"  ) var teacher  : String?  = null,
    @SerializedName("isClass"  ) var isClass  : Boolean? = null
)

