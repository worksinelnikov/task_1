public abstract class Employee {
    protected String name;
    protected double salary;
    protected double hours;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getHoursPercent(double workedHours) {
        return workedHours * 100 / hours;
    }

    protected abstract double getMonthSalary();

    public abstract void setWorkedHours(double workedHours);
}
