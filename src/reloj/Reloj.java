
package reloj;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author gabrielhs
 */
public class Reloj extends Thread{
 
    private JTextField txt_seg;
    private JTextField txt_min;
    private boolean isRun = false;
//    private int contador=1; 
    long s,m;
    public Reloj (JTextField txt_seg, JTextField txt_min){
        this.txt_seg = txt_seg;
        this.txt_min = txt_min;
    }
    
    public synchronized void detener(){
        isRun=false;
    }

    @Override
    public void run() {
        isRun = true;
        m = 0;
        while(isRun){
            
//            while(contador<60){
            try {
                s = Long.parseLong(txt_seg.getText());
                s++;
                if (s == 60) {
                    s = 0;
                    m++;
                    txt_min.setText(String.valueOf(m));
                }
                
                txt_seg.setText(String.valueOf(s));
                Thread.sleep(1000);
            
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
//            contador++;
//            }
//            contador=1;
//            s=0;
//            m=0;
//            txt_min.setText(String.valueOf(m));
//            txt_seg.setText(String.valueOf(s));
        }
        
    }

  
}
    
    
    
