package repositorios.repositoriosImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.NaoEncontradoException;
import models.Produto;
import repositorios.Repositorio;

public class ProdutoRepositorioImpl implements Repositorio<Produto, Integer>{

    private HashMap<Integer, Produto> produtos;
    
    public ProdutoRepositorioImpl(HashMap<Integer, Produto> produtos) {
		this.produtos = produtos;
    }

	@Override
	public List<Produto> buscarTodos() {
        List<Produto> listaProdutos = new ArrayList<Produto>();

        for (int produtoId : produtos.keySet()) {
            listaProdutos.add(produtos.get(produtoId));
        }
		return listaProdutos;
	}

	@Override
	public Produto buscarPorId(Integer id) throws NaoEncontradoException {
		
		return null;
	}

	@Override
	public void deletar(Integer id) throws NaoEncontradoException {
		
	}

	@Override
	public void atualizar(Integer id) throws NaoEncontradoException {
		
	}
    
        
}