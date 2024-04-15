package com.jpmchase.cib.customer.mapper;

import com.jpmchase.cib.customer.dto.BranchRequestResponseDTO;
import com.jpmchase.cib.customer.model.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BranchMapper {

    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class );

    BranchRequestResponseDTO branchToBranchRequestResponseDTO(Branch branch);

    List<BranchRequestResponseDTO> fromSetOfBranchToBranchRequestResponseDtos(List<Branch> branches);

    Branch fromBranchRequestResponeDTOtoBranch(BranchRequestResponseDTO branchRequestResponseDTO);
}
