import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

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

    public boolean writeToXml(String fileName) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(String.format("%s.xml", fileName))))) {
            xmlEncoder.writeObject(this.getEmployees());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean readFromXml(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try (XMLDecoder xmlDecoder = new XMLDecoder((new BufferedInputStream(
                new FileInputStream(String.format("%s.xml", fileName)))))) {
            employees = (ArrayList<Employee>) xmlDecoder.readObject();
            this.setEmployees(employees);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean writeToJson(String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(String.format("%s.json", fileName))) {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter objectWriter = mapper.writer().forType(new TypeReference<List<Employee>>(){});
            objectWriter.writeValue(fileOutputStream,this.getEmployees());
            //mapper.writeValue(fileOutputStream, this.getEmployees());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean readFromJson(String fileName) throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(String.format("%s.json", fileName))) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Employee>>(){});
            List<Employee> employees = objectReader.readValue(fileInputStream);
            this.setEmployees(employees);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
