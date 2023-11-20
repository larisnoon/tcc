package br.com.tcc.Enums;

public enum Raca {
	VIRALATA("Vira-Lata"),
	PITBULL("Pitbull"),
	PASTORALEMAO("Pastor-Alemao"),
	BULDOGUE("Buldogue"),
	POODLE("Poodle");
	
	private String raca;
	
	private Raca(String raca) {
		this.raca = raca;
	}
}
