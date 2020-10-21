
package ristinolla;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class RuudukkoBackup {
    
    private ArrayList<PelattavaRuutu> ruudukko;
    private Vuoro vuoro;
    
    public RuudukkoBackup ( int ruutujenMaara, Vuoro vuoro ) {
        this.ruudukko = new ArrayList<>();
        this.vuoro = vuoro;
        IntStream
                .range(0, ruutujenMaara)
                .forEach(i -> this.ruudukko.add(i, new PelattavaRuutu(i, TilaPois.vapaa, this.vuoro, ruutujenMaara)));
        
        
    }
    
    public ArrayList<PelattavaRuutu> getRuudut() {
        return this.ruudukko;
        
    }
    
    public boolean onkoKaikkiRuudutPelattu() {
        return ruudukko.stream().noneMatch((pr) -> ( pr.getSymboli().equals(" ") ));
        
    }
    
    
    
}
