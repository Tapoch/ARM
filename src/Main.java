import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private String csvFile;
    public static void main(String[] args){
        ArrayList<Float> points = new ArrayList<>();
        boolean stopped = false;
        System.out.println("Hello");
        String cvsSplitBy = ",";
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
        //points = CSVParser.parse(csvFile, cvsSplitBy);
        Scanner scanner = new Scanner(System.in);
        while (!stopped){
            System.out.println("\nEnter point index: ");
            String read = scanner.nextLine();
            if(read.equals("exit")){
                stopped=true;
                continue;
            }
            System.out.println(points.get(Integer.parseInt(read)-1));
        }
    }
    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }
}
