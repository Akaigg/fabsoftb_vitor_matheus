package br.univille.projfabsoftlavanderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftlavanderia.entity.Cliente;

@Repository
public interface ClienteRepository 
     extends JpaRepository<Cliente, Long> {
}