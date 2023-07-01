package com.company.DI.dto.request;

import com.company.DI.dao.entity.EmployeeEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeUpdateRequest {
    String name;
    Integer age;
    Integer isActive;

    public EmployeeEntity toEntity(EmployeeEntity employee) {
        employee.setName(this.name);
        employee.setAge(this.age);
        employee.setIsActive(this.isActive);
        return employee;
    }
}
