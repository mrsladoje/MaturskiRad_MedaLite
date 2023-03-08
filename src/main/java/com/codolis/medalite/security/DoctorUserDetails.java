package com.codolis.medalite.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.codolis.medalite.doctors.Doctor;

public class DoctorUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private Doctor doctor;
     
    public DoctorUserDetails(Doctor doctor) {
        this.doctor = doctor;
    }
 
    @Override
    public String getPassword() {
        return doctor.getDoctorPassword();
    }
 
    @Override
    public String getUsername() {
        return doctor.getDoctorUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
}
