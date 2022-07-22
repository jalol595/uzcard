package com.example.uzcard.controller;

import com.example.uzcard.dto.AuthDTO;
import com.example.uzcard.dto.LoginDTO;
import com.example.uzcard.dto.company.CompanyCreateDTO;
import com.example.uzcard.service.AuthService;
import com.example.uzcard.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<LoginDTO> login(@RequestBody CompanyCreateDTO dto) {
        companyService.create(dto);
        /*    return ResponseEntity.ok().body(response);*/
        return null;
    }

}
