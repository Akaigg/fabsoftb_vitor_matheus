package br.univille.projfabsoftlavanderia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftlavanderia.entity.Comanda;
import br.univille.projfabsoftlavanderia.service.ComandaService;

@RestController
@RequestMapping("/api/v1/comandas")

public class ComandaController {

    @Autowired
    private ComandaService service;
    
    @GetMapping
    public ResponseEntity<List<Comanda>> getComandas(){
        var listaComanda = service.getAll();
        
        return new ResponseEntity<List<Comanda>>(listaComanda, HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<Comanda> postComanda(@RequestBody Comanda Comanda){
        if(Comanda == null){
            return ResponseEntity.badRequest().build();
        }
        if(Comanda.getId() == 0){
            service.save(Comanda);
            return new ResponseEntity<Comanda>(Comanda, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Comanda>putComanda(@PathVariable long id, @RequestBody Comanda Comanda){
        if (id <=0 || Comanda == null){
            return ResponseEntity.badRequest().build();
        }
        var ComandaAntigo = service.getById(id);
        if (ComandaAntigo == null){
            return ResponseEntity.notFound().build();
        }
        //ComandaAntigo.setNome(Comanda.getNome());
        //ComandaAntigo.setTelefone(Comanda.getTelefone());
        //ComandaAntigo.setRoupas(Comanda.getRoupas());
        ComandaAntigo.setPagamento(Comanda.getPagamento());

        service.save(ComandaAntigo);
        return new ResponseEntity<Comanda>(ComandaAntigo, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Comanda> deleteComanda(@PathVariable long id){
        if (id <=0){
            return ResponseEntity.badRequest().build();
        }
        var ComandaExcluido = service.getById(id);
        if (ComandaExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Comanda>(ComandaExcluido, HttpStatus.OK);
    }
}
