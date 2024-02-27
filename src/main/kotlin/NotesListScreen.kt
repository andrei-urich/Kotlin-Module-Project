class NotesListScreen(label: String, val archive: Archive) : Screen(label) {
    init {
        updateMenuItems()
    }

    val list = archive.list

    override fun updateMenuItems() {
        if (archive.list.isNotEmpty()) {
            for (i in list) {
                menuItems[(list.indexOf(i)+2)] = i.name
            }
        }
    }
}