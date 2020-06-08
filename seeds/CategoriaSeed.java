package seeds;

import java.util.HashMap;

import models.Categoria;

public class CategoriaSeed {
    static public void popular(HashMap<Integer, Categoria> listaCategorias){
        Categoria[] categorias = {
            new Categoria(1, "Alimentos"),
            new Categoria(2, "Limpeza"),
            new Categoria(3, "Higiene"),
        };

        for(Categoria categoria : categorias){
            listaCategorias.put(categoria.getId(), categoria);
        }
    }
}