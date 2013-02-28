package br.com.model.dao;

import br.com.model.entity.IEntidade;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface comum a todas as classes desse pacote
 *
 * @author thiago
 */
public interface IDao {

    /**
     * Insere uma entidade no banco de dados.
     * Retorna a própria entidade com seu identificador.
     * Pode disparar um {@link SQLException}
     * 
     * @param entidade
     * @return a entidade com seu identificador
     */
    public IEntidade inserir(IEntidade entidade) throws SQLException;

    public IEntidade alterar(IEntidade entidade) throws SQLException;

    public IEntidade excluir(IEntidade entidade) throws SQLException;

    public IEntidade pesquisarPorId(int id) throws SQLException;

    public List<IEntidade> pesquisarTodos() throws SQLException;

    public List<IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento);
}
