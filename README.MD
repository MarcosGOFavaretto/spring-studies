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

**Result of a GET request:**

![image](https://user-images.githubusercontent.com/71560285/227100330-12eae70d-f8c8-45c0-9f09-3db6af7154f4.png)

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

# CORS (Cross-Origin Resource Sharing)

CORS is an W3C specification. By using the HTTP headers, that mechanism can validate if a resource `A` can access another resource `B`.

## Same origin.
A same origin request happens on three situations:
- Same protocol (`http://` or `https://`);
- Same host (`www.myhost.com`, for example);
- Same HTTP port (`8080`, for example).

At that type of requests, the CORS will not throw any errors for the API's user.

## Different origin.
If any situation for same origin is violated, an error is displayed, telling that the resource is not accessible.

Besides, if still need, that validation can be disabled, by using the `Access-Control-Allow-Origin` header and providing for it all URLs that are allowed to be accessed by different resources. It is possible to also limit the HTTP verbs that resources can use, with the `Access-Control-Allow-Methods` header and passing all allowed verbs separated by comma.

## Examples
The following table has some examples:

|     URL of first resource      |       URL of second resource       |                                           Explanation                                            |
| :----------------------------: | :--------------------------------: | :----------------------------------------------------------------------------------------------: |
|    http://mywebapp.com/pets    |   https://mywebapp.com/api/pets    |              The CORS error **WILL** happen, since the **protocols** are different.              |
|    http://mywebapp.com/pets    |   https://mywebapp.dev/api/pets    |                The CORS error **WILL** happen, since the **URLs** are different.                 |
|   https://mywebapp.com/pets    |   https://mywebapp.com/api/pets    | The CORS error will not happen, since the protocol, host and port (which is hidden) are the same |
| https://mywebapp.com:8443/pets | https://mywebapp.com:8080/api/pets |                The CORS error **WILL** happen, since the **ports** are different.                |


## How to allow different origins on Spring.
The configuration can be done by implementing the `WebMvcConfigurer` interface and overloading the `addCorsMappings` method. Like showed below.

```java
package br.estudies.spring.pet.configuration;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedOrigins("https://mywebapp.com:8443/pets") // shows who can access that resource.
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"); // shows all accepted HTTPS verbs.
    }
}
```
That example is from [Alura](https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java/task/116048#:~:text=Habilitando%20diferentes%20origens%20no%20Spring%20Boot) post about CORS.

## Another references.

That topic also has information from [Gabriel Machado post on Treina Web](https://www.treinaweb.com.br/blog/o-que-e-cors-e-como-resolver-os-principais-erros).

# DTO (_Data Transfer Object_).

DTO (or _Data Transfer Object_) is an object used to transfer data between different parts of systems. That objects contains only the needed data that is being shared to another system, resulting in the economy of resources and more security.

Let's have a look at the JSON received by Pet API.

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

That JSON body can be used as a simple String object. On that approach, for any field we want to get its value, would be necessary to use String's method to extract that values.

Java allow us to represent that JSON with classes, by using its fields and methods. The above JSON can be represented by the following class.

```java
public class Pet {

    private String name;
    private double age;
    private String allergies;
    private Owner owner;

    // Getters and Setters are omitted.
}
```
> Notice that the code which populates the class is not implemented, since it is not the goal of that section.

When we are using _DTOs_, the idea is to share only the needed data about an entity. For example, let's suppose that a third part mobile app consumes the Pet API to ranking the most used names for pets based on its ages.

Since it is not necessary to share the owner's data, we can create a _DTO_ to provide just the necessary information. The following snippet shows a _DTO_ created for Pets that satisfies the the need for third-party software.

```java
public class PetDTO {

    private String name;
    private double age;

    // Getters and Setters are omitted.
}
```

Beyond the security, that kind of classes also improves cohesion and less coupling for our Java program.

# Records as DTOs.

After Java 14, we can use the keyword `record` to declare DTOs in a simpler way.

It contains only a constructor. All fields are declared as parameters and the get methods are created by Java without the need of we implement it. Let's create a record for the following DTO.

**DTO**
```java
public class PetDTO {

    private String name;
    private double age;

    public PetDTO (String name, String age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return this.age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
```

**Java record**
```java
public record PetDTOAsRecord(String name, String age) {}
```

After the instantiation of `PetDTOAsRecord`, all `get` methods are implemented by Java. It is important to notice that the records are immutable, because of it, `set` methods does not exists for `PetDTOAsRecord`.