package Activities;

public class Activity2 {
    public static void main(String args[]) {

        int x[] = {10, 77, 10, 54, -11, 10};
        int sum = 0;
        int numTofind = 10;

        for (int i=0; i<x.length; i++) {
            if(x[i]==numTofind) {
                sum=sum+x[i];
            }
        }
        if(sum==30)
        {
            System.out.println("Sum is equal to 30");
        }
        else
        {
            System.out.println("Sum is incorrect");
        }
        }
}
