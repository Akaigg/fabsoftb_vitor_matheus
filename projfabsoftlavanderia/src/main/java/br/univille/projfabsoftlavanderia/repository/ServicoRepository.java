package br.univille.projfabsoftlavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftlavanderia.entity.Servico;

@Repository
public interface ServicoRepository 
     extends JpaRepository<Servico, Long> {
}