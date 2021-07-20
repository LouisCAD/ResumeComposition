package com.louiscad.resume

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text

// Regex inspired by http://blog.michaelperrin.fr/2019/02/04/advanced-regular-expressions/
// If needed, look at the article again to support nested brackets (not needed so far).
//language=RegExp
@Suppress("RegExpRedundantEscape") // False positive for closing bracket. TODO: Report on YouTrack.
private val linksRegex = """\[(?<text>[^\]]+)\]\((?<url>[^) ]+)(?: "(?<title>.+)")?\)""".toRegex()

@Composable
internal fun LinkableText(textWithMarkdownLinks: String) {
    var startIndex = 0
    linksRegex.findAll(input = textWithMarkdownLinks).forEach { matchResult ->
        textWithMarkdownLinks.substring(
            startIndex = startIndex,
            endIndex = matchResult.range.first
        ).let { textBefore ->
            if (textBefore.isNotEmpty()) Text(textBefore)
        }
        val groups = matchResult.groups
        val textGroup = groups[1]!!
        val urlGroup = groups[2]!!
        val titleGroup = groups[3]
        val url: String = urlGroup.value.trim()
        A(href = url,
            attrs = titleGroup?.value?.let { { title(it) } }
        ) {
            Text(textGroup.value)
        }
        startIndex = matchResult.range.last + 1
    }
    Text(textWithMarkdownLinks.substring(startIndex = startIndex))
}
