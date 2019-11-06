public class Manager extends Employee {

    public Manager(String name, String phone, double salaryPerMonth, double workedHours) {
        this.name = name;
        this.phone = phone;
        this.salaryPerMonth = salaryPerMonth;
        this.workedHours = workedHours;
    }

    @Override
    protected double getMonthSalary(int hoursPerMonth) {
        return workedHours >= hoursPerMonth ? salaryPerMonth : salaryPerMonth * getHoursPercent(hoursPerMonth) / PERCENT;
    }
}
