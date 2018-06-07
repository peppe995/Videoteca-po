/**
 * La classe Regista descrive un regista di un film, avendo come attributo nome,
 * cognome e nazionalità. Questa classe estende la superclasse Persona ereditandone
 * metodi e attributi
 * 
 * @author Carlone Giuseppe Pio
 * @author Mambella Alessandra
 * @author Sichetti Dylan
 */

public class Regista extends Persona
{
        
    /**
     * La nazionalità del regista
     */
    
    private String nazione;
    
    
                     /** Costruttori */
    
    /**
     * Il costruttore di default chiama il costruttore della superclasse Persona, il quale
     * imposta nome e cognome su parametri generici, mentre nell'istruzione successiva
     * imposta la nazionalità ("NazioneD")
     */
	
    public Regista()
        {
            super();
            nazione = "NazioneD";
        }
    
    /**
     * Questo costruttore istanzia un oggetto di tipo Regista inizializzando nome, 
     * cognome e nazionalità su parametri specifici
     * @param NomeR descrive il nome del regista
     * @param CognomeR descrive il cognome del regista
     * @param NazioneR descrive la nazionalità del regista
     */
    
    public Regista(String NomeR,String CognomeR,String NazioneR)
        {
            this.nome=NomeR;
            this.cognome=CognomeR;
            nazione=NazioneR;
        }
    
    /**
     * Restituisce la nazionalità di un regista
     * @return la nazionalità di un regista
     */
                      /** Metodi Get */
    
    public String getNazione()
        {
	    return nazione;
        }
    
    /**
     * Permette di impostare su un valore specifico la nazionalità di un regista
     * @param NazioneR descrive la nazionalità di un regista
     */
                      /** Metodi Set */
    public void setNazione(String NazioneR)
        {
	    nazione = NazioneR;
        }
    
    /**
     * Converte in una stringa il regista, in quanto restituisce nome, cognome
     * (chiamando il toString della superclasse Persona) e nazionalità 
     * in una stringa ordianta
     */
        
    public String toString()
        {
            return super.toString()+" \n"+nazione;
        }
    
    /**
     * Effettua un controllo di uguaglianza tra due registi
     * @param r descrive il regista che verrà inserito nel controllo
     * @return una variabile booleana che simboleggia lo stato di uguaglianza o meno tra due registi
     */
    
    public Boolean equals(Regista r)
        {
            if(this.nome.equalsIgnoreCase(r.getNome()) && this.cognome.equalsIgnoreCase(r.getCognome()) 
                && this.nazione.equalsIgnoreCase(r.nazione))
                {
                    return true;
                }
	    
            else
                {
		    return false;
                }
        }
        
    
}
