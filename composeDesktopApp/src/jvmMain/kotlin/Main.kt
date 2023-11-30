import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.MainScreen

/**
 * @property [main] main function for running the application.
 * This function is responsible for running the application. It is the entry point of the application for desktop application
 */
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MainScreen()
    }
}
