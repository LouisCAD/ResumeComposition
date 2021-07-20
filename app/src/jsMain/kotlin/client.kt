import com.louiscad.resume.LouisCadResume
import kotlinx.html.div
import kotlinx.html.dom.append
import org.w3c.dom.Node
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        LouisCadResume()
    }
    return
    @Suppress("UNREACHABLE_CODE")
    window.onload = { document.body?.sayHello() }
}

fun Node.sayHello() {
    append {
        div {
            +"Hello from JS"
        }
    }
}
