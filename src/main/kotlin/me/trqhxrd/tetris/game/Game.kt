package me.trqhxrd.tetris.game

object Game {
    var score = 0
        set(value) {
            if (value > highscore) highscore = score
            field = value
        }
    var highscore = 0
    var scoreToAdd = 0
    var spawnNewBlock = false
    var speedUp = false
    val blocks = mutableListOf<Block>()
    var currentBlock: Block? = Block(4, 4)
    var nextBlock: Block? = null

    val map = Array(10) { Array(18) { 0 } }
    var gameState = GameState.START

    fun clear() {
        for (x in this.map.indices)
            for (y in this.map[x].indices)
                this.map[x][y] = 0
        this.score = 0
    }
}