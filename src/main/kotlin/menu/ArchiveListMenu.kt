package menu

import model.Archive
import setNotEmptyInput

object ArchiveListMenu : MenuAbstract() {

    override val menuTitle: String = "Меню \"Список архивов:\""
    override var exitValue: Boolean = false
    override val menuItems = mutableListOf(
        "0. Создать архив",
        "1. Выход"
    )
    override val menuActions = mutableMapOf<Int, () -> Unit>()

    private val allArchive = mutableListOf<Archive>()

    override fun fillMenu() {
        menuActions[0] = { createArchive() }
        menuActions[1] = { exit() }

        allArchive.forEachIndexed { index, archive ->
            val menuItemIndex = 2 + index
            val menuItem = "${menuItemIndex}. ${archive.name}"
            if (!menuItems.contains(menuItem)) menuItems.add(menuItem)

            menuActions[menuItemIndex] = { ArchiveNoteListMenu(archive).showMenu() }
        }
    }

    private fun createArchive() {
        setNotEmptyInput(
            "Введите имя архива",
            "Имя архива не может быть пустым"
        ) { value: String ->
            if (value != "") {
                val archive = allArchive.find { it.name == value }

                if (archive == null) {
                    allArchive.add(Archive(value, mutableListOf()))
                } else {
                    println("Такой архив уже существует")
                }
            }
        }
    }
}
