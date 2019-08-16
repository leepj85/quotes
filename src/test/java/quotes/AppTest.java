/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testQuoteHasAnAuthor() throws FileNotFoundException {
        String filePath = "src/main/resources/quotes.json";
        String newQuote = App.getFileQuote(filePath);
        assertTrue(newQuote.contains("Author"));
    }
    @Test
    public void testLengthOfReturnedArray() throws FileNotFoundException {
        String filePath = "src/main/resources/quotes.json";
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filePath));
        Quote[] quotes = gson.fromJson(reader, Quote[].class);
        assertEquals(138,quotes.length);
    }
    @Test
    public void testQuoteHasText() throws FileNotFoundException {
        String filePath = "src/main/resources/quotes.json";
        String newQuote = App.getFileQuote(filePath);
        assertTrue(newQuote.contains("Quote"));
    }
    @Test
    public void testRandomNumberGenerator() throws FileNotFoundException {
        String filePath = "src/main/resources/quotes.json";
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filePath));
        Quote[] quotes = gson.fromJson(reader, Quote[].class);
        int newRandom = (int) (Math.random() * quotes.length);
        int high = quotes.length - 1;
        int low = 0;
        assertTrue("Error, random is too high", high >= newRandom);
        assertTrue("Error, random is too low",  low  <= newRandom);

    }

    @Test
    public void testStarWarsQuote() throws IOException {
        App.getStarWarsQuote("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
        File checkfile = new File("src/main/resources/starwars-quotes.json");
        assertTrue(checkfile.length() != 0 );
    }

}
