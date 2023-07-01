package com.company.DI.dto.response;

import com.company.DI.dao.entity.EmployeeEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResponse {
    String name;
    Integer age;
    Integer isActive;

    public static EmployeeResponse fromEntity(EmployeeEntity employee){
        return EmployeeResponse.builder()
                .name(employee.getName())
                .age(employee.getAge())
                .isActive(employee.getIsActive())
                .build();
    }
}
