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

import br.univille.projfabsoftlavanderia.entity.Roupa;
import br.univille.projfabsoftlavanderia.service.RoupaService;

@RestController
@RequestMapping("/api/v1/Roupas")

public class RoupaController {

    @Autowired
    private RoupaService service;
    
    @GetMapping
    public ResponseEntity<List<Roupa>> getRoupas(){
        var listaRoupa = service.getAll();
        
        return new ResponseEntity<List<Roupa>>(listaRoupa, HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<Roupa> postRoupa(@RequestBody Roupa Roupa){
        if(Roupa == null){
            return ResponseEntity.badRequest().build();
        }
        if(Roupa.getId() == 0){
            service.save(Roupa);
            return new ResponseEntity<Roupa>(Roupa, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Roupa>putRoupa(@PathVariable long id, @RequestBody Roupa Roupa){
        if (id <=0 || Roupa == null){
            return ResponseEntity.badRequest().build();
        }
        var RoupaAntigo = service.getById(id);
        if (RoupaAntigo == null){
            return ResponseEntity.notFound().build();
        }
        //RoupaAntigo.setNome(Roupa.getNome());
        //RoupaAntigo.setTelefone(Roupa.getTelefone());
        //RoupaAntigo.setRoupas(Roupa.getRoupas());
        //RoupaAntigo.setPagamento(Roupa.getPagamento());

        service.save(RoupaAntigo);
        return new ResponseEntity<Roupa>(RoupaAntigo, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Roupa> deleteRoupa(@PathVariable long id){
        if (id <=0){
            return ResponseEntity.badRequest().build();
        }
        var RoupaExcluido = service.getById(id);
        if (RoupaExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Roupa>(RoupaExcluido, HttpStatus.OK);
    }
}
