package com.example.vknewsclient.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItems(
    val title:String,
    val icon:ImageVector
) {
    object Home:NavigationItems(
        "Home",
        Icons.Outlined.Home
    )
    object Favorite:NavigationItems(
        "Favorite",
        Icons.Outlined.Favorite
    )
    object Profile:NavigationItems(
        "Profile",
        Icons.Outlined.Person
    )
}