package br.univille.projfabsoftlavanderia.service;

import java.util.List;
import br.univille.projfabsoftlavanderia.entity.Pagamento;

public interface PagamentoService {
    Pagamento save(Pagamento pagamento);
    List<Pagamento> getAll();
    Pagamento getById(Long id);
    Pagamento delete(Long id);
}
