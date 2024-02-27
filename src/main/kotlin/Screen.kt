abstract class Screen (val label : String) {
    val menuItems = mutableMapOf<Int, String>()
    init {
        menuItems.put(0, "Создать новый элемент")
        menuItems.put(1, "Назад/Выход")
    }

    abstract fun updateMenuItems()

}