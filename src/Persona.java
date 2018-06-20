import java.lang.Comparable;

/**
 * Fornisce un'astrazione di una persona con nome e cognome.
 * Implementa, inoltre, l'interfaccia Comparable in modo da effettuare un riordinamento
 * dell'ordine alfabetico attraverso il cognome utilizzando il metodo compareTo.
 * Dati due oggetti, tale metodo determina l'ordine di precedenza secondo un criterio di ordinamento.
 *
 * @author Carlone Giuseppe Pio
 * @author Mambella Alessandra
 * @author Sichetti Dylan
 *
 */
public class Persona implements Comparable{

    /**
     * Nome della persona
     */

    protected String nome;

    /**
     * Cognome della persona
     */

    protected String cognome;


                        /** Costruttori */

    /**
     * Costruttore di default che attribuisce alla persona:
     * "Nome" come nome e "Cognome" come cognome;
     */

    public Persona()
    {
        nome = "Nome";
        cognome = "Cognome";
    }

    /**
     * Costruttore che istanzia la persona con il nome e il cognome forniti
     * @param NomeP nome da attribuire alla persona
     * @param CognomeP cognome da attribuire alla persona
     */

    public Persona(String NomeP , String CognomeP)
    {
        nome = NomeP;
        cognome = CognomeP;
    }

                        /** Metodi Get */

    /**
     * restituisce il nome della persona
     * @return nome della persona
     */

    public String getNome()
    {
        return nome;
    }

    /**
     * restituisce il cognome della persona
     * @return cognome della persona
     */

    public String getCognome()
    {
        return cognome;
    }

                        /** Metodi Set */

    /**
     * Imposta il nome della persona
     * @param NomeP nome da impostare
     */
    public void setNome(String NomeP)
    {
        nome = NomeP;
    }

    /**
     * Imposta il cognome della persona
     * @param CognomeP cognome da impostare
     */

    public void setCognome(String CognomeP)
    {
        cognome = CognomeP;
    }

                        /** Metodi Utili */

    /**
     * Converte in stringa la persona
     * @return la stringa contenente nome e cognome nella forma: nome cognome
     */

    public String toString()
    {
        return nome+" "+cognome;
    }

    /**
     * Confronta la persona con un'altra (passata come parametro) confrontando l'ordine alfabetico del cognome
     * @param other la seconda persona con cui confrontare
     * @return l'intero corrispondente al risultato, -1 se minore,0 se uguale,1 se maggiore
     */

    public int compareTo(Object other)
    {
        Persona persona = (Persona)other;
        return this.cognome.compareToIgnoreCase(persona.getNome());
    }


    /**
     * Utilizzando la variabile "protected", rendiamo accessibili
     * gli attributi della superclasse Persona ai metodi delle sottoclassi.
     */

}
