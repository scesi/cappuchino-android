package org.scesi.cappuchino.ui.navigation

import kotlinx.serialization.Serializable

object NavFeature{
    @Serializable
    object Home

    @Serializable
    object Settings

    @Serializable
    object About

    @Serializable
    object More

    @Serializable
    object Schedule
}