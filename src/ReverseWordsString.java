public class ReverseWordsString {
    public static void main(String[] args){
        String s=" ";
        String newS=reverseWords(s);
        System.out.println(newS);

    }
    public static String reverseWords(String s) {
       String[] arr=s.split(" ");
       String.join(" ", arr);

    }
}
