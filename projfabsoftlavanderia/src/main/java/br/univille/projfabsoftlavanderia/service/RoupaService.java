package br.univille.projfabsoftlavanderia.service;

import java.util.List;
import br.univille.projfabsoftlavanderia.entity.Roupa;

public interface RoupaService {
    Roupa save(Roupa roupa);
    List<Roupa> getAll();
    Roupa getById(Long id);
    Roupa delete(Long id);
}
