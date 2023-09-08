package com.example.demo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entity.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {
	public Cliente findByUsername(String username);
}
