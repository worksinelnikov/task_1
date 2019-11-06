import java.util.ArrayList;
import java.util.List;

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

    public double calculateSalary(int hoursInMonth) {

        if (employees != null && !employees.isEmpty()) {
            return employees.stream().mapToDouble(c -> c.getMonthSalary(hoursInMonth)).sum();
        }
        return 0;
    }
}
