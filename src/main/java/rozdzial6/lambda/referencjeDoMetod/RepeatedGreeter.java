package rozdzial6.lambda.referencjeDoMetod;

import javax.swing.*;

public class RepeatedGreeter extends Greeter{
    public void greet(Class<RepeatedGreeter> event){
        var timer = new Timer(1000, super::greet);
        timer.start();
    }



}
