package me.trqhxrd.tetris.ui

import javax.swing.JLabel

abstract class Draw(x: Int, y: Int, width: Int, height: Int) : JLabel() {

    init {
        this.setBounds(x, y, width, height)
        this.isVisible = true
    }
}