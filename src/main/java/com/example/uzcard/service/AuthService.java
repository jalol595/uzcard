package com.example.uzcard.service;


import com.example.uzcard.config.CustomUserDetails;
import com.example.uzcard.dto.AuthDTO;
import com.example.uzcard.dto.CurrentUserDTO;
import com.example.uzcard.dto.JwtDTO;
import com.example.uzcard.dto.LoginDTO;
import com.example.uzcard.util.CurrentUserUtil;
import com.example.uzcard.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    public LoginDTO login(AuthDTO authDTO) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword()));

        CustomUserDetails user = (CustomUserDetails) authenticate.getPrincipal();
        String id = user.getId();
        String username = user.getUsername();

        JwtDTO jwtDTO = new JwtDTO();
        jwtDTO.setId(user.getId());
        jwtDTO.setRole(user.getRole().name());

        LoginDTO responseDTO = new LoginDTO();
        responseDTO.setJwt(JwtUtil.encode(jwtDTO));
        responseDTO.setUsername(username);
        responseDTO.setRole(user.getRole());
        return responseDTO;
    }

    public CurrentUserDTO getCurrentUser() {
        CurrentUserDTO dto = new CurrentUserDTO();
        dto.setId(CurrentUserUtil.currentUser().getId());
        dto.setUsername(CurrentUserUtil.currentUser().getUsername());
        dto.setRole(CurrentUserUtil.currentUser().getRole());
        return dto;
    }
}

