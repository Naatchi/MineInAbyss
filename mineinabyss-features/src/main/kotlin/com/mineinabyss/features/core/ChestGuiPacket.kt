package com.mineinabyss.features.core

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import com.comphenix.protocol.wrappers.WrappedChatComponent
import com.mineinabyss.features.abyss
import com.mineinabyss.guiy.inventory.GuiyInventoryHolder

class ChestGuiPacket : PacketAdapter(
    abyss.plugin, ListenerPriority.LOWEST, PacketType.Play.Server.OPEN_WINDOW
) {
    //Override the normal
    override fun onPacketSending(event: PacketEvent) {
        val inventory = event.player.openInventory.topInventory
        if (inventory.holder is GuiyInventoryHolder) return

        event.packet.chatComponents.write(
            0, WrappedChatComponent.fromText(
                ":space_-11::vanilla_chest_${inventory.size / 9}::space_-170:${event.player.openInventory.originalTitle}"
            )
        )
    }
}
