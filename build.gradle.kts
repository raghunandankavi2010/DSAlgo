import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.3.21"
    java
}

group = "programs"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib"))

    implementation("junit:junit:4.13.2")
    implementation("org.hamcrest:hamcrest:3.0")
    compileOnly("org.jetbrains:annotations:26.1.0")
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
}

sourceSets {
    main {
        java.setSrcDirs(listOf("src"))
        kotlin.setSrcDirs(listOf("src"))
    }
    test {
        java.setSrcDirs(emptyList<String>())
        kotlin.setSrcDirs(emptyList<String>())
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}
