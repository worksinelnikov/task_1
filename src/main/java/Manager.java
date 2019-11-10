public class Manager extends Employee{
    public Manager() {}

    public Manager(String name, String phone, double salaryPerMonth, double workedHours) {
        super(name, phone, salaryPerMonth, workedHours);
    }

    @Override
    public double getMonthSalary(int hoursPerMonth) {
        double salary = getWorkedHours() >= hoursPerMonth ? getSalaryPerMonth() : super.getMonthSalary(hoursPerMonth);
        return Math.round(salary * 100.0) / 100.0;
    }
}
