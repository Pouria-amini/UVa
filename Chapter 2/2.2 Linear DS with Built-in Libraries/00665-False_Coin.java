import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static int[] stringToIntArray(String[] args){
        return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());

        while (cases-- > 0) {
            in.readLine();
            int[] tests = stringToIntArray(in.readLine().split(" "));
            boolean[] coins = new boolean[tests[0]+1];


            for(int i=0; i < tests[1] ; i++){

                int[] conditions = stringToIntArray(in.readLine().split(" "));
                List<Integer> list = Arrays.stream(Arrays.copyOfRange(conditions, 1, conditions.length)).boxed().collect(Collectors.toList());

                String sign = in.readLine();

                List<Integer> numbers = new ArrayList<>();
                for(int j=1; j<=tests[0]; j++)
                    numbers.add(j);

                if(sign.equals(">") || sign.equals("<")){
                    numbers.removeAll(list);
                    for(int k: numbers){
                        coins[k] = true;
                    }
                }
                else {
                    numbers.retainAll(list);
                    for(int k:numbers){
                        coins[k] = true;
                    }

                }
            }
            int count = 0;
            int result = 0;
            for(int i=1; i < coins.length; i++){
                if(!coins[i]) {
                    count++;
                    result = i;
                }
            }
            if(count > 1) System.out.println(0);
            else System.out.println(result);
            if(cases >= 1) System.out.println();
        }
    }

}
