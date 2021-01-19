package inl_2;

import java.util.Arrays;
import java.util.List;

public class TomteDao {

    private static Node tomten = new Node("Tomten");
    private static Node glader = new Node("Glader");
    private static Node butter = new Node("Butter");
    private static Node tröger = new Node("Tröger");
    private static Node trötter = new Node("Trötter");
    private static Node blyger = new Node("Blyger");
    private static Node rådjuret = new Node("Rådjuret");
    private static Node nyckelpigan = new Node("Nyckelpigan");
    private static Node haren = new Node("Haren");
    private static Node räven = new Node("Räven");
    private static Node myran = new Node("Myran");
    private static Node gråsuggan = new Node("Gråsuggan");
    private static Node bladlusen = new Node("Bladlusen");
    private static Node skumtomten = new Node("Skumtomten");
    private static Node dammråttan = new Node("Dammråttan");

    static {
        tomten.addSubordinates(glader, butter);
        glader.addSubordinates(tröger, trötter, blyger);
        trötter.addSubordinates(skumtomten);
        skumtomten.addSubordinates(dammråttan);
        butter.addSubordinates(rådjuret, nyckelpigan, haren, räven);
        räven.addSubordinates(gråsuggan, myran);
        myran.addSubordinates(bladlusen);
    }

    public static List<Node> getAllNodes() {
        return Arrays.asList(
                tomten,
                glader,
                butter,
                tröger,
                trötter,
                blyger,
                rådjuret,
                nyckelpigan,
                haren,
                räven,
                myran,
                gråsuggan,
                bladlusen,
                skumtomten,
                dammråttan
        );
    }
}
