class OpenNoteScreen(label: String) : Screen(label) {
    override fun updateMenuItems() {
        menuItems.remove(0)
    }

}