package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.game.BlockType
import org.apache.logging.log4j.kotlin.Logging
import javax.swing.JFrame

object GUI : Logging {

    val jf = JFrame("Tetris")
    const val BOX_SIZE = 32
    const val GRID_WIDTH = 10
    const val GRID_HEIGHT = 18
    const val GRID_WIDTH_PIXEL = GRID_WIDTH * BOX_SIZE
    const val GRID_HEIGHT_PIXEL = GRID_HEIGHT * BOX_SIZE

    fun init() {
        this.logger.debug("Creating window.")
        jf.setSize(GRID_WIDTH_PIXEL + 200, GRID_HEIGHT_PIXEL)
        jf.layout = null
        jf.setLocationRelativeTo(null)
        jf.isResizable = false
        jf.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        jf.requestFocus()

        jf.add(DrawGrid)
        jf.add(DrawPreview)

        BlockType.values().forEach { this.logger.debug("${it.name}: ${it.state}") }

        jf.isVisible = true
        this.logger.debug("Created window.")
    }
}