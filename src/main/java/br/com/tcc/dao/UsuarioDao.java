package br.com.tcc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import br.com.tcc.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
	
	@Query("select i from Usuario i where i.email = :email")
	public Usuario findByEmail(String email); 
	
	@Query("select l from Usuario l where l.user = :user and l.senha = :senha")
	public Usuario buscarLogin(String user, String senha);

}
