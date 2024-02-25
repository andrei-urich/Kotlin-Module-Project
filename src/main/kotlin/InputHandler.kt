import Scanner.scanner

object InputHandler {
    fun getMenuInput(menuOptions: MutableSet<Int>): Int {
        val input: Int
        println("Введите пункт меню:")
        try {
            input = scanner.nextInt()
            scanner.nextLine()
        } catch (e: Exception) {
            scanner.nextLine()
            println("Нужно ввести цифру с номером пункта меню, а не произвольный набор символов.")
            println("Попробуйте еще раз!")
            println()
            return -1
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

            if (name.isEmpty()) {
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
                    if (message.isEmpty()) {
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
}
