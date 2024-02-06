package net.javaguides.emsbackend.web.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.emsbackend.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // テーブルに新しくデータを作成する
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeForm) {
        EmployeeDto saveEntity = employeeService.creatEmployeeForm(employeeForm);
        return new ResponseEntity<>(saveEntity, HttpStatus.CREATED);
    }

    // 特定のidのリストを取得
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        EmployeeDto employeeForm = employeeService.getEmployeeFormId(id);
        return ResponseEntity.ok(employeeForm);

    }

    // テーブルのリストを全件取得
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEntity() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // テーブルの更新
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updataEntity(@PathVariable("id") Long id,
            @RequestBody EmployeeDto upadateEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(id, upadateEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // テーブルの削除
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("Employee deleted Succes");
    }
}
