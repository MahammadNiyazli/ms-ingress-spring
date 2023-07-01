package com.company.DI.service;

import com.company.DI.dao.entity.EmployeeEntity;
import com.company.DI.dao.repository.EmployeeRepository;
import com.company.DI.dto.request.EmployeeSaveRequest;
import com.company.DI.dto.request.EmployeeUpdateRequest;
import com.company.DI.dto.response.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeResponse findById(Long id){
        return EmployeeResponse.fromEntity(findByIdOrElseThrow(id));
    }

    public void saveEmployee(EmployeeSaveRequest request){
        employeeRepository.save(request.toEntity());
    }

    public void updateEmployee(EmployeeUpdateRequest request, Long id){
        EmployeeEntity employee = findByIdOrElseThrow(id);
        employeeRepository.save(request.toEntity(employee));
    }


    public void deleteEmployee(Long id){
        EmployeeEntity employee = findByIdOrElseThrow(id);
        employee.setIsActive(0);
        employeeRepository.save(employee);
    }


    //private helper methods

    private EmployeeEntity findByIdOrElseThrow(Long id){
       return employeeRepository.findById(id).orElseThrow();
    }
}
