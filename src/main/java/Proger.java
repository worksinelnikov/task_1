public class Proger extends Employee {

    public Proger(String name, String phone, double salaryPerMonth, double workedHours) {
        this.name = name;
        this.phone = phone;
        this.salaryPerMonth = salaryPerMonth;
        this.workedHours = workedHours;
    }

    @Override
    protected double getMonthSalary(int hoursPerMonth) {
        return salaryPerMonth * getHoursPercent(hoursPerMonth) / PERCENT;
    }
}
