//by mschro67

package p1;

import java.util.Random;

public class p1_main {
    public static int[] randomArray(int x){
        int[] array=new int[x];
        Random r=new Random();

        for (int y=0;y<array.length;y++){
            array[y]=r.nextInt();
        }

        return array;
    }

    public static int[] randomArray2(int x){
        int[] array=new int[x];
        Random r=new Random();

        for (int y=0;y<array.length;y++){
            array[y]=r.nextInt(0,x);
        }

        return array;
    }

    public static int[] randomArray3(){
        int[] array=new int[6];
        Random r=new Random();

        for (int y=0;y<array.length;y++){
            array[y]=r.nextInt(55,76);
        }

        return array;
    }

    public static int[] randomArray4(int n) {
        int[] array = new int[n+1];
        Random r = new Random();

        for (int y = 0; y < n; y++) {
            array[y] = r.nextInt(1,51);
        }

        int sum=0;
        for (int y=0;y<n;y++){
            sum+=Integer.valueOf(array[y]);
        }
        array[n]=sum;

        return array;
    }
}
