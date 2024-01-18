package com.modern.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.modern.admin.user.UserRepository;
import com.modern.common.entity.User;

public class ModernUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.getUserByEmail(email);
		if (user != null) {
			return new ModernUserDetails(user);
		}

		throw new UsernameNotFoundException("Nuk mund të gjendet përdorues me email: " + email);
	}

}
