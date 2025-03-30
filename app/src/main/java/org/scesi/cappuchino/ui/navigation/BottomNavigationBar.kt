package org.scesi.cappuchino.ui.navigation

import android.util.Log
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun BottomNavigationBar(
    bottomNavOptions: List<BottomNavBarItem> = bottomNavBarItems,
    onNavBarItemClicked : (BottomNavBarItem) -> Unit,
    selectedItemIndex: Int

) {
    NavigationBar{
        bottomNavOptions.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = selectedItemIndex == index ,
                onClick = {
                    onNavBarItemClicked(screen)
                },
                icon = {
                    Log.d("icon", "Index: $index, Selected: $selectedItemIndex, IsSelected: ${selectedItemIndex == index}")
                    Icon(
                        painter = painterResource(id = if (index == selectedItemIndex ) screen.iconSelected else screen.iconUnselected),
                        contentDescription = screen.route
                    )
                },
                label = { Text(screen.route) }
            )
        }
    }
}
