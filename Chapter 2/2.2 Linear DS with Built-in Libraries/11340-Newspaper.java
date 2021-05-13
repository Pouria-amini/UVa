import java.io.*;
import java.util.*;

class Main {

    public static int[] stringToIntArray(String[] args){
        return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int noOfCases = Integer.parseInt(in.readLine());

        while (noOfCases-->0){

            int noOfLetter = Integer.parseInt(in.readLine());
            Map<Character, Double> prices = new HashMap<>();

            for(int i=0; i<noOfLetter; i++){
                String input = in.readLine();
                double charPrice = Double.parseDouble(input.substring(2));
                prices.put(input.charAt(0), charPrice/100);
            }

            int noOfLines = Integer.parseInt(in.readLine());
            double sum = 0;
            for(int i=0; i<noOfLines; i++){
                String line = in.readLine();
                for(int j=0; j<line.length(); j++){
                    sum+= prices.getOrDefault(line.charAt(j), 0.0);
                }
            }
            System.out.printf("%.2f$\n", sum);


        }


    }

}



