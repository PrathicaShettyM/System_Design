package Example_1.BetterCode;

public class EmployeePerformanceReportGenerator {
   public void printPerformanceReport(Employee e) {
       // code for generating performance report
       System.out.println("Performance report for " + e.getEmployeeName());
   } 
}

// now this class only handles performance report generation


// Now we have segregated the classes in a way such that there is one core 
// responsibility of every class has. Hence there is only one reason to change the logic