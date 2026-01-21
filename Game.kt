const val player = "λ"
@JvmField
var map: Array<Array<String>> = arrayOf()
var position: Array<Int> = arrayOf()
var worldNumber = 0
var active = true

fun initialize() {
    map = map0
    position = arrayOf(3,3)
    map[position[0]][position[1]] = player
    gameLoop()
}

fun gameLoop() {
    fun renderMap() {
        clear()
        for (i in map.indices) {
            for (j in map[i].indices) {
                print(map[i][j] + " ")
            }
            println()
        }
    }
    
    fun movement(deltaX: Int, deltaY: Int) {
        val x = position[0]
        val y = position[1]
        val targetX = x + deltaX
        val targetY = y + deltaY
        val targetTile = map[targetY][targetX]
        if (targetTile == " ") {
            map[y][x] = " "
            position[0] += deltaX
            position[1] += deltaY
            map[targetY][targetX] = player
        }
    } 
    
    fun nextMap() {
        worldNumber++
        when (worldNumber) {
            1 -> {
                disp("You Win!", false)
                active = false
            }
            else -> initialize()
        }
    }
    
    val input: String = readln()
    while (active) {
        renderMap()
        val input = readlnOrNull() ?: ""
        val key = input.firstOrNull()
        when (key) {
            'w' -> movement(0, -1)
            's' -> movement(0, 1)
            'a' -> movement(-1, 0)
            'd' -> movement(1, 0)
            'e' -> nextMap()
        }
    }
}