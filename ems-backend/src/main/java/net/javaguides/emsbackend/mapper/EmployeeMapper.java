package net.javaguides.emsbackend.mapper;

import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.web.Employee.EmployeeDto;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeForm(Employee employeeEntity) {
        return new EmployeeDto(
                employeeEntity.getId(),
                employeeEntity.getFirstName(),
                employeeEntity.getLastName(),
                employeeEntity.getEmail());
    }

    public static Employee mapToEmployeeEntity(EmployeeDto employeeForm) {
        return new Employee(
                employeeForm.getId(),
                employeeForm.getFirstName(),
                employeeForm.getLastName(),
                employeeForm.getEmail());
    }
}
