import java.util.ArrayList;

/**
 * Rappresenta una videoteca astratta con un elenco di clienti, film e noleggi. 
 *
 * @author Carlone Giuseppe Pio 
 * @author Mambella Alessandra
 * @author Sichetti Dylan
 */
public class Videoteca {

    /**
     * Lista dei film
     */

    private ArrayList<Film> film = new ArrayList<Film>();

    /**
     * Lista dei clienti
     */

    private ArrayList<Cliente> clienti = new ArrayList<Cliente>();

    /**
     * Lista dei noleggi
     */

    private ArrayList<Prestito> prestiti = new ArrayList<Prestito>();
    private static final int MaxPrestiti = 5;
    private static final int LimiteMin = 0;



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
     * @return La lista dei noleggi contenuti
     */
    public ArrayList<Prestito> getPrestiti()
    {
        return prestiti;
    }

    /**
     *
     * @return La lista dei film contenuti
     */
    public ArrayList<Film> getFilm()
    {
        return film;
    }

                        /** Metodi Add per gli ArrayList */

    /**
     * Aggiunge il film (Film) all'elenco; nel caso sia già presente, aumenta la
     * disponibilità sommando l'attributo di disponibilità del film passato a quello gia presente
     * @param film1 Film da aggiungere
     */
    public void AggiungiFilm(Film film1)
    {
        boolean uguale = false;
        if(CercaFilmTitolo(film1.getTitolo())!=null)
        {
            if(CercaFilmTitolo(film1.getTitolo()).getTitolo().equalsIgnoreCase(film1.getTitolo()))
            {
                CercaFilmTitolo(film1.getTitolo()).setDisponibilita(film1.getDisponibilita()+
                        CercaFilmTitolo(film1.getTitolo()).getDisponibilita());
                uguale = true;
            }
        }

        if(!uguale)
        {
            film.add(film1);
        }
    }
    /**
     * Aggiunge un cliente alla lista; Se questo è già presente, il metodo non lo aggiunge.
     * @param cliente1 Cliente da aggiungere
     */

    public void AggiungiCliente(Cliente cliente1)
    {
        boolean uguale = false;
        for(Cliente ClienteLista:clienti)
        {
            if(cliente1.equals(ClienteLista))
            {
                uguale = true;
            }
        }
        if (!uguale)
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
     * 2) Un controllo sulla disponibilità del film (Film), se la disponibilità è minore o uguale a 0
     *    non verrà aggiunto il noleggio.
     * Inoltre diminuisce di 1 la disponibilità del film e aumenta i noleggi all'attivo del cliente di 1
     * @param prestito noleggio da analizzare e, eventualmente, aggiungere
     * @return un booleano che rappresenta se è stato possibile noleggiare un film
     */
    public boolean Noleggio(Prestito prestito)
    {
        boolean b = false;
        Film film1 = new Film();
        Cliente cliente1 = new Cliente();
        for(Film FilmLista:film)
        {
            if(prestito.getFilm().equals(FilmLista))
            {
                b = true;
            }
        }

        if (b)
        {
            film1 = this.CercaFilmTitolo(prestito.getFilm().getTitolo());
            b = false;
            AggiungiCliente(prestito.getCliente());
            cliente1 = this.CercaCliente(prestito.getCliente().getNome(), prestito.getCliente().getCognome(),prestito.getCliente().getCodiceFisc());
            if(cliente1.getPrestiti()<MaxPrestiti && film1.getDisponibilita()>LimiteMin)
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
     * Rimuove un noleggio dalla videoteca,
     * inoltre incrementa di 1 la disponibilità del film (Film) del noleggio
     * passato e decrementa di 1 i noleggi all'attivo del cliente (Cliente) del noleggio;
     * @param prestito noleggio da rimuovere
     */
    public void Restituzione(Prestito prestito)
    {
        Cliente cliente1 = new Cliente();
        cliente1 = this.CercaCliente(prestito.getCliente().getNome(), prestito.getCliente().getCognome(),prestito.getCliente().getCodiceFisc());
        this.prestiti.remove(prestito);
        cliente1.Restituzione();
        CercaFilmTitolo(prestito.getFilm().getTitolo()).Restituzione();
    }

    /**
     * Viene ricercato nella lista dei film quello con il titolo ricercato
     * @param tf Titolo del film da ricercare
     * @return il film ricercato se già presente, altrimenti ritorna "null".
     */
    public Film CercaFilmTitolo(String tf)
    {
        Film film1 = null;
        for(Film FilmLista:film)
        {
            if(FilmLista.getTitolo().equalsIgnoreCase(tf))
            {
                film1 = FilmLista;
            }
        }
        return film1;
    }


    /**
     * Ricerca nella lista dei film con il regista passato
     * @param nome il nome del regista da cui ricercare i film
     * @param cognome il cognome del regista da cui ricercare i film
     * @return una lista dei film con il regista inserito
     */
    public ArrayList<Film> CercaFilmRegista(String nome,String cognome)
    {
        ArrayList<Film> FilmLis = new ArrayList<Film>();
        for(Film FilmLista:film)
        {
            if(FilmLista.getRegista().getNome().equalsIgnoreCase(nome) &&
                    FilmLista.getRegista().getCognome().equalsIgnoreCase(cognome))
            {
                FilmLis.add(FilmLista);
            }
        }
        return FilmLis;
    }
    /**
     * Ricerca nella lista dei clienti con tali parametri passati:
     * @param NomeC1 nome del cliente da ricercare
     * @param CognomeC1 cognome del cliente da ricercare
     * @param CodicefC1 data di nascita del cliente da ricercare
     * @return il cliente ricercato se è presente, altrimenti ritorna "null"
     */
    public Cliente CercaCliente(String NomeC1,String CognomeC1,String CodicefC1)
    {
        Cliente cliente1 = null;
        for(Cliente ClienteLista:clienti)
        {
            if(ClienteLista.equals(new Cliente(NomeC1,CognomeC1,CodicefC1)))
            {
                cliente1 = ClienteLista;
            }
        }
        return cliente1;
    }

    /**
     * Ricerca nella lista dei noleggi con i parametri passati:
     * @param tf titolo del film da cui ricercare il noleggio
     * @param NomeC1 nome del cliente da cui ricercare il noleggio
     * @param CognomeC1 cognome del cliente da cui ricercare il noleggio
     * @param CodicefC1 codice fiscale del cliente da cui ricercare il noleggio
     * @return il noleggio ricercato se è presente, altrimenti ritorna "null"
     */
    public Prestito RicercaPrestito(String tf,String NomeC1,String CognomeC1,String CodicefC1)
    {
        ArrayList<Prestito> PrestitoLis = CercaPrestitoCliente(NomeC1,CognomeC1,CodicefC1);
        Prestito prestito = null;
        for(Prestito PrestitoLista:PrestitoLis)
        {
            if(PrestitoLista.getFilm().getTitolo().equalsIgnoreCase(tf))
            {
                prestito = PrestitoLista;
            }
        }
        return prestito;
    }

    /**
     * Ricerca nella lista dei noleggi i film il cui titolo è passato per parametro
     * @param titolo titolo del film da cui ricercare i noleggi
     * @return i noleggi ricercati presenti
     */
    public ArrayList<Prestito> CercaPrestitoFilm(String titolo)
    {
        ArrayList<Prestito> PrestitoLis = new ArrayList<Prestito>();
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
        ArrayList<Prestito> PrestitoLis = new ArrayList<Prestito>();
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