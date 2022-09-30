package me.trqhxrd.tetris

import me.trqhxrd.tetris.threading.GameThread
import me.trqhxrd.tetris.ui.GUI

fun main() {
    GUI.init()
    GameThread.start()
}