package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.ui.GUI.TILE_SIZE
import java.awt.Color
import java.awt.Graphics
import javax.swing.JLabel

object DrawInterface : JLabel() {

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        g.color = Color.LIGHT_GRAY
        repeat(4) { x ->
            repeat(4) { y ->
                g.drawRect((x + 1) * TILE_SIZE, (y + 1) * TILE_SIZE, TILE_SIZE, TILE_SIZE)
            }
        }

        g.color = Color.BLACK
        g.drawRect(TILE_SIZE, TILE_SIZE, TILE_SIZE * 4, TILE_SIZE * 4)

        this.repaint()
    }
}