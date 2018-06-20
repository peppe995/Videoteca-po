
/**
 * La classe Cliente estende la classe Persona rappresentando un cliente astratto di una videoteca.
 * Presenta metodi sui noleggi all'attivo del cliente, la restituzione e codice fiscale.
 *
 * @author Carlone Giuseppe Pio
 * @author Mambella Alessandra
 * @author Sichetti Dylan
 *
 */
public class Cliente extends Persona{

    /**
     * Numero di noleggi attivi
     */

    private int prestiti;

    /**
     * Codice fiscale del cliente
     */

    private String codicef;

                        /** Costruttori */

    /** Costruttore di default: definisce gli attributi per il cliente come il numero dei prestiti attivi e il codice fiscale.
     *  Inoltre eredita gli attributi della classe Persona.
     */

    public Cliente()
    {
        super();
        prestiti = 0;
        codicef = "Codicef";
    }

    /**
     * Istanzia l'oggetto della classe cliente con i parametri passati
     * @param NomeC Nome del cliente
     * @param CognomeC Cognome del cliente
     * @param CodicefC Codice fiscale del cliente
     */

    public Cliente(String NomeC,String CognomeC,String CodicefC)
    {
        this.nome = NomeC;
        this.cognome = CognomeC;
        prestiti = 0;
        codicef = CodicefC;
    }
                    /** Metodi Get */

    /**
     * Restituisce il numero di noleggi attivi del cliente
     * @return numero di noleggi
     */

    public int getPrestiti()
    {
        return prestiti;
    }

    /**
     * Restituisce una stringa contenente il codice fiscale del cliente
     * @return il codice fiscale
     */

    public String getCodiceFisc()
    {
        return codicef;
    }
                    /** Metodi Set */

    /**
     * Imposta il numero dei noleggi del cliente
     * @param PrestitiC
     */

    public void setPrestiti(int PrestitiC)
    {
        prestiti = PrestitiC;
    }

    /**
     * Imposta il codice fiscale del cliente
     * @param CodicefC codice fiscale da impostare
     */

    public void setCodiceFisc(String CodicefC)
    {
        codicef = CodicefC;
    }


    /**
     * Aumenta di 1 il numero di noleggi del cliente
     */

    public void Nolegg()
    {
        prestiti++;
    }

    /**
     * Decresce di 1 il numero di noleggi all'attivo del cliente se questo è maggiore di 0
     */

    public void Restituzione()
    {
        if(prestiti > 0)
        {
            prestiti--;
        }

    }

    /**
     * Controlla se il cliente è uguale al secondo (passato come parametro).
     * Il metodo confronta il nome, il cognome e il codice fiscale
     * @param c cliente con cui operare il confronto
     * @return una variabile booleana che rappresenta lo stato di uguaglianza o meno tra due clienti
     */

    public boolean equals(Cliente c)
    {
        if(this.nome.equalsIgnoreCase(c.getNome()) && this.cognome.equalsIgnoreCase(c.getCognome()) &&
                codicef.equalsIgnoreCase(c.getCodiceFisc()))

        {
            return true;
        }

        else
        {
            return false;
        }
    }

    /**
     * Converte in stringa l'oggetto cliente
     * @return la stringa rappresentante il cliente nel formato: nome cognome codice fiscale
     */
    public String toString()
    {
        return super.toString()+" "+codicef;
    }
}
