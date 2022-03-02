package connRMI;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;
import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import sft.connRMI.IconnSrv;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ConnCli implements ILimiteReq{
    private IconnSrv connSrv;

    public ConnCli(RoundRobin roundRobin){
        try {
            String uri = roundRobin.newRequest();
            this.connSrv = (IconnSrv) Naming.lookup(uri);
            System.out.println("porta do servidor escolhido: "+uri);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println("exception conectar server");
            e.printStackTrace();
        }
    }
    @Override
    public double estimarLimite(UsuarioDT usuario) {
        try {
            //instanciando cliente
            ClienteDT cliente = new ClienteDT();

            cliente.salario = Double.parseDouble(usuario.rendimentos);

            return  this.connSrv.calcularLimite(cliente); /*{
                return this.limiteOps.calcularLimite(cliente);
            }
            System.out.println("print 1");
            return 0;*/
/*            else{
                return RuntimeException;
            }*/
        }catch (Exception t){
            System.out.println("exeption criar limite");
            //exibe mensagem de erro e para a aplicação
            System.out.println(t.getMessage());
            System.exit(0);
            //return 0;
        }

        return 0;
    }
}
