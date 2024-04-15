package com.jpmchase.cib.loan.mapper;
import com.jpmchase.cib.loan.dto.LoanRequestDTO;
import com.jpmchase.cib.loan.dto.LoanResponseDTO;
import com.jpmchase.cib.loan.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    Loan fromLoanRequestDTOtoLoan(LoanRequestDTO requestDTO);

    LoanResponseDTO fromLoanToLoanResponseDto(Loan loan);

}
