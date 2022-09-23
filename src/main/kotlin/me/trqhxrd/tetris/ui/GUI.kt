package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.io.KeyHandler
import java.awt.Dimension
import java.awt.Rectangle
import javax.swing.JFrame
import javax.swing.JLabel

object GUI {
    const val WIDTH = 320
    const val HEIGHT = 576
    const val TILE_SIZE = 32

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

        this.setupDraw(DrawGame, 0, 0, WIDTH, HEIGHT)
        this.setupDraw(DrawInterface, WIDTH + 1, 1, WIDTH, HEIGHT)

        jf.isVisible = true
    }

    private fun setupDraw(draw: JLabel, x: Int, y: Int, width: Int, height: Int) {
        draw.bounds = Rectangle(x, y, width, height)
        draw.isVisible = true
        this.jf.add(draw)
    }
}