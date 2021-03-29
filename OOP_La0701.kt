package ch08.JoinToStringDefault

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "",
        transform: (T) -> String = { it.toString() }
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }

    result.append(postfix)
    return result.toString()
}

fun invertCase(str: String): String {
    return str
        .map { it }
        .joinToString(
            separator = "",
            transform = { if (it.isUpperCase()) it.toLowerCase().toString() else it.toUpperCase().toString() }
        )
}

fun main(args: Array<String>) {
    val letters = listOf("Alpha", "Beta", "UPPERCASE", "lowercase", "mIxEdCaSe")
    println(letters.joinToString())
    println(letters.joinToString { it.toLowerCase() })
    println(letters.joinToString(
            separator = "! ",
            postfix = "! ",
            transform = { it.toUpperCase() }
    ))

    println()
    println("The requested functionality outputs:")
    println(letters.joinToString { invertCase(it) })
}
