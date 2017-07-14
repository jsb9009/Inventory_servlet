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

    ItemDto createEmployee(EmployeeDto employeeDtoDto);
}
