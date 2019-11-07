/**
 * @author Oleg Sinelnikov 2019
 * @version 1.0
 */
public abstract class Employee {
    private String name;
    private String phone;
    private double salaryPerMonth;
    private double workedHours;
    final int PERCENT = 100;

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
     * @param name - employee name
     * @param phone - employee phone
     * @param salaryPerMonth - employee salary per month
     * @param workedHours - employee worked hours per month
     */
    public Employee(String name, String phone, double salaryPerMonth, double workedHours) {
        this.name = name;
        this.phone = phone;
        this.salaryPerMonth = salaryPerMonth;
        this.workedHours = workedHours;
    }

    protected double getHoursPercent(int hoursPerMonth) {
        return workedHours * PERCENT / hoursPerMonth;
    }

    /**
     * calculate Salary method, must be overridden in child classes
     * @param hoursPerMonth - parameter for Booker
     * @return double value Math.round in 2
     */
    protected abstract double getMonthSalary(int hoursPerMonth);

}
