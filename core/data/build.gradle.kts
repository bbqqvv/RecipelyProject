plugins {
    alias(libs.plugins.recipely.android.library)
    alias(libs.plugins.recipely.android.hilt)
}

android {
    namespace = "com.vanbui.recipely.core.data"
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.datastore)
    implementation(projects.core.model)

    implementation(libs.kotlinx.datetime)
}