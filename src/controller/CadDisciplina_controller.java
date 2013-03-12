
package controller;

import util.Funcoes;
import view.janCadDisciplina;

/**
 *
 * @author Douglas F. Almeida- 101151405
 * @version 28/02/2013
 * 
 */
public class CadDisciplina_controller {
    
    public CadDisciplina_controller() {

        janCadDisciplina nDisciplina = new janCadDisciplina();
        nDisciplina.setVisible(true);
        
        Funcoes nFuncao = new Funcoes();
        nFuncao.centralizar(nDisciplina);
    
    }
}
