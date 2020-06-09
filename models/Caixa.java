package models;

import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private double montante;
	private List<Carrinho> fila;


	public Caixa(){
		fila = new ArrayList<Carrinho>();
	}

	public double getMontante() {
		return montante;
	}

	public void setMontante(double montante) {
		this.montante = montante;
	}

	public List<Carrinho> getFila() {
		return fila;
	}

	public void adicionaNaFila(Carrinho carrinho){
		this.fila.add(carrinho);
	}

	public void  andarFila(){
		
		fila.remove(0);
	}

	public double esvaziarCaixa(){
		double valorMontante = montante;

		montante = 0;

		return valorMontante; 
	}


	public void setFila(List<Carrinho> fila) {
		this.fila = fila;
	}

}