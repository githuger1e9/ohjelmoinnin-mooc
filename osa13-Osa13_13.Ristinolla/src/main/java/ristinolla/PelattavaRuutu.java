
package ristinolla;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class PelattavaRuutu {
    
    private String tila;
    private Button nappi;
    private Vuoro vuoro;
    private int[] koordinaatit;
    
    public PelattavaRuutu ( Vuoro vuoro, int[] koordinaatit ) {
        this.koordinaatit = koordinaatit;
        this.vuoro = vuoro;
        this.tila = "v";
        this.nappi = new Button();
        this.nappi.setFont(Font.font("Monospaced", 40));
        this.nappi.setText(" ");
        this.nappi.setOnAction((event) -> {
            this.pelaa();
            
        });
        
    }
    
    public int getXkoordinaatti() {
        return this.koordinaatit[0];
        
    }
    
    public int getYkoordinaatti() {
        return this.koordinaatit[1];
        
    }
    
    public void pelaa() {
        ///////////////////////////////////////////////////////////////////
        // Täällä on kutsuttava mm. seuraavia metodeja:
        // this.vuoro.asetaVuoro(String tila)
        // this.vuoro.paivitaTilanne(String tila)
        // this.vuoro.getRuudunTilanne(int x, int y)
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        // Ruudun voi pelata vain jos sen tila on "v".
        ///////////////////////////////////////////////////////////////////
        if ( this.tila.equals("v") && this.vuoro.onkoPeliKaynnissa() ) {
            //////////////////////////////////////////////////////////////
            // Asetetaan napin tekstiksi vuorossa olevan pelaajan tilaa
            // kuvaava symboli.
            //////////////////////////////////////////////////////////////
            this.nappi.setText(this.vuoro.getVuoro());
            //////////////////////////////////////////////////////////////
            // Päivitetään tilanne.
            //////////////////////////////////////////////////////////////
            this.vuoro.paivitaTilanne(this.koordinaatit[0], this.koordinaatit[1], this.vuoro.getVuoro());
            //////////////////////////////////////////////////////////////
            // Jos kolmen suora syntyi, niin peli päättyy ja siitä
            // ilmoitetaan päivitetyssä tekstikomponentissa.
            // Muutoin jatketaan.
            //////////////////////////////////////////////////////////////
            if ( !this.vuoro.onkoKolmenSuoraa(this.vuoro.getVuoro(), this.koordinaatit) ) {
                //////////////////////////////////////////////////////////////
                // Apumuuttuja.
                //////////////////////////////////////////////////////////////
                String uusiVuoro = "";
                if ( this.vuoro.getVuoro().equals("x") ) {
                    uusiVuoro = "o";
                } else if ( this.vuoro.getVuoro().equals("o") ) {
                    uusiVuoro = "x";
                } else {
                    uusiVuoro = "v";
                }
                //////////////////////////////////////////////////////////////
                // Ruudun tilan muutos.
                //////////////////////////////////////////////////////////////
                this.setTila(this.vuoro.getVuoro());
                //////////////////////////////////////////////////////////////
                // Vaihdetaan vuoroa.
                //////////////////////////////////////////////////////////////
                this.vuoro.asetaVuoro(uusiVuoro);
                //////////////////////////////////////////////////////////////
                // Päivitetään vuoron ilmaisevaa tekstikomponenttia.
                //////////////////////////////////////////////////////////////
                this.vuoro.setTekstiKomponenttiin("Vuoro: " + this.vuoro.getVuoro());
                
            }
        }
        
    }
    
    public String getTila() {
        ////////////////////////////////////////////
        // Jos pelattu, palauttaa "x" tai "o". Muutoin palauttaa "v".
        ////////////////////////////////////////////
        return this.tila;
        
    }
    
    ////////////////////////////////////////////
    // Voit asettaa esim. "x", "o" tai "v"
    ////////////////////////////////////////////
    public void setTila ( String tila ) {
        this.tila = tila;
        
    }
    
    public Button getNappi() {
        return this.nappi;
        
    }
    
}
