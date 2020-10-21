
package ristinolla;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class PelattavaRuutuBackup {
    
    private TilaPois tila;
    private Button ruutu;
    private String symboli;
    private Vuoro vuoro;
    private int maksimimaaraVuoroja;
    private int sijainti;
    
    public PelattavaRuutuBackup ( int sijainti, TilaPois tila, Vuoro vuoro, int maksimimaaraVuoroja ) {
        this.sijainti = sijainti;
        this.maksimimaaraVuoroja = maksimimaaraVuoroja;
        this.vuoro = vuoro;
        this.tila = tila;
        this.symboli = " ";
        this.ruutu = new Button();
        this.ruutu.setFont(Font.font("Monospaced", 40));
        this.ruutu.setText(symboli);
        this.ruutu.setOnAction((event) -> {
            this.pelaa();
            
        });
        
    }
    
    public void pelaa() {
        if ( this.tila == TilaPois.vapaa ) {
            ////////////////////////////////////////////
            // Toiminta
            ////////////////////////////////////////////
            this.symboli = this.vuoro.getPelaajanSymboli();
            this.ruutu.setText(symboli);
            if ( this.vuoro.getPelaajanSymboli().equals("x") ) {
                this.vaihdaTilaa(TilaPois.x);
                
            } else {
                this.vaihdaTilaa(TilaPois.o);
                
            }
            
            this.vuoro.pelaa();
            this.vuoro.asetaPelatuksi(this.sijainti);
            
            if ( !(this.vuoro.getPelattujenVuorojenLkm() < this.maksimimaaraVuoroja) ) {
                this.vuoro.setTekstiKomponenttiin("Loppu!");
            }
            
        }
        
    }
    
    public String getSymboli() {
        return this.symboli;
        
    }
    
    public void setSymboli ( String symboli ) {
        if ( (symboli.equals(" ")) || (symboli.equals("x")) || (symboli.equals("o")) ) {
            this.symboli = symboli;
            
        }
        
    }
    
    public Button getRuutu() {
        return this.ruutu;
        
    }
    
    public void vaihdaTilaa(TilaPois tila) {
        this.tila = tila;
        
    }
    
    
    
    
}
