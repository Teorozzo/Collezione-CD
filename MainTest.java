package it.unibs.fp.collezioneCd;

import java.util.Vector;

public class MainTest {

	private static final String LISTA_CD = "\n%d) %s - %s";
	private static Vector <CD> collection = new Vector <CD>();
	
	public static void main(String[] args) {
		
		 
		collection.add(new CD("Machine Gun kelly","Mainstream Sellout"));
		collection.add(new CD("Machine Gun kelly","Ticket to my downfall"));
		collection.add(new CD("RuPaul","Supermodel of the world"));
		
		collection.get(0).getListaBrani().add(new Brano("Emo Girl",2.5));
		collection.get(1).getListaBrani().add(new Brano("Title Track",2.5));
		collection.get(2).getListaBrani().add(new Brano("Supermodel (You Better Work)",2.5));
		collection.get(2).getListaBrani().add(new Brano("Supernatural",2.5));
		
		printCollection();
		
	}

	public static void printCollection() {
		int i,j;
		if (collection.size() != 0 )
			
			for(i=0; i<collection.size();i++) {
				System.out.println(String.format(LISTA_CD,i+1,collection.get(i).getAutore(),collection.get(i).getTitoloAlbum()));
				collection.get(i).printSongList();
				}
			}
	}

