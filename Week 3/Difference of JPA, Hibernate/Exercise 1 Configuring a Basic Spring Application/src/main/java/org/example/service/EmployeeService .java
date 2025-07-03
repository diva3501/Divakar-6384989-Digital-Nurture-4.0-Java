@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public void save() {
        Employee emp = new Employee();
        emp.setName("Bob");
        emp.setDepartment("Finance");
        repo.save(emp);
        System.out.println("Saved using Spring Data JPA");
    }
}
