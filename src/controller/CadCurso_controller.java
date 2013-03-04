
package controller;

import util.Funcoes;
import view.janCadCurso;

/**
 *
 * @author Douglas F. Almeida- 101151405
 * @version 28/02/2013
 * 
 */
public class CadCurso_controller extends Funcoes {
    
  public CadCurso_controller(){
      
    janCadCurso nCurso = new janCadCurso();
    nCurso.setVisible(true);
    centralizar(nCurso);
    
  }
}
