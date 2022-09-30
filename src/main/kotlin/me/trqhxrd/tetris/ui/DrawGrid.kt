package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.game.Block
import me.trqhxrd.tetris.game.BlockType
import me.trqhxrd.tetris.game.Grid
import me.trqhxrd.tetris.ui.GUI.BOX_SIZE
import me.trqhxrd.tetris.ui.GUI.GRID_HEIGHT_PIXEL
import me.trqhxrd.tetris.ui.GUI.GRID_WIDTH_PIXEL
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints

object DrawGrid : Draw(0, 0, GRID_WIDTH_PIXEL, GRID_HEIGHT_PIXEL) {
    var grid: Grid? = null

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        (g as Graphics2D).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF)

        Grid.draw(g)

        g.color = Color.LIGHT_GRAY
        for (x in 0 until GUI.GRID_WIDTH) {
            for (y in 0 until GUI.GRID_HEIGHT) {
                g.drawRect(x * BOX_SIZE, y * BOX_SIZE, BOX_SIZE, BOX_SIZE)
            }
        }

        this.repaint()
    }
}