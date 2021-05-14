import java.io.*;
import java.util.*;

class Main {

    public static int[] stringToIntArray(String[] args){
        return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    }

    public static void rotateCW(String[][] m) {
        int n = m.length;
        for (int i = 0; i < n / 2; i++)
            for (int j = 0; j < (n + 1) / 2; j++) {
                String temp = m[i][j];
                m[i][j] = m[n - 1 - j][i];
                m[n - 1 - j][i] = m[n - 1 - i][n - 1 - j];
                m[n - 1 - i][n - 1 - j] = m[j][n - 1 - i];
                m[j][n - 1 - i] = temp;
            }
    }

    public static int checkIfExists(String[][] big, String[][] small){
        int count = 0;
        for(int i=0; i <= big.length - small.length; i++){
            for(int j=0; j <= big.length - small.length; j++){
                boolean found = true;
                outer:
                for(int k=0; k < small.length; k++){
                    for(int l=0; l < small.length; l++){
                        if(!big[i+k][j+l].equals(small[k][l])){
                            found = false;
                            break outer;
                        }
                    }
                }
                if(found) count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String cases;

        while (!(cases = in.readLine()).equals("0 0")){
            String[] str = cases.split(" ");

            int arrLen = Integer.parseInt(str[0]);
            int nLen = Integer.parseInt(str[1]);
            String[][] letters = new String[arrLen][arrLen];

            for(int i=0; i<arrLen; i++){
                String[] line = in.readLine().split("");
                System.arraycopy(line, 0, letters[i], 0, line.length);
            }

            String[][] n = new String[nLen][nLen];

            for(int i=0; i<nLen; i++){
                String[] line = in.readLine().split("");
                System.arraycopy(line, 0, n[i], 0, line.length);
            }


            System.out.print(checkIfExists(letters, n) + " ");
            rotateCW(n);
            System.out.print(checkIfExists(letters, n) + " ");
            rotateCW(n);
            System.out.print(checkIfExists(letters, n) + " ");
            rotateCW(n);
            System.out.println(checkIfExists(letters, n));

        }
        in.close();
        out.close();
    }

}



