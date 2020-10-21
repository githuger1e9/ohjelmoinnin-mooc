
package ristinolla;

import java.util.HashMap;
import java.util.stream.IntStream;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Vuoro {
    
    private String nykyinenVuoro;
    private Label tekstikomponentti;
    private String[][] tilanne;
    private int ruudukonLeveys;
    private boolean peliKaynnissa;
    
    public Vuoro ( String ensinVuorossa, int ruudukonLeveys ) {
        this.peliKaynnissa = true;
        this.ruudukonLeveys = ruudukonLeveys;
        this.nykyinenVuoro = ensinVuorossa;
        this.tekstikomponentti = new Label("Vuoro: " + ensinVuorossa);
        this.tekstikomponentti.setFont(new Font("Arial", 30));
        ///////////////////////////////////////////////////////////////////
        // Luodaan tilanteen muistava taulukko ja merkitään kaikki ruudut
        // vapaiksi.
        ///////////////////////////////////////////////////////////////////
        this.tilanne = new String[3][3];
        for ( int i = 0; i < ruudukonLeveys; i++ ) {
            for ( int j = 0; j < ruudukonLeveys; j++ ) {
                tilanne[i][j] = "v";
                
            }
        }
        
    }
    
    public void asetaVuoro ( String tila ) {
        this.nykyinenVuoro = tila;
    }
    
    public String getVuoro() {
        return this.nykyinenVuoro;
        
    }
    
    
    public boolean onkoKolmenSuoraa ( String tila, int[] pelatunKoordinaatit ) {
        /////////////////////////////////////////////////////////////////////
        // Jos suoraa ei löydy tämän arvo pysyy false'na.
        /////////////////////////////////////////////////////////////////////
        boolean flag = false;
        
        StringBuilder voittoRivi = new StringBuilder();
        for ( int i = 0; i < ruudukonLeveys; i++ ) {
            voittoRivi.append(tila);
            
        }
        /////////////////////////////////////////////////////////////////////
        // Käydään läpi pelatun koordinaatin pohjalta tarpeelliset rivit,
        // sarakkeet ja halkaisijat.
        /////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////
        // Alustetaan verrattaRivi
        /////////////////////////////////////////////////////////////////////
        StringBuilder verrattavaRivi = new StringBuilder();
        verrattavaRivi.append(tila);
        /////////////////////////////////////////////////////////////////////
        // Kerätään merkit vaakariviltä tilasta vasemmalle ja oikealle, sekä
        // verrataan.
        /////////////////////////////////////////////////////////////////////
        
        if ( pelatunKoordinaatit[1]-1 >= 0 ) {
            for ( int j = pelatunKoordinaatit[1]-1; j >= 0; j-- ) {
                verrattavaRivi.insert(0, tilanne[pelatunKoordinaatit[0]][j]);
            }
        }
        if ( pelatunKoordinaatit[1]+1 < ruudukonLeveys ) {
            for ( int j = pelatunKoordinaatit[1]+1; j < ruudukonLeveys; j++ ) {
                verrattavaRivi.insert(verrattavaRivi.toString().length(), tilanne[pelatunKoordinaatit[0]][j]);
            }
        }
        
        if ( verrattavaRivi.toString().equals(voittoRivi.toString()) ) {
            flag = true;
            this.lopetaPeli();
            this.tekstikomponentti.setText("Peli loppui! " + this.nykyinenVuoro + " voitti.");
            
        } else {
            /////////////////////////////////////////////////////////////////////
            // Alustetaan verrattaRivi
            /////////////////////////////////////////////////////////////////////
            verrattavaRivi.delete(0, ruudukonLeveys);
            verrattavaRivi.append(tila);
            /////////////////////////////////////////////////////////////////////
            // Kerätään merkit pystysarakkeelta tilasta ylös ja alas, sekä
            // verrataan.
            /////////////////////////////////////////////////////////////////////
            if ( pelatunKoordinaatit[0]-1 >= 0 ) {
                for ( int j = pelatunKoordinaatit[0]-1; j >= 0; j-- ) {
                    verrattavaRivi.insert(0, tilanne[j][pelatunKoordinaatit[1]]);
                }
            }
            if ( pelatunKoordinaatit[0]+1 < ruudukonLeveys ) {
                for ( int j = pelatunKoordinaatit[0]+1; j < ruudukonLeveys; j++ ) {
                    verrattavaRivi.insert(verrattavaRivi.toString().length(), tilanne[j][pelatunKoordinaatit[1]]);
                }
            }
            
            if ( verrattavaRivi.toString().equals(voittoRivi.toString()) ) {
                flag = true;
                this.lopetaPeli();
                this.tekstikomponentti.setText("Peli loppui! " + this.nykyinenVuoro + " voitti.");

            } else {
                
                /////////////////////////////////////////////////////////////////////
                // Alustetaan verrattavaRivi
                /////////////////////////////////////////////////////////////////////
                verrattavaRivi.delete(0, ruudukonLeveys);
                verrattavaRivi.append(tila);
                /////////////////////////////////////////////////////////////////////
                // Jos pelatun koordinaatit ovat niin että x = y, koordinaatti
                // sijaitsee toisella ruudukon halkaisevalla suoralla.
                /////////////////////////////////////////////////////////////////////
                
                if ( pelatunKoordinaatit[0] == pelatunKoordinaatit[1] ) {
                    //////////////////////////////////////////////////
                    // Tarkistetaan halkaisija vasemmalta ylhäältä oikealle alas.
                    //////////////////////////////////////////////////
                    int x = pelatunKoordinaatit[0]-1;
                    int y = pelatunKoordinaatit[1]-1;
                    
                    while ( x >= 0 && y >= 0 ) {
                        verrattavaRivi.insert(0, tilanne[x][y]);
                        x--;
                        y--;
                    }
                    
                    x = pelatunKoordinaatit[0]+1;
                    y = pelatunKoordinaatit[1]+1;
                    while ( x < ruudukonLeveys && y < ruudukonLeveys ) {
                        verrattavaRivi
                                .insert(verrattavaRivi.toString().length(), tilanne[x][y]);
                        x++;
                        y++;
                    }
                    
                    if ( verrattavaRivi.toString().equals(voittoRivi.toString()) ) {
                        flag = true;
                        this.lopetaPeli();
                        this.tekstikomponentti.setText("Peli loppui! " + this.nykyinenVuoro + " voitti.");

                    }
                
                
                } else if ( pelatunKoordinaatit[0] == (ruudukonLeveys-1)-pelatunKoordinaatit[1] )  {
                    ///////////////////////////////////////////////////////////
                    // Lopuksi vielä jäljelle jäävän halkaisijan tarkistus.
                    ///////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////
                    // Alustetaan verrattavaRivi
                    /////////////////////////////////////////////////////////////////////
                    System.out.println("PelatunKoordinaatit: "
                        + pelatunKoordinaatit[0] + ", " + pelatunKoordinaatit[1]);
                    
                    verrattavaRivi.delete(0, ruudukonLeveys);
                    verrattavaRivi.append(tila);
                    
                    int x = pelatunKoordinaatit[0]-1;
                    int y = pelatunKoordinaatit[1]+1;
                    
                    while ( x >= 0 && y < ruudukonLeveys ) {
                        verrattavaRivi.insert(0, tilanne[x][y]);
                        x--;
                        y++;
                    }
                    
                    x = pelatunKoordinaatit[0]+1;
                    y = pelatunKoordinaatit[1]-1;
                    
                    while ( x < ruudukonLeveys && y >= 0 ) {
                        verrattavaRivi.insert(verrattavaRivi.toString().length(), tilanne[x][y]);
                        x++;
                        y--;
                    }
                    
                    System.out.println("Verrattava: " + verrattavaRivi.toString());
                    System.out.println("Voittorivi: " + voittoRivi.toString());

                    if ( verrattavaRivi.toString().equals(voittoRivi.toString()) ) {
                        flag = true;
                        this.lopetaPeli();
                        this.tekstikomponentti.setText("Peli loppui! " + this.nykyinenVuoro + " voitti.");

                    }
                    
                    
                }
                
            }
        }
        
        
        return flag;
        
    }
    
    /////////////////////////////////////////////////////
    // Tilan arvona voi olla "x", "o" tai "v".
    /////////////////////////////////////////////////////
    public void paivitaTilanne ( int x, int y, String tila ) {
        this.tilanne[x][y] = tila;
        
    }
    
    public String getRuudunTilanne ( int[] k ) {
        return this.tilanne[k[0]][k[1]];
        
    }
    
    public Label getTekstikomponentti() {
        return this.tekstikomponentti;
        
    }
    
    public void setTekstiKomponenttiin ( String teksti ) {
        this.tekstikomponentti.setText(teksti);
        
    }
    
    public void lopetaPeli() {
        this.peliKaynnissa = false;
        
    }
    
    public boolean onkoPeliKaynnissa() {
        return this.peliKaynnissa;
        
    }
    
//    public String pelaa() {
//        String nytPelasi = this.vuorossaNyt;
//        if ( this.vuorossaNyt.equals("x") ) {
//            this.vuorossaNyt = "o";
//            
//        } else {
//            this.vuorossaNyt = "x";
//            
//        }
//        
//        this.tekstikomponentti.setText("Vuoro: " + vuorossaNyt);
//        
//        this.pelattujenVuorojenLkm++;
//        
//        return nytPelasi;
//    }
    
}
