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

import br.univille.projfabsoftlavanderia.entity.Servico;
import br.univille.projfabsoftlavanderia.service.ServicoService;

@RestController
@RequestMapping("/api/v1/Servicos")

public class ServicoController {

    @Autowired
    private ServicoService service;
    
    @GetMapping
    public ResponseEntity<List<Servico>> getServicos(){
        var listaServico = service.getAll();
        
        return new ResponseEntity<List<Servico>>(listaServico, HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<Servico> postServico(@RequestBody Servico Servico){
        if(Servico == null){
            return ResponseEntity.badRequest().build();
        }
        if(Servico.getId() == 0){
            service.save(Servico);
            return new ResponseEntity<Servico>(Servico, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Servico>putServico(@PathVariable long id, @RequestBody Servico Servico){
        if (id <=0 || Servico == null){
            return ResponseEntity.badRequest().build();
        }
        var ServicoAntigo = service.getById(id);
        if (ServicoAntigo == null){
            return ResponseEntity.notFound().build();
        }
        //ServicoAntigo.setNome(Servico.getNome());
        //ServicoAntigo.setTelefone(Servico.getTelefone());
        //ServicoAntigo.setRoupas(Servico.getRoupas());
        //ServicoAntigo.setPagamento(Servico.getPagamento());

        service.save(ServicoAntigo);
        return new ResponseEntity<Servico>(ServicoAntigo, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> deleteServico(@PathVariable long id){
        if (id <=0){
            return ResponseEntity.badRequest().build();
        }
        var ServicoExcluido = service.getById(id);
        if (ServicoExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Servico>(ServicoExcluido, HttpStatus.OK);
    }
}
