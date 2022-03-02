package br.ufal.aracomp.main;

import br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import connRMI.ConnCli;
import connRMI.RoundRobin;


public class Principal {
    public static void main(String[] args) {
        RoundRobin roundRobin = new RoundRobin();
        System.out.println("*---------------------------------------------------------------------*");
        for(int i = 0; i < 5; i++ ) {
        //Instanciando emprestimo
        IManager compEmp = ComponentFactory.createInstance();
        ConnCli conector = new ConnCli(roundRobin);

        //bindings
        compEmp.setRequiredInterface("ILimiteReq", conector);

        //calcula o emprestimo
        IEmprestimoOps objEmpOps = (IEmprestimoOps)compEmp.getProvidedInterface("IEmprestimoOps");
        UsuarioDT usuario = new UsuarioDT();

        usuario.rendimentos = String.valueOf(999*i);
        System.out.println("Valor liberado: R$"+objEmpOps.liberarEmprestimoAutomatico(usuario));
        System.out.println("*---------------------------------------------------------------------*");
        }
    }
}
