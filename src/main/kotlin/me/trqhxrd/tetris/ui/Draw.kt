package me.trqhxrd.tetris.ui

import me.trqhxrd.tetris.ui.utils.FPS
import org.apache.logging.log4j.kotlin.Logging
import java.awt.Graphics
import javax.swing.JLabel

abstract class Draw(x: Int, y: Int, width: Int, height: Int) : JLabel(), Logging {

    private val fps = FPS()
    private var renderIndex = 0L

    init {
        this.setBounds(x, y, width + 1, height + 1)
        this.isVisible = true
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        if (this.renderIndex++ % 10000 == 0L) this.logger.debug("Rendering...")
        this.fps.update()
    }
}