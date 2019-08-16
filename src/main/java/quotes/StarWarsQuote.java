package quotes;

public class StarWarsQuote {

    private int id;
    private String starWarsQuote;
    private int faction;


//    public String getText() {
//        return this.quote;
//    }
    //    @Override
    public String toString() {
        return String.format("Star Wars quote: %s", this.starWarsQuote);
    }
}
