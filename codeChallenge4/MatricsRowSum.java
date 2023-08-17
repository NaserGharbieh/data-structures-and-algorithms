package codeChallenge4;

public class MatricsRowSum {

    public static int []  matricsRowSum (int[][] array) {
        int []rowSum= new int[array.length];
        if(array.length==0){
        rowSum[0]=0;
        return rowSum;}
        for (int i = 0; i < array.length; i++) { 
                int   sum =0;
            for (int j = 0; j < array[0].length; j++) { 
                
                    sum+=array[i][j];
                 
                }

            rowSum[i]=sum;
        }
         return rowSum;
    }

    public static void main(String[] args) {
        int[][] Array = {{4,8,15,16, 23,42},
        {5,-3,4,  7, 20 ,30}}; 
       
       int[]rowSum = matricsRowSum (Array);
       for (int i = 0; i < rowSum.length; i++) {
        System.out.println("Row sum for row "+i+" is : "+rowSum[i]);
       }
        

       

}


}
