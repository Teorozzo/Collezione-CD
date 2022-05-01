package it.unibs.fp.collezioneCd;

import java.util.Vector;

import it.unibs.fp.mylib.InputDati;

public class CD {
    
	//COSTANTI
	private static final String MSG_TITLE_SONG = "Inserisci il titolo della canzone";
	private static final double MIN_DURATION = 0;
	private static final String MSG_AUTHOR = "Inserisci il nome dell'artista: ";
	private static final String MSG_TITLE_ALBUM = "Inserisci il tutolo dell'album: ";
	private static final String MSG_POSITION = "Inserisci la posizione del brano, \n(0 per l'ultima posizione)" ;
	private static final String MSG_DURATION = "Inserisci la durata della canzone:" ;
	private static final String LISTA_BRANI = "  -> %s";
	
	//VARIABILI
	private String autore;
    private String titoloAlbum;
    private static Vector <Brani> listaBrani;
    
    /**
     * Costruttore CD
     * @param autore
     * @param titolo
     */
    public CD (String autore, String titolo){
        this.autore = autore;
        this.titoloAlbum = titolo;
        listaBrani = new Vector <Brani>();
        
    }

    public String getAutore() {
		return autore;
	}

	public String getTitoloAlbum() {
		return titoloAlbum;
	}

	public Vector<Brani> getListaBrani() {
		return listaBrani;
	}
	public static void setListaBrani(Vector<Brani> listaBrani) {
		CD.listaBrani = listaBrani;
	}

	/**
	 * Crea un nuovo oggetto CD
	 * @return  CD
	 */
	public static CD newCD(){
	    
	    String author = InputDati.leggiStringa(MSG_AUTHOR);
	    String title = InputDati.leggiStringa(MSG_TITLE_ALBUM);
	    
	    CD CompactDisc = new CD(author, title);
	    
	    return CompactDisc;
	}

	
	//NON FUNZIONA, DOVRO' SISTEMARLO
/**
 	* Controlla che il titolo del brano non sia gia stato utilizzato
 * @param title
 * @return vero se il titolo è già stato usato, falso altrimenti
 */
	private static boolean isDuplicated(String title) {
		for (int i = 0; i<listaBrani.size(); i++) {
			if (listaBrani.get(i).getTitoloBrano().equals(title)) {
				return true;
			}
		}
				return false;
		}

	/**
	 * Stampa l'elenco delle canzoni presenti nel CD
	 */
	public void printSongList() {
		int i;
		for (i=0; i<listaBrani.size(); i++)
			System.out.println(String.format(LISTA_BRANI,listaBrani.get(i).getTitoloBrano()));
		}
	
	/**
	 * Crea un nuovo brano
	 * @return Brano
	 */
	public static Brani newSong() {
		String title;
		
		//do {
			title = InputDati.leggiStringa(MSG_TITLE_SONG);
			//}while(listaBrani.size()==1 /*|| !isDuplicated(title)*/);  //FUNZIONE DA IMPLEMENTARE CON IL TITOLO NON UTILIZZATO
				
	    double duration = InputDati.leggiDoubleConMinimo(MSG_DURATION, MIN_DURATION);
		
	    Brani song = new Brani(title, duration);
	    
	    return song;
	}
	
	/**
	 * Aggiunge una nuova canzone nella lista dei brani;<br>
	 */
	public void addSong() {
		
		listaBrani.add(newSong());
		
	}
	
}

