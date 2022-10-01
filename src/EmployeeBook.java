import java.util.Arrays;
import java.util.Comparator;

public class EmployeeBook {
    //- **Очень сложно**
    //    Привести структуру проекта к ООП.
    //    1. +Создать класс EmployeeBook.
    //    2. +Перенести хранилище сотрудников в него (массив), закрыть к нему доступ извне (сделать приватным).
    //    3. +Все статические методы по работе с массивом перенести в этот класс и сделать нестатическими.
    //    4. Добавить несколько новых методов:
    //        +1. Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
    //        Нужно найти свободную ячейку в массиве и добавить нового сотрудника в нее.
    //        Искать нужно всегда с начала, так как возможно добавление в ячейку удаленных ранее сотрудников.
    //        +2. Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве).
    //    5. Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
    //        +1. Изменить зарплату.
    //        +2. Изменить отдел.
    //        Придумать архитектуру. Сделать или два метода, или один, но продумать его.
    //    6. +Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
    private Employee[] employees = new Employee[10];

    public void addNewEmployee(Employee newEmployee) {
        boolean isEmployeeNotInBook = true;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].equals(newEmployee)) {
                    System.out.println("Такой сотрудник " + employees[i] + " уже есть в базе");
                    isEmployeeNotInBook = false;
                }
            } else if (isEmployeeNotInBook) {
                employees[i] = newEmployee;
                break;
            }
        }
    }

    public void deleteEmployee(String fullNameEmployeeToDelete, int id) {
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && ((employees[i].getFio().equals(fullNameEmployeeToDelete))) && (employees[i].getId() == id)) {
                employees[i] = null;
            }
        }
    }

    public void changeEmployeeSpecs(String fullNameEmployeeToChange, int newSalary, int newDepartment) {
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].getFio().equals(fullNameEmployeeToChange))) {
                if (newSalary != employees[i].getSalary()) {
                    employees[i].setSalary(newSalary);
                }
                if (employees[i].getDepartment() != newDepartment) {
                    employees[i].setDepartment(newDepartment);
                }
            }
        }
    }

    public void printAllEmployeesByDepartments(Employee[] employeesList) {
        Employee[] solidEmployeeList = new Employee[employeesList.length];
        int counter = 0;
        for (int i = 0; i < employeesList.length; i++) {
            if (employees[i] != null) {
                solidEmployeeList[counter] = employeesList[i];
                counter++;
            }
        }
        employeesList = Arrays.copyOf(solidEmployeeList, counter);
        Arrays.sort(employeesList, Comparator.comparing(Employee::getDepartment));

        boolean isDiffDept = true;
        for (int i = 0; i < employeesList.length; i++) {
            if (isDiffDept) {
                System.out.println("Сотрудники отдела №" + employeesList[i].getDepartment() + ":");
            }
            System.out.println(employeesList[i].getFio());
            if ((i + 1) > employeesList.length - 1) {
                break;
            } else if (employeesList[i].getDepartment() == employeesList[i + 1].getDepartment()) {
                isDiffDept = false;
            } else isDiffDept = true;
        }
    }

    public void printAllEmployees(Employee[] employeesList) {
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i] != null) {
                System.out.println(employeesList[i]);
            }
        }
    }

    public int getSalarySumPerMonth(Employee[] employeesList) {
        int summ = 0;
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i] != null) {
                summ += employeesList[i].getSalary();
            }
        }
        return summ;
    }

    public void printAllEmployeesWithMinSalary(Employee[] employeesList) {
        int min = 0;
        int firstNotNullCell = 0;
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i] != null) {
                min = employeesList[i].getSalary();
                firstNotNullCell = i;
                break;
            }
        }
        Employee[] minSalaryEmployees = new Employee[employeesList.length];
        for (int i = firstNotNullCell; i < employeesList.length; i++) {
            if ((employeesList[i] != null) && (employeesList[i].getSalary() < min)) {
                min = employeesList[i].getSalary();
                minSalaryEmployees[i] = employeesList[i];
            }
        }
        //2 цикла так как сотрудников может быть не один, сначала находим с минимальной ЗП, потом находим всех с такой ЗП
        for (int i = firstNotNullCell; i < employeesList.length; i++) {
            if ((employeesList[i] != null) && (min == employeesList[i].getSalary())) {
                System.out.println("Минимальная ЗП: " + employeesList[i]);
            }
        }
    }

    public void printAllEmployeesWithMaxSalary(Employee[] employeesList) {
        int max = 0;
        int firstNotNullCell = 0;
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i] != null) {
                max = employeesList[i].getSalary();
                firstNotNullCell = i;
                break;
            }
        }
        for (int i = firstNotNullCell; i < employeesList.length; i++) {
            if ((employeesList[i] != null) && (employeesList[i].getSalary() >= max)) {
                max = employeesList[i].getSalary();
            }
        }//2 цикла так как сотрудников может быть не один, сначала находим с минимальной ЗП, потом находим всех с такой ЗП
        for (int i = firstNotNullCell; i < employeesList.length; i++) {
            if ((employeesList[i] != null) && (max == employeesList[i].getSalary())) {
                System.out.println("Максимальная ЗП: " + employeesList[i]);
            }
        }
    }

    private int getNumberOfEmployees(Employee[] employeesList) {
        int num = 0;
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i] != null) {
                num++;
            }
        }
        return num;
    }

    public int getAverageSalary(Employee[] employeesList) {
        int num = getNumberOfEmployees(employeesList);
        if (num == 0) {
            return num;
        } else {
            return (getSalarySumPerMonth(employeesList) / num);
        }
    }

    public void printAllEmployeesFullName(Employee[] employeesList) {
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i] != null) {
                System.out.println(employeesList[i].getFio());
            }
        }
    }

    public Employee[] setIncreaseSalaryByPercentToAllEmployees(Employee[] employeesList, int percent) {
        float coefficient = ((percent / 100f) + 1f);      //получаем коэффициент пересчёта процентов
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i] != null) {
                employeesList[i].setSalary((int) (employeesList[i].getSalary() * (coefficient)));
            }
        }
        return employeesList;
    }

    private Employee[] getSpecificDepartment(Employee[] employeesList, int deptId) {
        Employee[] employeesByDept = new Employee[employeesList.length];
        int j = 0;
        for (int i = 0; i < employeesList.length; i++) {
            if ((employeesList[i] != null) && (employeesList[i].getDepartment() == deptId)) {
                employeesByDept[j] = employeesList[i];
                j++;
            }
        }
        employeesByDept = Arrays.copyOf(employeesByDept, j);
        return employeesByDept;
    }

    public void printEmployeeWithMinSalaryInDept(Employee[] employeesList, int deptId) {
        System.out.println("По отделу " + deptId + " ");
        printAllEmployeesWithMinSalary(getSpecificDepartment(employeesList, deptId));
    }

    public void printEmployeeWithMaxSalaryInDept(Employee[] employeesList, int deptId) {
        System.out.println("По отделу " + deptId + " ");
        printAllEmployeesWithMaxSalary(getSpecificDepartment(employeesList, deptId));
    }

    public void printMonthSalaryInDept(Employee[] employeesList, int deptId) {
        System.out.println("Сумма затрат на зарплату в месяц по отделу № " + deptId + " равна: " + getSalarySumPerMonth(getSpecificDepartment(employeesList, deptId)));
    }

    public void printAverageSalaryInDept(Employee[] employeesList, int deptId) {
        System.out.println("Средняя зарплата по отделу № " + deptId + " равна: " + getAverageSalary(getSpecificDepartment(employeesList, deptId)));
    }

    public void setIncreaseSalaryByPercentInDept(Employee[] employeesList, int deptId, int percent) {
        setIncreaseSalaryByPercentToAllEmployees(getSpecificDepartment(employeesList, deptId), percent);
    }

    public void printAllEmployeesInDept(Employee[] employeesList, int deptId) {
        System.out.println("Сотрудники в отделе: " + deptId);
        Employee[] deptEmployee = getSpecificDepartment(employeesList, deptId);
        for (int i = 0; i < deptEmployee.length; i++) {
            System.out.println(deptEmployee[i].toStringDept());
        }
    }

    public void printAllEmployeesSalaryLowerThanThis(Employee[] employeesList, int edge) {
        System.out.println("Сотрудники с ЗП ниже чем " + edge);
        for (int i = 0; i < employeesList.length; i++) {
            if ((employeesList[i] != null) && (employeesList[i].getSalary() < edge)) {
                System.out.println("id: " + employeesList[i].getId() + ", ФИО: " + employeesList[i].getFio() + ", З/П: " + employeesList[i].getSalary());
            }
        }
    }

    public void printAllEmployeesSalaryUpperThanThis(Employee[] employeesList, int edge) {
        System.out.println("Сотрудники с ЗП выше чем " + edge);
        for (int i = 0; i < employeesList.length; i++) {
            if ((employeesList[i] != null) && (employeesList[i].getSalary() >= edge)) {
                System.out.println("id: " + employeesList[i].getId() + ", ФИО: " + employeesList[i].getFio() + ", З/П: " + employeesList[i].getSalary());
            }
        }
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
