package me.trqhxrd.tetris.threading

import org.apache.logging.log4j.kotlin.Logging

object GameThread : Thread("game"),Logging {

    val runnables = mutableSetOf<Runnable>()
    private var stop = false

    init {
        this.runnables.add(GridTick)
    }

    override fun run() {
        while (!this.stop) {
            this.runnables.forEach { it.run() }
            sleep(300)
        }
    }

    fun shutdownGracefully() {
        this.stop = true
    }
}