package ristinolla;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class RistinollaSovellus extends Application {
    ////////////////////////////////////////////////////
    // Olio Vuoro sisältää muun muassa tekstikomponentin
    // joka ilmaisee vuorossa olevan pelaajan symbolin.
    ////////////////////////////////////////////////////
    private Vuoro vuoro;
    private Ruudukko ruudukko;
    private int ruudukonLeveys;
    
    public RistinollaSovellus() {
        this.ruudukonLeveys = 3;
        this.vuoro = new Vuoro("x", ruudukonLeveys);
        this.ruudukko = new Ruudukko(this.ruudukonLeveys, this.vuoro);
    }
    
    @Override
    public void start ( Stage stage ) throws Exception {
        
        ///////////////////////////////////////////////////////
        // 
        ///////////////////////////////////////////////////////
        
        ///////////////////////////////////////////////////////
        // Pääasettelu, jonka keskellä on pelattava ruudukko ja
        // ylälaidassa vuoroa ilmaiseva tekstikomponentti.
        ///////////////////////////////////////////////////////
        BorderPane pohjakerros = new BorderPane();
        pohjakerros.setCenter(ruudukko.getAsettelu());
        pohjakerros.setTop(this.vuoro.getTekstikomponentti());
        
        Scene nakyma = new Scene(pohjakerros);
        
        stage.setScene(nakyma);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
        
    }
}

        ///////////////////////////////////////////////////////
        // 
        ///////////////////////////////////////////////////////