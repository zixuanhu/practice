public class longestPalindrome {
    public static void main(String[] args) {
        String s = "babcbabaad";
        String answer = longestPalindrome(s);
        System.out.println(answer);
        //camelCase 是用于前端
        //snake_case 是用于后端
        //CapitalCase 是用于class define 创建Object class PersonInfo
        //pieChart = pie_chart
    }

    public static String longestPalindrome(String s) {
        String longest = "";
        boolean solo = false;
        int maxIndex = 0;
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            int len_solo=checkPalindrome1(s, i);
            int len_double=checkPalindrome2(s, i);
            if (len_solo > maxlength || len_double > maxlength) {
                maxIndex = i;
                maxlength = Math.max(len_solo,len_double);

                if (len_solo == maxlength) {
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
