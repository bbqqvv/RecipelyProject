plugins {
    alias(libs.plugins.recipely.android.feature)
    alias(libs.plugins.recipely.android.library.compose)
}

android {
    namespace = "com.vanbui.recipely.feature.account"
}

dependencies {
    implementation(libs.kotlinx.datetime)
    implementation(libs.coil.compose)
}
