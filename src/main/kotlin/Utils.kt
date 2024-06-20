fun setNotEmptyInput(
    valueTitle: String,
    errorMessage: String,
    action: (String) -> Unit
) {
    var value = ""
    while (value == "") {
        println(valueTitle)
        value = scanner.nextLine()

        if (value != "") {
            action(value)
        } else {
            println(errorMessage)
        }
    }
}

fun inputMenu(menu: MutableMap<Int, () -> Unit>) {
    val input = scanner.nextLine()

    try {
        val menuIndex = input.toInt()
        if (menu[menuIndex] != null) {
            menu[menuIndex]?.invoke()
        } else {
            println("Такого пункта меню не существует.")
        }
    } catch (t: Throwable) {
        println(
            "Это не пункт меню. Пункт меню вводится в виде числа указанного напротив меню"
        )
    }
}
