import androidx.compose.ui.window.Window
import com.louiscad.resume.App
import androidx.compose.ui.window.application
import com.louiscad.resume.LouisCadResume

fun main() = application {
    Window(onCloseRequest = {}, title = "Louis CAD Resume") {
        LouisCadResume()
//      App()
    }
}
