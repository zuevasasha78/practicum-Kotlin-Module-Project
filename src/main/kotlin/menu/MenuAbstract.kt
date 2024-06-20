package menu

import inputMenu

abstract class MenuAbstract {

    abstract val menuTitle: String
    abstract var exitValue: Boolean
    abstract val menuActions: MutableMap<Int, () -> Unit>
    abstract val menuItems: MutableList<String>

    abstract fun fillMenu()

    fun showMenu() {
        while (!exitValue) {
            println(menuTitle)

            fillMenu()

            menuItems.forEach {
                println(it)
            }

            inputMenu(menuActions)
        }
    }

    fun exit() {
        exitValue = true
    }
}
