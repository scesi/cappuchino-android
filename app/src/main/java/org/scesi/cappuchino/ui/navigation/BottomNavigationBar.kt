package org.scesi.cappuchino.ui.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.scesi.cappuchino.R


@Composable
fun BottomNavigationBar(
    bottomNavOptions: List<BottomNavBarItem> = bottomNavBarItems,
    onNavBarItemClicked : (BottomNavBarItem) -> Unit,
    selectedItemIndex: Int

) {
    NavigationBar(
        containerColor = Color.White,
        ) {
        bottomNavOptions.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = index == selectedItemIndex,
                onClick = {
                    onNavBarItemClicked(screen)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = if (index == selectedItemIndex) screen.iconSelected else screen.iconUnselected),
                        contentDescription = screen.route,
                        modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size))
                    )
                },
                label = { Text(screen.route) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = LocalContentColor.current.copy(alpha = 0.2f),
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = LocalContentColor.current.copy(alpha = 0.2f),
                    indicatorColor = Color.White
                ),

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val selectedItemIndex = remember { mutableStateOf(0) }

    BottomNavigationBar(
        bottomNavOptions = bottomNavBarItems,
        onNavBarItemClicked = { },
        selectedItemIndex = selectedItemIndex.value
    )
}