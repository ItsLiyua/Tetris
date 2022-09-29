package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.game.Block
import me.trqhxrd.tetris.ui.GUI.BOX_SIZE
import me.trqhxrd.tetris.ui.GUI.GRID_WIDTH_PIXEL
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints

object DrawPreview : Draw(GRID_WIDTH_PIXEL + BOX_SIZE, BOX_SIZE, BOX_SIZE * 4, BOX_SIZE * 4) {

    var block: Block? = null

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        (g as Graphics2D).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF)

        g.color = Color.GREEN
        g.fillRect(0, 0, this.width, this.height)

        this.repaint()
    }
}