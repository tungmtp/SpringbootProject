package org.erp.apigetway.controller;

import org.erp.apigetway.security.JwtService;
import org.erp.apigetway.user.AuthRequest;
import org.erp.apigetway.user.UserInfo;
import org.erp.apigetway.user.UserInfoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RabbitTemplate rabbitTemplate;

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
        return new ResponseEntity<UserInfo>(userInfoService.updateUser(id, userInfo), HttpStatus.OK);
    }

    @GetMapping("/testToken")
    public String testToken() {
        return "OK";
    }

    //------------------------ NOTIFICATION MESSAGE
//    @PostMapping("/sendMessage/orderDeliveryID")
//    public ResponseEntity<String> sendMessage(@RequestBody String message, @RequestHeader("UserName") String userName) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("RequestType", "SENDMESSAGE_orderDeliveryID");
//        headers.add("UserName", userName);
//        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK)
//                .headers(headers)
//                .body(message);
//        System.out.println("UserName: " + userName);
//        // Gửi message đến RabbitMQ
//        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
//        return response;
//    }

}
