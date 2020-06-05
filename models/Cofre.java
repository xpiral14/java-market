package models;

public class Cofre {
    private int id;
    private String senha;
    private double montante;
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getMontante() {
		return montante;
	}
	public void setMontante(double montante) {
		this.montante = montante;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
    
    
}