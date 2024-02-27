object ElementsHandler {
    fun addNew(screen: Screen, label: String) {
        when (screen) {
            is ArchivesListScreen -> {
                val newArchive = InputHandler.getElementInput(label) as Archive
                println("Добавлен новый архив ${newArchive.name}")
                println()
                screen.list.add(newArchive)
            }

            is NotesListScreen -> {
                val newNote = InputHandler.getElementInput(label) as Note
                println("Добавлена новая заметка ${newNote.name}")
                println()
                screen.list.add(newNote)
            }
        }
        screen.updateMenuItems()

        ScreenManager.showScreen(ScreenManager.screenStack.pop())

    }

    fun open(element: Element, label: String) {
        when (label) {
            Resources.ARCHIVES -> {
                val newScreen =
                    NotesListScreen((Resources.NOTES + element.name), element as Archive)
                newScreen.updateMenuItems()
                ScreenManager.showScreen(newScreen)
            }

            else -> {
                val newScreen = OpenNoteScreen(Resources.NOTE + element.name)
                newScreen.updateMenuItems()
                newScreen.noteMessage = (element as Note).message
                ScreenManager.showScreen(newScreen)
            }
        }
    }
}