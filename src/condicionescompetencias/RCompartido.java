
package condicionescompetencias;
import java.util.ArrayList;

public class RCompartido {
    private String rc;
    private Mutex m;
    
    RCompartido(Mutex m){
        this.m = m;
        this.rc = "";
    }

        public String getRc() {
                String aux= " En espera ...";
                aux = rc;        
                return aux;
        }

        public void setRc(String rc) {
               
                this.rc = rc;
        }

        public Mutex getM() {
                return m;
        }

        public void setM(Mutex m) {
                this.m = m;
        }
     
    
    public boolean isEntra(){
            return m.isPase();                
    }
    
}
