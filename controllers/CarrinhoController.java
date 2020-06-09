package controllers;

import java.util.HashMap;
import java.util.Scanner;

import exceptions.NaoEncontradoException;
import models.Carrinho;
import models.Produto;

public class CarrinhoController {
    private Scanner inp  = new Scanner(System.in);
    private Carrinho carrinho;

	public CarrinhoController(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

    public void adicionaProduto(HashMap<Integer, Produto> produtos) throws NaoEncontradoException{
        int codigoProduto;
        Produto produto;
        System.out.println("Digite o código do produto:");
        codigoProduto = inp.nextInt();
        
        produto = produtos.get(codigoProduto);
                
        if(produto == null) throw new NaoEncontradoException("Produto nao encontrado");
        
        carrinho.adicionaProduto(produto);
    } 
    
}