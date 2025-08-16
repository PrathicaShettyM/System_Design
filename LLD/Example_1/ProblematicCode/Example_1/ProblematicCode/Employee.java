// This is a Employee Management System
// Similar to applications like Workday, Rippling

// problem with this code
// this class is trying to do too many things
// hence there are too many reasons to change this code
// hence this is a Monster class
package Example_1.ProblematicCode;
public class Employee {
    private int id; // emp id
    private String name; // emp name
    private String address; // emp address

    public Employee(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // suppose you want to change the report format from word to excel this code changes
    // then this code needs an update
    public void printPerformanceReport(){
        // code for printing performance report
        System.out.println("Performance report for employee: " + name);
    }

    // if taxation changes, we need to change this code
    public double computeSalary(){
        // code for computing salary
        return 1000.0;
    }

    // suppose this was done on excel sheets
    // now the company scales and we need a DB to store all these
    public void updateEmployeeData(){
        // code for updating employee data
        System.out.println("Updating data for employee: " + name);
    }

    public void fetchEmployeeData(){
        // code for fetching employee data
        System.out.println("Fetching data for employee: " + name);
    }
}

// Since the above class is doing too many things, there are too many reasons to change this code
// This violates the Single Responsibility Principle (SRP) of SOLID principles
// Single Responsibility Principle states that a there should only be one and only one reason to change a class / piece of code
// So all these functions can be separately handled
