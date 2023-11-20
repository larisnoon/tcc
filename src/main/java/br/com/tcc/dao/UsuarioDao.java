package br.com.tcc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcc.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

}
