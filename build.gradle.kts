plugins {
    `java-library`
    jacoco
    pmd
    `build-dashboard`
    id("com.github.spotbugs") version "4.0.5"
}

repositories {
    jcenter()
    mavenCentral()
}

ext {

}

dependencies {
    implementation("com.google.http-client:google-http-client:1.32.1")
    implementation("com.google.http-client:google-http-client-gson:1.32.1")

    implementation("org.apache.httpcomponents:httpclient:4.5.10")

    implementation("com.google.code.gson:gson:2.8.5")

    implementation("ch.qos.logback:logback-core:1.2.3")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.slf4j:slf4j-api:1.7.30")

    testImplementation("org.jmockit:jmockit:1.49")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

sourceSets {
    main {
        java.srcDir("src/main/java")
    }
}

val YT_HOST: String by project
val YT_TOKEN: String by project

tasks {
    test {
        useJUnitPlatform()
        testLogging.showExceptions = true
        jvmArgs("-javaagent:${classpath.find { it.name.contains("jmockit") }!!.absolutePath}")
        environment("YT_HOST", YT_HOST)
        environment("YT_TOKEN",YT_TOKEN)
    }

    wrapper {
        gradleVersion = "6.3"
    }
}

pmd {
    isIgnoreFailures = true
    toolVersion = "6.22.0"
}

spotbugs {
    showProgress.set(true)
    toolVersion.set("4.0.2")
    ignoreFailures.set(true)

    tasks.spotbugsMain {
        reports.create("html") {
            isEnabled = true
            setStylesheet("fancy-hist.xsl")
        }
    }

    tasks.spotbugsTest {
        reports.create("html") {
            isEnabled = true
            setStylesheet("fancy-hist.xsl")
        }
    }
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = false
        csv.isEnabled = false
        html.isEnabled = true
    }
}

tasks.buildDashboard




