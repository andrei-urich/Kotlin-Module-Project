object Menu {
    fun showMenu(screen: Screen) {
        println(screen.label)
        for ((key, value ) in screen.menuItems) {
            println("${key}. - ${value}")
        }
        when (screen) {
            is ArchivesListScreen, is NotesListScreen -> {
                InputHandler.getMenuInput(screen)}
            is OpenNoteScreen -> return
        }
} }




