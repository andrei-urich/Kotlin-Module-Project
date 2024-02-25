object MenuHandler {
    fun addNew(currentScreen: Screen) {
        ScreenManager.screenStack.push(currentScreen)
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
        ScreenManager.screenStack.push(currentScreen)
        when (currentScreen) {
            is ArchivesListScreen -> ElementsHandler.open(
                currentScreen.list.get(index - 2),
                currentScreen.label
            )

            is NotesListScreen -> {
                ElementsHandler.open(currentScreen.list.get(index - 2), currentScreen.label)
            }
        }
    }

    fun back(screen: Screen) {
        if (ScreenManager.screenStack.isNotEmpty()) {
            ScreenManager.showScreen(ScreenManager.screenStack.pop())
        } else {
            println("Приложение закрыто. Спасибо!")
            return
        }
    }
}