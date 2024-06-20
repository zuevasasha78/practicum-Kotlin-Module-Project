package menu

import model.Note

class NoteMenu(private val note: Note) : MenuAbstract() {

    override val menuTitle = "Меню \"Заметки ${note.name};, Открыть заметку:\""
    override var exitValue: Boolean = false
    override val menuActions = mutableMapOf<Int, () -> Unit>()
    override val menuItems = mutableListOf(
        "0. Вырнуться в меню \"Архив. Список заметок\"",
        "1. Отркыть заметку ${note.name}"
    )

    override fun fillMenu() {
        menuActions[0] = { exit() }
        menuActions[1] = { openNote(note) }
    }

    private fun openNote(note: Note) {
        println("Просмотр заметки:")
        println(note.name)
        println(note.text)
    }
}
