package rozdzial6.lambda.referencjeDoMetod;

import java.awt.event.ActionEvent;
import java.time.Instant;

public class Greeter {
    public void greet(ActionEvent event){
        System.out.println("Czesc, teraz jest godzina " + Instant.ofEpochMilli(event.getWhen()));
    }
}
