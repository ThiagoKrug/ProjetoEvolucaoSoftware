
package controller;

import util.Funcoes;
import view.janCadBibliografia;

/**
 *
 * @author Douglas F. Almeida- 101151405
 * @version 28/02/2013
 * 
 */
public class CadBibliografia_controller {
    
   public CadBibliografia_controller() {
   
       janCadBibliografia nBibliografia = new janCadBibliografia();
       nBibliografia.setVisible(true);
       
       Funcoes nFuncao = new Funcoes();
       nFuncao.centralizar(nBibliografia);
   
   }
}
