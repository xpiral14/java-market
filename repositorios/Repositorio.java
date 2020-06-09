package repositorios;

import java.util.List;

import exceptions.NaoEncontradoException;

public interface Repositorio<T, K> {
    List<T> buscarTodos();
    T buscarPorId(K id);
    T buscarPorIdOuFalhar(K id) throws NaoEncontradoException;
    void criar(T model);
    void deletar(K id) throws NaoEncontradoException;
    void atualizar(K id, T model) throws NaoEncontradoException;
}