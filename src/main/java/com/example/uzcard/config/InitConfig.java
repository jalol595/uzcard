package com.example.uzcard.config;


import com.example.uzcard.entity.CompanyEntity;
import com.example.uzcard.entity.ProfileEntity;
import com.example.uzcard.enums.GeneralRole;
import com.example.uzcard.enums.GeneralStatus;
import com.example.uzcard.repository.CompanyRepository;
import com.example.uzcard.repository.ProfileRepository;
import com.example.uzcard.util.BCryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class InitConfig {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Bean
    CommandLineRunner ok() {
        return args -> {
            Optional<ProfileEntity> optional = profileRepository.findByUsername("uz_card_moder");
            if (optional.isPresent()){
                return;
            }
            String bCrypt = BCryptUtil.getBCrypt("123");

            ProfileEntity admin = new ProfileEntity();
            admin.setName("Admin");
            admin.setSurname("adminjon");
            admin.setUsername("uz_card_admin");
            admin.setPassword(bCrypt);
            admin.setVisible(true);
            admin.setStatus(GeneralStatus.ACTIVE);
            admin.setRole(GeneralRole.ROLE_ADMIN);
            profileRepository.save(admin);

            ProfileEntity moderator = new ProfileEntity();
            moderator.setName("Moderator");
            moderator.setSurname("moderatorjon");
            moderator.setUsername("uz_card_moder");
            moderator.setPassword(bCrypt);
            moderator.setVisible(true);
            moderator.setStatus(GeneralStatus.ACTIVE);
            moderator.setRole(GeneralRole.ROLE_MODERATOR);
            profileRepository.save(moderator);

            CompanyEntity bank = new CompanyEntity();
            bank.setName("QORA BANK");
            bank.setAddress("Tashkent");
            bank.setContact("qora_bank@gmail.com");
            bank.setUsername("bank");
            bank.setPassword(bCrypt);
            bank.setVisible(true);
            bank.setStatus(GeneralStatus.ACTIVE);
            bank.setRole(GeneralRole.ROLE_BANK);
            companyRepository.save(bank);

            CompanyEntity payment = new CompanyEntity();
            payment.setName("CLICK");
            payment.setAddress("Tashkent");
            payment.setContact("click@gmail.com");
            payment.setUsername("click");
            payment.setPassword(bCrypt);
            payment.setVisible(true);
            payment.setStatus(GeneralStatus.ACTIVE);
            payment.setRole(GeneralRole.ROLE_PAYMENT);
            companyRepository.save(payment);
        };
    }
}
