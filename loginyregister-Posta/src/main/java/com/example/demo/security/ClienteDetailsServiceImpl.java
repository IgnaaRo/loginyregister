package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.example.demo.models.dao.ClienteDao;
import com.example.demo.models.entity.Cliente;

public class ClienteDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Cliente cliente = clienteDao.findByUsername(username);
		UserBuilder builder = null;

		if (cliente != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(cliente.getPassword());
			builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

		return builder.build();
	}

}
