package me.trqhxrd.tetris.threading

import me.trqhxrd.tetris.game.Grid

object GridTick : Runnable {
    override fun run() {
        Grid.tick()
    }
}