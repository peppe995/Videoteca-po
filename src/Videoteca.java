
import java.util.ArrayList;
import javax.swing.*;

/**
 * Rappresenta una videoteca astratta con un elenco di clienti, film e noleggi. 
 * 
 * @author Carlone Giuseppe Pio 
 * @author Mambella Alessandra
 * @author Sichetti Dylan
 */
public class Videoteca {
        
    /**
     * Lista dei libri
     */
    
    private ArrayList<Film> libri=new ArrayList<Film>();
    
    /**
     * Lista dei clienti
     */
    
    private ArrayList<Cliente> clienti=new ArrayList<Cliente>();
    
    /**
     * Lista dei noleggi
     */
    
    private ArrayList<Prestito> prestiti=new ArrayList<Prestito>();
    private static final int MaxPrestiti=5;
    private static final int LimiteMin=0;
    
    
    
    /**
     * 
     * @return La lista dei clienti (Cliente) contenuti
     */
    public ArrayList<Cliente> getClienti()
    {
        return clienti;
    }      
    
    /**
     * 
     * @return La lista dei noleggi (Loan) contenuti
     */
    public ArrayList<Prestito> getPrestiti()
    {
        return prestiti;
    }
    
    /**
     * 
     * @return La lista dei libri (Book) contenuti
     */
    public ArrayList<Film> getFilm()
    {
        return libri; 
    }
    
    /** Metodi Add */
    
    /**
     * Aggiunge il libro (Film) all'elenco; nel caso sia già presente, aumenta la
     * disponibilità sommando l'attributo di disponibilità del libro passato a quello gia presente
     * @param film1 Film da aggiungere
     */
    public void AggiungiFilm(Film film1)
    {
        boolean Uguale=false;
        if(CercaFilmTitolo(film1.getTitolo())!=null)
        {
            if(CercaFilmTitolo(film1.getTitolo()).getTitolo().equalsIgnoreCase(film1.getTitolo()))
            {
		    CercaFilmTitolo(film1.getTitolo()).setDisponibilità(film1.getDisponibilità()+
			    CercaFilmTitolo(film1.getTitolo()).getDisponibilità());
		    Uguale=true;
            }
        }
	
        if(!Uguale)
	{
		libri.add(film1);
	}
    }
    /**
     * Aggiunge un cliente alla lista; Se questo è già presente, il metodo non lo aggiunge.
     * @param cliente1 Cliente da aggiungere
     */
    
    public void AggiungiCliente(Cliente cliente1)
    {
        boolean Uguale=false;
        for(Cliente ClienteLista:clienti)
            {
                if(cliente1.equals(ClienteLista))
                {
                    Uguale=true;
                }
            }
        if (!Uguale)
	{
		clienti.add(cliente1);
	}
    }
        
        
    
    /** Metodi Utili */
    
    /**
     * Aggiunge un noleggio alla lista controllando se ciò è possibile.
     * La "possibilità" di questa azione è data da:
     * 1) Un controllo sui noleggi correnti del cliente (Cliente), nel caso ne abbia 
     *    all'attivo un numero maggiore o uguale a 5 non verrà aggiunto il noleggio
     * 2) Un controllo sulla disponibilità  del libro (Film), se la disponibilità è minore o uguale a 0
     *    non verrà aggiunto il noleggio.
     * Inoltre diminuisce di 1 la disponibilità del libro e aumenta i noleggi all'attivo del cliente di 1
     * @param prestito noleggio da analizzare e ,eventualmente, aggiungere
     * @return un booleano che rappresenta se è stato possibile noleggiare un libro
     */
    public boolean Noleggio(Prestito prestito)
    {
        boolean b=false;
        Film film1=new Film();
        Cliente cliente1=new Cliente();
        for(Film FilmLista:libri)
        {
            if(prestito.getFilm().equals(FilmLista))
	    {
		    b=true;
	    }
        }
	
        if (b)
        {
            film1=this.CercaFilmTitolo(prestito.getFilm().getTitolo());
            b=false;
            AggiungiCliente(prestito.getCliente());
            cliente1=this.CercaCliente(prestito.getCliente().getNome(), prestito.getCliente().getCognome(),prestito.getCliente().getCodiceFisc());
            if(cliente1.getPrestiti()<MaxPrestiti && film1.getDisponibilità()>LimiteMin)
            {
                this.prestiti.add(new Prestito(film1, cliente1, prestito.getData()));
                film1.Noleggio();
                cliente1.Nolegg();
                return true;
            }
	    
            else 
	    {
		    return false;
	    }
        }
        else 
	{
		return false;
	}
    }
    /**
     * Rimuove un noleggio dalla biblioteca,
     * inoltre incrementa di 1 la disponibilità del libro (Film) del noleggio
     * passato e decrementa di 1 i noleggi all'attivo del cliente (Cliente) del noleggio;
     * @param prestito noleggio da rimuovere
     */
    public void Restituzione(Prestito prestito)
    {
        Cliente cliente1=new Cliente();
        cliente1=this.CercaCliente(prestito.getCliente().getNome(), prestito.getCliente().getCognome(),prestito.getCliente().getCodiceFisc());
        this.prestiti.remove(prestito);
        cliente1.Restituzione();
        CercaFilmTitolo(prestito.getFilm().getTitolo()).Restituzione();
    }
    
