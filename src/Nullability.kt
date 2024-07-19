fun main() {

    //Non-Nullable Types
    var favoriteActor1: String = "Sarah Oh"
    // favoriteActor = null // This will cause a compilation error
    println(favoriteActor1.length)

    //Nullable Types
    var favoriteActor2: String? = "Sarah Oh"
    //println(favoriteActor2.length) //No safe call will cause and error
    //Allowed
    favoriteActor2 = null
    println(favoriteActor2)

    // Prints: null if nullable is null, otherwise prints the length of the string
    var favoriteActor3: String? = "Sarah Oh"
    //Accessing string property with safe call operator
    println(favoriteActor3?.length)

}