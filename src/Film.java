import java.lang.Comparable;

/**
 * La classe Film gestisce oggetti di tipo film attraverso il titolo, il codice identificativo ISAN,
 * il regista e la disponibilità, i quali a loro volta rappresentano gli attributi della classe stessa,
 * all'interno di una "videoteca".
 * Implementa, inoltre, l'interfaccia Comparable rendendo possibile un riordinamento
 * dei film in base agli attributi elencati.
 *
 * @author Carlone Giuseppe Pio
 * @author Mambella Alessandra
 * @author Sichetti Dylan
 */

public class Film implements Comparable{

    /**
     * Il titolo di un film
     */

    private String titolo;

    /**
     * Il regista del film
     */

    private Regista regista;

    /**
     * Il codice ISAN del film
     */

    private String codice;

    /**
     * La disponibilità del film, cioè il numero di copie disponibili di film
     */

    private int disponibilita;

                        /** Costruttori */
    /**
     * Il costruttore di default: descrive un oggetto di tipo film con attributi quali titolo, codice ISAN
     * e a un regista generici con disponibilità unitaria.
     */

    public Film()
    {
        titolo = "Titolo";
        regista = new Regista();
        codice = "Codice";
        disponibilita = 1;
    }
    
    /**
     * Tale costruttore permette tramite il passaggio di parametri specificati
     * dall'utente di inizializzare l'oggetto film ad uno stato specifico, permettendo
     * di scegliere anche il totale di numero di copie disponibili
     * @param tf descrive il titolo del film
     * @param rf descrive il regista del film
     * @param df descrive la disponibilità di tale film
     * @param cf descrive il codice ISAN del film
     */

    public Film(String tf, Regista rf, String cf, int df)
    {
        regista = new Regista(rf.getNome(), regista.getCognome(), regista.getNazione());
        titolo = tf;
        codice = cf;
        setDisponibilita(df);
    }

    /**
     * Il costruttore inizializza un film con disponibilità unica attraverso
     * il passaggio dei parametri titolo, regista e codice ISAN
     * @param tf descrive il titolo del film
     * @param rf descrive l'regista del film
     * @param cf descrive il codice ISAN del film
     */

    public Film(String tf, Regista rf, String cf)
    {
        regista = new Regista(rf.getNome(), rf.getCognome(), rf.getNazione());
        titolo = tf;
        codice = cf;
        disponibilita = 1;
    }

                    /** Metodi Get */

    /**
     * Restituisce il titolo del film
     * @return Il titolo del film
     */
    public String getTitolo()
    {
        return titolo;
    }

    /**
     * Restituisce il totale delle copie disponibili di un dato film
     * @return l'ammontare delle copie disponibili del film selezionato
     */

    public int getDisponibilita()
    {
        return disponibilita;
    }

    /**
     * Restituisce una copia del regista del film
     * @return regista del film
     */

    public Regista getRegista()
    {
        return new Regista(regista.getNome(),regista.getCognome(),regista.getNazione());
    }

    /**
     * Restituisce il codice ISAN di tale film
     * @return Il genere di tale film
     */

    public String getCodice()
    {
        return codice;
    }
    /** Metodi Set */
    /**
     * Permette di stabilire il titolo di un film
     * @param tf rappresenta il titolo del film selezionato
     */

    public void setTitolo(String tf)
    {
        titolo = tf;
    }

    /**
     * Permette di impostare il totale delle copie disponibili di un film
     * @param df rappresenta il totale delle copie disponibili di un dato film
     */

    public void setDisponibilita(int df)
    {
        if(df>=0)
        {
            disponibilita = df;
        }
        else
        {
            disponibilita = 0;
        }
    }

    /**
     * Permette di selezionare il regista del film
     * @param rf rappresenta il regista di un determinato film
     */

    public void setRegista(Regista rf)
    {
        regista = new Regista(rf.getNome(), rf.getCognome(), rf.getNazione());
    }

    /**
     * Consente di impostare il codice ISAN di un film
     * @param cf rappresenta il codice ISAN di un determinato film
     */

    public void setCodice(String cf)
    {
        codice = cf;
    }

    /**
     * Restituisce una stringa contenente tutte le informazioni sul film
     * @return La stringa ordinata è una composizione di titolo, regista ed codice ISAN
     */

    public String toString()
    {
        return titolo+" "+regista+" "+codice+" ";
    }

    /**
     * In caso di noleggio di un film si riduce la disponibilità di un'unità , se questa è maggiore di 0;
     */

    public void Noleggio()
    {
        if(disponibilita>0)
        {
            disponibilita--;
        }
    }

    /**
     * In caso di restituzione di un film ne aumenta la disponibilità di un'unità
     */

    public void Restituzione()
    {
        disponibilita++;
    }

    /**
     * Effettua un confronto per verificare l'uguaglianza tra due film dati comparando titolo e regista
     * @param f rappresenta il secondo film che verrà aggiunto al confronto
     * @return una variabile booleana che rappresenta l'uguaglianza o meno dei due film
     */

    public boolean equals(Film f)
    {

        if(titolo.equalsIgnoreCase(f.getTitolo()) && regista.equals(f.getRegista()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }







    /**
     * Effettua un confronto  in base al titolo dei film confrontati
     * e rende possibile stabilire se un film va collocato prima o dopo in un riordinamento
     * @param other rappresenta il secondo elemento del paragone
     * @return un intero positivo, negativo, oppure zero in base al risultato
     */

    public int compareTo(Object other)
    {
        Film f=(Film)other;
        return titolo.compareToIgnoreCase(f.getTitolo());
    }
}
