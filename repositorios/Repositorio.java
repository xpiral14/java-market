package repositorios;

import java.util.List;

import exceptions.NaoEncontradoException;

public interface Repositorio<T, K> {
    List<T> buscarTodos();
    T buscarPorId(K id) throws NaoEncontradoException;
    void deletar(K id) throws NaoEncontradoException;
    void atualizar(K id) throws NaoEncontradoException;
}