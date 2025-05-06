package br.univille.projfabsoftlavanderia.service;

import java.util.List;
import br.univille.projfabsoftlavanderia.entity.Servico;

public interface ServicoService {
    Servico save(Servico servico);
    List<Servico> getAll();
    Servico getById(Long id);
    Servico delete(Long id);
}
