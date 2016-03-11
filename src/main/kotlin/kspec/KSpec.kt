package kspec

import io.polymorphicpanda.kspec.junit.KSpecRunner
import org.junit.runner.RunWith

@RunWith(KSpecRunner::class)
abstract class KSpec: Spec {
    var engine: Spec? = null

    abstract fun spec()

    override fun before(action: () -> Unit) {
        engine!!.before(action)
    }

    override fun after(action: () -> Unit) {
        engine!!.after(action)
    }

    override fun beforeEach(action: () -> Unit) {
        engine!!.beforeEach(action)
    }

    override fun afterEach(action: () -> Unit) {
        engine!!.afterEach(action)
    }

    override fun specBlock(description: String, term: String?, terminal: Boolean, block: () -> Unit) {
        engine!!.specBlock(description, term, terminal, block)
    }
}
