package Example_1.BetterCode;

// This class follows the Single Responsibility Principle (SRP) by only handling employee data.
public class Employee {
    private int id; // emp id
    private String name; // emp name
    private String address; // emp address

    public Employee(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getEmployeeId() {
        return id;
    }

    public String getEmployeeName() {
        return name;
    }   

    public String getEmployeeAddress() {
        return address;
    }

    public void setEmployeeAddress(String address) {
        this.address = address;
    }

    public void setEemployeeName(String name) {
        this.name = name;
    }


}

// Now this class only handles employee data