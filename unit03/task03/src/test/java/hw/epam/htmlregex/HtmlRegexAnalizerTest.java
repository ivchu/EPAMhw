package hw.epam.htmlregex;

import org.junit.Test;

/**
 * Created by MM8 on 06.03.2017.
 */
public class HtmlRegexAnalizerTest {
    @Test
    public void readTextFromFile() throws Exception {
        HtmlRegexAnalizer testinUnit = new HtmlRegexAnalizer();
        String text = (testinUnit.readTextFromFile("C:\\ivan\\java\\epamhw\\unit03\\task03\\src\\main\\html.html"));
    }

    @Test
    public void arePicturesInOrder() throws Exception {
        HtmlRegexAnalizer testinUnit = new HtmlRegexAnalizer();
        String text = (testinUnit.readTextFromFile("C:\\ivan\\java\\epamhw\\unit03\\task03\\src\\main\\html.html"));
        System.out.println(testinUnit.arePicturesInOrder(text));
    }

    @Test
    public void findLinesWithPic() throws Exception {
        HtmlRegexAnalizer testinUnit = new HtmlRegexAnalizer();
        String text = (testinUnit.readTextFromFile("C:\\ivan\\java\\epamhw\\unit03\\task03\\src\\main\\html.html"));
        System.out.println(testinUnit.findSentencesWithPic(text));
    }

}