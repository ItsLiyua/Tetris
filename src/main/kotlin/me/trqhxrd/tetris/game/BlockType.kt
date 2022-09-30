package me.trqhxrd.tetris.game

import me.trqhxrd.tetris.game.TypeUtils.buildShape
import org.apache.logging.log4j.kotlin.Logging
import java.awt.Color
import kotlin.math.sqrt

enum class BlockType(val color: Color, val size: Int, vararg val states: Set<Pair<Int, Int>>) {

    I(
        Color.YELLOW,
        4,
        buildShape("0100010001000100"),
        buildShape("0000111100000000"),
        buildShape("0010001000100010"),
        buildShape("0000000011110000")
    ),
    J(
        Color.RED,
        3,
        buildShape("010010110"),
        buildShape("100111000"),
        buildShape("011010010"),
        buildShape("000111001"),
    ),
    L(
        Color.RED,
        3,
        buildShape("010010011"),
        buildShape("001111000"),
        buildShape("110010010"),
        buildShape("000111100")
    ),
    O(
        Color.RED,
        2,
        buildShape("1111"),
        buildShape("1111"),
        buildShape("1111"),
        buildShape("1111")
    ),
    S(
        Color.RED,
        3,
        buildShape("000011110"),
        buildShape("100110010"),
        buildShape("000011110"),
        buildShape("100110010")
    ),
    T(
        Color.RED,
        3,
        buildShape("000111010"),
        buildShape("010110010"),
        buildShape("010111000"),
        buildShape("010011010")
    ),
    Z(
        Color.RED,
        3,
        buildShape("000110011"),
        buildShape("000011110"),
        buildShape("000110011"),
        buildShape("000011110"),
    );
}

private object TypeUtils : Logging {
    fun buildShape(boxes: String): Set<Pair<Int, Int>> {
        val sideLength = sqrt(boxes.length.toFloat()).toInt()
        val coordinates = boxes.toCharArray().map { it.digitToInt() }
        val shape = mutableSetOf<Pair<Int, Int>>()
        for (coordinate in coordinates.withIndex().filter { it.value == 1 }.map { it.index }) {
            shape.add(coordinate % sideLength to coordinate / sideLength)
        }
        return shape
    }
}
