plugins {
    `java-library`
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

    testImplementation("org.mockito:mockito-core:3.3.3")
    testImplementation( "org.powermock:powermock-module-junit5:1.6.4")
    testImplementation( "org.powermock:powermock-module-junit4:1.6.4")
    testImplementation( "org.powermock:powermock-api-mockito2:2.0.7")
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

tasks {
    test {
        testLogging.showExceptions = true
    }

    wrapper {
        gradleVersion = "6.3"
    }
}
