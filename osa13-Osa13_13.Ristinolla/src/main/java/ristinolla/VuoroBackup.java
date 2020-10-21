
package ristinolla;

import java.util.HashMap;
import java.util.stream.IntStream;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class VuoroBackup {
    private int pelattujenVuorojenLkm;
    private String vuorossaNyt;
    private Label tekstikomponentti;
    // Jos arvona x tai o; pelattu.
    private String[][] pelatut;
    
    public VuoroBackup() {
        this.pelatut = new String[3][3];
        this.vuorossaNyt = "x";
        this.tekstikomponentti = new Label();
        this.tekstikomponentti.setFont(Font.font("Monospaced", 30));
        this.tekstikomponentti.setText("Vuoro: " + vuorossaNyt);
        this.pelattujenVuorojenLkm = 0;
        
    }
    
    public boolean onkoKolmenSuoraa() {
        boolean flag = false;
        
        if ( vuorossaNyt.equals("x") ) {
            StringBuilder etsittavaSuora = new StringBuilder();
            for ( int i = 0; i < pelatut.length; i++ ) {
                etsittavaSuora.append("o");
            }
            StringBuilder verrattavaSuora = new StringBuilder();
            /////////////////////////////////////////////////////
            // Tarkistetaan vaakarivit
            // Tämä pitää muokata toimimaan kaksiulotteisen taulukon kanssa.
            /////////////////////////////////////////////////////
            for ( int i = 0; i < this.pelatut.length; i++ ) {
                for ( int j = 0; j < this.pelatut.length; j++ ) {
                    verrattavaSuora.append(this.pelatut[i][j]);
                    
                }
                
                if ( verrattavaSuora.toString().equals(etsittavaSuora.toString()) ) {
                    flag = true;
                    break;
                    
                } else {
                    verrattavaSuora.delete(0, this.pelatut.length);
                    
                }
            }
            /////////////////////////////////////////////////////
            // Tarkistetaan pystyrivit
            // Tämä pitää muokata toimimaan kaksiulotteisen taulukon kanssa.
            /////////////////////////////////////////////////////
            for ( int i = 0; i < this.pelatut.length; i++ ) {
                for ( int j = 0; j < this.pelatut.length; j++ ) {
                    verrattavaSuora.append(this.pelatut[i][j]);
                    
                }
                
                if ( verrattavaSuora.toString().equals(etsittavaSuora.toString()) ) {
                    flag = true;
                    break;
                    
                } else {
                    verrattavaSuora.delete(0, this.pelatut.length);
                    
                }
            }
        }
        
        if ( vuorossaNyt.equals("o") ) {
            StringBuilder etsittavaSuora = new StringBuilder();
            for ( int i = 0; i < pelatut.length; i++ ) {
                etsittavaSuora.append("x");
            }
            StringBuilder verrattavaSuora = new StringBuilder();
            /////////////////////////////////////////////////////
            // Tarkistetaan vaakarivit
            // Tämä pitää muokata toimimaan kaksiulotteisen taulukon kanssa.
            /////////////////////////////////////////////////////
            for ( int i = 0; i < this.pelatut.length; i++ ) {
                for ( int j = 0; j < this.pelatut.length; j++ ) {
                    verrattavaSuora.append(this.pelatut[i][j]);
                    
                }
                
                if ( verrattavaSuora.toString().equals(etsittavaSuora.toString()) ) {
                    flag = true;
                    break;
                    
                } else {
                    verrattavaSuora.delete(0, this.pelatut.length);
                    
                }
            }
            /////////////////////////////////////////////////////
            // Tarkistetaan pystyrivit
            // Tämä pitää muokata toimimaan kaksiulotteisen taulukon kanssa.
            /////////////////////////////////////////////////////
            for ( int i = 0; i < this.pelatut.length; i++ ) {
                for ( int j = 0; j < this.pelatut.length; j++ ) {
                    verrattavaSuora.append(this.pelatut[i][j]);
                    
                }
                
                if ( verrattavaSuora.toString().equals(etsittavaSuora.toString()) ) {
                    flag = true;
                    break;
                    
                } else {
                    verrattavaSuora.delete(0, this.pelatut.length);
                    
                }
            }
        }
        
        return flag;
        
    }
    
    /////////////////////////////////////////////////////
    // Tänne pitää saada luokasta PelattavaRuutu
    // metodista pelaa() kyseisen ruudun arvo this.sijainti
    /////////////////////////////////////////////////////
    public void asetaPelatuksi ( int sijainti ) {
        this.pelatut.put(sijainti, 1);
        
    }
    
    public Label getTekstikomponentti() {
        return this.tekstikomponentti;
        
    }
    
    public void setTekstiKomponenttiin ( String teksti ) {
        this.tekstikomponentti.setText(teksti);
        
    }
    
    public String getPelaajanSymboli() {
        return this.vuorossaNyt;
        
    }
    
    public int getPelattujenVuorojenLkm() {
        return this.pelattujenVuorojenLkm;
        
    }
    
    public String pelaa() {
        String nytPelasi = this.vuorossaNyt;
        if ( this.vuorossaNyt.equals("x") ) {
            this.vuorossaNyt = "o";
            
        } else {
            this.vuorossaNyt = "x";
            
        }
        
        this.tekstikomponentti.setText("Vuoro: " + vuorossaNyt);
        
        this.pelattujenVuorojenLkm++;
        
        return nytPelasi;
    }
    
}
