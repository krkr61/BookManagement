import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
    id("org.flywaydb.flyway") version "7.2.1"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    id("org.jooq.jooq-codegen-gradle") version "3.19.8"
}

group = "com.submission"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.jooq:jooq")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    jooqCodegen("org.postgresql:postgresql")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val jdbcDriver by extra("org.postgresql.Driver")
val jdbcUrl by extra("jdbc:postgresql://localhost:5432/bookmanagement")
val jdbcUser by extra("admin")
val jdbcPassword by extra("password")
val jdbcSchema by extra("public")

flyway {
    driver = jdbcDriver
    url = jdbcUrl
    user = jdbcUser
    password = jdbcPassword
    schemas = arrayOf(jdbcSchema)

}

jooq {
    version = "3.19.8"
    configuration {
        jdbc {
            driver = jdbcDriver
            url = jdbcUrl
            user = jdbcUser
            password = jdbcPassword
        }
        generator {
            database {
                name = "org.jooq.meta.postgres.PostgresDatabase"
                inputSchema = jdbcSchema
                includes = ".*"
            }
            target {
                packageName = "com.jooq.generate"
                directory = "src/main/java"
            }
        }
    }
}
tasks.named("jooqCodegen") { dependsOn("processResources") }

