package menu

import model.Archive
import model.Note
import setNotEmptyInput

class ArchiveNoteListMenu(private val archive: Archive) : MenuAbstract() {

    override val menuTitle = "Меню \"Архив ${archive.name}. Список заметок:\""
    override var exitValue: Boolean = false
    override val menuItems = mutableListOf(
        "0. Создать заметку",
        "1. Вырнуться в меню \"Список архивов\""
    )
    override val menuActions = mutableMapOf<Int, () -> Unit>()

    override fun fillMenu() {
        menuActions[0] = { createNote(archive) }
        menuActions[1] = { exit() }

        if (archive.notes.isNotEmpty()) {
            archive.notes.forEachIndexed { index, note ->
                val menuItemIndex = 2 + index
                val menuItem = "${menuItemIndex}. ${note.name}"
                if (!menuItems.contains(menuItem)) menuItems.add(menuItem)

                menuActions[menuItemIndex] = { NoteMenu(note).showMenu() }
            }
        }
    }

    private fun createNote(archive: Archive) {
        println("Создание заметки:")

        var name: String? = null

        while (name == null) {
            setNotEmptyInput(
                "Введите имя заметки:",
                "Имя заметки не может быть пустым"
            ) { value: String ->
                val note = archive.notes.find { it.name == value }

                if (note != null) {
                    println("Такая заметка уже существует")
                } else {
                    name = value
                }
            }
        }

        setNotEmptyInput(
            "Введите текст заметки:",
            "Текст заметки не может быть пустым"
        ) { value: String ->
            archive.notes.add(Note(name!!, value))
        }
    }
}
