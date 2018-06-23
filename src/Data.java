import java.lang.Comparable;

/**
 * La classe Data descrive giorno, mese ed anno di una data
 * controllando che i valori inseriti rispettino le bisestilità e le lunghezze effettive dei mesi.
 *
 * @author Carlone Giuseppe Pio
 * @author Mambella Alessandra
 * @author Sichetti Dylan

 * L'utilizzo dell'interfaccia Comparable permette un confronto in
 * ordine di precedenza tra due istanze di tipo Data
 */
public class Data implements Comparable {

    /**
     * Il giorno della data
     */

    private int giorno;

    /**
     * Il mese della data
     */

    private int mese;

    /**
     * L'anno della data
     */

    private int anno;

    /**
     * La possibile bisestilità di un anno
     */

    private boolean bis;
    private static final int Min = 1;            // private static final associa ad una
    private static final int MaxGiorni = 31;     // variabile una costante
    private static final int MaxMesi = 12;
    private static final int MinAnno = 2000;
    private static final int[] Special = { 4 , 100 , 400 };


    /**
     * Il costruttore di default genera una data nel formato
     * (gg/mm/aaaa) impostando i valori al giorno 01/01/2000
     */

    public Data()
    {
        giorno = Min;
        mese = Min;
        anno = MinAnno;
    }

    /**
     * Attravero questo costruttore, passando i parametri giorno, mese, anno
     * viene inizializzato un oggetto di tipo data specifico, il quale
     * risulterà avere le caratteristiche scelte dall'utente
     * @param g il giorno che verrà impostato
     * @param m il mese che verrà impostato
     * @param a l'anno che verrà impostato
     *
     */

    public Data(int g, int m, int a)
    {
        setAnno(a);
        setMese(m);
        setGiorno(g);
    }
                        /** Metodi Get */
    /**
     * Restituisce il giorno
     * @return Il giorno
     */

    public int getGiorno()
    {
        return giorno;
    }

    /**
     * Restituisce il mese
     * @return il mese
     */

    public int getMese()
    {
        return mese;
    }

    /**
     * Restituisce l'anno
     * @return l'anno
     */

    public int getAnno()
    {
        return anno;
    }

    /**
     * Permette di impostare il valore del giorno di una data
     * @param g il giorno da impostare
     */

    public void setGiorno(int g)
    {
        int GiorniTot = ControlloGiorniMese();
        if( g > GiorniTot)
        {
            g = GiorniTot;
        }

        if(g < Min)
        {
            g = Min;
        }

        giorno = g;
    }

    /**
     * Permette di impostare il valore del mese di una data
     * @param m il mese da impostare
     */

    public void setMese(int m)
    {
        if( m > MaxMesi)
        {
            m = MaxMesi;
        }

        else if(m < Min)
        {
            m = Min;
        }

        mese = m;
    }

    /**
     * Permette di impostare il valore dell'anno di una data e calcola
     * se questo è bisestile o no
     * @param a l'anno da impostaare
     */

    public void setAnno(int a)
    {
        if( a <= 0)
        {
            anno = MinAnno;
            bis = true;
        }

        else
        {
            anno = a;
            if(anno%Special[0]==0 && (a%Special[1]!=0 || a%Special[2]==0))
            {
                bis = true;
            }
            else
            {
                bis = false;
            }
        }
    }


    private int ControlloGiorniMese()
    {
        int GiorniTot = MaxGiorni;

        switch(this.mese)
        {
            case 4 :
            case 6 :
            case 9 :
            case 11: GiorniTot = 30; break;

            case 2 :
                if(bis)
                {
                    GiorniTot = 29;
                }
                else
                {
                    GiorniTot = 28;
                }
                break;
        }

        return GiorniTot;
    }

    /**
     * Inserito un numero intero di giorni calcola la data esatta dopo i giorni immessi
     * @param g numero di giorni da aggiungere alla data attuale
     * @return la data esatta che ci sarà dopo quel quantitativo di giorni
     */

    public Data RicavaGiorno(int g)
    {
        int GiorniTot = ControlloGiorniMese();
        int giorni = giorno;
        int mesi = mese;
        int anni = anno;
        boolean bisestile = bis;
        giorno = giorno+g;
        while(giorno > GiorniTot)
        {
            giorno = giorno-GiorniTot;
            mese++;
            if( mese > MaxMesi)
            {
                mese = mese-MaxMesi;
                anno++;
                if(anno%Special[0]==0 && (anno%Special[1]!=0||anno%Special[2]==0))
                {
                    bis = true;
                }
                else
                {
                    bis = false;
                }
            }
            GiorniTot = ControlloGiorniMese();
        }

        Data data = new Data(giorno,mese,anno);
        giorno = giorni;
        mese = mesi;
        anno = anni;
        bis = bisestile;
        return data;
    }

    /**
     * Converte una composizione di attributi giorno, mese, anno in una
     * stringa contenente tali parametri nel formato gg/mm/aaaa
     * @return la data richiesta nel formato gg/mm/aaaa
     */

    public String toString()
    {
        String s = giorno+"/"+mese+"/"+anno;
        return s;
    }

    /**
     * Applica un confronto tra date e controlla se sono uguali confrontando giorno, mese e anno
     * @param data rappresenta la data da confrontare
     * @return una variabile booleana indicante l'uguaglianza o non tra due date
     */

    public boolean equals(Data data)
    {
        if(data.getGiorno()==giorno && data.getMese()==mese && data.getAnno()==anno)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Implementando questo metodo viene reso possibile il riordinamento
     * a sfondo temporale tra due date
     *
     * @param other rappresenta l'altra data da inserire nel confronto temporale
     * @return un intero a seconda dei casi che simboleggia la posizione di una data rispetto ad un'altra
     */

    public int compareTo(Object other)
    {
        Data data2 = (Data)other;
        if(anno>data2.getAnno() || anno<data2.getAnno())
        {
            if(anno > data2.getAnno())
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        else
        {
            if(mese>data2.getMese() || mese<data2.getMese())
            {
                if(mese > data2.getMese())
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                if(giorno>data2.getGiorno() || giorno<data2.getGiorno())
                {
                    if(giorno>data2.getGiorno())
                    {
                        return 1;
                    }
                    else
                    {
                        return -1;
                    }
                }
                else
                {
                    return 0;
                }
            }
        }
    }
}
