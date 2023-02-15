package com.bfcy.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class StandaloneGradlePlugin : Plugin<Project> {
    override fun apply(p0: Project) {
        println("Method 3: Test gradle plugin in standalone module")
    }
}