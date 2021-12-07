fun main() {

    val options = arrayOf("камень", "ножницы", "бумага")
    val gameChoice = getGameChoice(options)
    val userChoise = getUserChoise(options)
    printResult(userChoise, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoise(optionsParam: Array<String>): String {
    var isValidChoise = false
    var userChoise = ""

    while (!isValidChoise) {
        println("Введите: ")
        for (item in optionsParam) println("$item")
        val userInput = readLine()
        if (userInput != null && userInput in optionsParam) {
            isValidChoise = true
            userChoise = userInput
        } else if (!isValidChoise) println("Не верно ввели слово! Попробуйте вновь...")
    }
    return userChoise
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    if (userChoice == gameChoice) result = "Ничья"
    else if ((userChoice == "камень" && gameChoice == "ножницы") ||
        (userChoice == "бумага" && gameChoice == "камень") ||
        (userChoice == "ножницы" && gameChoice == "бумага")
    ) result = "Вы победили !!!"
    else result = "Вы проиграли..."
    println("Пользователь выбрал $userChoice. Компьютер выбрал $gameChoice. $result")
}