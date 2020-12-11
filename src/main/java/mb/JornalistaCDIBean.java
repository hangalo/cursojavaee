/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.JornalistaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import modelo.Jornalista;

@Named(value = "jornalistaCDIBean")
@SessionScoped
public class JornalistaCDIBean implements Serializable {

    Jornalista jornalista = new Jornalista();
    JornalistaDAO dao = new JornalistaDAO();
    List<Jornalista> jornalistas = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        jornalistas = dao.listarTodos();
    }

    public String guardar() {
        dao.guardar(jornalista);
        jornalista = new Jornalista();
        return null;
    }

    public String eliminar() {
        dao.eliminar(jornalista);
        jornalista = new Jornalista();
        return null;
    }

    public String prepararEditar() {
        return "editar-jornalista";
    }

    public String editar() {
        dao.actualizar(jornalista);
        jornalista = new Jornalista();
        return "gerir-jornalista";
    }

    public JornalistaCDIBean() {
    }

    public void fazerAlgo(ActionEvent event){
    
        //o que fazer
    
    }
    public Jornalista getJornalista() {
        return jornalista;
    }

    public void setJornalista(Jornalista jornalista) {
        this.jornalista = jornalista;
    }

    public List<Jornalista> getJornalistas() {
        return jornalistas;
    }

    public void setJornalistas(List<Jornalista> jornalistas) {
        this.jornalistas = jornalistas;
    }

}
