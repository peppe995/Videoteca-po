import java.io.File; // Pacchetto che descrive file e cartelle presenti nel disco e usato per la costruzione di un file di testo
import java.io.FileNotFoundException; // Eccezione riguardante il file nel caso non sia trovato
import java.util.NoSuchElementException; // Eccezione che si verifica quando la fine del file viene raggiunta prima che sia stato aggiunto almeno un carattere alla parola che si sta costruendo
import java.io.IOException; // Eccezione a controllo obbligatorio (errore non gestibile dal programmatore)
import java.io.PrintWriter; // Pacchetto per la scrittura dati su un file
import java.util.Scanner; // Pacchetto per la lettura di file di testo
/**
 * Gestisce la scrittura e la lettura su/da file
 * degli elementi di un oggetto della classe Videoteca
 * 
 * @author Carlone Giuseppe Pio 
 * @author Mambella Alessandra
 * @author Sichetti Dylan
 */

public class FileManager {
    
    /**
     * Oggetto gestito
     */
    
    private Videoteca vid;
    
    /** 
     * 
     * @param videoteca La Videoteca sulla quale l'oggetto opererà
     */    
    public FileManager(Videoteca videoteca)
     {
        vid = videoteca;
     }
    
    /** 
     * 
     * @return La Videoteca gestita dall'oggetto FileManager  
     */    
    public Videoteca getVid()
     {
        return vid;
     }
    
    
    /**
     * Imposta l'oggetto della classe Videoteca da gestire
     * @param videoteca Videoteca da gestire
     */
    public void setVid(Videoteca videoteca)
     {
        vid = videoteca;
     }
    
    /**
     * Scrive sui file passati, sovrascrivendo quelli gia presenti con lo stesso nome 
     * e creandone nel caso di mancanza;
     * @param FilmLis File su cui verranno scritti gli oggetti Film dell'oggetto Videoteca
     * @param PrestitoLis File su cui verranno scritti gli oggetti Prestito dell'oggetto Videoteca
     * @param ClienteLis File su cui verranno scritti gli oggetti Cliente dell'oggetto Videoteca
     * @throws FileNotFoundException Eccezione riguardante il file nel caso non sia trovato
     * @throws IOException Eccezione a controllo obbligatorio (errore non gestibile dal programmatore)
     */
    
    public void Scrittura(File FilmLis,File PrestitoLis,File ClienteLis)throws FileNotFoundException, IOException 
     {
	FilmLis.delete();
	PrestitoLis.delete();
        ClienteLis.delete();
	File newFilmLis = new File(FilmLis.getName());
        File newPrestitoLis = new File(PrestitoLis.getName());  
        File newClienteLis = new File(ClienteLis.getName());
	FilmLis.createNewFile();
	PrestitoLis.createNewFile();
        ClienteLis.createNewFile();
        PrintWriter SalvaFilm = new PrintWriter(newFilmLis); // Uso il Printwriter per scrivere dati (lista film)
        for(Film FilmLista:vid.getFilm())                 // in un file
         {
            SalvaFilm.println(FilmLista.getDisponibilità());   // Nella fase di scrittura della lista che
            SalvaFilm.println(FilmLista.getTitolo());          // caratterizza il film, vengono trasferiti i seguenti
            SalvaFilm.println(FilmLista.getCodice());          // dati: Disponibilità del film, titolo, codice ISAN, Nome, Cognome
            SalvaFilm.println(FilmLista.getRegista().getNome());  // e nazione del regista
            SalvaFilm.println(FilmLista.getRegista().getCognome());
            SalvaFilm.println(FilmLista.getRegista().getNazione());
         }
        SalvaFilm.close();  // Al termine dell'elaborazione del File, chiudiamo l'oggetto Printwriter
	
        PrintWriter SalvaPrest = new PrintWriter(newPrestitoLis);
        for(Prestito PrestitoLista:vid.getPrestiti())  // Eseguiamo la stessa operazione per la lista dei prestiti
         {
            SalvaPrest.println(PrestitoLista.getFilm().getTitolo());
            SalvaPrest.print(PrestitoLista.getData().getGiorno()+" ");
	    SalvaPrest.print(PrestitoLista.getData().getMese()+" ");
            SalvaPrest.println(PrestitoLista.getData().getAnno());
            SalvaPrest.println(PrestitoLista.getCliente().getNome());
            SalvaPrest.println(PrestitoLista.getCliente().getCognome());
            SalvaPrest.println(PrestitoLista.getCliente().getCodiceFisc());
         }
        SalvaPrest.close();  // Chiudo il file dei prestiti
        
        PrintWriter SalvaClienti = new PrintWriter(ClienteLis);
        for(Cliente ClienteLista:vid.getClienti())
         {
            SalvaClienti.println(ClienteLista.getNome());
            SalvaClienti.println(ClienteLista.getCognome());
            SalvaClienti.println(ClienteLista.getCodiceFisc());
            SalvaClienti.println(ClienteLista.getPrestiti());
         }
        SalvaClienti.close(); // Chiudo il file dei clienti
     }
    
