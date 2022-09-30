package me.trqhxrd.tetris.threading

import me.trqhxrd.tetris.game.Grid
import org.apache.logging.log4j.kotlin.Logging

object GameThread : Thread("game"), Logging {

    val runnables = mutableSetOf<Runnable>()
    private var stop = false

    init {
        this.runnables.add(GridTick)
    }

    override fun run() {
        while (!this.stop) {
            this.runnables.forEach { it.run() }
            sleep(if (Grid.speedUp) 100 else 300)
        }
    }

    fun shutdownGracefully() {
        this.stop = true
        this.logger.debug("Stopping game thread.")
    }
}