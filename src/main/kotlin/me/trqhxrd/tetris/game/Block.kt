package me.trqhxrd.tetris.game

import org.apache.logging.log4j.kotlin.Logging

class Block(
    var x: Int = 4,
    var y: Int = -2
) : Logging {
    val type: BlockType = BlockType.random()
    var rotation: Int = 0

    init {
        this.logger.debug("Created new Block with type \"${this.type}\".")
    }

    fun rotate() {
        if (++this.rotation >= 4) this.rotation = 0
        this.logger.debug("Rotated block [${this.rotation}].")
    }

    fun bounds() = this.type.bounds(this.rotation)
}