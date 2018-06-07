import java.lang.Comparable;

/**
* La classe Prestito descrive l'azione del noleggio di un film permettendo la 
* registrazione della data di nolegggio, della scadenza, e di tutte le informazioni
* relative al cliente che sta effettuando il noleggio stesso.
* 
 * @author Carlone Giuseppe Pio
 * @author Mambella Alessandra
 * @author Sichetti Dylan
 */

public class Prestito implements Comparable{
    
    /**
     * Le informazioni sul film
     */
    private Film film;
    
    /**
     * Le credenziali del cliente
     */
    private Cliente cliente;
    
    /**
     * La data in cui è avvenuto il noleggio
     */
    private Data data;
    
    /**
     * La data di scadenza di un dato noleggio
     */
    private Data scadenza;
    
    
    /**
     * Il costruttore di default inizializza un noleggio chiamando i costruttori 
     * di default delle classi film, cliente e data, per poi impostare la scadenza di 
     * tale prestito a 30 giorni dal giorno attuale
     */
    public Prestito()
     {
        film = new Film();
        cliente = new Cliente();
        data = new Data();
        scadenza = data.RicavaGiorno(30);
     }
    
    /**
     * Tale costruttore imposta una copia del film noleggiato,una copia del cliente
     * che lo ha preso in prestito e una copia del giorno di tale atto 
     * su dei parametri specifici immessi dall'utente
     * @param film1 descrive il film noleggiato
     * @param cliente1 descrive colui che ha effettuato il noleggio
     * @param data1 segnala la data in cui è avvenuto il noleggio
     */
    
    public Prestito(Film film1, Cliente cliente1, Data data1)
     {
        film = new Film(film1.getTitolo(),film1.getAutore(),film1.getCodice());
        cliente = new Cliente(cliente1.getNome(),cliente1.getCognome(),cliente1.getCodiceFisc());
        data = new Data(data1.getGiorno(),data1.getMese(),data1.getAnno());
        scadenza = data1.RicavaGiorno(30);        
     }
    
    /**
     * Restituisce una copia del film noleggiato
     * @return Il film noleggiato 
     */
    
    public Film getFilm()
     {
        return new Film(film.getTitolo(),film.getAutore(),film.getCodice());
     }
    
    /**
     * Restituisce le credenziali del cliente
     * @return il cliente che ha effettuato il noleggio
     */
    
    public Cliente getCliente()
     {
       return cliente = new Cliente(cliente.getNome(),cliente.getCognome(),cliente.getCodiceFisc());
     }
    
    /**
     * Restituisce la copia della data in cui è stato effettuato il noleggio
     * @return Il giorno associato al noleggio
     */
    
    public Data getData()
     {
        return new Data(data.getGiorno(),data.getMese(),data.getAnno());
     }
    
    /**
     * Restituisce la copia della data di scadenza associata ad un determinato noleggio
     * @return La data di scadenza del noleggio
     */
     
    public Data getScadenza()
     {
        return new Data(scadenza.getGiorno(),scadenza.getMese(),scadenza.getAnno());
     }
    
    /**
     * Permette di impostare le caratteristiche di un film in un noleggio passando 
     * per parametro un film determinato
     * @param film1 rappresenta le caratteristiche del film noleggiato
     */
    
    public void setFilm(Film film1)
     {
        film = new Film(film1.getTitolo(),film1.getAutore(),film1.getCodice());
     }
    
    /**
     * Permette di impostare le credenziali di un cliente in un determinato noleggio
     * @param cliente1 rappresenta il cliente
     */
    
    public void setCliente(Cliente cliente1)
     {
        cliente = new Cliente(cliente1.getNome(),cliente1.getCognome(),cliente1.getCodiceFisc());
     }
    
    /**
     * Permette di impostare la data specifica associata al noleggio
     * @param data1 rappresenta la data specifica del noleggio
     */
    
    public void setData(Data data1)
     {
        data = new Data(data1.getGiorno(),data1.getMese(),data1.getAnno());
     }
            
    
    /**
     * Converte le caratteristiche di un determinato noleggio in una stringa ordinata
     * @return una stringa contenente titolo del film, informazioni sul cliente, data di noleggio e di scadenza
     */
    
    public String toString()
     {
        return film.getTitolo()+ " " + cliente + " " + data + " " + scadenza;
     }
    
    /**
     * Permette di controllare se un dato noleggio scadrà prima o dopo rispetto 
     * ad un altro, rendendo possibile anche un riordinamento; restituisce un intero 
     * che simboleggia lo stato di un oggetto noleggio rispetto ad un altro nel confronto
     * @param other descrive l'altro noleggio da confrontare
     * @return un intero che simboleggia quale dei due noleggi è antecedente all'altro
     */
    
    public int compareTo(Object other)
     {
        Prestito prestito = (Prestito)other;
        return scadenza.compareTo(prestito.getScadenza());
     }

}