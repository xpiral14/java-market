package controllers;

import java.util.HashMap;
import java.util.Scanner;

import exceptions.CategoriaNaoEncontradaException;
import exceptions.RelacaoExisteException;
import models.Categoria;
import models.Produto;

public class CategoriaController {

    public Scanner inp = new Scanner(System.in);
    private HashMap<Integer, Categoria> categorias;
    private HashMap<Integer, Produto> produtos;

    public CategoriaController(HashMap<Integer, Categoria> categorias, HashMap<Integer, Produto> produtos) {
        this.categorias = categorias;
        this.produtos = produtos;
    }

    public void adicionaCategoria() {
        int categoriaId;
        String categoriaNome;
        System.out.println("Digite o nome da categoria");
        categoriaNome = inp.next();
        categoriaId = categorias.size();

        categorias.put(categoriaId, new Categoria(categoriaId, categoriaNome));

    }

    public void deletaCategoria() throws RelacaoExisteException {
        System.out.println("Digite o codigo do categoria");
        int categoriaId = inp.nextInt();
        Categoria categoriaEncontrada = categorias.get(categoriaId);

        for (int produtoId : produtos.keySet()) {
            if (produtos.get(produtoId).getCategoria().getId() == categoriaId) {
                throw new RelacaoExisteException(
                        String.format("Relacao entre %s e %s ainda existe", "categoria", "produto"));
            }
        }
        if (categoriaEncontrada != null) {
            categorias.remove(categoriaId);
        }

    }

    public Categoria pegarCategoria(int categoriaId) throws CategoriaNaoEncontradaException {

        Categoria categoriaEncontrada = categorias.get(categoriaId);

        if (categoriaEncontrada == null) {
            throw new CategoriaNaoEncontradaException();
        }

        return categoriaEncontrada;
    }

    public void mostrarCategorias() {

        for (int categoriaId : categorias.keySet()) {

            System.out.println(categorias.get(categoriaId));
        }
    }

    public void editaCategoria() throws CategoriaNaoEncontradaException {
        System.out.println("Digite o codigo do categoria");
        int categoriaId = inp.nextInt();

        System.out.println("Digite o nome");
        String nome = inp.next();

        Categoria categoriaEncontrada = categorias.get(categoriaId);

        if (categoriaEncontrada == null) {
            throw new CategoriaNaoEncontradaException();
        }

        categoriaEncontrada.setNome(nome);

    }

    public void verCategoria() throws CategoriaNaoEncontradaException {
        System.out.println("Digite o codigo do categoria");
        int categoriaId = inp.nextInt();
        Categoria categoriaEncontrada = categorias.get(categoriaId);

        if (categoriaEncontrada == null)
            throw new CategoriaNaoEncontradaException();

        System.out.println(categoriaEncontrada);

    }
}
