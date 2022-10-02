package me.trqhxrd.tetris.threading

import me.trqhxrd.tetris.game.Grid
import me.trqhxrd.tetris.ui.DrawPause
import org.apache.logging.log4j.kotlin.Logging

object GameThread : Thread("game"), Logging {

    private var stop = false
    var isPaused = false
        set(value) {
            if (field != value) synchronized(this.lock) {
                field = value
                this.logger.info("Game ${if (!value) "un" else ""}paused.")
                if (!value) {
                    this.onUnpause?.let { it() }
                    this.lock.notify()
                } else this.onPause?.let { it() }
            }
        }
    private val lock = Object()
    var onPause: (() -> Unit)? = {
        println("visible")
        DrawPause.isVisible = true
    }
    var onUnpause: (() -> Unit)? = {
        println("hidden")
        DrawPause.isVisible = false
    }

    override fun run() {
        while (!this.stop) {
            synchronized(this.lock) {
                while (this.isPaused) this.lock.wait()
            }
            Grid.tick()
            sleep(if (Grid.speedUp) 100 else 300)
        }
    }

    fun shutdownGracefully() {
        this.stop = true
        this.logger.debug("Stopping game thread.")
    }
}