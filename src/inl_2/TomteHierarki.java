package inl_2;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static inl_2.TomteDao.getAllNodes;

public class TomteHierarki {

    public static Map<String, List<Node>> tomteMap = getAllNodes().stream()
            .collect(Collectors.groupingBy(n -> n.getName().toLowerCase()));

    public static List<Node> getHierarchy(String input, String dir) {
        if (dir.equalsIgnoreCase("ö"))
            return tomteMap.get(input).get(0).getSuperiors();
        else return tomteMap.get(input).get(0).getSubordinates();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String dir;
        List<Node> tomtar;

        while (true) {
            System.out.println("Vill du söka efter överordnade eller undersåtar? [ö/u]");
            if ((dir = scan.nextLine()) != null &&
                    (dir.equalsIgnoreCase("u") || dir.trim().equalsIgnoreCase("ö")))
                break;
        }

        System.out.println("Ange vem du vill börja ifrån: [namn]");

        String name = scan.nextLine();
        String outDir = dir.equalsIgnoreCase("u") ? "undersåtar" : "överordnade";

        try {
            tomtar = getHierarchy(name.toLowerCase().trim(), dir);
            if (tomtar.isEmpty())
                throw new NullPointerException();

            System.out.println(tomteMap.get(name.toLowerCase().trim()).get(0).getName() + "s " + outDir + " är:\n");
            tomtar.forEach(tomte -> System.out.println(tomte.getName()));
        } catch (NullPointerException e) {
            System.out.println(name + " har inga " + outDir + " eller jobbar inte i tomteverkstaden.");
        }
    }
}