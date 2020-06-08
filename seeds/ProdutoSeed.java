package seeds;

import java.util.HashMap;

import models.Produto;

public class ProdutoSeed {
    
   static public void popular(HashMap<Integer, Produto> listaProdutos){
        Produto[] produtos = {
            new Produto(2, "Sabonete", 328, 0.60, 0, "1290129012", null), 
            new Produto(3, "Arroz", 234, 11.32, 0, "2108095483", null), 
            new Produto(4, "Feijão", 123, 7.32, 0, "12039012", null), 
            new Produto(5, "Carne", 321, 38, 0, "734586783", null), 
            new Produto(6, "Escova de dente", 53, 5, 0, "83241971", null),    
    };


        for(Produto produto : produtos ){
            listaProdutos.put(produto.getId(),produto);
        }
    }
}