import java.lang.Comparable;

/**
 * La classe Film gestisce oggetti di tipo film attraverso il titolo, il codice identificativo ISAN,
 * il regista e la disponibilità, i quali a loro volta rappresentano gli attributi della classe stessa,
 * all'interno di una "videoteca". 
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
     * Il regista del film
     */
    
    private Regista regista;
    
    /**
     * Il codice ISBN del film
     */
    
    private String codice;
    
    /**
    * La disponibilità del film, ossia il numero di copie disponibili di film
    */
    
    private int disponibilità;
                        
                        /** Costruttori */
    /**
     * Il costruttore di default: descrive un oggetto di tipo film con attributi quali titolo, codice ISAN 
     * e a un regista generici con disponibilità unitaria.
     */
    
    public Film()
    {
        titolo = "TitoloD";
        regista = new Regista();
        codice = "CodiceD";
        disponibilità = 1;
    }
    
    /**
     * Tale costruttore permette tramite il passaggio di parametri specificati 
     * dall'utente di inizializzare l'oggetto film ad uno stato specifico, permettendo 
     * di scegliere anche il totale di numero di copie disponibili (se la disponibilità è maggiore o uguale a 0)
     * @param TF descrive il titolo del film
     * @param RF descrive il regista del film
     * @param DF descrive la disponibilità di tale film
     * @param CF descrive il codice ISAN del film
     */
    
    public Film(String TF, Regista RF, String CF, int DF)
    {
        regista = new Regista(RF.getNome(), regista.getCognome(), regista.getNazione());
        titolo = TF;
        codice = CF;
        setDisponibilità(DF);
    }
    
    /**
     * Il suddetto costruttore inizializza un film con disponibilità unica attraverso 
     * il passaggio dei parametri titolo, regista e codice ISAN
     * @param TF descrive il titolo del film
     * @param RF descrive l'regista del film
     * @param CL descrive il codice ISAN del film
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
     * @param TF rappresenta il titolo del film selezionato
     */
                        
    public void setTitolo(String TF)
    {
        titolo = TF;
    }
    
    /**
     * Permette di impostare il totale delle copie disponibili di un film
     * @param DF rappresenta il totale delle copie disponibili di un dato film
     */
    
    public void setDisponibilità(int DF)
    {
        if(DF>=0)
	{
		disponibilità = DF;
	}
	else
	{
		disponibilità = 0;
	}
    }
    
    /**
     * Permette di selezionare il regista del film
     * @param RF rappresenta il regista di un determinato film
     */
    
    public void setRegista(Regista RF)
    {
        regista = new Regista(RF.getNome(), RF.getCognome(), RF.getNazione());
    }
    
    /**
     * Consente di impostare il codice ISAN di un film
     * @param CF rappresenta il codice ISAN di un determinato film
     */
    
    public void setCodice(String CF)
    {
        codice = CF;
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
	if(disponibilità>0)
	{
            disponibilità--;
	}
    }
    
    /**
     * In caso di restituzione di un film ne aumenta la disponibilità di un'unità
     */
    
    public void Restituzione()
    {
        disponibilità++;
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
     * Effettua un confronto lessico-grafico in base al titolo dei film confrontati
     * e rende possibile stabilire se un film va collocato prima o dopo in un riordinamento
     * @param o rappresenta il secondo elemento del paragone
     * @return un intero positivo, negativo, oppure zero in base al risultato
     */
    
    public int compareTo(Object o)
    {
        Film f=(Film)o;
        return titolo.compareToIgnoreCase(f.getTitolo());
    }
    
}
