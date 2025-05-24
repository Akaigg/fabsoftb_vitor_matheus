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

import br.univille.projfabsoftlavanderia.entity.Pagamento;
import br.univille.projfabsoftlavanderia.service.PagamentoService;

@RestController
@RequestMapping("/api/v1/Pagamentos")

public class PagamentoController {

    @Autowired
    private PagamentoService service;
    
    @GetMapping
    public ResponseEntity<List<Pagamento>> getPagamentos(){
        var listaPagamento = service.getAll();
        
        return new ResponseEntity<List<Pagamento>>(listaPagamento, HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<Pagamento> postPagamento(@RequestBody Pagamento Pagamento){
        if(Pagamento == null){
            return ResponseEntity.badRequest().build();
        }
        if(Pagamento.getId() == 0){
            service.save(Pagamento);
            return new ResponseEntity<Pagamento>(Pagamento, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pagamento>putPagamento(@PathVariable long id, @RequestBody Pagamento Pagamento){
        if (id <=0 || Pagamento == null){
            return ResponseEntity.badRequest().build();
        }
        var PagamentoAntigo = service.getById(id);
        if (PagamentoAntigo == null){
            return ResponseEntity.notFound().build();
        }
        //PagamentoAntigo.setNome(Pagamento.getNome());
        //PagamentoAntigo.setTelefone(Pagamento.getTelefone());
        //PagamentoAntigo.setRoupas(Pagamento.getRoupas());
        //PagamentoAntigo.setPagamento(Pagamento.getPagamento());

        service.save(PagamentoAntigo);
        return new ResponseEntity<Pagamento>(PagamentoAntigo, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Pagamento> deletePagamento(@PathVariable long id){
        if (id <=0){
            return ResponseEntity.badRequest().build();
        }
        var PagamentoExcluido = service.getById(id);
        if (PagamentoExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Pagamento>(PagamentoExcluido, HttpStatus.OK);
    }
}