package controllers;

import java.util.HashMap;
import java.util.Scanner;

import exceptions.CategoriaNaoEncontradaException;
import exceptions.ProdutoNaoEncontradoException;
import models.Categoria;
// import exceptions.ProdutoNaoEncontradaException;
import models.Produto;

public class ProdutoController {

    public Scanner inp = new Scanner(System.in);
    private HashMap<Integer, Produto> produtos;
    private CategoriaController categoriaController;

    public ProdutoController(HashMap<Integer, Produto> produtos, HashMap<Integer, Categoria> categorias) {
        this.produtos = produtos;
        this.categoriaController = new CategoriaController(categorias);
    }

    public void adicionaProduto(Produto produto) {

        produtos.put(produto.getId(), produto);

    }

    public void adicionaProduto() {
        int id;
        String nome;
        int quantidade;
        double preco;
        double desconto;
        String codigoBarras;
        Categoria categoria;
        int categoriaId;

        Produto novoProduto;
        id = produtos.size();
        System.out.println("Digite o nome");
        nome = inp.next();
        System.out.println("Digite a quantidade");
        quantidade = inp.nextInt();
        System.out.println("Digite o preco");
        preco = inp.nextDouble();
        System.out.println("Digite o desconto");
        desconto = inp.nextDouble();

        System.out.println("Digite o codigo de barras");
        codigoBarras = inp.next();

        System.out.println("Digite o codigo da categoria");
        categoriaId = inp.nextInt();
        try {
            categoria = categoriaController.pegarCategoria(categoriaId);
            novoProduto = new Produto(id, nome, quantidade, preco, desconto, codigoBarras, categoria);

            produtos.put(id, novoProduto);
        } catch (CategoriaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deletaProduto(int produtoId) throws ProdutoNaoEncontradoException {

        Produto ProdutoEncontrado = produtos.get(produtoId);

        if (ProdutoEncontrado == null) {
            throw new ProdutoNaoEncontradoException();
        }

        produtos.remove(produtoId);

    }

    public Produto pegarProduto(int produtoId) throws ProdutoNaoEncontradoException {

        Produto ProdutoEncontrado = produtos.get(produtoId);

        if (ProdutoEncontrado == null) {
            throw new ProdutoNaoEncontradoException();
        }

        return ProdutoEncontrado;
    }

    public void mostrarProdutos() {

        for (int produtoId : produtos.keySet()) {

            System.out.println(produtos.get(produtoId));
        }
    }

    public void editaProduto(int produtoId) throws ProdutoNaoEncontradoException, CategoriaNaoEncontradaException{
        String nome;
        int quantidade;
        double preco;
        double desconto;
        String codigoBarras;
        Categoria categoria;
        int categoriaId;

        System.out.println("Digite o nome");
        nome = inp.next();
        System.out.println("Digite a quantidade");
        quantidade = inp.nextInt();
        System.out.println("Digite o preco");
        preco = inp.nextDouble();
        System.out.println("Digite o desconto");
        desconto = inp.nextDouble();

        do {
            System.out.println("Digite o codigo de barras");
            codigoBarras = inp.next();
        } while (codigoBarras.length() < 48);

        System.out.println("Digite o codigo da categoria");
        categoriaId = inp.nextInt();

        Produto ProdutoEncontrado = produtos.get(produtoId);

        if (ProdutoEncontrado == null) {
            throw new ProdutoNaoEncontradoException();
        }
        try {
            categoria = categoriaController.pegarCategoria(categoriaId);
            ProdutoEncontrado.setNome(nome);
            ProdutoEncontrado.setQuantidade(quantidade);
            ProdutoEncontrado.setPreco(preco);
            ProdutoEncontrado.setDesconto(desconto);
            ProdutoEncontrado.setCodigoBarras(codigoBarras);
            ProdutoEncontrado.setCategoria(categoria);
        } catch (Exception e) {
            throw e;
        }

    }

}
