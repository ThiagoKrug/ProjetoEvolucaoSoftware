/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.model.entity.IEntidade;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marcelo Maia
 */
public class ProvaMemorialDao  implements IDao{

    @Override
    public IEntidade inserir(IEntidade entidade) {
       
      return null;
    }

    @Override
    public IEntidade alterar(IEntidade entidade) {
        return null;
    }

    @Override
    public IEntidade excluir(IEntidade entidade) {
        return null;
    }

    @Override
    public IEntidade pesquisarPorId(int id) {
       return null;
    }

    @Override
    public List<IEntidade> pesquisarTodos()  {
        return null;
    }

    @Override
    public List<IEntidade> pesquisarTodosOrdenadoPor(String criterioOrdenamento) {
     return null;
    }
    
}
