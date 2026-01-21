@JvmField
var menuOptions: Array<String> = arrayOf()
var menuIndex = 0
var menuActive = true

fun main() {
    mainMenu()
}

fun mainMenu() {
    fun displayMenu() {
        clear()
        val name: Array<String> = arrayOf(" █████   ████           █████    ████   ███            ", "░░███   ███░           ░░███    ░░███  ░░░             ", " ░███  ███     ██████  ███████   ░███  ████  ████████  ", " ░███████     ███░░███░░░███░    ░███ ░░███ ░░███░░███ ", " ░███░░███   ░███ ░███  ░███     ░███  ░███  ░███ ░███ ", " ░███ ░░███  ░███ ░███  ░███ ███ ░███  ░███  ░███ ░███ ", " █████ ░░████░░██████   ░░█████  █████ █████ ████ █████", "░░░░░   ░░░░  ░░░░░░     ░░░░░  ░░░░░ ░░░░░ ░░░░ ░░░░░ ", "\n", "   █████████                                           ", "  ███░░░░░███                                          ", " ███     ░░░   ██████   █████████████    ██████        ", "░███          ░░░░░███ ░░███░░███░░███  ███░░███       ", "░███    █████  ███████  ░███ ░███ ░███ ░███████        ", "░░███  ░░███  ███░░███  ░███ ░███ ░███ ░███░░░         ", " ░░█████████ ░░████████ █████░███ █████░░██████        ", "  ░░░░░░░░░   ░░░░░░░░ ░░░░░ ░░░ ░░░░░  ░░░░░░         ")
        for (line in name) {
            println(line)
        }
        for (option in menuOptions) {
            var prefix = ""
            var suffix = ""
            if (option == menuOptions[menuIndex]) {
                prefix = "> "
                suffix = " <"
            }
            println(prefix + option + suffix)
        }
    }
    
    fun handleInput(selection: Int) {
        when (selection) {
            0 -> initialize()
            1 -> settings()
            2 -> credits()
            3 -> exitGame()
        }
    }
    
    menuOptions = arrayOf("Start Game", "Settings", "Credits", "Exit Game")
    while (menuActive) {
        displayMenu()
        val input = readlnOrNull() ?: ""
        val key = input.firstOrNull()
        when (key) {
            'w' -> {
                menuIndex--
                if (menuIndex < 0) {
                    menuIndex = 0
                }
            }
            's' -> {
                menuIndex++
                if (menuIndex > 3) {
                    menuIndex = 3
                }
            }
            'e' -> {
                menuActive = false
                handleInput(menuIndex)
            }
        }
    }
}

fun settings() {
    disp("There are no settings right now", false)
}

fun credits() {
    disp("There are no credits right now.", false)
}

fun exitGame() {
    disp("Thanks for playing!", false)
}