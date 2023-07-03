package com.company.DI.service;

import com.company.DI.dao.entity.EmployeeEntity;
import com.company.DI.dao.repository.EmployeeRepository;
import com.company.DI.dto.criteria.EmployeeCriteria;
import com.company.DI.dto.criteria.PageCriteria;
import com.company.DI.dto.request.EmployeeSaveRequest;
import com.company.DI.dto.request.EmployeeUpdateRequest;
import com.company.DI.dto.response.EmployeeResponse;
import com.company.DI.dto.response.base.PageableEmployeeResponse;
import com.company.DI.service.specification.EmployeeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.company.DI.constant.FieldConstants.COUNT_DEFAULT_VALUE;
import static com.company.DI.constant.FieldConstants.PAGE_DEFAULT_VALUE;

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

    public PageableEmployeeResponse getEmployees(PageCriteria pageCriteria, EmployeeCriteria employeeCriteria){
        Integer pageNumber = pageCriteria.getPage() == null ? PAGE_DEFAULT_VALUE : pageCriteria.getPage();
        Integer count = pageCriteria.getCount() == null ? COUNT_DEFAULT_VALUE : pageCriteria.getCount();

        Page<EmployeeEntity> employeePage = employeeRepository.findAll(new EmployeeSpecification(employeeCriteria), PageRequest.of(pageNumber, count));
        return PageableEmployeeResponse.fromEntity(employeePage);
    }



    //private helper methods

    private EmployeeEntity findByIdOrElseThrow(Long id){
       return employeeRepository.findById(id).orElseThrow();
    }
}
