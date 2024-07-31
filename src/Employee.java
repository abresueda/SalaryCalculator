import java.util.Scanner;

public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (salary < 1000) {
            return 0;
        } else {
            return (salary * 0.03);
        }
    }

    public double bonus() {
        if (workHours > 40) {
            return (workHours - 40) * 30;
        } else {
            return 0;
        }
    }

    public double raiseSalary() {
        int currentYear = 2021;
        int workYears = currentYear - hireYear;
        if (workYears < 10) {
            return salary * 0.05;
        } else if (workYears >= 10 && workYears < 20) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    @Override
    public String toString() {
        double taxAmount = tax();
        double bonusAmount = bonus();
        double raiseAmount = raiseSalary();
        double salaryWithTaxAndBonus = salary - taxAmount + bonusAmount;
        double totalSalary = salary + raiseAmount + bonusAmount - taxAmount;

        return "Name : " + name + "\n" +
                "Salary : " + salary + "\n" +
                "Work Hours : " + workHours + "\n" +
                "Hire Year : " + hireYear + "\n" +
                "Tax : " + taxAmount + "\n" +
                "Bonus : " + bonusAmount + "\n" +
                "Raise Salary : " + raiseAmount + "\n" +
                "Salary With Tax And Bonus : " + salaryWithTaxAndBonus + "\n" +
                "Total Salary : " + totalSalary;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = inp.nextLine();
        System.out.print("Enter your salary: ");
        double salary = inp.nextDouble();
        System.out.print("Enter your weekly work hours: ");
        int workHours = inp.nextInt();
        System.out.print("Enter your hire year: ");
        int hireYear = inp.nextInt();

        Employee emp = new Employee(name, salary, workHours, hireYear);
        System.out.println(emp);
    }

}