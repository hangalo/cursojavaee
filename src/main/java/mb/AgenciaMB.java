/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.AgenciaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import modelo.Agencia;

@Named(value = "agenciaMB")
@RequestScoped
public class AgenciaMB {

    Agencia agencia = new Agencia();
    AgenciaDAO dao = new AgenciaDAO();

    List<Agencia> agencias = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        agencias = dao.findAll();
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Agencia> getAgencias() {
        for (Agencia a : agencias) {
            System.out.println("TesteAgencia" + a.getNome());
        }
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

    public String insert() {
        dao.insert(agencia);
        agencia = new Agencia();
        return "agencias?faces-redirect=true";
    }
}
