package me.trqhxrd.tetris.game

import me.trqhxrd.tetris.ui.GUI
import me.trqhxrd.tetris.ui.GUI.BOX_SIZE
import org.apache.logging.log4j.kotlin.Logging
import java.awt.Graphics2D

class Block(
    val type: BlockType = BlockType.random(),
    x: Int = GUI.GRID_WIDTH / 2 - type.size / 2,
    y: Int = -2,
    rotation: Int = (0..3).random()
) : Logging {

    var x = x
        set(value) {
            if (value < field && CollisionHandler.checkCollideWall(this) != CollisionHandler.Wall.LEFT) field = value
            else if (value > field && CollisionHandler.checkCollideWall(this) != CollisionHandler.Wall.RIGHT) field =
                value
            else this.logger.debug("Block collided with wall")
        }
    var y = y
        set(value) {
            var b = false
            if (CollisionHandler.checkCollideFloor(this)) {
                this.logger.info("Block reached the bottom. Generating new block.")
                b = true
            } else if (CollisionHandler.checkCollideMap(this)) {
                this.logger.info("Block collided with another block.")
                b = true
            } else field = value
            if (b) {
                Grid.saveBlock(this)
                Grid.generateNewBlock()
            }
        }
    var rotation = rotation
        private set

    init {
        this.logger.debug(
            "Initialized new block with type=\"${this.type.name}\", x=${this.x}, " + "y=${this.y}, rotation=${this.rotation}."
        )
    }

    fun move() {
        this.y += 1
        // TODO: Add collision handler
    }

    fun draw(g: Graphics2D) {
        g.color = this.type.color
        val state = this.type.states[this.rotation]
        state.forEach {
            g.fillRect(
                (this.x + it.first) * BOX_SIZE,
                (this.y + it.second) * BOX_SIZE,
                BOX_SIZE,
                BOX_SIZE
            )
        }
    }

    fun drawPreview(g: Graphics2D) {
        g.color = this.type.color
        val state = this.type.states[this.rotation]
        val offset = if (this.type.size == 2) 1 else 0
        state.forEach {
            g.fillRect(
                (it.first + offset) * BOX_SIZE,
                (it.second + offset) * BOX_SIZE,
                BOX_SIZE,
                BOX_SIZE
            )
        }
    }

    fun rotate() {
        if (CollisionHandler.checkCollideRotation(this)) {
            this.logger.debug("Rotation not possible.")
            return
        }
        val old = this.rotation
        if (++this.rotation >= 4) this.rotation = 0
        this.logger.debug("Rotated block from $old to ${this.rotation}.")
    }

    fun destroy() {
        Grid.saveBlock(this)
        Grid.generateNewBlock()
    }

    fun state() = this.type[this.rotation]
}