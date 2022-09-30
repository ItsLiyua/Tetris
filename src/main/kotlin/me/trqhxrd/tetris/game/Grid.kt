package me.trqhxrd.tetris.game

import org.apache.logging.log4j.kotlin.Logging
import java.awt.Color
import java.awt.Graphics2D

object Grid : Logging {
    private val map = mutableMapOf<Pair<Int, Int>, Color?>()
    var activeBlock = Block()
    var speedUp = false
        set(value) {
            if (field != value) this.logger.debug("New speed-up state: $value")
            field = value
        }

    fun tick() {
        this.activeBlock.move(speedUp)
    }

    fun draw(g: Graphics2D) {
        this.activeBlock.draw(g)
    }
}