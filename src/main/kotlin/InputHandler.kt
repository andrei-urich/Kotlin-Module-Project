import java.util.*
object InputHandler {
    fun getMenuInput(screen: Screen) {
        val scanner = Scanner(System.`in`)
        var input: Int
        while (true) {
            println("Введите пункт меню:")
            while (true) {
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt()
                    break
                } else {
                    println("Нужно ввести цифру пункта, а не произвольный символ.")
                    println("Попробуйте еще раз!")
                    scanner.nextLine()
                    continue
                }
            }
            if (screen.menuItems.contains(key = input)) {
                when (input) {
                    0 -> MenuHandler.addNew(screen)
                    1 -> MenuHandler.back()
                    else -> MenuHandler.open(screen, input)
                }
                break
            } else {
                println("Нужно ввести цифру, соответствующую номеру нужного вам пункта. Без точек, без пробелов и прочих символов.")
                println("Пробуем еще раз!")
                Menu.showMenu(screen)
                scanner.nextLine()
                continue
            }
        }

        scanner.close()
    }

    fun getElementInput(label: String): Element {
        val scanner = Scanner(System.`in`)
        var name: String
        var message: String
        while (true) {
            println(label)
            println("Введите название:")
            name = scanner.nextLine()
            if (name.isEmpty()) {
                println("Пустое название нельзя использовать")
            } else {
                break
            }
        }
        when (label) {
            Resources.NEW_ARCHIVE -> return Archive(name)
            Resources.NEW_NOTE -> {
                while (true) {
                    println("Введите текст заметки: ")
                    message = scanner.nextLine()
                    if (message.isEmpty()) {
                        println("Пустое содержание нельзя использовать")
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
