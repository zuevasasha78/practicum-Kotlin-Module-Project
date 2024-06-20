import menu.ArchiveListMenu
import java.util.Scanner

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {

    println("Программа для хранения заметок")
    println("Важно! Для перемещения по пунктам меню использует цифру указанную напротив пункта меню")

    ArchiveListMenu.showMenu()
}
