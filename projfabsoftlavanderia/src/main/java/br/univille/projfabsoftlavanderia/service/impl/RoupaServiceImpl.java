package br.univille.projfabsoftlavanderia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projfabsoftlavanderia.entity.Roupa;
import br.univille.projfabsoftlavanderia.repository.RoupaRepository;
import br.univille.projfabsoftlavanderia.service.RoupaService;

@Service
public class RoupaServiceImpl implements RoupaService {

    @Autowired
    private RoupaRepository repository;
    
    @Override
    public Roupa save(Roupa Roupa) {
        repository.save(Roupa);
        return Roupa;
    }

    @Override
    public List<Roupa> getAll() {
        return repository.findAll();
    }

    @Override
    public Roupa getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Roupa delete(Long id) {
        var Roupa  = getById(id);
        if(Roupa  != null)
            repository.deleteById(id);
        return Roupa;
    }

}
