@Component vs @Bean :

@Bean is also an annotation that Spring uses to gather beans at runtime, but it’s not used at the class level. Instead, we annotate methods with @Bean so that Spring can store the method’s result as a Spring bean.
        
    @Bean
    Engine engine() {
       return new Engine();
    }
Note, that all methods annotated with @Bean must be in @Configuration classes

1. @Component is a class-level annotation, but @Bean is at the method level, so @Component is only an option when a class’s source code is editable. @Bean can always be used, but it’s more verbose.
2. @Component is compatible with Spring’s auto-detection, but @Bean requires manual class instantiation.
3. Using @Bean, decouples the instantiation of the bean from its class definition. This is why we can use it to make third-party classes into Spring beans. It also means we can introduce logic to decide which of several possible instance options for a bean to use.


@Value : injecting property values into beans or we can use placeholder strings in @Value to wire values defined in external sources
        
    @Value("${engine.fuelType}")
    String fuelType;    
    
    Engine(@Value("8") int cylinderCount) {
        this.cylinderCount = cylinderCount;
    }

@Qualifier : We use @Qualifier along with @Autowired to provide the bean id or bean name we want to use in ambiguous situations.
    
    class Bike implements Vehicle {}
    class Car implements Vehicle {}
    @Autowired
    Biker(@Qualifier("bike") Vehicle vehicle) {
        this.vehicle = vehicle;
    }

@Primary
Sometimes we need to define multiple beans of the same type. In these cases, the injection will be unsuccessful because Spring has no clue which bean we need.
    
    @Component
    @Primary
    class Car implements Vehicle {}
    
    @Component
    class Bike implements Vehicle {}

@Component: is a class level annotation.It allows Spring to detect our custom beans automatically. During the component scan, Spring Framework automatically detects classes annotated with @Component
They all act the same because they are all composed annotations with @Component as a meta-annotation for each of them

@ComponentScan : Spring uses the @ComponentScan annotation to gather them into its ApplicationContext.

    @SpringBootApplication
    @ComponentScan({"com.baeldung.component.inscope", "com.baeldung.component.scannedscope"})
    public class ComponentApplication {
    //public static void main(String[] args) {...}
    }

@Repository, @Service, @Configuration, and @Controller are all meta-annotations of @Component, they share the same bean naming behavior. Spring also automatically picks them up during the component scanning process.

@Repository : DAO or Repository classes usually represent the database access layer in an application it has automatic persistence exception translation enabled

@Service : The business logic of an application usually resides within the service layer.

@Controller : is a class level annotation, which tells the Spring Framework that this class serves as a controller in Spring MVC

@Configuration : 
1. classes can contain bean definition methods annotated with @Bean:
2. Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

@SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan.
it will automatically scan the components in the current package and its sub-packages. Thus it will register them in Spring’s Application Context, and allow us to inject beans using @Autowired.

@Autowired : mark a dependency which Spring is going to resolve and inject, we can use autowiring on properties, setters, and constructors.


    @Component("fooFormatter")
    public class FooFormatter {
        public String format() {
            return "foo";
        }
    }
    This will inject this bean into the FooService bean using @Autowired in the field defination
    
    @Component
    public class FooService {  
        @Autowired
        private FooFormatter fooFormatter;
    }

@Scope : We use @Scope to define the scope of a @Component class or a @Bean definition. It can be either singleton, prototype, request, session, globalSession or some custom scope.
        
    @Component
    @Scope("prototype")
    class Engine {}

@Profile : If we want Spring to use a @Component class or a @Bean method only when a specific profile is active, we can mark it with @Profile.
    
    @Component
    @Profile("sportDay")
    class Bike implements Vehicle {}
