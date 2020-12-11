
package modelo;

import java.util.Date;


public class AgenciaJornalista {
    private Jornalista jornalista;
    private Agencia agencia;
    private Date inicio;
    private Date fim;

    public AgenciaJornalista() {
    }

    public AgenciaJornalista(Jornalista jornalista, Agencia agencia, Date inicio, Date fim) {
        this.jornalista = jornalista;
        this.agencia = agencia;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Jornalista getJornalista() {
        return jornalista;
    }

    public void setJornalista(Jornalista jornalista) {
        this.jornalista = jornalista;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
    
    
}
