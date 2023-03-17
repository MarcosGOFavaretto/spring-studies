# Spring

That repository contains all of my studies about Spring.

# Difference between Spring Framework and Boot.

The Spring Framework is a modular Java framework, which means that it is not necessary to use all of them classes, resources and dependencies, allowing us to use less computer resources.

The Spring Boot is one of the modules created for Spring Framework. It allow us to create Spring projects more easily, since the number of modules for Spring applications is very large.

# Declaration of Spring Framework on Maven projects.

After select some modules for a new Spring application on [Spring Initializr](https://start.spring.io/), we can notice on `pom.xml` file that the Spring Framework is not a dependency at our application.

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.0.4</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

Spring Framework is declared as a parent. Because of that reason, all Spring's plugins (modules) does not requests the `<version>` tag, since that information is inherited of the parent `POM`.