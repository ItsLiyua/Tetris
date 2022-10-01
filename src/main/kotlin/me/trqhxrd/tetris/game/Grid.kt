package me.trqhxrd.tetris.game

import me.trqhxrd.tetris.ui.GUI.BOX_SIZE
import org.apache.logging.log4j.kotlin.Logging
import java.awt.Color
import java.awt.Graphics2D

object Grid : Logging {
    val map = mutableMapOf<Pair<Int, Int>, Color?>()
    lateinit var activeBlock: Block
    lateinit var nextBlock: Block
    var speedUp = false
        set(value) {
            if (field != value) this.logger.debug("New speed-up state: $value")
            field = value
        }

    init {
        this.generateNewBlock()
    }

    fun tick() = this.activeBlock.move()


    fun draw(g: Graphics2D) {
        this.map.forEach { (coords, color) ->
            g.color = color
            g.fillRect(coords.first * BOX_SIZE, coords.second * BOX_SIZE, BOX_SIZE, BOX_SIZE)
        }
        this.activeBlock.draw(g)
    }

    fun generateNewBlock() {
        if (this::nextBlock.isInitialized) this.activeBlock = this.nextBlock
        else this.activeBlock = Block()
        this.nextBlock = Block()
    }

    fun saveBlock(block: Block) {
        block.state().forEach {
            this.map[block.x + it.first to block.y + it.second] = block.type.color
        }
    }
}