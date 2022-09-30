package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.game.BlockType
import me.trqhxrd.tetris.io.KeyHandler
import me.trqhxrd.tetris.threading.GameThread
import me.trqhxrd.tetris.ui.utils.FPS
import org.apache.logging.log4j.kotlin.Logging
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.JFrame

object GUI : Logging {

    private val jf = JFrame("Tetris")
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
        jf.addWindowListener(WindowHandler)
        jf.addKeyListener(KeyHandler)
        jf.requestFocus()

        jf.add(DrawGrid)
        jf.add(DrawPreview)

        jf.isVisible = true
        this.logger.debug("Created window.")
    }

    object WindowHandler : WindowListener {
        override fun windowOpened(e: WindowEvent?) {
        }

        override fun windowClosing(e: WindowEvent?) {
            GameThread.shutdownGracefully()
        }

        override fun windowClosed(e: WindowEvent?) {
        }

        override fun windowIconified(e: WindowEvent?) {
        }

        override fun windowDeiconified(e: WindowEvent?) {
        }

        override fun windowActivated(e: WindowEvent?) {
        }

        override fun windowDeactivated(e: WindowEvent?) {
        }

    }
}