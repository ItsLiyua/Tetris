package me.trqhxrd.tetris.game

import me.trqhxrd.tetris.ui.GUI
import me.trqhxrd.tetris.ui.GUI.BOX_SIZE
import java.awt.Graphics2D

class Block(
    val type: BlockType,
    var x: Int = GUI.GRID_WIDTH / 2 - type.size / 2,
    var y: Int = -2,
    var rotation: Int = (0..3).random()
) {

    fun draw(g: Graphics2D) {
        g.color = this.type.color
        val state = this.type.states[this.rotation]
        state.forEach {
            g.fillRect((this.x + it.first) * BOX_SIZE, (this.y + it.second) * BOX_SIZE, BOX_SIZE, BOX_SIZE)
        }
    }
}