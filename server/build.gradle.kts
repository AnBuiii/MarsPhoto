plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.serialization)
    application
}

group = "com.anbui.marsphoto"
version = "1.0.0"
application {
    mainClass.set("com.anbui.marsphoto.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    
    // Ktor
    implementation(libs.ktor.server.core) 
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    
    // Test
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}