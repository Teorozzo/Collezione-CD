package it.unibs.fp.collezioneCd;

import java.util.Random;
import java.util.Vector;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

/******************************************************************************

Una persona possiede un certo numero di CD musicali e desidera organizzare il proprio archivio tramite uno strumento software. 
Il programma deve permettere:
- l’inserimento di un nuovo CD nella collezione - la visualizzazione e la rimozione di un CD
- la visualizzazione del contenuto dell’intera collezione
- la selezione di un brano a caso estratto dall’intera collezione.

*******************************************************************************/

public class Main
{
	
	//COSTANTI
    private static final String [] VOCI_MENU ={"Inserisci CD","Inserisci Brano","Visualizza lista CD","Visualizza le canzoni di un CD","Visualizza brano random","Elimina CD","Elimina Brano"};
    private static final String MENU_TITLE = "Inserisci un azione: ";
	private static final String MSG_IMPUT_CHOISE = "Seleziona un opzione: ";
	private static final String INSERT_ALBUM_NUMBER = "Inserisci il numero dell'album: ";
	private static final String INSERT_SONG_NUMBER = "Inserisci il numero del brano: ";
	private static final String HEADER_ROW_CD = "\n%-8s| %-30s | %-30s|%-9s|%s";
	private static final String LISTA_CD = "%-8d| %-30s | %-30s| %-7.2f |%s";
	private static final String LINE ="\n------------------------------------------------------------------------------------";
	private static final String NUMBER = "NUMBER";
	private static final String AUTHOR = "AUTHOR";
	private static final String TITLE = "TITLE";
	private static final Object ALBUM_DURATION = "DURATION";
	private static final String MSG_RANDOM_SONG = "Questo è il brano scelto casualmente:\n------------------------------------------------------\n|%-30s by %-17s |\n------------------------------------------------------\n";

	
	//VARIABILE
    private static Vector <CD> collection = new Vector <CD>(); 
    private static int choise=0;
    private static int randomCD;
    private static int randomSong;
    
    
    
    
        
	public static void main(String[] args) {
		
		MyMenu menu = new MyMenu( MENU_TITLE, VOCI_MENU);
		int position=0;
		int chooseedCD=0;
		
		CreateInitialDatabase();
		
		do {
			
			choise = menu.scegli();
			
			switch(choise){
			    case 1: 
			    	collection.add(CD.newCD());
			        break;   
			    
			    case 2: //aggiunge un brano in un CD
			    	chooseedCD = printEChooseCD();
			    	collection.get(chooseedCD).addSong();
			    	
			        break;
			        
			    case 3://stampa la lista dei CD
			    	printCDs();
			    	break;
			    	
			    case 4://stampa la lista dei brani nel CD e aggiunge un brano nel CD selezionato
			    	chooseedCD = printEChooseCD();
			    	collection.get(chooseedCD).printSongList();
			    	break;
			    
			    case 5://stampa la brano casualmente
			    	randomCD = (int) (Math.random()*(collection.size()));
			    	randomSong = (int) (Math.random()*(collection.get(randomCD).getListaBrani().size()));
			    	
			    	
			    	System.out.println(String.format(MSG_RANDOM_SONG,collection.get(randomCD).getListaBrani().get(randomSong).getTitoloBrano(),collection.get(randomCD).getAutore()));
			    	break;
			    	
			    case 6://stampa la lista dei CD e sceglie quello da eliminare
			    	chooseedCD = printEChooseCD();
			    	collection.remove(chooseedCD);
			    	break;
			    	
			    case 7://stampa la lista dei brani nel CD
			    	chooseedCD = printEChooseCD();
			    	collection.get(chooseedCD).printSongList();
			    	int chooseedSong=(InputDati.leggiIntero(INSERT_SONG_NUMBER, 0, collection.get(chooseedCD).getListaBrani().size()))-1;
			    	collection.get(chooseedCD).getListaBrani().remove(chooseedSong);
			    	break;
			    	
			    default:
			    
			        break;
			}
		
		}while (choise != 0);
		
	}


	/**
	 * Stampa la lista della collezione e fa inserire il numero del CD 
	 * @return CD scelto
	 */
	private static int printEChooseCD() {
		printCDs();
		int chooseedCD=InputDati.leggiIntero(INSERT_ALBUM_NUMBER, 0, collection.size());
		return chooseedCD-1;
	}
	  
	/**
	 * Stampa la collezione di CD
	 */
	public static void printCDs() {
		if (collection.size() != 0 )
			System.out.println(String.format(HEADER_ROW_CD,NUMBER,AUTHOR,TITLE,ALBUM_DURATION,LINE));
			for(int i=0; i<collection.size();i++) {
				System.out.println(String.format(LISTA_CD,i+1,collection.get(i).getAutore(),collection.get(i).getTitoloAlbum(),collection.get(i).getAlbumDuration(),LINE));
			}
			System.out.println();
	}
	/**
	 * Crea un database statico iniziale in modo da poter utilizzare il programma in modo completo fin da subito
	 */
	private static void CreateInitialDatabase() {
		collection.add(new CD("Machine Gun kelly","Mainstream Sellout"));
		collection.add(new CD("Machine Gun kelly","Ticket to my downfall"));
		collection.add(new CD("RuPaul","Supermodel of the world"));
		collection.add(new CD("Lady Gaga","Chromatica"));
		
		collection.get(0).getListaBrani().add(new Brano("Emo Girl",2.5));
		collection.get(1).getListaBrani().add(new Brano("Title Track",2.5));
		collection.get(2).getListaBrani().add(new Brano("Supermodel (You Better Work)",2.5));
		collection.get(2).getListaBrani().add(new Brano("Supernatural",2.5));
		collection.get(3).getListaBrani().add(new Brano("Alice",2.5));
		collection.get(3).getListaBrani().add(new Brano("Stupid Love",1));
		collection.get(3).getListaBrani().add(new Brano("911",2.5));
		collection.get(3).getListaBrani().add(new Brano("Sine From Above",2));
		
		for(int i =0;i<collection.size();i++) {
			for(int j=0; j<collection.get(i).getListaBrani().size();j++) {
				double somma = collection.get(i).getAlbumDuration()+ collection.get(i).getListaBrani().get(j).getDurata();
				 collection.get(i).setAlbumDuration(somma);
			}
		}
		
	}
	
}
