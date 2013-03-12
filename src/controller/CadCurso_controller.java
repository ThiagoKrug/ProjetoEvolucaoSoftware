
package controller;

import util.Funcoes;
import view.janCadCurso;

/**
 *
 * @author Douglas F. Almeida- 101151405
 * @version 28/02/2013
 * 
 */
public class CadCurso_controller {
    
  public CadCurso_controller(){
      
    janCadCurso nCurso = new janCadCurso();
    nCurso.setVisible(true);
    
    Funcoes nFuncao = new Funcoes();
    nFuncao.centralizar(nCurso);
    
  }
}
