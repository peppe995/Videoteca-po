import java.lang.Comparable;

/**
 * La classe Film gestisce oggetti di tipo film attraverso il titolo, il codice ISBN,
 * il regista e la disponibilità, i quali rappresentano gli attributi della classe stessa,
 * all'interno di una "videoteca"
 * 
 * Implementa, inoltre, l'interfaccia Comparable rendendo possibile un riordinamento
 * dei film in base agli attributi sopra elencati.
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
     * L'regista del libro
     */
    
    private Regista regista;
    
    /**
     * Il codice ISBN del film
     */
    
    private String codice;
    
    /**
    * La disponibilità del film, ossia il numero di copie disponibili film
    */
    
    private int disponibilità;
                        
                        /** Costruttori */
    /**
     * Il costruttore di default: descrive un oggetto di tipo film con attributi quali titolo, codice ISBN 
     * e a un regista generici e, con disponibilità unitaria.
     */
    
    public Film()
    {
        titolo = "TitoloD";
        regista = new Regista();
        codice = "CodiceD";
        disponibilità = 1;
    }
    
    /**
     * Tale costruttore invece permette tramite il passaggio di parametri specificati 
     * dall'utente di inizializzare l'oggetto film ad uno stato specifico, permettendo 
     * di scegliere anche l'ammontare della disponibilità (se questa è maggiore o uguale a 0)
     * @param TF descrive il titolo del film
     * @param RF descrive il regista del film
     * @param DF descrive la disponibilità di tale film
     * @param CF descrive il codice ISBN del film
     */
    
    public Film(String TF, Regista RF, String CF, int DF)
    {
        regista = new Regista(RF.getNome(), regista.getCognome(), regista.getNazione());
        titolo = TF;
        codice = CF;
        setDisponibilità(DF);
    }
    
    /**
     * Questo costruttore inizializza un libro con disponibilità unica attraverso 
     * il passaggio dei parametri titolo, regista e codice ISBN
     * @param T descrive il titolo del libro
     * @param RF descrive l'regista del libro
     * @param CL descrive il codice ISBN del libro
     */
    
    public Film(String TF, Regista RF, String CF)
    {
        regista = new Regista(RF.getNome(), RF.getCognome(), RF.getNazione());
        titolo = TF;
        codice = CF;
        disponibilità = 1;
    }
    
    /**
     * Restituisce il titolo del film
     * @return Il titolo del film
     */
                        /** Metodi Get */
    public String getTitolo()
    {
        return titolo;
    }
    
    /**
     * Restituisce il totale delle copie disponibili di un dato film
     * @return L'ammontare delle copie disponibili del film selezionato 
     */
    
    public int getDisponibilità()
    {
        return disponibilità;
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
     * Restituisce il codice ISBN di tale libro
     * @return Il genere di tale libro 
     */
    
    public String getCodice()
    {
        return codice;
    }
    
    /**
     * Permette di impostare il titolo di un libro
     * @param TL rappresenta il titolo del libro
     */
    
    public void setTitolo(String TL)
    {
        titolo=TL;
    }
    
    /**
     * Permette di impostare l'ammontare delle copie disponibili di un libro
     * @param DL rappresenta l'ammontare delle copie disponibili di un dato libro
     */
    
    public void setDisponibilità(int DL)
    {
        if(DL>=0)
	{
		disponibilità=DL;
	}
	else
	{
		disponibilità=0;
	}
    }
    
    /**
     * Permette di impostare l'regista del libro
     * @param RF rappresenta l'regista di un libro
     */
    
    public void setRegista(Regista RF)
    {
        regista=new Regista(RF.getNome(), RF.getCognome(), RF.getNazione());
    }
    
    /**
     * Permette di impostare il codice ISBN di un libro
     * @param CL rappresenta il codice ISBN di un dato libro
     */
    
    public void setCodice(String CL)
    {
        codice=CL;
    }
    
    /**
     * Restituisce una stringa contenente tutte le informazioni sul libro
     * @return Restituisce una composizione di titolo, regista ed codice ISBN in una stringa ordinata
     */
    
    public String toString()
    {
        return titolo+" "+regista+" "+codice+" ";
    }
    
    /**
     * In caso di noleggio di un libro ne riduce la disponibilità di un'unità , se questa è maggiore di 0;
     */
    
    public void Noleggio()
    {
	if(disponibilità>0)
	{
            disponibilità--;
	}
    }
    
    /**
     * In caso di restituzione di un libro ne aumenta la disponibilità di un'unità
     */
    
    public void Restituzione()
    {
        disponibilità++;
    }
    
    /**
     * Effettua un confronto per verificare l'uguaglianza tra due libri dati confrontando titolo e regista
     * @param l rappresenta il secondo libro che verrà aggiunto al confronto
     * @return una variabile booleana che rappresenta l'effettiva uguaglianza o non
     */
    
    public boolean equals(Libro l)
    {
        
            if(titolo.equalsIgnoreCase(l.getTitolo()) && regista.equals(l.getRegista()))
	    {
		    return true;
	    }
            else
	    {
		    return false;
	    }
    }
    
    /**
     * Permette di effettuare un confronto lessico-grafico in base al titolo dei libri confrontati
     * e rende possibile stabilire se un libro va collocato prima o dopo 
     * in un riordinamento
     * @param o rappresenta il secondo elemento del paragone
     * @return un intero positivo, negativo, oppure zero in base al risultato
     */
    
    public int compareTo(Object o)
    {
        Libro l=(Libro)o;
        return titolo.compareToIgnoreCase(l.getTitolo());
    }
    
}
