package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.io.KeyHandler
import java.awt.Dimension
import javax.swing.JFrame

object GUI {
    const val WIDTH = 320
    const val HEIGHT = 576

    lateinit var jf: JFrame
        private set

    fun create() {
        jf = JFrame("Tetris")
        jf.size = Dimension(WIDTH + 17 + 200, HEIGHT + 41)
        jf.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        jf.setLocationRelativeTo(null)
        jf.isResizable = false
        jf.layout = null
        jf.addKeyListener(KeyHandler())

        jf.requestFocus()
        jf.isVisible = true
    }
}