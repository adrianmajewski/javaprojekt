
package projekt;

import hibernate.narzedzia.HibernateSingleton;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import projekt.model.Buty;
import projekt.model.Sklep;
import projekt.model.Spodnie;

public class Main {
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = HibernateSingleton.pobierzSessionFactory();
        Session session = sessionFactory.openSession();
            
        Transaction transaction = session.beginTransaction();
            
        Sklep sklep = new Sklep();
        sklep.setNazwa("Junke Buty");
        sklep.setTelefon("123456789");
        
        Buty buty1 = new Buty();
        buty1.setNazwa("Nike Ninja");
        buty1.setKolor("białe");
        buty1.setRozmiar(40.0f);
        buty1.setSklep(sklep);
        sklep.dodajButy(buty1);
        session.save(buty1);
        
        Buty buty2 = new Buty();
        buty2.setNazwa("Puma Krzywy Ogórek");
        buty2.setKolor("białe");
        buty2.setRozmiar(42.0f);
        buty2.setSklep(sklep);
        sklep.dodajButy(buty2);
        session.save(buty2);
        
        Buty buty3 = new Buty();
        buty3.setNazwa("AdiDOS");
        buty3.setKolor("białe");
        buty3.setRozmiar(40.0f);
        buty3.setSklep(sklep);
        sklep.dodajButy(buty3);
        session.save(buty3);
        
        Buty buty4 = new Buty();
        buty4.setNazwa("Nike Taekwondo");
        buty4.setKolor("białe");
        buty4.setRozmiar(40.0f);
        buty4.setSklep(sklep);
        sklep.dodajButy(buty4);
        session.save(buty4);
        
        Spodnie spodnie1 = new Spodnie();
        spodnie1.setMarka("Levis");
        spodnie1.setRozmiar("W31 H32");
        spodnie1.setSklep(sklep);
        sklep.dodajSpodnie(spodnie1);
        session.save(spodnie1);
        
        Spodnie spodnie2 = new Spodnie();
        spodnie2.setMarka("Bugjo");
        spodnie2.setRozmiar("W34 H33");
        spodnie2.setSklep(sklep);
        sklep.dodajSpodnie(spodnie2);
        session.save(spodnie2);
        
        Spodnie spodnie3 = new Spodnie();
        spodnie3.setMarka("Wrangler");
        spodnie3.setRozmiar("W31 H32");
        spodnie3.setSklep(sklep);
        sklep.dodajSpodnie(spodnie3);
        session.save(spodnie3);
        
        Spodnie spodnie4 = new Spodnie();
        spodnie4.setMarka("Lee");
        spodnie4.setRozmiar("W34 H33");
        spodnie4.setSklep(sklep);
        sklep.dodajSpodnie(spodnie4);
        session.save(spodnie4);
        
        session.save(sklep);
        
        transaction.commit();
        
        System.out.println("\n-szukanie po rozmiarze butów\n");
        List<Buty> buty = Sklep.szukajButyPoRomiarze(40.0f);
        for(Buty b : buty) {
            System.out.println(b.getNazwa() + " " + b.getKolor() + " " + b.getRozmiar());
        }
        
        System.out.println("\n-szukanie po rozmiarze spodni\n");
        List<Spodnie> spodnie = Sklep.szukajSpodniePoRomiarze("W34 H33");
        for(Spodnie s : spodnie) {
            System.out.println(s.getMarka() + " " + s.getRozmiar());
        }
        
        System.out.println("\n-szukanie po marce spodni\n");
        spodnie = Sklep.szukajPoMarce("Lee");
        for(Spodnie s : spodnie) {
            System.out.println(s.getMarka() + " " + s.getRozmiar());
        }
        
        System.out.println("\n-szukanie po nazwie butów\n");
        buty = Sklep.szukajPoNazwie("Nike Ninja");
        for(Buty b : buty) {
            System.out.println(b.getNazwa() + " " + b.getKolor() + " " + b.getRozmiar());
        }
    }
}
