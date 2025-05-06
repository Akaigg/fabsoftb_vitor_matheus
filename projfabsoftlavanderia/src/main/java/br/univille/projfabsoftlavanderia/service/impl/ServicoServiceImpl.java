package br.univille.projfabsoftlavanderia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projfabsoftlavanderia.entity.Servico;
import br.univille.projfabsoftlavanderia.repository.ServicoRepository;
import br.univille.projfabsoftlavanderia.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository repository;
    
    @Override
    public Servico save(Servico Servico) {
        repository.save(Servico);
        return Servico;
    }

    @Override
    public List<Servico> getAll() {
        return repository.findAll();
    }

    @Override
    public Servico getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Servico delete(Long id) {
        var Servico = getById(id);
        if(Servico != null)
            repository.deleteById(id);
        return Servico;
    }

}
