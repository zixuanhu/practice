public class longestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        String answer = longestPalindrome(s);
        System.out.println(answer);

    }

    public static String longestPalindrome(String s) {
        String longest = "";
        boolean solo = false;
        int maxIndex = 0;
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (checkPalindrome1(s, i) > maxlength || checkPalindrome2(s, i) > maxlength) {
                maxIndex = i;
                maxlength = Math.max(checkPalindrome1(s, i), checkPalindrome2(s, i));

                if (checkPalindrome1(s, i) == maxlength) {
                    solo = true;
                } else {
                    solo = false;
                }
            }
        }


        if (solo) {
            longest = s.substring(maxIndex - (maxlength+1)/2 + 1, maxIndex + maxlength/2 + 1);
        }else{
            longest = s.substring(maxIndex - maxlength/2 + 1, maxIndex + maxlength/2 + 1);
        }

        return longest;
    }

    public static int checkPalindrome1(String s, int index) {
        int i = 1;
        while (i + index < s.length() && index - i >= 0) {
            if (s.charAt(index + i) != s.charAt(index - i)) {
                break;
            }
            i++;
        }
        return i*2-1;
    }

    public static int checkPalindrome2(String s, int index) {
        if (index + 1 == s.length()) return 0;
        if (s.charAt(index) != s.charAt(index + 1)) return 0;

        int i = 1;
        while (i + index + 1 < s.length() && index - i >= 0) {
            if (s.charAt(index + i + 1) != s.charAt(index - i)) {
                break;
            }
            i++;
        }

        return 2*i;
    }


}
