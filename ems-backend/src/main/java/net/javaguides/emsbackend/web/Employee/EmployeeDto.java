package net.javaguides.emsbackend.web.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    

}
