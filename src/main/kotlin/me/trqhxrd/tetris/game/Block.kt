package me.trqhxrd.tetris.game

import me.trqhxrd.tetris.ui.GUI
import me.trqhxrd.tetris.ui.GUI.BOX_SIZE
import org.apache.logging.log4j.kotlin.Logging
import java.awt.Graphics2D

class Block(
    val type: BlockType = BlockType.random(),
    var x: Int = GUI.GRID_WIDTH / 2 - type.size / 2,
    var y: Int = -2,
    var rotation: Int = (0..3).random()
) : Logging {

    init {
        this.logger.debug("Initialized new block with type=\"${this.type.name}\", x=${this.x}, y=${this.y}, rotation=${this.rotation}.")
    }

    fun move(speedUp: Boolean = false) {
        val speed = if (speedUp) 2 else 1
        this.y += speed
        // TODO: Add collision handler
    }

    fun draw(g: Graphics2D) {
        g.color = this.type.color
        val state = this.type.states[this.rotation]
        state.forEach {
            g.fillRect((this.x + it.first) * BOX_SIZE, (this.y + it.second) * BOX_SIZE, BOX_SIZE, BOX_SIZE)
        }
    }

    fun rotate() {
        val old = this.rotation
        if (++this.rotation >= 4) this.rotation = 0
        this.logger.debug("Rotated block from $old to ${this.rotation}.")
    }
}