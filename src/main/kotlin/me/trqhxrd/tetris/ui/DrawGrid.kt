package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.game.Grid
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

        g.color = Color.RED
        g.fillRect(0, 0, this.width, this.height)

        this.repaint()
    }
}