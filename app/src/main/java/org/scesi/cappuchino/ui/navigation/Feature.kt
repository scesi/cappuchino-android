package org.scesi.cappuchino.ui.navigation

import kotlinx.serialization.Serializable

sealed class NavFeature {
    @Serializable
    object Home : NavFeature()

    @Serializable
    object Settings : NavFeature()

    @Serializable
    object About : NavFeature()

    @Serializable
    object More : NavFeature()

    @Serializable
    object Schedule : NavFeature()
}
