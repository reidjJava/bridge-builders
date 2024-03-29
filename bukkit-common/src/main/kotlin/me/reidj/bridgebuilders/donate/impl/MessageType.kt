package me.reidj.bridgebuilders.donate.impl

import dev.implario.bukkit.item.item
import me.reidj.bridgebuilders.data.Rare
import me.reidj.bridgebuilders.data.Rare.*
import me.reidj.bridgebuilders.donate.DonatePosition
import me.reidj.bridgebuilders.user.User
import org.bukkit.Material

/**
 * @project : BridgeBuilders
 * @author : Рейдж
 **/
enum class MessageType(
    private val title: String,
    private val ether: Int,
    private val rare: Rare,
    vararg val messages: String
) : DonatePosition {
    NONE(
        "Отсутствует",
        0,
        COMMON,
        "Игрок %e был убит игроком %k",
        "Игрок %k убил игрока %e",
        "Игрок %e попал в загробный мир"
    ),
    CHOP(
        "Отбивная",
        512,
        COMMON,
        "Игрок %e был отбит в лепёшку игроком %k",
        "Игрок %k забил до смерти игрока %e",
        "Игрок %e превратился в отбивную"
    ),
    AQUARIUM(
        "Аквариум",
        512,
        COMMON,
        "Игрок %e был утоплен в аквариуме игроком %k",
        "Игрок %k скормил рыбам игрока %e",
        "Игрока %e смыли в унитаз"
    ),
    MIDDLE_AGES(
        "Средневековье",
        512,
        COMMON,
        "Игрок %e был убит мечом %k",
        "Игрок %k победил в дуэли игрока %e",
        "Игрок %e ушёл в мир иной"
    ),
    CLEARED(
        "Замемлен",
        768,
        UNUSUAL,
        "Игрок %e был замемлен игроком %k",
        "Игрок %k подшутил над игроком %e",
        "Игрок %e неудачно пошутил и ушёл в мир иной"
    ),
    SNAKE(
        "Змея",
        768,
        UNUSUAL,
        "Игрок %e был отравлен ядом %k",
        "Игрок %k ввёл яд игроку %e",
        "Игрок %e выпил яд и ушёл в мир иной"
    ),
    KUS(
        "Кусь",
        1024,
        RARE,
        "Игрок %e был закусан до смерти игроком %k",
        "Игрок %k сделал нежный кусь игроку %e",
        "Игрок %e умер от бешенства"
    ),
    JAWS(
        "Челюсти",
        1024,
        RARE,
        "Игрок %e был съеден игроком %k",
        "Игрок %k разорвла игрока %e",
        "Игрок %e стал кормом для акул"
    ),
    EXECUTIONER(
        "Палач",
        1024,
        RARE,
        "Игрок %e был повешен игроком %k",
        "Игрок %k разрубил голову %e",
        "Игрок %e повесился"
    ),
    FORGOTTEN(
        "Забычен",
        1024,
        RARE,
        "Игрок %e был растоптан игроком %k",
        "Игрок %k затоптал игрока %e",
        "Игрок %e был забычен"
    ),
    GUILLOTINE(
        "Гильотина",
        1024,
        RARE,
        "Игрок %e был казнён игроком %k",
        "Игрок %k обезглавил игрока %e",
        "Игрок %e потерял свою голову"
    ),
    BBQ(
        "Барбекю",
        1024,
        RARE,
        "Игрок %e был изманаз в соусе игрока %k",
        "Игрок %k зажарил игрока %e",
        "Игрок %e превратился в бифштекс"
    ),
    FIRE(
        "Огонь",
        1024,
        RARE,
        "Игрок %e был сожжён заживо игроком %k",
        "Игрок %k сжёг игрока %e",
        "Игрок %e превратился в уголь"
    ),
    ASTRONAUT(
        "Космонавт",
        2048,
        EPIC,
        "Игрок %e был сбит игроком %k",
        "Игрок %k вскрыл скафандр игрока %e",
        "Игрока %e засосало в чёрную дыру"
    ),
    GALACTIC(
        "Галактический",
        2048,
        EPIC,
        "Игрок %e был превращён в космическую пыль игроом %k",
        "Игрок %k убил %e галактическим лучом",
        "Игрок %e был придавлен Астероидом"
    ),
    INSECT(
        "Насекомое",
        2048,
        EPIC,
        "Игрок %e был раздавлен игроком %k",
        "Игрок %k отрезал крылья игроку %e",
        "Игрок %e был раздавлен ботинком"
    ),
    LIFE_DRAWER(
        "Высасыватель жизни",
        2048,
        EPIC,
        "Игрок %e был разрезан пополам игроком %k",
        "Игрок %k лопнул сердце %e",
        "Игрок %e превратился в сухарь"
    ),
    BANANA(
        "Банан",
        2048,
        EPIC,
        "Игрок %e был очищен от кожуры игроком %k",
        "Игрок %k проткнул бананом игрока %e",
        "Игрок %e был разрезан на 12 частей"
    ),
    COMPUTER(
        "Компьютер",
        4096,
        LEGENDARY,
        "Игрок %e был удалён из игры игроком %k",
        "Игрок %k вырезал папку игрока %e",
        "Игрок %e был заблокирован"
    ),
    TIME_MACHINE(
        "Машина времени",
        4096,
        LEGENDARY,
        "Игрок %e был убит в прошлом и умер в настоящем от игрока %k",
        "Игрок %k уничтожил будущее игрока %e",
        "Игрок %e потерялся во времени"
    ),
    SURGEON(
        "Хирург",
        4096,
        LEGENDARY,
        "Органы %e были проданы игроком %k",
        "Игрок %k вырезал почки игрока %e",
        "Игрок %e не проснулся после операции"
    ),
    PUPPETEER(
        "Кукловод",
        4096,
        LEGENDARY,
        "Кукла ввиде игрока %e была проткнута игроком %k",
        "Игрок %k заставил игрока %e совершить суицид",
        "Игрок %e был превращён в куклу"
    ),
    JOHN_WICK(
        "Джон Уик",
        4096,
        LEGENDARY,
        "Игрок %e был застрелен из револьвера игроком %k",
        "Игрок %k проделал 30 отверстий в теле игрока %e",
        "Игрок %e погиб от кровотечения"
    ),
    LOVE(
        "Любовь",
        8192,
        MYTHIC,
        "Игрок %e был зацелован до смерти игроком %k",
        "Игрок %k не смог удержаться и засосал %e до смерти",
        "Игрок %e не смог выдержать расставания и покончил жизнь самоубийством"
    ),
    REPER(
        "Репер",
        8192,
        MYTHIC,
        "Игрок %e был забатлен до смерти игроком %k",
        "Игрок %k зарифмовал игрока %e до смерти",
        "У игрока %e случилась передозировка и он скончался"
    ),
    ENCODER(
        "Кодер",
        8192,
        MYTHIC,
        "Игрок %e был закодирован до смерти игроком %k",
        "Игрок %k закодировал %e до смерти",
        "Игрок %e был запрограммирован на самоубийство"
    ),
    ;

    override fun getTitle() = title

    override fun getDescription() = "${replaced(messages[0])}.\n${replaced(messages[1])}.\n${replaced(messages[2])}."

    private fun replaced(message: String) = message.replace("%e", "func").replace("%k", "reidj")

    override fun getEther() = ether

    override fun getCrystals() = 0

    override fun getRare() = rare

    override fun getName() = name

    override fun getTexture(): String? = null

    override fun getIcon() = item {
        type = Material.CLAY_BALL
        nbt("other", "pets1")
    }

    override fun getLevel() = 0

    override fun give(user: User) {
        user.stat.messages.add(name)
    }

    override fun isActive(user: User) = user.stat.currentMessages == name

}