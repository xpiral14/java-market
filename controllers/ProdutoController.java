package controllers;

import java.util.Scanner;
import exceptions.NaoEncontradoException;
import models.Categoria;
import models.Produto;
import repositorios.repositoriosImpl.CategoriaRepositorioImpl;
import repositorios.repositoriosImpl.ProdutoRepositorioImpl;
import utils.RandomUtils;

public class ProdutoController {

    public Scanner inp = new Scanner(System.in);
    private CategoriaRepositorioImpl categoriaRepositorio;
    private ProdutoRepositorioImpl produtoRepositorio;

    public ProdutoController(ProdutoRepositorioImpl  produtoRepositorio, CategoriaRepositorioImpl categoriaRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
    }

    public void adicionaProduto() throws NaoEncontradoException {
        int id;
        String nome;
        int quantidade;
        double preco;
        double desconto;
        String codigoBarras;
        Categoria categoria;
        int categoriaId;

        Produto novoProduto;
        id = RandomUtils.intervalo(1, 1000);
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
    
        categoria = categoriaRepositorio.buscarPorId(categoriaId);
        novoProduto = new Produto(id, nome, quantidade, preco, desconto, codigoBarras, categoria);
        produtoRepositorio.criar(novoProduto);
   
        System.out.println("produto adicionado com sucesso");
    }

    public void deletaProduto() throws NaoEncontradoException {
        System.out.println("Digite o codigo do produto");
        int produtoId = inp.nextInt();
        
        produtoRepositorio.deletar(produtoRepositorio.buscarPorIdOuFalhar(produtoId).getId());
        System.out.println("produto removido com sucesso");

    }

    public Produto pegarProduto() throws NaoEncontradoException {
        System.out.println("Digite o codigo do produto");
        int produtoId = inp.nextInt();
        Produto produtoEncontrado = produtoRepositorio.buscarPorIdOuFalhar(produtoId);


        return produtoEncontrado;
    }

    public void mostrarProdutos() {

        for (Produto produto : produtoRepositorio.buscarTodos()) {
            System.out.println(produto);
        }
    }

    public void editaProduto() throws NaoEncontradoException {
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

        Produto produtoEncontrado = produtoRepositorio.buscarPorIdOuFalhar(produtoId);

        categoria = categoriaRepositorio.buscarPorIdOuFalhar(categoriaId);
        produtoEncontrado.setNome(nome);
        produtoEncontrado.setQuantidade(quantidade);
        produtoEncontrado.setPreco(preco);
        produtoEncontrado.setDesconto(desconto);
        produtoEncontrado.setCodigoBarras(codigoBarras);
        produtoEncontrado.setCategoria(categoria);
       
        System.out.println("Produto editado com sucesso");
    }

    public void verProduto() throws NaoEncontradoException {
        System.out.println("Digite o codigo do produto");
        int produtoId = inp.nextInt();

        Produto produtoEncontrado = produtoRepositorio.buscarPorIdOuFalhar(produtoId);

        System.out.println(produtoEncontrado);

    }

}
