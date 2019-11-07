public class Proger extends Employee {

    public Proger(String name, String phone, double salaryPerMonth, double workedHours) {
        super(name, phone, salaryPerMonth, workedHours);
    }

    @Override
    protected double getMonthSalary(int hoursPerMonth) {
        double salary = getSalaryPerMonth() * getHoursPercent(hoursPerMonth) / PERCENT;
        return Math.round(salary * 100.0) / 100.0;
    }
}
