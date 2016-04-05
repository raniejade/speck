package io.polymorphicpanda.kspec

import io.polymorphicpanda.kspec.tag.Tag
import kotlin.reflect.KClass

fun Spec.describe(description: String, action: () -> Unit) {
    group("describe: $description", action)
}

fun <T: Any> Spec.describe(subject: KClass<T>, description: String = "%s", action: SubjectSpec<T>.() -> Unit) {
    group(subject, "describe: $description", action)
}

fun Spec.context(description: String, action: () -> Unit) {
    group("context: $description", action)
}

fun <T: Any> Spec.context(subject: KClass<T>, description: String = "%s", action: SubjectSpec<T>.() -> Unit) {
    group(subject, "context: $description", action)
}

fun Spec.it(description: String, vararg tags: Tag, action: () -> Unit) {
    example("it: $description", setOf(*tags), action)
}

fun Spec.xit(description: String, reason: String? = null, block: (() -> Unit)? = null) {
    pendingExample("it: $description", reason, block)
}

fun <T: Any> SubjectSpec<T>.itBehavesLike(sharedExample: SharedExample<in T>) {
    include(sharedExample)
}
