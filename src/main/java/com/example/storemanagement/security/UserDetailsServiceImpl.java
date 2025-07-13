package com.example.storemanagement.security;

import com.example.storemanagement.model.AppUser;
import com.example.storemanagement.repository.AppUserRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private AppUserRepository repo;
    
	public UserDetailsServiceImpl(AppUserRepository productRepository) {
        this.repo = productRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return User.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            .roles(user.getRole().replace("ROLE_", "")) // expects "ADMIN" or "USER"
            .build();
    }
}
