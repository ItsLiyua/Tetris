package me.trqhxrd.tetris.game

import me.trqhxrd.tetris.ui.GUI.GRID_HEIGHT
import me.trqhxrd.tetris.ui.GUI.GRID_WIDTH

object CollisionHandler {

    fun checkCollideWall(block: Block): Wall {
        if (block.x - 1 < 3) {
            block.state().forEach {
                if (block.x + it.first - 1 < 0) return Wall.LEFT
            }
        } else if (block.x + block.type.size > GRID_WIDTH - 3) {
            block.state().forEach {
                if (block.x + it.first + 1 >= GRID_WIDTH) return Wall.RIGHT
            }
        }
        return Wall.NONE
    }

    fun checkCollideFloor(block: Block): Boolean {
        block.state().forEach {
            val y = block.y + it.second + 1
            if (y >= GRID_HEIGHT) return true
        }
        return false
    }

    fun checkCollideMap(block: Block): Boolean {
        block.state().forEach {
            val x = block.x + it.first
            val y = block.y + it.second + 1
            val c = Grid.map[x to y]
            if (c != null) return true
        }
        return false
    }

    fun checkCollideRotation(block: Block): Boolean {
        val next = block.type[block.rotation + 1]
        next.forEach {
            val x = block.x + it.first
            val y = block.y + it.second
            val c = Grid.map[x to y]
            if (x < 0 || x >= GRID_WIDTH) return true
            if (y >= GRID_HEIGHT) return true
            if (c != null) return true
        }
        return false
    }

    enum class Wall {
        NONE, LEFT, RIGHT
    }
}