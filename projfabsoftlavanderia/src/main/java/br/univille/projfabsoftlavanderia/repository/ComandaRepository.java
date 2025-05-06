package br.univille.projfabsoftlavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftlavanderia.entity.Comanda;

@Repository
public interface ComandaRepository 
     extends JpaRepository<Comanda, Long> {
}
