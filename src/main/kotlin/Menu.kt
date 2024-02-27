class Menu {
    fun showMenu(screen: Screen) {
        println(screen.label)
        for ((key, value) in screen.menuItems) {
            println("${key}. - ${value}")
        }
        println()
        if (screen is OpenNoteScreen) {
            println(screen.noteMessage)
            println()
        }
    }

    fun getMenuOptions(screen: Screen): Int {
        var menuOption = InputHandler.getMenuInput(screen.menuItems.keys)
        while (menuOption == -1 || menuOption == -2) {
            showMenu(screen)
            menuOption = InputHandler.getMenuInput(screen.menuItems.keys)
        }
        return menuOption
    }
}




