package me.trqhxrd.tetris.io

import me.trqhxrd.tetris.game.Grid
import me.trqhxrd.tetris.threading.GameThread
import java.awt.event.KeyEvent
import java.awt.event.KeyEvent.*
import java.awt.event.KeyListener

object KeyHandler : KeyListener {
    override fun keyTyped(e: KeyEvent) {
    }

    override fun keyPressed(e: KeyEvent) {
        when (e.keyCode) {
            VK_W -> Grid.activeBlock.rotate()
            VK_S -> Grid.speedUp = true
            VK_A -> Grid.activeBlock.x -= 1
            VK_D -> Grid.activeBlock.x += 1
            VK_ESCAPE -> GameThread.isPaused = !GameThread.isPaused
        }
    }

    override fun keyReleased(e: KeyEvent) {
        when (e.keyCode) {
            VK_S -> Grid.speedUp = false
        }
    }
}