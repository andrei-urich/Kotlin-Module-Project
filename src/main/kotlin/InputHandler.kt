import Scanner.scanner


object InputHandler {
    fun getMenuInput(menuOptions: MutableSet<Int>): Int {
        println("Введите пункт меню:")
        val uncheckedInput = scanner.nextLine()
        var input = checkTheInput(uncheckedInput)
        when (input) {
            -1 -> {
                println("Нужно ввести цифру с номером пункта меню")
                println("Попробуйте еще раз!")
                println()
                return -1
            }

            -2 -> {
                println("Нужно ввести цифру с номером пункта меню, а не набор символов.")
                println("Попробуйте еще раз!")
                println()
                return -1
            }

            else -> input = uncheckedInput.toInt()
        }
        if (menuOptions.contains(input)) {
            return input
        } else {
            println("Такого пункта в меню нет. Нужно ввести цифру, соответствующую номеру нужного вам пункта.")
            println()
            return -2
        }
    }

    fun getElementInput(label: String): Element {
        var name: String
        var message: String
        while (true) {
            println("Введите название:")
            name = scanner.nextLine()

            if (name.isBlank()) {
                println("Пустое название нельзя использовать")
                println()
            } else {
                break
            }
        }
        when (label) {
            Resources.NEW_ARCHIVE -> {
                return Archive(name)
            }

            Resources.NEW_NOTE -> {
                while (true) {
                    println("Введите текст заметки: ")
                    message = scanner.nextLine()
                    if (message.isBlank()) {
                        println("Пустое содержание нельзя использовать")
                        println()
                    } else {
                        break
                    }
                }
                return Note(name, message)
            }

            else -> return Element(name)
        }
    }

    fun checkTheInput(input: String): Int {
        val regex = "\\d+".toRegex()
        if (input.isBlank()) {
            return -1
        } else {
            if (!regex.matches(input)) {
                return -2
            } else {
                if (input.length > 1 && input.first() == '0') {
                    return -2
                } else return 1
            }
        }
    }
}

