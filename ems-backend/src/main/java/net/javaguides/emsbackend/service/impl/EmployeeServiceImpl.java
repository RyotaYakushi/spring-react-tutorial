package net.javaguides.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.mapper.EmployeeMapper;
import net.javaguides.emsbackend.repositpry.EmployeeRepository;
import net.javaguides.emsbackend.service.EmployeeService;
import net.javaguides.emsbackend.web.Employee.EmployeeDto;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository repository;

    @Override
    public EmployeeDto creatEmployeeForm(EmployeeDto employeeForm) {
        Employee employeeEntity = EmployeeMapper.mapToEmployeeEntity(employeeForm);
        Employee saveEntity = repository.save(employeeEntity);
        return EmployeeMapper.mapToEmployeeForm(saveEntity);

    }

    @Override
    public EmployeeDto getEmployeeFormId(Long id) {
        Employee employeeEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        return EmployeeMapper.mapToEmployeeForm(employeeEntity);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeEntities = repository.findAll();
        return employeeEntities.stream().map((employee) -> EmployeeMapper.mapToEmployeeForm(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updateDto) {

        Employee employeeEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        employeeEntity.setFirstName(updateDto.getFirstName());
        employeeEntity.setLastName(updateDto.getLastName());
        employeeEntity.setEmail(updateDto.getEmail());

        Employee updateEmployeeObj = repository.save(employeeEntity);
        return EmployeeMapper.mapToEmployeeForm(updateEmployeeObj);
    }

    @Override
    public void delete(Long id) {
        Employee employeeEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        repository.deleteById(id);
    }
}
