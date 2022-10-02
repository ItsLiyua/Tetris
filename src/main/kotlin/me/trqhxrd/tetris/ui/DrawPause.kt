package me.trqhxrd.tetris.ui

import java.awt.Color
import java.awt.Font
import java.awt.Graphics

object DrawPause : Draw(0, 200, 400, 200) {

    const val LINE_1 = "Game Paused!"
    const val LINE_2 = "Press ESC to continue."
    val FONT = Font("Arial", Font.BOLD, 20)

    init {
        this.isVisible = false
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        g.color = Color.BLACK
        g.font = FONT
        g.drawString(LINE_1, 135, 100)
        g.drawString(LINE_2, 100, 130)

        this.repaint()
    }
}