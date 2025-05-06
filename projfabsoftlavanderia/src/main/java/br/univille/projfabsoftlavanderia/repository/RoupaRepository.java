package br.univille.projfabsoftlavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftlavanderia.entity.Roupa;

@Repository
public interface RoupaRepository 
     extends JpaRepository<Roupa, Long> {
}