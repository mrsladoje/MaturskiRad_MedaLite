package com.codolis.medalite.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.codolis.medalite.doctors.DoctorRepository;

public class DoctorUserDetailsService implements UserDetailsService{

	@Autowired
		DoctorRepository doctorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (doctorRepository.findByDoctorUsername(username) == null) {
			throw new UsernameNotFoundException("Cound not find user");
		}
		
		return new DoctorUserDetails(doctorRepository.findByDoctorUsername(username));
	}

}
