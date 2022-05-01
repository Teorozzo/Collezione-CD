package it.unibs.fp.collezioneCd;

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
	private static final int MIN_CHOISE = 5;
    private static final String [] VOCI_MENU ={"Inserisci CD","Inserisci Brano","Stampa lista CD","Stampa le canzoni di un CD"};
    private static final String MENU_TITLE = "Inserisci un azione: ";
	private static final String MSG_IMPUT_CHOISE = "Seleziona un opzione: ";
	private static final String LISTA_CD = "%d) %s - %s";

	
	//VARIABILE
    private static Vector <CD> collection = new Vector <CD>(); 
    private static int choise=0;
    
    
    
    
        
	public static void main(String[] args) {
		
		MyMenu menu = new MyMenu( MENU_TITLE, VOCI_MENU);
		int position=0;
		int chooseedCD=0;
		
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
			    	printCollection();
			    	break;
			    	
			    case 4://stampa la lista dei brani nel CD
			    	chooseedCD = printEChooseCD();
			    	collection.get(chooseedCD).printSongList();
			    	break;
			    default:
			    
			        break;
			}
		
		}while (choise != 0);
		
	}

	/**
	 * Stampa la lista della collezione e fa inserire il numero del CD  
	 * @return CD richiesto
	 */
	private static int printEChooseCD() {
		printCollection();
		int chooseedCD=InputDati.leggiIntero("Inserisci il numero dell'album", 0, collection.size());
		return chooseedCD-1;
	}
	  

	public static void printCollection() {
		if (collection.size() != 0 )
			for(int i=0; i<collection.size();i++)
				System.out.println(String.format(LISTA_CD,i+1,collection.get(i).getAutore(),collection.get(i).getTitoloAlbum()));
	}
	
}
