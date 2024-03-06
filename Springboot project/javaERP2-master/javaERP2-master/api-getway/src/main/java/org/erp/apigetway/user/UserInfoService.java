package org.erp.apigetway.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    public UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userDetail = userInfoRepository.findByName(username);
        return userDetail.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy " + username));
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User added successfully";
    }

    public UserInfo updateUser(UUID id, UserInfo userInfo) {
        UserInfo existUser = userInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not found "));
        if (existUser != null) {
            if (userInfo.getName() != null && !"".equalsIgnoreCase(userInfo.getName())) {
                existUser.setName(userInfo.getName());
            }
            if (userInfo.getPassword() != null && !"".equalsIgnoreCase(userInfo.getPassword())){
                existUser.setPassword(encoder.encode(userInfo.getPassword()));
            }
            if (userInfo.getRoles() != null && !"".equalsIgnoreCase(userInfo.getRoles())) {
                existUser.setRoles(userInfo.getRoles());
            }
        }
        return existUser;
    }
}
