class OpenNoteScreen(label: String) : Screen(label) {
    var noteMessage = ""
    override fun updateMenuItems() {
        menuItems.remove(0)
    }

}