package it.unibs.fp.collezioneCd;

import java.util.Random;
import java.util.Vector;

import it.unibs.fp.mylib.InputDati;

public class CD {
    
	
	//COSTANTI
	private static final double MIN_DURATION = 0;
	
	private static final String MSG_AUTHOR = "Inserisci il nome dell'artista: ";
	private static final String MSG_TITLE_ALBUM = "Inserisci il titolo dell'album: ";
	private static final String MSG_TITLE_SONG = "Inserisci il titolo della canzone: ";
	private static final String MSG_DURATION = "Inserisci la durata della canzone: ";
	private static final String RIGHT_ADDED = "\nBrano aggiunto correttamente\n";
	
	private static final String MSG_POSITION = "Inserisci la posizione del brano, \n(0 per l'ultima posizione)" ;
	
	private static final String HEADER_ROW_SONG = "\n%-8s| %-30s|\n-----------------------------------------";
	private static final String SONG_LIST = "   %-5d| %-30s|";
	private static final String NUMBER = "NUMBER";
	private static final String TITLE = "TITLE";
	
	//VARIABILI
	private String autore;
    private String titoloAlbum;
    private Vector <Brano> listaBrani;
    private double albumDuration = 0;
    boolean duplicated = false;
    
    
    /**
     * Costruttore CD
     * @param autore
     * @param titolo
     */
    public CD (String autore, String titolo){
        this.autore = autore;
        this.titoloAlbum = titolo;
        listaBrani = new Vector <Brano>();
        albumDuration = 0;
        
    }

    public String getAutore() {
		return autore;
	}

	public String getTitoloAlbum() {
		return titoloAlbum;
	}

	public Vector<Brano> getListaBrani() {
		return listaBrani;
	}
	
	public double getAlbumDuration() {
		return albumDuration;
	}

	public void setAlbumDuration(double albumDuration) {
		this.albumDuration = albumDuration;
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

	/**
	 * Crea un nuovo brano
	 * @return Brano
	 */
	public static Brano newSong() {
		String title;
		
		title = InputDati.leggiStringa(MSG_TITLE_SONG);
		//AGGIUNGERE CONTROLLO PER STRINGA DUPLICATA
				
	    double duration = InputDati.leggiDoubleConMinimo(MSG_DURATION, MIN_DURATION);
		
	    Brano song = new Brano(title, duration);
	    
	    return song;
	}
	
	/**
	 * Aggiunge una nuova canzone nella lista dei brani ed incrementa la durata del disco.
	 */
	public void addSong() {
		Brano song = newSong();
		listaBrani.add(song);
		albumDuration = getAlbumDuration() + song.getDurata();
		
		System.out.println(RIGHT_ADDED);
		
	}
	
	//NON FUNZIONA, DOVRO' SISTEMARLO
	/**Controlla che il titolo del brano non sia gia stato utilizzato
	 * @param title
	 * @return vero se il titolo è già stato usato, falso altrimenti
	 */
	private boolean isDuplicated(String title) {
		for (int i = 0; i<getListaBrani().size(); i++) {
			if (listaBrani.get(i).getTitoloBrano().equals(title)) {
				return duplicated;
			}
		}
		return false;
	}

	/**
	 * Stampa l'elenco delle canzoni presenti in un CD
	 */
	public void printSongList() {
		int i;
		System.out.println(String.format(HEADER_ROW_SONG,NUMBER,TITLE));
		for (i=0; i<listaBrani.size(); i++) {
			System.out.println(String.format(SONG_LIST,i+1,listaBrani.get(i).getTitoloBrano()));
		}
		System.out.println("\n");
		}
	
}

