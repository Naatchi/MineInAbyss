package com.mineinabyss.npc.shopkeepers

import com.mineinabyss.idofront.commands.extensions.actions.playerAction
import com.mineinabyss.mineinabyss.core.AbyssFeature
import com.mineinabyss.mineinabyss.core.MineInAbyssPlugin
import com.mineinabyss.mineinabyss.core.commands
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bukkit.Bukkit
import org.bukkit.entity.Player

@Serializable
@SerialName("shopkeeper")
class ShopkeeperFeature : AbyssFeature {
    override fun MineInAbyssPlugin.enableFeature() {

        commands {
            mineinabyss {
                "shopkeeper"(desc = "Shopkeeper related commands") {
                    "UnfuckMobdrops"(desc = "Unfuck your mobdrops") {
                        playerAction {
                            val player = sender as Player
                            val console = Bukkit.getServer().consoleSender
                            Bukkit.dispatchCommand(console, "shopkeeper remote Mobdrop-Unfuckinator ${player.name}")
                        }
                    }
                    "OrthCoinFixer"(desc = "Fixes broken Orth Coins") {
                        playerAction {
                            val player = sender as Player
                            val console = Bukkit.getServer().consoleSender
                            Bukkit.dispatchCommand(console, "shopkeeper remote Orth-Coin-Updater ${player.name}")
                        }
                    }
                }
            }
            tabCompletion {
                when (args.size) {
                    1 -> listOf(
                        "shopkeeper"
                    ).filter { it.startsWith(args[0]) }
                    2 -> {
                        when (args[0]) {
                            "shopkeeper" -> listOf("UnfuckMobdrops", "OrthCoinFixer")
                            else -> null
                        }
                    }
                    else -> null
                }
            }
        }
    }
}
