package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.game.Grid
import me.trqhxrd.tetris.ui.GUI.GRID_HEIGHT_PIXEL
import me.trqhxrd.tetris.ui.GUI.GRID_WIDTH_PIXEL
import java.awt.Color
import java.awt.Graphics

object DrawGrid : Draw(0,0,GRID_WIDTH_PIXEL, GRID_HEIGHT_PIXEL) {
    var grid: Grid? = null


    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        g.color = Color.RED
        g.fillRect(0, 0, this.width, this.height)

        this.repaint()
    }
}