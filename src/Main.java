public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 2.7");
        System.out.println("Базовая сложность");

        EmployeeBook employeeBook = new EmployeeBook();

        // employeeBook.getEmployees()[0] = new Employee("Первый Сотрудник Сотрудниковый", 5, 100000);
        //employeeBook.getEmployees()[1] = new Employee("Второй Сотрудник Сотрудниковый", 1, 111);
        //employeeBook.getEmployees()[2] = new Employee("Третий Сотрудник Сотрудниковый", 2, 300000);
        employeeBook.addNewEmployee(new Employee("Четвёртый Сотрудник Сотрудниковый", 2, 50000));
        employeeBook.addNewEmployee(new Employee("Пятый Сотрудник Сотрудниковый", 4, 150000));
        employeeBook.addNewEmployee(new Employee("Шестой Сотрудник Сотрудниковый", 2, 120000));
        employeeBook.addNewEmployee(new Employee("Седьмой Сотрудник Сотрудниковый", 3, 170000));
        employeeBook.addNewEmployee(new Employee("Девятый Сотрудник Сотрудниковый", 2, 99999999));
        employeeBook.addNewEmployee(new Employee("Десятый Сотрудник Сотрудниковый", 5, 50000));


        employeeBook.printAllEmployees();
//        System.out.println();
//        System.out.println("Сумма затрат на зарплаты в месяц: " + employeeBook.getSalarySumPerMonth(employeeBook.getEmployees()));
//        System.out.println();
//        employeeBook.printAllEmployeesWithMinSalary(employeeBook.getEmployees());
//        System.out.println();
//        employeeBook.printAllEmployeesWithMaxSalary(employeeBook.getEmployees());
//        System.out.println();
//        System.out.println("Средняя ЗП за месяц: " + employeeBook.getAverageSalary(employeeBook.getEmployees()));
//        System.out.println();
//        employeeBook.printAllEmployeesFullName(employeeBook.getEmployees());
//        System.out.println();
//        employeeBook.setIncreaseSalaryByPercentToAllEmployees(employeeBook.getEmployees(), 10);
//        employeeBook.printAllEmployees(employeeBook.getEmployees());
//        System.out.println();
//        employeeBook.printEmployeeWithMinSalaryInDept(employeeBook.getEmployees(), 2);
//        System.out.println();
//        employeeBook.printEmployeeWithMaxSalaryInDept(employeeBook.getEmployees(), 2);
//        System.out.println();
//        employeeBook.printMonthSalaryInDept(employeeBook.getEmployees(), 2);
//        System.out.println();
//        employeeBook.printAverageSalaryInDept(employeeBook.getEmployees(), 2);
//        System.out.println();
//        employeeBook.setIncreaseSalaryByPercentInDept(employeeBook.getEmployees(), 2, 30);
//        employeeBook.printAllEmployeesInDept(employeeBook.getEmployees(), 2);
//        System.out.println();
//        employeeBook.printAllEmployeesSalaryLowerThanThis(employeeBook.getEmployees(), 120000);
//        System.out.println();
//        employeeBook.printAllEmployeesSalaryUpperThanThis(employeeBook.getEmployees(), 200000);
//        System.out.println();
        employeeBook.addNewEmployee(new Employee("Первый Сотрудник Сотрудниковый", 5, 50000));
        employeeBook.printAllEmployees();
        System.out.println("Удаляем");
        employeeBook.deleteEmployee("Первый Сотрудник Сотрудниковый", 9);
        employeeBook.printAllEmployees();
        System.out.println("меняем спек сотрудника Первый");
        employeeBook.changeEmployeeSpecs("Первый Сотрудник Сотрудниковый",102,888);
        employeeBook.printAllEmployees();
        System.out.println();
        employeeBook.printAllEmployeesByDepartments();
    }
}