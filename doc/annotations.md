# Spring Boot basic annotations

In the example application, we have these Spring Boot annotations:

* `@Bean` - indicates that a method produces a bean to be managed by Spring.
* `@Service` - indicates that an annotated class is a service class.
* `@Repository` - indicates that an annotated class is a repository, which is an abstraction of data access and storage.
* `@Configuration` - indicates that a class is a configuration class that may contain bean definitions.
* `@Controller` - marks the class as web controller, capable of handling the requests.
* `@RequestMapping` - maps HTTP request with a path to a controller method.
* `@Autowired` - marks a constructor, field, or setter method to be autowired by Spring dependency injection.
* `@SpringBootApplication` - enables Spring Boot autoconfiguration and component scanning.

`@Component` is a generic stereotype for a Spring managed component. 
It turns the class into a Spring bean at the auto-scan time. 
Classes decorated with this annotation are considered as candidates for auto-detection 
when using annotation-based configuration and classpath scanning. 

`@Repository`, `@Service`, and `@Controller` are specializations of `@Component` for more specific use cases.

There are also Hibernate `@Entity`, `@Table`, `@Id`, and `@GeneratedValue` annotations.