    /**
     * Viene ricercato nella lista dei libri, il libro con il titolo ricercato
     * @param TL Titolo del libro da ricercare
     * @return il libro ricercato se già presente, altrimenti ritorna "null".
     */
    public Film CercaFilmTitolo(String TL)
    {
        Film film1=null;
        for(Film FilmLista:libri)
        {
            if(FilmLista.getTitolo().equalsIgnoreCase(TL))
	    {
		    film1=FilmLista;
	    }
        }
        return film1;
    }
    
    
    /**
     * Ricerca nella lista dei libri quelli con l'autore passato
     * @param nome il cognome dell'autore da cui ricercare i libri
     * @param cognome il nome dell'autore da cui ricercare i libri
     * @return una lista dei libri con l'autore inserito
     */
    public ArrayList<Film> CercaFilmAutore(String nome,String cognome)
    {
        ArrayList<Film> FilmLis=new ArrayList<Film>();
        for(Film FilmLista:libri)
        {
            if(FilmLista.getFilm().getNome().equalsIgnoreCase(nome) && 
                    FilmLista.getFilm().getCognome().equalsIgnoreCase(cognome))
	    {
		    FilmLis.add(FilmLista);
	    }
        }
        return FilmLis;
    }
    /**
     * Ricerca nella lista dei clienti quello con i parametri passati
     * @param NomeC1 nome del cliente da ricercare
     * @param CognomeC1 cognome del cliente da ricercare
     * @param CodicefC1 data di nascita del cliente da ricercare
     * @return il cliente ricercato se è presente, altrimenti ritorna "null"
     */
    public Cliente CercaCliente(String NomeC1,String CognomeC1,String CodicefC1)
    {
        Cliente cliente1=null;
        for(Cliente ClienteLista:clienti)
        {
            if(ClienteLista.equals(new Cliente(NomeC1,CognomeC1,CodicefC1)))
	    {
		    cliente1=ClienteLista;
	    }
        }
        return cliente1;
    }
    
    /**
     * Ricerca nella lista dei noleggi quello con i parametri passati
     * @param TL titolo del libro da cui ricercare il noleggio
     * @param NomeC1 nome del cliente da cui ricercare il noleggio
     * @param CognomeC1 cognome del cliente da cui ricercare il noleggio
     * @param CodicefC1 data di nascita del cliente da cui ricercare il noleggio
     * @return il noleggio ricercato se è presente, altrimenti ritorna "null"
     */
    public Prestito RicercaPrestito(String TL,String NomeC1,String CognomeC1,String CodicefC1)
    {
        ArrayList<Prestito> PrestitoLis = CercaPrestitoCliente(NomeC1,CognomeC1,CodicefC1);
        Prestito prestito=null;
        for(Prestito PrestitoLista:PrestitoLis)
        {
            if(PrestitoLista.getFilm().getTitolo().equalsIgnoreCase(TL))
	    {
		    prestito=PrestitoLista;
	    }
        }
        return prestito;
    }
    
    /**
     * Ricerca nella lista dei noleggi quelli del libro il cui titolo è passato per parametro
     * @param titolo titolo del libro da cui ricercare i noleggi
     * @return i noleggi ricercati presenti
     */
    public ArrayList<Prestito> CercaPrestitoFilm(String titolo)
    {
        ArrayList<Prestito> PrestitoLis=new ArrayList<Prestito>();
        for(Prestito PrestitoLista:prestiti)
        {
            if(PrestitoLista.getFilm().getTitolo().equalsIgnoreCase(titolo))
	    {
		    PrestitoLis.add(PrestitoLista);
	    }
        }
        return PrestitoLis;
    }
    
    /**
     * Ricerca nella lista dei noleggi quello con i parametri passati
     * @param NomeC1 nome del cliente da cui ricercare il noleggio
     * @param CognomeC1 cognome del cliente da cui ricercare il noleggio
     * @param CodicefC1 data di nascita del cliente da cui ricercare il noleggio
     * @return i noleggi ricercati
     */
    public ArrayList<Prestito> CercaPrestitoCliente(String NomeC1,String CognomeC1,String CodicefC1)
    {
        ArrayList<Prestito> PrestitoLis=new ArrayList<Prestito>();
        for(Prestito PrestitoLista:prestiti)
        {
            if(PrestitoLista.getCliente().equals(new Cliente(NomeC1,CognomeC1,CodicefC1)))
	    {
		    PrestitoLis.add(PrestitoLista);
	    }
        }
        return PrestitoLis;
    }

}