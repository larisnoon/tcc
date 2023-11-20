package br.com.tcc.model;

import br.com.tcc.Enums.Raca;
import br.com.tcc.Enums.SexoCachorro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;


@Entity
public class Cachorro {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column  (name= "nomeCachorro")
	private String nomeCachorro;
	
	@Column  (name = "raca")
	@Enumerated(EnumType.STRING)
	private Raca raca;
	
	@Column (name = "sexoDoCachorro")
	@Enumerated(EnumType.STRING)
	private SexoCachorro sexoCachorro;
	
	@Column (name = "microchip")
	private Integer numeroMicrochip;
	
	@Column (name = "matricula")
	private String matricula;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public SexoCachorro getSexoCachorro() {
		return sexoCachorro;
	}
	public void setSexoCachorro(SexoCachorro sexoCachorro) {
		this.sexoCachorro = sexoCachorro;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeCachorro() {
		return nomeCachorro;
	}
	public void setNomeCachorro(String nomeCachorro) {
		this.nomeCachorro = nomeCachorro;
	}

	public Raca getRaca() {
		return raca;
	}
	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Integer getNumeroMicrochip() {
		return numeroMicrochip;
	}
	public void setNumeroMicrochip(Integer numeroMicrochip) {
		this.numeroMicrochip = numeroMicrochip;
	}
	
	
}
