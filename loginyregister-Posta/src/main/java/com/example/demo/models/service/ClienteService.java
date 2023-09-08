package com.example.demo.models.service;

import com.example.demo.models.entity.Cliente;

public interface ClienteService {
	public Cliente findByUsername(String username);
}