    /**
     * Legge dai file passati gli elementi per l'oggetto Videoteca
     * 
     * @param VideoLis  File da cui verranno letti gli oggetti Video dell'oggetto Videoteca
     * @param PrestitoLis  File da cui verranno letti gli oggetti Prestito dell'oggetto Videoteca
     * @param ClienteLis File da cuui verranno letti gli oggetti Clienti dell'oggetto Videoteca
     * @throws FileNotFoundException Eccezione riguardante il file nel caso non sia trovato
     * @throws IOException Eccezione a controllo obbligatorio (errore non gestibile dal programmatore)
     * @throws NoSuchElementException Eccezione che si verifica quando la fine del file viene raggiunta prima che sia stato aggiunto almeno un carattere alla parola che si sta costruendo. 
     */
    
    public void Lettura(File FilmLis,File PrestitoLis,File ClienteLis)throws FileNotFoundException, IOException, NoSuchElementException 
     {
	if(!FilmLis.exists()) // Caso in cui il file non "esiste"
         {
            FilmLis.createNewFile();  // Allora si creano i tre file
            PrestitoLis.createNewFile();
            ClienteLis.createNewFile();
         }
        else
         {
            if(!PrestitoLis.exists())  // Se il file dei film esiste ma non c'è quello dei prestiti
             {
                 PrestitoLis.createNewFile();  // Viene creato soltanto quello dei prestiti
             }
            if(!ClienteLis.exists()) // Se il file dei film esiste ma non c'è quello dei clienti
             {
                ClienteLis.createNewFile();  // Viene creato soltanto quello dei clienti
             }
	 }
        Scanner FilmScanner = new Scanner(FilmLis);  // L'oggetto Scanner permette la lettura del testo contenuto in FilmLis in questo caso
        Scanner PrestitoScanner = new Scanner(PrestitoLis); // Mentre qui la lettura del contenuto in PrestitoLis
        Scanner ClienteScanner = new Scanner(ClienteLis); // Mentre qui la lettura del contenuto in ClientiLis
	
        while(FilmScanner.hasNext())  // Vengono acquisiti dati in ingresso
	 {
	    Regista RF = new Regista();
	    Film film1 = new Film();
	    film1.setDisponibilità(FilmScanner.nextInt());
	    FilmScanner.nextLine();
	    film1.setTitolo(FilmScanner.nextLine());
	    film1.setCodice(FilmScanner.nextLine());
	    RF.setNome(FilmScanner.nextLine());
	    RF.setCognome(FilmScanner.nextLine());
	    RF.setNazione(FilmScanner.nextLine());
	    film1.setRegista(RF);
	    vid.AggiungiFilm(film1);
	 }

	while(PrestitoScanner.hasNext())
	 {
	    int GiornoPrest,MesePrest,AnnoPrest;
	    Film film1 = new Film();
	    Cliente cliente1 = new Cliente();
	    cliente1.Nolegg();
	    String lettura;
	    lettura = PrestitoScanner.nextLine();
	    film1 = vid.CercaFilmTitolo(lettura);
	    GiornoPrest = PrestitoScanner.nextInt();
	    MesePrest = PrestitoScanner.nextInt();
	    AnnoPrest = PrestitoScanner.nextInt();
	    PrestitoScanner.nextLine();
	    cliente1.setNome(PrestitoScanner.nextLine());
	    cliente1.setCognome(PrestitoScanner.nextLine());
	    cliente1.setCodiceFisc(PrestitoScanner.nextLine());
            
            Prestito prestito = new Prestito(film1,cliente1,new Data(GiornoPrest,MesePrest,AnnoPrest));
	    vid.getPrestiti().add(prestito);
            boolean bo = false;
	    for(Cliente ClienteLista:vid.getClienti())
	     {
		if(cliente1.equals(ClienteLista))
		 {
			ClienteLista.Nolegg();
			bo = true;
		 }
	     }
	    if(!bo)
	     {
		    vid.getClienti().add(cliente1);
	     }      
        
         while(ClienteScanner.hasNextInt())
          {
            cliente1 = new Cliente();
            lettura = ClienteScanner.nextLine();
            cliente1.setNome(lettura);
            cliente1.setCognome(lettura);
            cliente1.setCodiceFisc(lettura);
            ClienteScanner.nextInt();
            cliente1.setPrestiti(ClienteScanner.nextInt());
            cliente1.Nolegg();
            cliente1.Restituzione();
          } 
	 }
        FilmScanner.close();
        PrestitoScanner.close();
        ClienteScanner.close();
     }
    

 }