public class Manager extends Employee {
    private double workedHours;

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public Manager(String name, double salary, double hours) {
        this.name = name;
        this.salary = salary;
        this.hours = hours;
    }

    @Override
    protected double getMonthSalary() {
        return getHoursPercent(workedHours) >= 100 ? salary : getHoursPercent(workedHours) * salary / 100;
    }
}
