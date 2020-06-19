
package reloj;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author gabrielhs
 */
public class Reloj extends Thread{
private JTextField txt;
boolean isRun;
int min=1,seg=1;
long time,s;
//Thread segundo;

public synchronized void detener(){
    isRun=false;
}

    public Reloj(long time,JTextField txt) {
        this.time=time;
        this.txt=txt;
    }


    @Override
    public void run() {
        
      isRun=true;
        while(isRun){
            
       //min=-1;
//            txt.setText(String.valueOf(min));
            while(min<59){
            s=-1;
            txt.setText(String.valueOf(s));
            while(s<59){
            // 59 ta bien
            s= Long.parseLong(txt.getText());
            
            s++;
           
            txt.setText(String.valueOf(s));
            
            try {
               
                Thread.sleep(time);
              
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
        //seg++;
            }
        
        min++;
            }
        
        
        }
            
            
    }

  
}
    
    
    
