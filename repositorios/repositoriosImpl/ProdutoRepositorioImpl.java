
package repositorios.repositoriosImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.NaoEncontradoException;
import models.Produto;
import repositorios.Repositorio;
/**
 * ProdutoRepositorioImpl
 */
public class ProdutoRepositorioImpl implements Repositorio<Produto, Integer> {

	private HashMap<Integer, Produto> produtos ;

	public ProdutoRepositorioImpl(HashMap<Integer, Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public List<Produto> buscarTodos() {
		List<Produto> produtosLita = new ArrayList<Produto>();
		for (int produtoId : produtos.keySet()) {
			produtosLita.add(produtos.get(produtoId));
		}
		return produtosLita;
	}

	@Override
	public Produto buscarPorId(Integer id) {
		
		return produtos.get(id);
	}

	@Override
	public Produto buscarPorIdOuFalhar(Integer id) throws NaoEncontradoException {
		Produto produto = produtos.get(id);

		if(produto == null) throw new NaoEncontradoException("Produto nao encotrado");

		return produto;
	}

	@Override
	public void deletar(Integer id) throws NaoEncontradoException {
		Produto produto = buscarPorIdOuFalhar(id);

		produtos.remove(produto.getId());

				
	}

	@Override
	public void atualizar(Integer id, Produto produto) throws NaoEncontradoException {
		
		Produto produtoEncontrado = buscarPorIdOuFalhar(id);

		produtoEncontrado.setNome(produto.getNome());
		produtoEncontrado.setQuantidade(produto.getQuantidade());
		produtoEncontrado.setPreco(produto.getPreco());
		produtoEncontrado.setDesconto(produto.getDesconto());
		produtoEncontrado.setCodigoBarras(produto.getCodigoBarras());
		produtoEncontrado.setCategoria(produto.getCategoria());


	}

	@Override
	public void criar(Produto model) {
		produtos.put(model.getId(), model);
		
	}

	

	

	
}