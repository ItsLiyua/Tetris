package me.trqhxrd.tetris.game

import java.awt.Color
import java.io.InputStreamReader

enum class BlockType(val size: Int, val color: Color) {
    I(4, Color.CYAN),
    J(3, Color.BLUE),
    L(3, Color.ORANGE),
    O(2, Color.YELLOW),
    S(3, Color.GREEN),
    T(3, Color.MAGENTA),
    Z(3, Color.RED);

    companion object {
        fun random() = BlockType.values().random()
    }

    fun bounds() = buildMap {
        val s = this@BlockType::class.java.getResourceAsStream("/blocks/$name.txt")!!
        val content = s.use { InputStreamReader(it).readLines() }
        for (rot in 0 until 4) {
            for (i in 0 until this@BlockType.size) {
                val row = content[rot * this@BlockType.size + i]
                    .split("")
                    .filter { it.isNotBlank() }
                    .map { it.toInt() }
                for (index in row.indices) this[Triple(rot, index, i)] = row[index]
            }
        }
    }

    fun bounds(rot: Int) = this.bounds()
        .filterKeys { it.first == rot }
        .mapKeys { Pair(it.key.second, it.key.third) }
        .toMap()
}