package com.spring.action.tacocloud.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetails loadUserDetailsByUsername(String userName) throws UsernameNotFoundException;
}
