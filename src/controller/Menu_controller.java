
package controller;

import util.Funcoes;
import view.janMenu;

/**
 *
 * @author Douglas F. Almeida- 101151405
 * @version 28/02/2013
 * 
 */
public class Menu_controller {

    public static void main(String[] args) {
        
        janMenu Menu = new janMenu();
        Menu.setVisible(true);
        Funcoes nFuncao = new Funcoes();
        nFuncao.centralizar(Menu);
        
    }
}
