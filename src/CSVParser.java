import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {

    public static ArrayList<Float> parse(String route, String split) {
        String line = "";
        String[] headers;
        String closeHeader = "<CLOSE>";
        int closeId = -1;
        ArrayList<Float> pointsF = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(route))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] points = line.split(split);
                if(i==0){
                    headers = points;
                    System.out.print("Headers: ");
                    int j = 0;
                    for (String point: points) {
                        System.out.print("["+point+"]");
                        if(point.equals(closeHeader))
                            closeId = j;
                        j++;
                    }
                    i++;
                    continue;
                }
                System.out.print("\nPoint["+(i)+"]");
                int n = 0;
                for (String point: points) {
                    System.out.print("["+point+"]");
                    if(n==closeId){
                        pointsF.add(Float.parseFloat(point));
                    }
                    n++;
                }
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pointsF;

    }

}