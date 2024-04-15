package com.jpmchase.cib.customer.service;

import com.jpmchase.cib.customer.dto.BranchRequestResponseDTO;
import com.jpmchase.cib.customer.mapper.BranchMapper;
import com.jpmchase.cib.customer.model.Branch;
import com.jpmchase.cib.customer.repository.BranchRepository;
import com.jpmchase.cib.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchService {

    private BranchRepository branchRepository;
    private CustomerRepository customerRepository;

    public List<BranchRequestResponseDTO> getAllBankBranch() {
        return BranchMapper.INSTANCE.fromSetOfBranchToBranchRequestResponseDtos(branchRepository.findAll());
    }

    public BranchRequestResponseDTO saveBankBranch(BranchRequestResponseDTO requestDTO) {
        Branch branch = BranchMapper.INSTANCE.fromBranchRequestResponeDTOtoBranch(requestDTO);
        return BranchMapper.INSTANCE.branchToBranchRequestResponseDTO(branchRepository.save(branch));
    }


    public BranchRequestResponseDTO getBranchByCustId(Long custId) {
        return BranchMapper.INSTANCE.branchToBranchRequestResponseDTO(customerRepository.getReferenceById(custId).getBranch());
    }

    public BranchRequestResponseDTO getBranchByItsId(Long branchId) {
        return BranchMapper.INSTANCE.branchToBranchRequestResponseDTO(branchRepository.getReferenceById(branchId));
    }

}
