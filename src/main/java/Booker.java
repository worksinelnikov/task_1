import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Booker {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Booker() {
        this.employees = new ArrayList<Employee>();
    }

    public boolean addEmployee(Employee employee) {
        if (employees != null) {
            employees.add(employee);
            return true;
        }
        return false;
    }

    public double calculateSalary() {
        if (employees != null && !employees.isEmpty()) {
            return employees.stream().mapToDouble(Employee::getMonthSalary).sum();
        }
        return 0;
    }
}
