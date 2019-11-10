import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Booker booker = new Booker();

        Employee employee1 = new Proger("Ivanov", "+380",10000, 100);
        Employee employee2 = new Manager("Petrov", "+380", 2000, 50);
        Employee employee3 = new Manager("Sidorov", "+380", 1000, 120);
        booker.addEmployee(employee1);
        booker.addEmployee(employee2);
        booker.addEmployee(employee3);
        booker.getEmployees().forEach(System.out::println);
        //System.out.println(booker.writeToXml("employees"));

        //Booker booker2 = new Booker();
        //System.out.println(booker2.readFromXml("employees"));
        //booker2.getEmployees().forEach(System.out::println);
        //System.out.println(booker2.calculateSalary(100));

    }
}
