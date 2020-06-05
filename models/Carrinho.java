package models;

import java.util.List;

public class Carrinho {
    
    List<Produto> produtos;

    public void esvaziarCarrinho(){

        produtos.clear();
    }

	public List<Produto> getProdutos() {
		return produtos;
	}


	public void adicionaProduto(Produto produto){

		produtos.add(produto);
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

    
}