package com.example.ex_06.services;

import com.example.ex_06.models.ClienteModel;
import com.example.ex_06.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel criarCliente(ClienteModel categoriaModel) {
        return clienteRepository.save(categoriaModel);
    }

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> buscarIdCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
