package com.company.DI.dto.response.base;

import com.company.DI.dao.entity.EmployeeEntity;
import com.company.DI.dto.response.EmployeeResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PageableEmployeeResponse {
    List<EmployeeResponse> employeeResponseList;
    int lastPageNumber;
    long totalElements;
    boolean hasNextPage;

    public static PageableEmployeeResponse fromEntity(Page<EmployeeEntity> employeePage){
        return PageableEmployeeResponse.builder()
                .employeeResponseList(employeePage.stream().map(EmployeeResponse::fromEntity).collect(Collectors.toList()))
                .lastPageNumber(employeePage.getTotalPages())
                .totalElements(employeePage.getTotalElements())
                .hasNextPage(employeePage.hasNext())
                .build();
    }
}
