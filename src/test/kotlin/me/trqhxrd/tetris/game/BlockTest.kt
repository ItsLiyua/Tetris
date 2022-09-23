package me.trqhxrd.tetris.game

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class BlockTest {

    lateinit var block: Block

    @BeforeEach
    fun setUp() {
        this.block = Block()
    }

    @Test
    fun init() {
        assertContains(BlockType.values(), this.block.type)
        assertTrue(this.block.y < 0)
        assertEquals(0, this.block.rotation)
    }

    @Test
    fun rotate() {
        for (i in arrayOf(1, 2, 3, 0)) {
            this.block.rotate()
            assertEquals(i, this.block.rotation)
        }
    }
}