package org.erp.apigetway.controller;

import org.erp.apigetway.security.JwtService;
import org.erp.apigetway.user.AuthRequest;
import org.erp.apigetway.user.UserInfo;
import org.erp.apigetway.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/generateToken")
    public String authenticateAndGenerateToken(@RequestBody AuthRequest authRequest) {
//        System.out.println("Có nhận dữ liệu" + authRequest.getUsername());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Not found user");
        }
    }
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserInfo> updateUser(@PathVariable UUID id, @RequestBody UserInfo userInfo) {
        return new ResponseEntity<UserInfo>(userInfoService.updateUser(id, userInfo),HttpStatus.OK);
    }

    @GetMapping("/testToken")
    public String testToken() {
        return "OK";
    }
}
