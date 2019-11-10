import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
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
            double salary = employees.stream().mapToDouble(c -> c.getMonthSalary(hoursInMonth)).sum();
            return Math.round(salary * 100.0) / 100.0;
        }
        return 0;
    }

    public boolean writeToXml(String fileName) throws IOException {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(String.format("%s.xml", fileName))))) {
            xmlEncoder.writeObject(this.getEmployees());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean readFromXml(String fileName) throws IOException{
        List<Employee> employees = new ArrayList<>();
        try (XMLDecoder xmlDecoder = new XMLDecoder((new BufferedInputStream(
                new FileInputStream(String.format("%s.xml", fileName)))))){
            employees = (ArrayList<Employee>)xmlDecoder.readObject();
            this.setEmployees(employees);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
