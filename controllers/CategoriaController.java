package controllers;

import java.util.Scanner;

import exceptions.NaoEncontradoException;
import exceptions.RelacaoExisteException;
import models.Categoria;
import models.Produto;
import repositorios.repositoriosImpl.CategoriaRepositorioImpl;
import repositorios.repositoriosImpl.ProdutoRepositorioImpl;
import utils.RandomUtils;

public class CategoriaController {

    public Scanner inp = new Scanner(System.in);
    private CategoriaRepositorioImpl categoriaRepositorio;
    private ProdutoRepositorioImpl produtoRepositorio;

    public CategoriaController(CategoriaRepositorioImpl categoriaRepositorio, ProdutoRepositorioImpl produtoRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
        this.produtoRepositorio = produtoRepositorio;
    }

    public void adicionaCategoria() {
        int categoriaId;
        String categoriaNome;
        System.out.println("Digite o nome da categoria");
        categoriaNome = inp.next();
        categoriaId = RandomUtils.intervalo(1, 10000);

        categoriaRepositorio.criar(new Categoria(categoriaId, categoriaNome));
        
        System.out.println("Categoria adicionada com sucesso.");
    }

    public void deletaCategoria() throws RelacaoExisteException, NaoEncontradoException {
        System.out.println("Digite o codigo do categoria");
        int categoriaId = inp.nextInt();
        Categoria categoriaEncontrada = categoriaRepositorio.buscarPorIdOuFalhar(categoriaId);

        for (Produto produto : produtoRepositorio.buscarTodos()) {
            if (produto.getCategoria() != null && produto.getCategoria().equals(categoriaEncontrada)) {
                throw new RelacaoExisteException(
                        String.format("Relacao entre %s e %s ainda existe", "categoria", "produto"));
            }
        }

        categoriaRepositorio.deletar(categoriaEncontrada.getId());
        System.out.println("Categoria deletada com sucesso.");
        
    }
    
    
    public void mostrarCategorias() {
        for (Categoria categoria : categoriaRepositorio.buscarTodos()) {
            System.out.println(categoria);
        }
    }
    
    public void editaCategoria() throws NaoEncontradoException {
        System.out.println("Digite o codigo do categoria");
        int categoriaId = inp.nextInt();
        
        System.out.println("Digite o nome");
        String nome = inp.next();
        
        Categoria categoriaEncontrada = categoriaRepositorio.buscarPorIdOuFalhar(categoriaId);
        
        categoriaEncontrada.setNome(nome);
        
        categoriaRepositorio.atualizar(categoriaEncontrada.getId(),categoriaEncontrada);
        System.out.println("Categoria editada com sucesso.");
    }

    public void verCategoria() throws NaoEncontradoException {
        System.out.println("Digite o codigo do categoria");
        int categoriaId = inp.nextInt();
        Categoria categoriaEncontrada = categoriaRepositorio.buscarPorIdOuFalhar(categoriaId);
        System.out.println(categoriaEncontrada);

    }
}
