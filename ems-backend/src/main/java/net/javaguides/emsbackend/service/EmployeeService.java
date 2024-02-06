package net.javaguides.emsbackend.service;

import java.util.List;

import net.javaguides.emsbackend.web.Employee.EmployeeDto;

public interface EmployeeService {
    EmployeeDto creatEmployeeForm(EmployeeDto employeeForm);

    EmployeeDto getEmployeeFormId(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long id , EmployeeDto updateDto);

    void delete(Long id);
}
