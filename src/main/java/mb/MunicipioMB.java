/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.MunicipioDAO;
import dao.ProvinciaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Municipio;
import modelo.Provincia;

@Named(value = "municipioMB")
@SessionScoped
public class MunicipioMB implements Serializable {

    Municipio municipio = new Municipio();
    Provincia provincia = new Provincia();
    MunicipioDAO municipioDAO = new MunicipioDAO();
    ProvinciaDAO provinciaDAO = new ProvinciaDAO();
    List<Municipio> municipios = new ArrayList<>();
    List<Provincia> provincias = new ArrayList<>();

    @PostConstruct
    public void init() {

        provincias = provinciaDAO.findAll();
        municipios = municipioDAO.findAll();
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String startEdit() {
        return "municipio-edit";
    }

    public String finishEdit() {
        municipioDAO.update(municipio);
        return "municipios";
    }

    public String insert() {
        municipioDAO.insert(municipio);
        municipio = new Municipio();
        return "municipios?faces-redirect=true";
    }

    public String delete() {
        municipioDAO.delete(municipio);
        return "municipios?faces-redirect=true";
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

}
