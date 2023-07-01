package com.company.DI.dto.request;

import com.company.DI.dao.entity.EmployeeEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeSaveRequest {
    String name;
    Integer age;

    public EmployeeEntity toEntity(){
        return EmployeeEntity.builder()
                .name(this.name)
                .age(this.age)
                .isActive(1)
                .build();
    }
}
