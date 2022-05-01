package it.unibs.fp.collezioneCd;

public class Brani{
	
    private String titoloBrano;
    private double durata; 
    
    public Brani (String titolo, double durata){
        this.titoloBrano = titolo;
        this.durata = durata;

    }

	public String getTitoloBrano() {
		return titoloBrano;
	}

	public void setTitoloBrano(String titoloBrano) {
		this.titoloBrano = titoloBrano;
	}

	public double getDurata() {
		return durata;
	}

	public void setDurata(double durata) {
		this.durata = durata;
	}
    
}