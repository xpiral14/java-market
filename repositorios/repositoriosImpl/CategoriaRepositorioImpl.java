
package repositorios.repositoriosImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.NaoEncontradoException;
import models.Categoria;
import repositorios.Repositorio;
/**
 * CategoriaRepositorioImpl
 */
public class CategoriaRepositorioImpl implements Repositorio<Categoria, Integer> {

	private HashMap<Integer, Categoria> categorias ;

	public CategoriaRepositorioImpl(HashMap<Integer, Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public List<Categoria> buscarTodos() {
		List<Categoria> categoriaLista = new ArrayList<Categoria>();
		for (int produtoId : categorias.keySet()) {
			categoriaLista.add(categorias.get(produtoId));
		}
		return categoriaLista;
	}

	@Override
	public Categoria buscarPorId(Integer id) {
		
		return categorias.get(id);
	}

	@Override
	public Categoria buscarPorIdOuFalhar(Integer id) throws NaoEncontradoException {
		Categoria categoria = categorias.get(id);

		if(categoria == null) throw new NaoEncontradoException("Categoria nao encotrado");

		return categoria;
	}

	@Override
	public void deletar(Integer id) throws NaoEncontradoException {
		Categoria categoria = buscarPorIdOuFalhar(id);

		categorias.remove(categoria.getId());

				
	}

	@Override
	public void atualizar(Integer id, Categoria categoria) throws NaoEncontradoException {
		
		Categoria categoriaEncontrada = buscarPorIdOuFalhar(id);

		categoriaEncontrada.setNome(categoria.getNome());
	


	}

	@Override
	public void criar(Categoria model) {
		categorias.put(model.getId(), model);
		
	}

	

	

	
}

