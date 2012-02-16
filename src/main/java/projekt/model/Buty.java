
package projekt.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Buty implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nazwa;
    private String kolor;
    private Float rozmiar;
    @ManyToOne
    private Sklep sklep;


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public Float getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(float rozmiar) {
        this.rozmiar = rozmiar;
    }

    public Sklep getSklep() {
        return sklep;
    }

    public void setSklep(Sklep sklep) {
        this.sklep = sklep;
    }
}
