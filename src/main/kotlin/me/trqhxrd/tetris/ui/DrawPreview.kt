package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.game.Block
import me.trqhxrd.tetris.ui.GUI.BOX_SIZE
import me.trqhxrd.tetris.ui.GUI.GRID_WIDTH_PIXEL
import java.awt.Color
import java.awt.Graphics

object DrawPreview : Draw(GRID_WIDTH_PIXEL + BOX_SIZE, BOX_SIZE, BOX_SIZE * 4, BOX_SIZE * 4) {

    var block: Block?=null

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        g.color = Color.GREEN
        g.fillRect(0, 0, this.width, this.height)

        this.repaint()
    }
}