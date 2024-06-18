plugins {
    alias(libs.plugins.recipely.android.library)
    alias(libs.plugins.recipely.android.hilt)
    alias(libs.plugins.recipely.android.room)
}

android {
    namespace = "com.vanbui.recipely.core.database"
}

dependencies {
    implementation(projects.core.model)

    implementation(libs.kotlinx.datetime)

}