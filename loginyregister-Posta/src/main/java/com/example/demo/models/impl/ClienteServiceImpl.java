package com.example.demo.models.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.ClienteDao;
import com.example.demo.models.entity.Cliente;
import com.example.demo.models.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente findByUsername(String username) {
		return null;
	}

}