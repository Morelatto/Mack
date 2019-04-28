package velhaserver;

import com.br.lp3.rmi.IA_Impl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas_Banana
 */
public class VelhaServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("IA",new IA_Impl());
            System.out.println("Serviço dísponivel.");
        } catch (RemoteException ex) {
            Logger.getLogger(VelhaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
