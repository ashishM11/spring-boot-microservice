package com.jpmchase.cib.customer.mapper;

import com.jpmchase.cib.customer.dto.BranchRequestResponseDTO;
import com.jpmchase.cib.customer.dto.CustomerRequestDTO;
import com.jpmchase.cib.customer.dto.CustomerResponseDTO;
import com.jpmchase.cib.customer.model.Branch;
import com.jpmchase.cib.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class );

    @Mapping(source = "branch", target = "branch", qualifiedByName = "setBranchResponse")
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);

    @Mapping(source = "branch", target = "branch", qualifiedByName = "setBranchResponse")
    List<CustomerResponseDTO> fromListOfCustomersToCustomerResponseDTOS(List<Customer> customerList);

    @Named("setBranchResponse")
    default BranchRequestResponseDTO setBranchResponse(Branch branch) {
        return BranchMapper.INSTANCE.branchToBranchRequestResponseDTO(branch);
    }

    Customer fromCustomerRequestDtoToCustomer(CustomerRequestDTO customerRequestDTO);

}
