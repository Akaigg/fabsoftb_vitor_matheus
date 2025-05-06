package br.univille.projfabsoftlavanderia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projfabsoftlavanderia.entity.Pagamento;
import br.univille.projfabsoftlavanderia.repository.PagamentoRepository;
import br.univille.projfabsoftlavanderia.service.PagamentoService;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository repository;
    
    @Override
    public Pagamento save(Pagamento Pagamento) {
        repository.save(Pagamento);
        return Pagamento;
    }

    @Override
    public List<Pagamento> getAll() {
        return repository.findAll();
    }

    @Override
    public Pagamento getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Pagamento delete(Long id) {
        var Pagamento = getById(id);
        if(Pagamento != null)
            repository.deleteById(id);
        return Pagamento;
    }

}