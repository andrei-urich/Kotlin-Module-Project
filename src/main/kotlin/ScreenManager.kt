import java.util.*

object ScreenManager {
    val screenStack: Stack<Screen> = Stack()
    val menu = Menu()

    fun showScreen(screen: Screen) {
        menu.showMenu(screen)
        var menuOption = menu.getMenuOptions(screen)
        when (menuOption) {
            0 -> MenuHandler.addNew(screen)
            1 -> MenuHandler.back(screen)
            else -> MenuHandler.open(screen, menuOption)
        }
    }
}

