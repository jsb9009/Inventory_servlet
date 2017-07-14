package sample.dao;

import sample.dto.EmployeeDto;
import sample.dto.ItemDto;

/**
 * Created by jaliya on 7/14/17.
 */

/**
 * providing an abstraction for the employee related data
 */
public interface EmployeeDao {
    //FIXME No need o public access modifier for interface methods.Remove
    public ItemDto createEmployee(EmployeeDto employeeDtoDto);
}
