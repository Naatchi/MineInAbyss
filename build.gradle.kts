plugins {
    id("com.mineinabyss.conventions.kotlin")
    id("com.mineinabyss.conventions.papermc")
    id("com.mineinabyss.conventions.copyjar")
    id("com.mineinabyss.conventions.publication")
//    kotlin("plugin.serialization") apply false
    kotlin("jvm") apply false
}

allprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://repo.codemc.org/repository/maven-public/")
        maven("https://repo.dmulloy2.net/nexus/repository/public/") //ProtocolLib
        maven("https://jitpack.io")
    }

    dependencies {
        val libs = rootProject.libs
        val mialibs = rootProject.mialibs

        // Geary platform
        compileOnly(mialibs.geary.papermc.core)
        compileOnly(mialibs.geary.commons.papermc)
        compileOnly(mialibs.looty)

        // MineInAbyss platform
        compileOnly(libs.kotlin.stdlib)
        compileOnly(libs.kotlinx.serialization.json)
        compileOnly(libs.kotlinx.serialization.kaml)
        compileOnly(libs.kotlinx.coroutines)
        compileOnly(libs.minecraft.mccoroutine)
        compileOnly(libs.reflections)
        implementation(libs.idofront.autoscan) {
            exclude("org.reflections")
        }

        compileOnly(libs.exposed.core) { isTransitive = false }
        compileOnly(libs.exposed.dao) { isTransitive = false }
        compileOnly(libs.exposed.jdbc) { isTransitive = false }
        compileOnly(libs.exposed.javatime) { isTransitive = false }
        compileOnly(libs.sqlite.jdbc)
        compileOnly(libs.minecraft.anvilgui)

        implementation(libs.idofront.core)

        // Plugin libs
        compileOnly(libs.minecraft.plugin.vault) { exclude(group = "org.bukkit") }
        compileOnly(libs.minecraft.plugin.fawe.core)
        compileOnly(libs.minecraft.plugin.fawe.bukkit) { isTransitive = false }
        compileOnly(libs.minecraft.plugin.protocollib)

        compileOnly(mialibs.deeperworld)
        compileOnly(mialibs.minecraft.plugin.blocklocker)
        compileOnly(mialibs.minecraft.plugin.gsit)
        compileOnly(mialibs.minecraft.plugin.protocolburrito)

    }
}

dependencies {

    // Shaded
    implementation(project(":mineinabyss-core"))
    implementation(project(":mineinabyss-features"))
}
