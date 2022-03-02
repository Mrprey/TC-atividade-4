package sft.connRMI;

import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerUp1 {
    public static void main(String[] args) throws RemoteException {

        //instanciando limite
        br.ufal.aracomp.cosmos.limite.spec.prov.IManager compLimite =
                br.ufal.aracomp.cosmos.limite.impl.ComponentFactory.createInstance();


        //instacianco conector
        ILimiteOps limiteOps = (ILimiteOps) compLimite.getProvidedInterface("ILimiteOps");
        try {
            IconnSrv connSrv = new ConectorRMIServidor(limiteOps);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Server1", connSrv);
            System.out.print("Servidor OK");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
