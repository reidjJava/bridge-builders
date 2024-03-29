package me.reidj.bridgebuilders.user

import me.func.mod.Anime
import me.func.mod.conversation.ModTransfer
import me.func.mod.ui.Glow
import me.func.mod.world.Banners
import me.func.protocol.data.color.GlowColor
import me.func.protocol.data.element.Banner
import me.reidj.bridgebuilders.data.Stat
import me.reidj.bridgebuilders.getRequiredExperience
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import ru.cristalix.core.formatting.Color
import ru.cristalix.core.formatting.Formatting

/**
 * @project : BridgeBuilders
 * @author : Рейдж
 **/
class User(stat: Stat) {

    var stat: Stat

    var cachedPlayer: Player? = null
    var team: Color? = null
    var inventory: Inventory? = null

    var isArmLock = false
    var isTeleportAvailable = false
    var inGame = false
    var isGod = false

    var collectedBlocks = 0
    var cacheKills = 0
    var exp = 0F

    var lastDamager: Player? = null

    init {
        this.stat = stat
    }

    fun giveEther(ether: Int) {
        givePureEther(ether)
    }

    fun givePureEther(ether: Int) {
        stat.ether += ether
    }

    fun getLevel() = me.reidj.bridgebuilders.getLevel(stat.exp)

    fun giveExperience(exp: Int) {
        val prevLevel = getLevel()
        givePureExperience(exp)
        ModTransfer(
            getLevel(),
            stat.exp - getRequiredExperience(getLevel() - 1),
            getRequiredExperience(getLevel()) - getRequiredExperience(getLevel() - 1)
        ).send("bridge:exp", cachedPlayer)
        if (getLevel() > prevLevel) {
            cachedPlayer?.let {
                Anime.alert(
                    it,
                    "§lПоздравляем!",
                    "Ваш уровень был повышен!\n§7$prevLevel §f ➠ §l${getLevel()}"
                )
                Glow.animate(it, .5, GlowColor.BLUE)
                if (getLevel() % 10 == 0) {
                    giveEther(512)
                    it.sendMessage(Formatting.fine("Вы получили §c512 Эфира §f за повышение уровня."))
                }
            }
        }
    }

    fun givePureExperience(exp: Int) {
        stat.exp += exp
    }

    fun updateBanner(banner: Banner, title: String) = Banners.content(
        cachedPlayer!!,
        banner,
        "§6$title\nПобед: §3${stat.wins}\nУбийств: §3${stat.kills}\nСыграно: §3${stat.games}"
    )
}