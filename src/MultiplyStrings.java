public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "256";
        String num2 = "64";
        System.out.println(multiply(num1,num2));
        //Character.getNumericValue('1') -> 1 -> int
        //Interger.parseInt("11") -> 11
    }
    public static String multiply(String num1, String num2) {

        //需要的变量：
        //arr 1用来装num

        //arr_2
        // carrior 4 * 6 =》 24   carrior = 2
        //String res


        //从后过第一个数的每一个数位

            //从后过第二个数的每一个数位
                //carrior？
                //product
                //上数位

        return "";
    }

    public static String sum_helper (String numOld, String numNew){
        int carrior=0;
        String numB="";
        for(int i = numNew.length()- 1; i>=0; i-- ){
            int sum=Character.valueOf(numOld.charAt(i))+Character.valueOf(numNew.charAt(i))+carrior;
            carrior=sum/10;
            numB=(char)sum%10+numB;



        }

        return numB;
    }

}
