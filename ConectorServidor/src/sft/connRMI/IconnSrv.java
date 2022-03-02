package sft.connRMI;

import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IconnSrv extends Remote {
    public double calcularLimite(ClienteDT client) throws RemoteException;
}
