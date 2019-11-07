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

    public Employee(String name, String phone, double salaryPerMonth, double workedHours) {
        this.name = name;
        this.phone = phone;
        this.salaryPerMonth = salaryPerMonth;
        this.workedHours = workedHours;
    }

    protected double getHoursPercent(int hoursPerMonth) {
        return workedHours * PERCENT / hoursPerMonth;
    }

    protected abstract double getMonthSalary(int hoursPerMonth);

}
