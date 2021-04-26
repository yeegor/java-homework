letterPattern = ~/[a-zA-Z]/

String.metaClass.isPalindrome = {->
    symbols = delegate.split("")
    lettersOnly = symbols.findAll{ letterPattern.matcher(it).matches() }
    lettersOnlyString = lettersOnly.join("")

    return lettersOnlyString == lettersOnlyString.reverse();
}

println 'm1o0m'.isPalindrome()