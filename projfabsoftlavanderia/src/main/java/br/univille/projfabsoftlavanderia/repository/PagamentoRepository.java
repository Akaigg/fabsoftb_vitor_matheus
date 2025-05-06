package br.univille.projfabsoftlavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftlavanderia.entity.Pagamento;

@Repository
public interface PagamentoRepository 
     extends JpaRepository<Pagamento, Long> {
}
