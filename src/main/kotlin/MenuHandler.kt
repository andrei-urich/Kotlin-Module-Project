object MenuHandler {
    fun addNew(currentScreen: Screen) {
        ScreenStack.screenStack.push(currentScreen)
        when (currentScreen) {
            is ArchivesListScreen -> {
                ElementsHandler.addNew(currentScreen, Resources.NEW_ARCHIVE)
            }
            is NotesListScreen -> {
                ElementsHandler.addNew(currentScreen, Resources.NEW_NOTE)
            }
        }
    }

    fun open(currentScreen: Screen, index: Int) {
        ScreenStack.screenStack.push(currentScreen)
        when (currentScreen) {
            is ArchivesListScreen -> ElementsHandler.open(currentScreen.list.get(index-2), currentScreen.label)
            is NotesListScreen -> ElementsHandler.open(currentScreen.list.get(index-2), currentScreen.label)
        }
    }

    fun back() {
        if (ScreenStack.screenStack.isNotEmpty()) {
            Menu.showMenu(ScreenStack.screenStack.pop())
        } else {
            println("Приложение закрыто. Спасибо!")
            return
        }
    }
}