package org.scesi.cappuchino.ui.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.scesi.cappuchino.R
import org.scesi.cappuchino.ui.theme.ContainerColor


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
                        contentDescription = stringResource(id = screen.route),
                        modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size))
                    )
                },
                label = { Text(text = stringResource(id = screen.route)) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ContainerColor,
                    unselectedIconColor = LocalContentColor.current.copy(alpha = 0.2f),
                    selectedTextColor = ContainerColor,
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