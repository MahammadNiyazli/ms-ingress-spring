package com.company.DI.service.specification;

import com.company.DI.dao.entity.EmployeeEntity;
import com.company.DI.dto.criteria.EmployeeCriteria;
import com.company.DI.util.PredicateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.Specification;

import static com.company.DI.constant.FieldConstants.EmployeeFields.AGE;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeSpecification implements Specification<EmployeeEntity> {

    EmployeeCriteria employeeCriteria;

    @Override
    public Predicate toPredicate(Root<EmployeeEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var predicates = PredicateUtil.builder()
                .addNullSafety(employeeCriteria.getAgeFrom(), ageFrom-> cb.greaterThan(root.get(AGE), ageFrom))
                .addNullSafety(employeeCriteria.getAgeTo(), ageTo-> cb.lessThan(root.get(AGE), ageTo))
                .build();

        return cb.and(predicates);
    }
}
