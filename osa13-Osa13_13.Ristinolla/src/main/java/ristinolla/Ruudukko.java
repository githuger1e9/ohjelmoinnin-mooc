
package ristinolla;

import java.util.ArrayList;
import java.util.stream.IntStream;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Ruudukko {
    
    private ArrayList<PelattavaRuutu> ruudut;
    private GridPane asettelu;
    private Vuoro vuoro;
    
    public Ruudukko ( int ruudukonLeveys, Vuoro vuoro ) {
        //////////////////////////////////////////////////////////////////////
        // Vuoro on vähän kuin erotuomari, joka kulkee jokaisen ruudun matkassa.
        //////////////////////////////////////////////////////////////////////
        this.vuoro = vuoro;
        //////////////////////////////////////////////////////////////////////
        // Luodaan lista ruutujen lisäämistä varten.
        //////////////////////////////////////////////////////////////////////
        this.ruudut = new ArrayList<>();
        //////////////////////////////////////////////////////////////////////
        // Lisätään listalle riittävä määrä pelattavia ruutuja.
        //////////////////////////////////////////////////////////////////////
        for ( int i = 0; i < ruudukonLeveys; i++ ) {
            for ( int j = 0; j < ruudukonLeveys; j++ ) {
                ruudut.add(new PelattavaRuutu(this.vuoro, new int[] {i, j}));
                
            }
        }
        
        //////////////////////////////////////////////////////////////////////
        // Luodaan asettelu. Haetaan pelattavista ruuduista napit ja
        // lisätään ne asetteluun.
        //////////////////////////////////////////////////////////////////////
        this.asettelu = new GridPane();
        asettelu.setPadding(new Insets(5, 5, 5, 5));
        asettelu.setHgap(10);
        asettelu.setVgap(10);
        asettelu.setAlignment(Pos.CENTER);
        for ( PelattavaRuutu pr: this.ruudut ) {
            asettelu.add(pr.getNappi(), pr.getYkoordinaatti(), pr.getXkoordinaatti());
            
        }
    }
    
    public GridPane getAsettelu() {
        return this.asettelu;
        
    }
    
    
}
