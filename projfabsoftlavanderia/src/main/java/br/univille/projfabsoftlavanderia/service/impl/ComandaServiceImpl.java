package br.univille.projfabsoftlavanderia.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projfabsoftlavanderia.entity.Comanda;
import br.univille.projfabsoftlavanderia.repository.ComandaRepository;
import br.univille.projfabsoftlavanderia.service.ComandaService;

@Service
public class ComandaServiceImpl implements ComandaService {

    @Autowired
    private ComandaRepository repository;
    
    @Override
    public Comanda save(Comanda comanda) {
        repository.save(comanda);
        return comanda;
    }

    @Override
    public List<Comanda> getAll() {
        return repository.findAll();
    }

    @Override
    public Comanda getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Comanda delete(Long id) {
        var comanda = getById(id);
        if(comanda != null)
            repository.deleteById(id);
        return comanda;
    }

}