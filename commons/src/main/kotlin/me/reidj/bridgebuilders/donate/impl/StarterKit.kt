package me.reidj.bridgebuilders.donate.impl

import dev.implario.bukkit.item.item
import me.reidj.bridgebuilders.donate.DonatePosition
import me.reidj.bridgebuilders.donate.MoneyFormatter
import me.reidj.bridgebuilders.donate.Rare
import me.reidj.bridgebuilders.user.User
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

enum class StarterKit(
    private val title: String,
    private val price: Int,
    private val rare: Rare,
    private val items: Pair<Material, Int>,
    private val lore: String,
    val content: Array<ItemStack>
) : DonatePosition {
    NONE("Отсутствует", 0, Rare.COMMON, Material.BARRIER to 1, "", arrayOf()),
    LUMBERJACK(
        "Лесоруб",
        256,
        Rare.COMMON,
        Material.IRON_AXE to 1,
        "§b  Железный топор\n§b  Кольчужный нагрудник\n§b  Яблоко х16",
        arrayOf(
            ItemStack(Material.IRON_AXE),
            ItemStack(Material.CHAINMAIL_CHESTPLATE),
            ItemStack(Material.APPLE, 16)
        )
    ),
    EXCAVATOR(
        "Землерой",
        512,
        Rare.RARE,
        Material.IRON_SPADE to 1,
        "§b  Железную лопату\n§b  Кольчужные поножи\n§b  Хлеб х16",
        arrayOf(
            ItemStack(Material.IRON_SPADE),
            ItemStack(Material.CHAINMAIL_LEGGINGS),
            ItemStack(Material.BREAD, 16)
        )
    ),
    MINER(
        "Рудокоп",
        768,
        Rare.RARE,
        Material.IRON_PICKAXE to 1,
        "§b  Железную кирку\n§b  Кольчужный шлем\n§b  Морковь х6",
        arrayOf(
            ItemStack(Material.IRON_PICKAXE),
            ItemStack(Material.CHAINMAIL_HELMET),
            ItemStack(Material.CARROT, 6)
        )
    ),
    BLACKSMITH(
        "Кузнец",
        2048,
        Rare.EPIC,
        Material.FURNACE to 1,
        "§b  Печка х2\n§b  Железная руда х16\n§b  Уголь х16\n§b  Золотой слиток х16\n§b  Алмаз х2\n§b  Жареная баранина х2",
        arrayOf(
            ItemStack(Material.FURNACE, 2),
            ItemStack(Material.IRON_ORE, 16),
            ItemStack(Material.COAL, 16),
            ItemStack(Material.GOLD_INGOT, 16),
            ItemStack(Material.DIAMOND, 2),
            ItemStack(Material.COOKED_MUTTON, 10)
        )
    ),
    COOK(
        "Повар",
        2048,
        Rare.EPIC,
        Material.BREAD to 32,
        "§b  Хлеб х32\n§b  Яблоко х32\n§b  Торт х5\n§b  Жареная баранина х16\n§b  Стейк х16",
        arrayOf(
            ItemStack(Material.BREAD, 32),
            ItemStack(Material.APPLE, 32),
            ItemStack(Material.CAKE, 5),
            ItemStack(Material.COOKED_MUTTON, 16),
            ItemStack(Material.COOKED_BEEF, 16)
        )
    ),
    HEALER(
        "Целитель",
        2048,
        Rare.EPIC,
        Material.GOLDEN_APPLE to 1,
        "§b  Зелье регенерации I х2\n§b  Зелье лечения I х3\n§b  Золотое яблоко х2\n§b  Хлеб х16",
        arrayOf(
            createPotion(PotionEffectType.REGENERATION, 60, 0, 2, "регенерации"),
            createPotion(PotionEffectType.HEAL, 0, 0, 3, "лечения"),
            ItemStack(Material.GOLDEN_APPLE, 2),
            ItemStack(Material.BREAD, 16)
        )
    ),
    ASSASSIN(
        "Ассассин",
        2048,
        Rare.EPIC,
        Material.BOW to 1,
        "§b  Зелье невидимости х2\n§b  Зелье скорости I x2\n§b  Лук\n§b  Стрелы х32\n§b  Каменный меч\n§b  Стейк х12",
        arrayOf(
            createPotion(PotionEffectType.INVISIBILITY, 15, 0, 2, "невидимости"),
            createPotion(PotionEffectType.SPEED, 60, 0, 2, "скорости"),
            ItemStack(Material.BOW),
            ItemStack(Material.ARROW, 32),
            ItemStack(Material.STONE_SWORD),
            ItemStack(Material.COOKED_BEEF, 12)
        )
    ),
    COLLECTOR(
        "Коллекционер",
        4096,
        Rare.LEGENDARY,
        Material.DIAMOND_PICKAXE to 1,
        "§b  Алмазная кирка\n§b  Алмазный топор\n§b  Алмазная лопата\n§b  Жареная баранина х16",
        arrayOf(
            ItemStack(Material.DIAMOND_PICKAXE),
            ItemStack(Material.DIAMOND_AXE),
            ItemStack(Material.DIAMOND_SPADE),
            ItemStack(Material.COOKED_MUTTON, 16)
        )
    ),
    LUCIFER(
        "Люцифер",
        4096,
        Rare.LEGENDARY,
        Material.CHAINMAIL_HELMET to 1,
        "§b  Кольчужный шлем\n§b  Кольчужный нагрудник\n§b  Кольчужные поножи\n§b  Кольчужные ботинки\n§b  Каменный меч\n§b  Золотое яблоко х2",
        arrayOf(
            ItemStack(Material.CHAINMAIL_HELMET),
            ItemStack(Material.CHAINMAIL_CHESTPLATE),
            ItemStack(Material.CHAINMAIL_LEGGINGS),
            ItemStack(Material.CHAINMAIL_BOOTS),
            ItemStack(Material.WOOD_SWORD),
            ItemStack(Material.GOLDEN_APPLE, 2)
        )
    ),
    ;

    override fun getTitle() = title

    override fun getPrice() = price

    override fun getRare() = rare

    override fun getIcon(): ItemStack {
        return item {
            type = items.first
            amount = items.second
            text(rare.with(title) + "\n\n§fРедкость: ${rare.getColored()}\n§fСтоимость: ${MoneyFormatter.texted(price)} ${if (lore == "") "" else "\n\n§fВы получите:\n$lore"}")
        }
    }

    override fun give(user: User) {
        user.stat.activeKit = this
        user.stat.donate.add(this)
    }

    override fun isActive(user: User): Boolean {
        return user.stat.activeKit == this
    }

    override fun getName() = name
}

fun createPotion(type: PotionEffectType, duration: Int, amplifier: Int, amount: Int, title: String): ItemStack {
    val potion = ItemStack(Material.SPLASH_POTION, amount)
    val potionMeta = potion.itemMeta as PotionMeta

    potionMeta.displayName = "Зелье $title"
    potionMeta.color = type.color
    potionMeta.addCustomEffect(PotionEffect(type, duration * 20, amplifier), true)
    potion.itemMeta = potionMeta

    return potion
}