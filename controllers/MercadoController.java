package controllers;

import java.util.HashMap;
import java.util.Scanner;

import exceptions.NaoEncontradoException;
import models.Carrinho;
import models.Produto;

/**
 * MercadoController
 */
public class MercadoController {
    private Scanner inp = new Scanner(System.in);
    private HashMap<Integer, Produto> produtos ;
    Carrinho carrinho;

	public MercadoController(HashMap<Integer, Produto> produtos, Carrinho carrinho) {
		this.produtos = produtos;
		this.carrinho = carrinho;
    }
    
    public void verProdutos(){

        for (int produtoId : produtos.keySet()) {
            
            System.out.println(produtos.get(produtoId));

        }
    }

    public void verCarrinho(){
        if(carrinho.getProdutos().isEmpty()){
            throw new NullPointerException("O carrinho está vazio");
        }
        for(Produto produto : carrinho.getProdutos()){
            System.out.println(produto);
        }
    }

    public Produto selecionaProduto() throws NaoEncontradoException{
        int produtoId;
        Produto produtoEncontrado;
        
        System.out.println("Digite o codigo do produto");
        produtoId = inp.nextInt();
        
        produtoEncontrado = produtos.get(produtoId);
        
        if(produtoEncontrado == null)
            throw new NaoEncontradoException("Produto nao encontrado");

        return produtoEncontrado;
    }

    public void adicionaProdutoCarrinho() throws NaoEncontradoException{
        Produto produto = selecionaProduto();
        carrinho.adicionaProduto(produto);
        System.out.println("Produto adicionado com sucesso");
    }
    
    
    public void removeProdutoCarrinho() throws NaoEncontradoException{
        Produto produto = selecionaProduto();
        
		// para cada produto adicionado na lista de produtos
		for (int i = 0; i < carrinho.getProdutos().size(); i++) {
			// se o id do produto na posição i for igual ao id passado no parâmetro
			// remove da lista de produtos.
			if(carrinho.getProdutos().get(i).getId() == produto.getId()){
				carrinho.removeProduto(i);
				break;
			}
		}
        carrinho.removeProduto(produto.getId());

        System.out.println("Produto removido com sucesso");
    } 
    
    
}
