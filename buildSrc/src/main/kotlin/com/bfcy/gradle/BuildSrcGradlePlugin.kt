package com.bfcy.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildSrcGradlePlugin : Plugin<Project> {
    override fun apply(p0: Project) {
        println("Method 2: Test gradle plugin in buildSrc module")
    }
}