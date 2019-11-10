public class Manager extends Employee{
    public Manager() {}

    public Manager(String name, String phone, double salaryPerMonth, double workedHours) {
        super(name, phone, salaryPerMonth, workedHours);
    }

    @Override
    protected double getMonthSalary(int hoursPerMonth) {
        double salary = getWorkedHours() >= hoursPerMonth ? getSalaryPerMonth() : getSalaryPerMonth() * getHoursPercent(hoursPerMonth) / PERCENT;
        return Math.round(salary * 100.0) / 100.0;
    }
}
