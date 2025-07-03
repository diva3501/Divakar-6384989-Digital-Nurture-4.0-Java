@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
    @Autowired
    private EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        service.save();
    }
}
