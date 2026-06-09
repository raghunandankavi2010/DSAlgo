/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.jvm)
    java
    idea
}

group = "programs"
version = "1.0-SNAPSHOT"

// This project uses a non-standard layout (sources in `src`, tests in `test`).
// Explicitly tell the IDEA model that `test` holds TEST sources so IntelliJ marks
// it as a Test Sources Root (green) and offers "Run test" on the classes in it.
idea {
    module {
        sourceDirs = setOf(file("src"))
        testSources.from(file("test"))
    }
}

dependencies {
    // stdlib version is supplied by the Kotlin plugin, so no explicit version needed.
    implementation(kotlin("stdlib"))

    implementation(libs.hamcrest)

    compileOnly(libs.jetbrains.annotations)
    compileOnly(libs.findbugs.jsr305)

    // JUnit 5/6 (Jupiter). Versions are centralised in gradle/libs.versions.toml.
    // The BOM aligns Jupiter + Platform; the launcher must be on the test runtime
    // classpath explicitly (Gradle 9 / JUnit 6 no longer add it automatically).
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
}

sourceSets {
    main {
        java.setSrcDirs(listOf("src"))
        kotlin.setSrcDirs(listOf("src"))
    }
    test {
        java.setSrcDirs(listOf("test"))
        kotlin.setSrcDirs(listOf("test"))
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

// Required if you switch to Option B (JUnit 5) so Gradle knows how to execute the suite
tasks.test {
    useJUnitPlatform()
}