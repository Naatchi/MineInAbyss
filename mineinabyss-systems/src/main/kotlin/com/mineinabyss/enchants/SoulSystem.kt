package com.mineinabyss.enchants

import com.mineinabyss.geary.ecs.api.entities.with
import com.mineinabyss.geary.ecs.api.systems.TickingSystem
import com.mineinabyss.geary.ecs.engine.iteration.QueryResult
import com.mineinabyss.geary.ecs.entities.parent
import com.mineinabyss.geary.minecraft.components.Soulbound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class SoulSystem : TickingSystem() {
    private val QueryResult.soul by get<Soulbound>()
    private val QueryResult.item by get<ItemStack>()

    override fun QueryResult.tick() {
        //TODO generalize for all enchants
        entity.parent?.with { player: Player ->
            if (soul.owner != player.uniqueId && item.containsEnchantment(CustomEnchants.SOULBOUND)) {
                item.removeEnchantment(CustomEnchants.SOULBOUND)
            }
            if (soul.owner == player.uniqueId && !item.containsEnchantment(CustomEnchants.SOULBOUND)) {
                item.addCustomEnchant(
                    CustomEnchants.SOULBOUND,
                    1,
                    "to ${soul.ownerName}"
                )
            }

            item.updateEnchantmentLore(
                CustomEnchants.SOULBOUND,
                1,
                "to ${soul.ownerName}"
            )
        }
    }
}
