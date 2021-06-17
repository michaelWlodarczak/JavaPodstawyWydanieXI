package rozdzial6.lambda.referencjeDoMetod;

//TODO wrocic do tego, bo nie moge zaczac wywolywac metody .greet(); strona 304
public class RGApp {
    public static void main(String[] args) {
        RepeatedGreeter repeatedGreeter = new RepeatedGreeter();
        repeatedGreeter.greet(RepeatedGreeter.class);

    }
}
