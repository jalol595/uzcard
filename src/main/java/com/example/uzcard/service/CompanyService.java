package com.example.uzcard.service;

import com.example.uzcard.dto.AuthDTO;
import com.example.uzcard.dto.company.CompanyCreateDTO;
import com.example.uzcard.entity.CompanyEntity;
import com.example.uzcard.enums.GeneralRole;
import com.example.uzcard.enums.GeneralStatus;
import com.example.uzcard.exseptions.AlreadyExist;
import com.example.uzcard.repository.CompanyRepository;
import com.example.uzcard.util.BCryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void create(CompanyCreateDTO dto) {

        if(companyRepository.existsByName(dto.getName())){
            throw new AlreadyExist("Already exisists");
        }

        Optional<CompanyEntity> repository =
                companyRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (repository.isPresent()){
            throw new AlreadyExist("username and password busy");
        }
        companyRepository.save(toEntity(dto));

    }

    public CompanyEntity toEntity(CompanyCreateDTO dto){
        CompanyEntity entity = new CompanyEntity();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setContact(dto.getContact());
        entity.setUsername(dto.getUsername());
        entity.setPassword(BCryptUtil.getBCrypt(dto.getPassword()));
        entity.setCardEntity(null);
        entity.setRole(GeneralRole.ROLE_BANK);
        return entity;
    }

    public CompanyCreateDTO toDTO(CompanyEntity entity){
        CompanyCreateDTO response = new CompanyCreateDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setAddress(entity.getAddress());
        response.setContact(entity.getContact());
        response.setUsername(entity.getUsername());
        response.setRole(GeneralRole.ROLE_BANK);
        return response;
    }
}
