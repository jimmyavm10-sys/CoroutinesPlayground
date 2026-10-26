plugins {
    kotlin("jvm") version "2.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
}

val examples = mapOf(
    "run01Synchronous" to "synchronous.Synchronous",
    "run02Asynchronous" to "asynchronous.Asynchronous",
    "run03ExceptionHandling" to "exceptions.ExceptionHandling",
    "run04Cancellation" to "cancellation.Cancellation",
    "run05Dispatchers" to "dispatchers.DispatchersExample"
)

examples.forEach { (taskName, mainClassName) ->
    tasks.register<JavaExec>(taskName) {
        group = "examples"
        classpath = sourceSets["main"].runtimeClasspath
        mainClass.set(mainClassName)
    }
}
