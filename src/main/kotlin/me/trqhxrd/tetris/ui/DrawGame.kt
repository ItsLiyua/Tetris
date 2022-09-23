package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.ui.GUI.TILE_SIZE
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JLabel

object DrawGame : JLabel() {
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        if (g !is Graphics2D) return

        g.color = Color.LIGHT_GRAY
        repeat(10) { x ->
            repeat(18) { y ->
                g.drawRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE)
            }
        }

        g.color = Color.BLACK
        g.drawRect(0, 0, width - 1, height - 1)

        this.repaint()
    }
}