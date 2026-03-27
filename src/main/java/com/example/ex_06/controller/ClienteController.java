package com.example.ex_06.controller;

import com.example.ex_06.models.ClienteModel;
import com.example.ex_06.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel clienteModel){

        ClienteModel request = clienteService.criarCliente(clienteModel);

        URI uri = URI.create("/clientes/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> request = clienteService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<ClienteModel> buscarIdCliente(@PathVariable Long id) {
        return clienteService.buscarIdCliente(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
