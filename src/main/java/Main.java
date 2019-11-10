import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws IOException {

        Booker booker = new Booker();

        Employee employee1 = new Proger("Ivanov", "+380",10000, 100);
        Employee employee2 = new Manager("Petrov", "+380", 1000, 50);
        Employee employee3 = new Manager("Sidorov", "+380", 1000, 200);


        booker.addEmployee(employee1);
        booker.addEmployee(employee2);
        booker.addEmployee(employee3);
        booker.getEmployees().forEach(System.out::println);

        System.out.println(employee1.getMonthSalary(100));
        System.out.println(employee2.getMonthSalary(100));
        System.out.println(employee3.getMonthSalary(100));
        System.out.println("---------------------------");
        System.out.println(booker.calculateSalary(100));

        //System.out.println(booker.writeToXml("employees"));
        System.out.println(booker.writeToJson("employees"));
        System.out.println("--------------------");
        Booker booker1 = new Booker();
        System.out.println(booker1.readFromJson("employees"));
        //System.out.println(booker1.readFromXml("employees"));
        booker1.getEmployees().forEach(System.out::println);
        System.out.println(booker1.calculateSalary(100));



        //System.out.println(booker.writeToXml("employees"));

        //Booker booker2 = new Booker();
        //System.out.println(booker2.readFromXml("employees"));
        //booker2.getEmployees().forEach(System.out::println);
        //System.out.println(booker2.calculateSalary(100));

    }


}
