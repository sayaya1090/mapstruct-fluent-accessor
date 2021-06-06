# mapstruct-fluent-accessor

Usage
1. clone & build

   gradle publishToMavenLocal 커맨드로 프로젝트를 빌드하고 로컬 Maven Repository에 추가합니다.
   
   
2. gradle 의존성 추가
```grale
repositories {
    mavenCentral()
    mavenLocal()
}
dependencies {
    compileOnly("org.projectlombok:lombok")
    compileOnly("net.sayaya:mapstruct-fluent-accessor:1.0")
    compileOnly("org.mapstruct:mapstruct:1.4.2.Final")
    compileOnly("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("net.sayaya:mapstruct-fluent-accessor:1.0")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
}
```
