package sft.connRMI;

import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConectorRMIServidor extends UnicastRemoteObject implements IconnSrv{
    private ILimiteOps limiteOps;

    protected ConectorRMIServidor(ILimiteOps limiteOps) throws RemoteException {
        super();
        this.limiteOps = limiteOps;
    }

    @Override
    public double calcularLimite(ClienteDT client) throws RemoteException {
        try {
            return  this.limiteOps.calcularLimite(client);
        }catch (Exception t){
            //exibe mensagem de erro e para a aplicação
            System.out.println(t.getMessage());
            System.exit(0);
            //return 0;
        }
        return 0;
    }
}
