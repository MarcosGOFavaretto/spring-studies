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

# Running a Spring application.

By default, Spring Boot contains on its dependencies a server that runs our Java application: Apache Tomcat. Therefore, it is not necessary to download server applications.

Spring projects contains a class called as Project + Application, for example: ApiApplication, MySpringProjectApplication, etc.

> That class contains the `@SpringBootApplication` annotations, which means that the entry point is declared on that class.

By executing it, the Spring boot will turn the server up and provide our application for use.


```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.4)

[...] omitted.

2023-03-21T23:46:12.970-03:00  INFO 480 --- [  restartedMain] medi.voll.api.ApiApplication             : Started ApiApplication in 5.59 seconds (process running for 6.894)

```

# Hello World in Spring.

To create a Hello World in Spring Boot by using a RESTFull API is quite simple.

The first thing we need to do is create a class with the `@RestController` and `RequestMapping("/my/endpoint/name")` annotations.

>The **first** one defines that our class is a **RESTFull controller** that deals with the requests. The **second** one defines the **end-point** that triggers the created controller.

```java
package br.estudies.spring.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

}
```

It is also necessary to tell Spring what to return during our request. It can be implemented on GET requests, by using the `@GetMapping`.

>That annotation defines which method of the entire class should be executed on GET requests for the specified end-point.

```java
package br.estudies.spring.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping; // Added.
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    // Method and annotation added.
    @GetMapping
	public String sayHello() {
		return "Hello World!";
	}

}
```

Done! After run the `@SpringBootApplication` annotated class and access the [created end-point](http://localhost:8080/hello), a beautiful `Hello World!` message will be displayed.

# Voll Medi.

Voll Medi is an example of application that will be implemented during the [Alura Spring Boot course for Rest APIs](https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java).

During each class, the professor [Rodrigo Ferreira](https://www.linkedin.com/in/rcaneppele) improves functionalities for that API, teaching new concepts about Spring Boot.

That project is present on that repository, besides, its code will not be documented here, only its concepts.

# Creation of records
The creation of records at a Rest API is done by a POST request. Spring Boot allow us to create that kind of endpoint.

The first step is to create at the Controller class a new method, which has to be annotated with `@PostMapping`.

> The `@PostMapping` annotation sings to Spring Boot that method has to be executed when an POST request is received by the endpoint specified on `@RequestMapping("/address/of/your/endpoint")` annotation at the controller.

Let's create the PetController.

```java
package br.estudies.spring.pet.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {

}
```

Now, lets create a simple method that will be annotated with `@PostMapping`.

```java
package br.estudies.spring.pet.controller;

import org.springframework.web.bind.annotation.PostMapping; // added
import org.springframework.web.bind.annotation.RequestBody; // added
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {

	@PostMapping
	public void createPet(@RequestBody String body) {
		System.out.println(body);
	}
}

```
> The `@RequestBody` annotation will deserialize the received request's body to a parameter. Then, we can get a provided JSON in String or Pojo.

Then, if we make a PUT request for "/pets" endpoint, the provided body will be printed on terminal.

**CURL request:**
```bash
curl --location 'http://localhost:8080/pets' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Nino",
    "age": 10,
    "allergies": null,
    "owner": {
        "name": "Marcos Favaretto",
        "contact": {
            "phone": "+55 (019) 9 9467-2748",
            "email": "marcosfavaretto.dev@gmail.com"
        },
        "address": {
            "zip_code": "13614260",
            "street": "Rua Paulo Rebessi",
            "number": "42",
            "complement": null,
            "neighborhood": "Cidade Jardim",
            "city": "Leme",
            "state": "SP",
            "country": "Brazil"
        }
    }
}'
```

**Result printed on API's console:**
```json
{
    "name": "Nino",
    "age": 10,
    "allergies": null,
    "owner": {
        "name": "Marcos Favaretto",
        "contact": {
            "phone": "+55 (019) 9 9467-2748",
            "email": "marcosfavaretto.dev@gmail.com"
        },
        "address": {
            "zip_code": "13614260",
            "street": "Rua Paulo Rebessi",
            "number": "42",
            "complement": null,
            "neighborhood": "Cidade Jardim",
            "city": "Leme",
            "state": "SP",
            "country": "Brazil"
        }
    }
}
```
**Result of a GET request:**

![image](https://user-images.githubusercontent.com/71560285/227100330-12eae70d-f8c8-45c0-9f09-3db6af7154f4.png)
