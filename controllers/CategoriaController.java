package controllers;

import java.util.HashMap;
import java.util.Scanner;

import exceptions.CategoriaNaoEncontradaException;
import models.Categoria;

public class CategoriaController {

    public Scanner inp = new Scanner(System.in);
    private HashMap<Integer, Categoria> categorias;

    public CategoriaController(HashMap<Integer, Categoria> categorias) {
        this.categorias = categorias;
    }

    public void adicionaCategoria() {
        int categoriaId;
        String categoriaNome;
        System.out.println("Digite o nome da categoria");
        categoriaNome = inp.next();
        categoriaId = categorias.size();

        categorias.put(categoriaId, new Categoria(categoriaId, categoriaNome));

    }

    public void deletaCategoria(int categoriaId) {

        Categoria categoriaEncontrada = categorias.get(categoriaId);

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

    public void editaCategoria(int cateogoriaId, String nome) throws CategoriaNaoEncontradaException {

        Categoria categoriaEncontrada = categorias.get(cateogoriaId);

        if (categoriaEncontrada == null) {
            throw new CategoriaNaoEncontradaException();
        }

        categoriaEncontrada.setNome(nome);

    }

}
