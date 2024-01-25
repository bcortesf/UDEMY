package com.company.springboot3di.repositories;

import java.util.List;
import java.util.Optional;

import com.company.springboot3di.models.Client;

public interface IClient {
    public List<Client> findAll();
    public Optional<Client> findById(Long id);
}
