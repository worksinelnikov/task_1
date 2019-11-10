import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Oleg Sinelnikov 2019
 * @version 1.0
 */

@JsonAutoDetect
public class Employee implements Serializable {
    private String name;
    private String phone;
    private double salaryPerMonth;
    private double workedHours;
    @JsonIgnore
    public final int PERCENT = 100;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(double salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    /**
     * Constructor with params
     *
     * @param name           - employee name
     * @param phone          - employee phone
     * @param salaryPerMonth - employee salary per month
     * @param workedHours    - employee worked hours per month
     */
    public Employee(String name, String phone, double salaryPerMonth, double workedHours) {
        this.name = name;
        this.phone = phone;
        this.salaryPerMonth = salaryPerMonth;
        this.workedHours = workedHours;
    }

    public double getHoursPercent(int hoursPerMonth) {
        return workedHours * PERCENT / hoursPerMonth;
    }

    /**
     * calculate Salary method, must be overridden in child classes
     *
     * @param hoursPerMonth - parameter for Booker
     * @return double value Math.round in 2
     */
    //protected abstract double getMonthSalary(int hoursPerMonth);
    protected double getMonthSalary(int hoursPerMonth){
        double salary = getSalaryPerMonth() * getHoursPercent(hoursPerMonth) / PERCENT;
        return Math.round(salary * 100.0) / 100.0;
    }
    @Override
    public String toString() {
        return String.format("Name: %s (phone %s)\tSalary per month: $%.2f\tWorked hours: %.2f", name, phone, salaryPerMonth, workedHours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salaryPerMonth, salaryPerMonth) == 0 &&
                Double.compare(employee.workedHours, workedHours) == 0 &&
                name.equals(employee.name) &&
                phone.equals(employee.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, salaryPerMonth, workedHours, PERCENT);
    }
}
