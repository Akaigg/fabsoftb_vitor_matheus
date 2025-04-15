package br.univille.projfabsoftlavanderia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftlavanderia.entity.Cliente;
import br.univille.projfabsoftlavanderia.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")

public class ClienteController {

    @Autowired
    private ClienteService service;
    
    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){
        var listaCliente = service.getAll();
        
        return new ResponseEntity<List<Cliente>>(listaCliente, HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<Cliente> postCliente(@RequestBody Cliente cliente){
        if(cliente == null){
            return ResponseEntity.badRequest().build();
        }
        if (cliente.getId() == 0){
            service.save(cliente);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
