/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

@Named(value = "gestorLingua")
@SessionScoped
public class GestorLingua implements Serializable {

    private Locale locale;
    private String lingua;
    private Map<String, Object> listaLinguas;

    @PostConstruct
    public void init() {

        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
        carregarLinguas();
    }

    private void carregarLinguas() {
        listaLinguas = new LinkedHashMap<>();
        listaLinguas.put("Inglês", new Locale("en", "GB"));
        listaLinguas.put("Portugues", new Locale("pt", "PT"));
        listaLinguas.put("Espanhol", new Locale("es", "ES"));
    }

    public void escolherLingua(String linguaEscolhida) {
        configurarLingua(linguaEscolhida);
        for (Map.Entry<String, Object> valor : listaLinguas.entrySet()) {
            if (valor.toString().equals(linguaEscolhida)) {
                this.lingua = linguaEscolhida;
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) valor.getValue());
            }

        }
    }

    private void configurarLingua(String linguaSeleccionada) {
        String[] lc = linguaSeleccionada.split("_");
        this.locale = new Locale(lc[0]);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    public String getLinguaPagina() {
        return locale.getLanguage();
    }

}
