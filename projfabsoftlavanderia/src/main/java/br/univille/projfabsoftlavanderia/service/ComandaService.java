package br.univille.projfabsoftlavanderia.service;

import java.util.List;
import br.univille.projfabsoftlavanderia.entity.Comanda;

public interface ComandaService {
    Comanda save(Comanda comanda);
    List<Comanda> getAll();
    Comanda getById(Long id);
    Comanda delete(Long id);
}
