package controllers;

// import java.util.Scanner;

import exceptions.FilaVaziaException;
import exceptions.NaoEncontradoException;
import models.Caixa;
import models.Carrinho;
import models.Produto;

public class CaixaController {
    
    // private Scanner inp = new Scanner(System.in);
    private Caixa caixa;

    
    public CaixaController(Caixa caixa){
        this.caixa = caixa;
    }


 
 
    public void atenderCarrinho() throws FilaVaziaException, NaoEncontradoException{
        
        double valorCarrinho = 0;

        if(caixa.getFila().isEmpty()) throw new FilaVaziaException();

        Carrinho primeiroCarrinho = caixa.getFila().get(0);
        
        System.out.println("O carringo possui:");
        
        for (Produto produto : primeiroCarrinho.getProdutos()) {
            System.out.println(produto.getNome());
            valorCarrinho +=  produto.getPreco();
        }
        System.out.println("O valor total do carrinho foi de: " + valorCarrinho);
        caixa.setMontante(valorCarrinho);
        caixa.andarFila();

    }

    public void adicionaCarrinho(Carrinho carrinho) throws NaoEncontradoException{

        caixa.adicionaNaFila(carrinho);
    }

    public void verFila() throws NaoEncontradoException{

        System.out.println("o caixa atualmente tem " + caixa.getFila().size() + "carrinho(s) na fila" );
    }
}