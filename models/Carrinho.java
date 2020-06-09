package models;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    
    private List<Produto> produtos = new ArrayList<Produto>();

    public void esvaziarCarrinho(){

        produtos.clear();
    }

	public List<Produto> getProdutos() {
		return produtos;
	}


	public void adicionaProduto(Produto produto){

		produtos.add(produto);
	}

	public void removeProduto(int posicaoProduto){
		System.out.println(produtos.size());
		produtos.remove(posicaoProduto);
		
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

    
}