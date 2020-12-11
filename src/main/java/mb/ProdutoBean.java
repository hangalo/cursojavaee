/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author DGTALE
 */
@Named(value = "produtoBean")
@SessionScoped
public class ProdutoBean implements Serializable {

    private String codigoBarras="";
    private String codigoComercial="";
    private String nomeProduto="";
    private Double precoProduto=0.0;
    private String validade ="";

    public ProdutoBean() {
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoComercial() {
        return codigoComercial;
    }

    public void setCodigoComercial(String codigoComercial) {
        this.codigoComercial = codigoComercial;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    
    public String guardar() {
        return "produtos";
    }

}
