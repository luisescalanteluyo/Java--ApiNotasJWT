package es.luis.prueba.adapter.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import es.luis.prueba.domain.model.User;
import es.luis.prueba.domain.dto.Auth;
import es.luis.prueba.domain.service.UserService;
import es.luis.prueba.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private UserService  userService;

    @PostMapping("auth")
    public Auth login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        Auth auth = new Auth();

        User userData = userService.findByUsername(username);

        if (userData != null) {
            log.info("usuario encontrado.. ");
            log.info("Username: "+userData.getUsername());
        }else{
            log.info("creando usuario.. ");
            userData = new User();
            userData.setUsername(username);
            userData.setPassword(pwd);
            userService.createOrUpdateUser(userData);
        }


        String token = new JwtUtil().getJWTToken(username);
        auth.setUser(username);
        auth.setToken(token);

        return auth;
    }

    private String getJWTToken(String username) {
        String secretKey = "123456789ABCD";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
