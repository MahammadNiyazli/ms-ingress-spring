package com.company.DI.controller;

import com.company.DI.dto.criteria.EmployeeCriteria;
import com.company.DI.dto.criteria.PageCriteria;
import com.company.DI.dto.request.EmployeeSaveRequest;
import com.company.DI.dto.request.EmployeeUpdateRequest;
import com.company.DI.dto.response.EmployeeResponse;
import com.company.DI.dto.response.base.BaseResponse;
import com.company.DI.dto.response.base.PageableEmployeeResponse;
import com.company.DI.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public BaseResponse<?> saveEmployee(@RequestBody EmployeeSaveRequest request){
        employeeService.saveEmployee(request);
        return BaseResponse.success();
    }

    @PutMapping("/{id}")
    public BaseResponse<?> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeUpdateRequest request){
        employeeService.updateEmployee(request, id);
        return BaseResponse.success();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<?> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return BaseResponse.success();
    }

    @GetMapping("/{id}")
    public BaseResponse<?> getEmployeeById(@PathVariable Long id){
        EmployeeResponse response = employeeService.findById(id);
        return BaseResponse.success(response);
    }

    @GetMapping
    public BaseResponse<?> getEmployees(PageCriteria pageCriteria, EmployeeCriteria employeeCriteria){
        PageableEmployeeResponse response = employeeService.getEmployees(pageCriteria, employeeCriteria);
        return BaseResponse.success(response);
    }
}
