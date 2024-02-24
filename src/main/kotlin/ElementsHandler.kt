object ElementsHandler {
    fun addNew(screen: Screen, label: String) {
        when (screen) {
            is ArchivesListScreen -> {
                val newArchive: Archive = InputHandler.getElementInput(label) as Archive
                screen.list.add(newArchive)
                println("Новый архив " + newArchive.name + " добавлен.")
            }

            is NotesListScreen -> {
                val newNote: Note = InputHandler.getElementInput(label) as Note
                screen.list.add(newNote)
                println("Новая заметка " + newNote.name + " добавлена.")
            }
        }
        screen.updateMenuItems()
        Menu.showMenu(ScreenStack.screenStack.pop())
    }


    fun open(element: Element, label: String) {
        when (label) {
            Resources.ARCHIVES -> {
                val newScreen =
                    NotesListScreen((Resources.NOTES + element.name), element as Archive)
                newScreen.updateMenuItems()
                Menu.showMenu(newScreen)
            }

            else -> {
                val newScreen = OpenNoteScreen(Resources.NOTE + element.name)
                newScreen.updateMenuItems()
                Menu.showMenu(newScreen)
                println((element as Note).message)
                InputHandler.getMenuInput(newScreen)

            }
        }
    }
}

