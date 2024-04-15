package com.jpmchase.cib.account.mapper;

import com.jpmchase.cib.account.dto.BranchResponseDTO;
import com.jpmchase.cib.account.model.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchMapper {

    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);
    BranchResponseDTO fromBranchToBranchResponseDto(Branch branch);

}
