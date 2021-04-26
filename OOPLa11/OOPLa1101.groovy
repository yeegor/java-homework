movieTitles = ["Seven", "SnowWhite", "Die Hard"]
testPattern = ~/^[sS].*/

movieTitles.each({x -> 
    if (testPattern.matcher(x).matches()) {
	    println x
    }
})