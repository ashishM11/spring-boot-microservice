package com.jpmchase.cib.loan.mapper;

import com.jpmchase.cib.loan.dto.LoanTypeRequestResponseDTO;
import com.jpmchase.cib.loan.model.LoanType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoanTypeMapper {

    LoanTypeMapper  INSTANCE = Mappers.getMapper(LoanTypeMapper.class);

    LoanTypeRequestResponseDTO fromLoanToLoanRequestResponseDto(LoanType loanType);

}
