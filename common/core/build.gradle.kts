dependencies {
    implementation(platform(libs.spring.cloud.dependencies))

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    testImplementation(libs.spring.boot.starter.test)
}

tasks.bootJar {
    enabled = false
}
tasks.jar {
    enabled = true
}
