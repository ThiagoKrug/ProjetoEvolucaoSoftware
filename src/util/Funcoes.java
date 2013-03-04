
package util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author Douglas F. Almeida- 101151405
 * @version 04/03/2013
 * 
 */
public class Funcoes {
    
     /**
     * Metodo que centraliza a janela na tela
     */
    public Funcoes(){
    
        
        
    }
    
    public static void centralizar(Component componente){
       
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle r = componente.getBounds();

        int widthSplash = r.width;
        int heightSplash = r.height;

        int posX = (screen.width / 2) - (widthSplash / 2);
        int posY = (screen.height / 2) - (heightSplash / 2);

        componente.setBounds(posX, posY, widthSplash, heightSplash);
        
    }
        
}
