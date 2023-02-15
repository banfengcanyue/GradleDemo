
### gradle插件

### 插件的使用方式
```groovy
// 新版写法
plugins {
id 'com.android.application'
}
// 旧版写法
apply plugin: 'com.android.library'
```

```groovy

```
### 创建插件的三种方式

#### 一、脚本插件

> 直接在app 模块的 build.gradle 中写插件，并引用

```groovy
class ScriptGradlePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "Method 1: Test Gradle in build.gradle"
    }
}

apply plugin: ScriptGradlePlugin
```
#### 二、buildSrc插件

> 在根目录创建一个 buildSrc 目录（只能创建一个），
> 然后创建一个 build.gradle 文件，写入以下代码

```groovy
apply plugin: 'kotlin'
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // 因为想使用kotlin，所以这里增加kotlin插件
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10-RC"
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10"
}
```

> 在 buildSrc 目录下创建相应的文件夹，这里选择 kotlin 编写
src/main/kotlin
src/main/java
src/main/groovy

> 创建包文件夹com.bfcy.gradle，并编写插件类



#### 三、独立项目插件

1. 独立插件的本地引用
> 复制 buildSrc 包，修改包名、类名、插件名，在app的build.gradle中引用，会报找不到插件的错误
> 在 settings.gradle 加上 include ':standalone-gradle-plugin'，还是会报找不到插件的错误
> 因为 buildSrc 是一个特殊目录，Gradle会自动编译并引入，其他目录的插件是无法识别的
> 在 settings.gradle 加上 includeBuild('standalone-gradle-plugin')，就可以像 buildSrc 一样在本地引用了

2. 独立插件发布到JitPack并引用
> 在 settings.gradle 加上 include ':standalone-gradle-plugin'，变成一个普通模块
> 然后在命令行执行：./gradlew publish
> 提交并上传github仓库，打上tag，并打开 Jitpack 网站，搜索我们的项目名称，进行构建