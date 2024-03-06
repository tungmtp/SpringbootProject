package org.erp.apigetway.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrivateService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserDetails findUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userDetail = userInfoRepository.findByName(username);
        return userDetail.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy " + username));
    }
}
