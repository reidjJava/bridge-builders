package me.reidj.bridgebuilders.map

import me.reidj.bridgebuilders.data.Block
import org.bukkit.Material.*

enum class MapType(
    val title: String,
    var blocks: Set<Block>,
    var needBlocks: Int,
    var length: Int,
    var height: Int
) {
    AQUAMARINE(
        "Aquamarine",
        HashSet<Block>(
            listOf(
                Block("Булыжная ограда", 1, COBBLE_WALL),
                Block("Еловый забор", 2, SPRUCE_FENCE),
                Block("Призмарин", 10, PRISMARINE),
                Block("Фиолетовая керамика", 24, STAINED_CLAY, 10),
                Block("Песчаниковые ступеньки", 42, SANDSTONE_STAIRS),
                Block("Бирюзовый бетон", 48, CONCRETE, 9),
                Block("Булыжные ступеньки", 56, COBBLESTONE_STAIRS),
                Block("Дубовые ступеньки", 84, WOOD_STAIRS),
                Block("Еловые доски", 84, WOOD, 1),
                Block("Еловые ступеньки", 116, SPRUCE_WOOD_STAIRS),
                Block("Песчаниковая плита", 130, STEP, 1),
                Block("Песок", 160, SAND),
                Block("Люк", 164, TRAP_DOOR),
                Block("Бирюзовый цемент", 216, CONCRETE_POWDER, 9),
                Block("Еловая плита", 218, WOOD_STEP, 1),
                Block("Андезит", 406, STONE, 5)
            )
        ),
        1761,
        42,
        30
    ),
    BTR(
        "btr",
        HashSet<Block>(
            listOf(
                Block("Фиолетовая керамика", 10, PURPLE_GLAZED_TERRACOTTA),
                Block("Незеритовая плита", 12, STEP, 6),
                Block("Булыжник", 42, COBBLESTONE),
                Block("Тропическая плита", 42, WOOD_STEP, 3),
                Block("Люк", 68, TRAP_DOOR),
                Block("Железные прутья", 90, IRON_FENCE),
                Block("Глина", 102, CLAY),
                Block("Гравий", 106, GRAVEL),
                Block("Булыжная плита", 124, STEP, 3),
                Block("Булыжные ступеньки", 160, COBBLESTONE_STAIRS),
                Block("Светло-серый цемент", 322, CONCRETE_POWDER, 8),
                Block("Андезит", 452, STONE, 5),
            )
        ),
        1456,
        43,
        30
    )
}