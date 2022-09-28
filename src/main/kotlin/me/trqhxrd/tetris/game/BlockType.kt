package me.trqhxrd.tetris.game

import org.apache.logging.log4j.kotlin.Logging
import java.awt.Color
import kotlin.math.sqrt

enum class BlockType(val state: Set<Pair<Int, Int>>, val color: Color) {
    I(TypeUtils.buildShape("0100010001000100"), Color.RED),
    J(TypeUtils.buildShape("010010110"), Color.RED),
    L(TypeUtils.buildShape("010010011"), Color.RED),
    O(TypeUtils.buildShape("1111"), Color.RED),
    S(TypeUtils.buildShape("000011110"), Color.RED),
    T(TypeUtils.buildShape("000111010"), Color.RED),
    Z(TypeUtils.buildShape("000110011"), Color.RED)
}

private object TypeUtils : Logging {
    fun buildShape(boxes: String): Set<Pair<Int, Int>> {
        val size = sqrt(boxes.length.toFloat()).toInt()
        return buildSet {
            for ((index, box) in boxes.toCharArray().map { it.digitToInt() }.withIndex()) {
                if (box == 1) this.add(Pair((index / size) - (size / 2), (index % size) - size / 2))
                else if (box != 0) throw IllegalArgumentException("Only 0 and 1 are allowed! [$box]")
            }
            this@TypeUtils.logger.debug("Loaded new block type: $this")
        }
    }
}
