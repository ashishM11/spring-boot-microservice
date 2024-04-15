package com.jpmchase.cib.loan.repository;

import com.jpmchase.cib.loan.model.Loan;
import com.jpmchase.cib.loan.model.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType,Long> {

    Optional<LoanType> findByLoanType(String loanType);
}
