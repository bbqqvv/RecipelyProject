plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.serialization)
}

dependencies {
    implementation(libs.kotlinx.datetime)
    implementation(libs.ktor.serialization.kotlinx.json)
//    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")
}

