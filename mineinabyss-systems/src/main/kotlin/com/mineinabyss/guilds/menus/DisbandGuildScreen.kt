package com.mineinabyss.guilds.menus

import androidx.compose.runtime.Composable
import com.mineinabyss.guiy.components.Spacer
import com.mineinabyss.guiy.layout.Row
import com.mineinabyss.guiy.modifiers.Modifier
import com.mineinabyss.guiy.modifiers.clickable
import com.mineinabyss.guiy.modifiers.size
import com.mineinabyss.guiy.nodes.InventoryCanvasScope.at
import com.mineinabyss.helpers.TitleItem
import com.mineinabyss.mineinabyss.extensions.deleteGuild
import org.bukkit.ChatColor

@Composable
fun GuildUIScope.GuildDisbandScreen() {
    Row(Modifier.at(1, 1)) {
        ConfirmButton()
        Spacer(width = 1)
        CancelButton()
    }

    BackButton(Modifier.at(0, 3))
}

@Composable
fun GuildUIScope.ConfirmButton(modifier: Modifier = Modifier) = Button(
    TitleItem.of("${ChatColor.GREEN}${ChatColor.BOLD}Confirm Guild Disbanding"),
    modifier.size(3, 2).clickable {
        player.deleteGuild()
        nav.reset()
    }
)

@Composable
fun GuildUIScope.CancelButton(modifier: Modifier = Modifier) = Button(
    TitleItem.of("${ChatColor.RED}${ChatColor.BOLD}Cancel Guild Disbanding"),
    modifier.size(3, 2).clickable { nav.back() }
)
