
fun main() {
    val firstUserEmailId = "user_one@gmail.com"

    println(displayAlertMessage(emailId = firstUserEmailId))
    println()

    val secondUserOperatingSystem = "Windows"
    val secondUserEmailId = "user_two@gmail.com"

    println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
    println()

    val thirdUserOperatingSystem = "Mac OS"
    val thirdUserEmailId = "user_three@gmail.com"

    println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
    println()


   println(trackScreen(300, 250))
   println(trackScreen(300, 300))
   println(trackScreen(200, 220))
}

fun displayAlertMessage(operatingSystem: String = "unknown", emailId: String): String {
    return "There's a new sign-in request on $operatingSystem OS for your Google Account $emailId."
}

fun trackScreen(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}
