
package projekt.model;

import hibernate.narzedzia.HibernateSingleton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@Entity
public class Sklep implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    private String nazwa;
    private String telefon;
    @OneToMany(mappedBy = "sklep")
    private List<Buty> buty = new ArrayList<Buty>();
    @OneToMany(mappedBy = "sklep")
    private List<Spodnie> spodnie = new ArrayList<Spodnie>();

    public long getId() {
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<Buty> getButy() {
        return buty;
    }

    public void setButy(List<Buty> buty) {
        this.buty = buty;
    }

    public List<Spodnie> getSpodnie() {
        return spodnie;
    }

    public void setSpodnie(List<Spodnie> spodnie) {
        this.spodnie = spodnie;
    }
    
    public void dodajButy(Buty buty) {
        this.buty.add(buty);
    }
    
    public void dodajSpodnie(Spodnie spodnie) {
        this.spodnie.add(spodnie);
    }
    
    public static List<Spodnie> szukajSpodniePoRomiarze(String rozmiar) {
        Session session = HibernateSingleton.pobierzSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Spodnie.class);
        criteria.add(Restrictions.eq("rozmiar", rozmiar));
        List<Spodnie> wynik = criteria.list();
        
        transaction.commit();

        return wynik;
    }
    
    public static List<Buty> szukajButyPoRomiarze(float rozmiar) {
        Session session = HibernateSingleton.pobierzSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Buty.class);
        criteria.add(Restrictions.eq("rozmiar", rozmiar));
        List<Buty> wynik = criteria.list();
        
        transaction.commit();

        return wynik;
    }
    
    public static List<Spodnie> szukajPoMarce(String marka) {
        Session session = HibernateSingleton.pobierzSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Spodnie.class);
        criteria.add(Restrictions.eq("marka", marka));
        List<Spodnie> wynik = criteria.list();
        
        transaction.commit();

        return wynik;
    }
    
    public static List<Buty> szukajPoNazwie(String nazwa) {
        Session session = HibernateSingleton.pobierzSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Buty.class);
        criteria.add(Restrictions.eq("nazwa", nazwa));
        List<Buty> wynik = criteria.list();
        
        transaction.commit();

        return wynik;
    }
}
