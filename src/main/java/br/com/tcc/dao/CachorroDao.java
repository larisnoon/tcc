package br.com.tcc.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcc.model.Cachorro;

public interface CachorroDao extends JpaRepository<Cachorro, Integer> {

}
