import java.io.*;
import java.util.*;

class Main {

    public static int[] stringToIntArray(String[] args){
        return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = in.readLine()) != null  && str.length()!=0){
            int[] nums = stringToIntArray(str.split(" "));
            List<Integer> differences = new ArrayList<>();
            List<Integer> oneToN = new ArrayList<>(nums[0]);
            for(int j = 1; j < nums[0]; j++){
                oneToN.add(j);
            }

            for(int i=1; i<nums.length-1; i++){
                differences.add(Math.abs(nums[i]-nums[i+1]));
            }
            for(Integer i: oneToN){
                differences.remove(i);
            }
            if(differences.isEmpty())
                System.out.println("Jolly");
            else System.out.println("Not jolly");
        }

    }

}
