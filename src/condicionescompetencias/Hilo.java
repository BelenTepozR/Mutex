
package condicionescompetencias;
import javax.swing.JTextArea;

public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean pausado = false;   
    private boolean corriendo = true;   
    private int numHilo;
    private int inic;
    private final static int ini = 100;
    private final static int fin = 200;
    private Mutex mutex ;
    private boolean dead = false;
      private boolean block = false;
    Hilo(JTextArea area, RCompartido rc, int n, Mutex m){
        this.area = area;
        this.rc = rc;
        this.setName("Perrito" + n);
        this.numHilo = n;
        this.mutex = m;
    }
   
    @Override
    public void run(){
      
            while(true){
                try{
                      System.out.println(rc.isEntra());
                        if(rc.isEntra()){
                                try{
                                        mutex.lock();
                                         rc.setRc(this.getName());
                                         area.append(rc.getRc() +": entra... \n"); 
                                         if(isDead()){
                                                  area.append(rc.getRc() +" Me matan ... \n");
                                                 stop(); 
                                         }  
                                }finally{
                                       mutex.unlock();
    
                                }                    
                        } else
                        area.append("Esperando" + "\n");
                        
                        inic = (int) ( Math.random()*50);
                        sleep((int) (inic +Math.random() * fin)); 
                }catch(Exception e){
                System.out.println(e.getMessage());
                } 
            }
          
    }

        public boolean isDead() {
                return dead;
        }

        public void setDead(boolean dead) {
                this.dead = dead;
        }

        public boolean isBlock() {
                return block;
        }

        public void setBlock(boolean block) {
                this.block = block;
        }
  
}
