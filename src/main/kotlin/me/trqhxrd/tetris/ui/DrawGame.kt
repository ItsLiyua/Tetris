package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.game.Game
import me.trqhxrd.tetris.ui.GUI.TILE_SIZE
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JLabel

object DrawGame : JLabel() {
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        if (g !is Graphics2D) return

        val b = Game.currentBlock
        if (b != null) {
            val center = b.type.size / 2
            g.color = b.type.color
            b.bounds().filterValues { it == 1 }.forEach {
                val x = b.x + it.key.first - center
                val y = b.y + it.key.second - center
                g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE)
            }
        }

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