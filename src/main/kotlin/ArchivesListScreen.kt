class ArchivesListScreen(label: String) : Screen(label) {
    val list = ArrayList<Archive>()
    override fun updateMenuItems() {
        if (list.isNotEmpty()) {
            for (i in list) {
                menuItems[(list.indexOf(i)+2)] = i.name
            }
        }
    }
}