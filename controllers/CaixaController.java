package controllers;

import java.util.HashMap;
import java.util.Scanner;

import exceptions.FilaVaziaException;
import exceptions.NaoEncontradoException;
import models.Caixa;
import models.Carrinho;
import models.Produto;

public class CaixaController {
    
    private Scanner inp = new Scanner(System.in);
    private HashMap<Integer, Caixa> caixas;

    
    public CaixaController(HashMap<Integer,Caixa> caixas){

        this.caixas = caixas;
    }

    public void adicionaCaixa(){
        caixas.put(caixas.size(),new Caixa(caixas.size()));
        System.out.println("Caixa criado com sucesso");
    }

    public void removeCaixa() throws Exception{
        Caixa caixa =  selecionaCaixa();

        caixas.remove(caixa.getId());
    }


    public void verCaixa() throws NaoEncontradoException{
        Caixa caixa = selecionaCaixa();
        caixas.remove(caixa.getId());
    }

    public Caixa selecionaCaixa() throws NaoEncontradoException{
        int codigoCaixa;
        System.out.println("Digite o codigo do caixa");
        codigoCaixa = inp.nextInt();

        Caixa caixaEncontrado = caixas.get(codigoCaixa);
        if(caixaEncontrado == null) throw new NaoEncontradoException("Caixa nao encontrado");

        return caixaEncontrado;
    }

    public void atenderCarrinho() throws FilaVaziaException, NaoEncontradoException{
        
        double valorCarrinho = 0;

        Caixa caixa = selecionaCaixa();

        if(caixa == null) throw new NaoEncontradoException("Caixa nao encontrado");

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
        int codigoCaixa;
        System.out.println("Digite o codigo do caixa");
        codigoCaixa = inp.nextInt();

        Caixa caixa = caixas.get(codigoCaixa);
        if(caixa == null) throw new NaoEncontradoException("Caixa nao encontrado");


        caixa.adicionaNaFila(carrinho);
    }

    public void verFila() throws NaoEncontradoException{
        Caixa caixa = selecionaCaixa();

        System.out.println("o caixa atualmente tem " + caixa.getFila().size() + "carrinho(s) na fila" );
    }
}