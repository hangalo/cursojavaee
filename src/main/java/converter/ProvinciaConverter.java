/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Provincia;

@FacesConverter("provinciaConverter")
public class ProvinciaConverter implements Converter {

    private static Map<String, Provincia> mapa = new HashMap<String, Provincia>();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return mapa.get(value);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        if (valor instanceof Provincia) {
            Provincia pr = (Provincia) valor;
            mapa.put(String.valueOf(pr.getId()), pr);
            return String.valueOf(pr.getId());
        } else {
            return "";
        }
    }

}
