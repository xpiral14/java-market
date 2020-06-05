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
        this.categoriaController = new CategoriaController(categorias, produtos);
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
            System.out.println("erro");
            System.out.println(e.getMessage());
        }
        System.out.println("produto adicionado com sucesso");
    }

    public void deletaProduto() throws ProdutoNaoEncontradoException {
        System.out.println("Digite o codigo do produto");
        int produtoId = inp.nextInt();
        Produto ProdutoEncontrado = produtos.get(produtoId);

        if (ProdutoEncontrado == null) {
            throw new ProdutoNaoEncontradoException();
        }

        produtos.remove(produtoId);
        System.out.println("produto removido com sucesso");

    }

    public Produto pegarProduto() throws ProdutoNaoEncontradoException {
        System.out.println("Digite o codigo do produto");
        int produtoId = inp.nextInt();
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

    public void editaProduto() throws ProdutoNaoEncontradoException, CategoriaNaoEncontradaException {
        System.out.println("Digite o codigo do produto");
        int produtoId = inp.nextInt();
        String nome;
        int quantidade;
        double preco;
        double desconto;
        String codigoBarras;
        Categoria categoria;
        int categoriaId;

        do {

            System.out.println("Digite o nome");
            nome = inp.next();
        } while (nome.isEmpty());

        do {
            System.out.println("Digite a quantidade");
            quantidade = inp.nextInt();
        } while (quantidade <= 0);

        do {
            System.out.println("Digite o preco");
            preco = inp.nextDouble();

        } while (preco <= 0);

        do {
            System.out.println("Digite o desconto");
            desconto = inp.nextDouble();
        } while (desconto < 0);

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
        System.out.println("Produto editado com sucesso");
    }

    public void verProduto() throws ProdutoNaoEncontradoException {
        System.out.println("Digite o codigo do produto");
        int produtoId = inp.nextInt();

        Produto produtoEncontrado = produtos.get(produtoId);

        if (produtoEncontrado == null)
            throw new ProdutoNaoEncontradoException();

        System.out.println(produtoEncontrado);

    }

}
