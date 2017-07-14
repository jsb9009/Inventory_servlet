package sample.dto;

/**
 * Created by jaliya on 7/14/17.
 */

/**
 * encapsulation of employee data
 */
public class EmployeeDto {

    public EmployeeDto(String employeeNumber, String employeeName, String position) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.position = position;
    }

    private String employeeNumber;
    private String employeeName;
    private String position;

    public String getEmployeeNumber() {

        return employeeNumber;
    }

    public String getEmployeeName() {


        return employeeName;
    }

    public String getEmployeePosition() {


        return position;
    }


}
