plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    alias(libs.plugins.multiplatform) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.androidx.room) apply false
    alias(libs.plugins.google.gms.google.services) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
}
