plugins {
    id("java")
    id("io.quarkus") version "3.11.1"
}

group = "com.distribuida"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val quarkusVersion="3.11.1"

dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:${quarkusVersion}"))
    //Motor de CDI
    implementation("io.quarkus:quarkus-arc")

    //Motor de JAX RS en su version reactiva
    implementation("io.quarkus:quarkus-resteasy-reactive")

    //JSON
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")

    //JPA-hibernate
    implementation("io.quarkus:quarkus-hibernate-orm-panache")

    //Base de datos
    //implementation("com.h2database:h2:2.2.224")

    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.7.3")


}