public class LongestValidParentheses {
    public static void main(String[] agrs){
        System.out.println(longestValidParentheses("(()(("));
    }
    public static int longestValidParentheses(String s) {
        if (s.length()==0){
            return 0;
        }
        int max_number=0;
        int cur_length;
        int end_index=0;
        int start_index=0;
        int left=0;
        int right=0;
        if(s.charAt(0)=='('){
            left++;
        }else {
            right++;
        }
        while (end_index<s.length()||left==right){
            System.out.println(start_index+" "+end_index+" "+left+" "+right);

            //清除多余）

            while(left<right&&start_index<s.length()){
                if(s.charAt(start_index)=='('){
                    left--;
                }else {
                    right--;
                }

                start_index++;
                if(start_index>end_index) end_index++;
            }



            //System.out.println(start_index+" "+end_index+" "+left+" "+right+"yyyy");
            //System.out.println(s.charAt(end_index)+" "+end_index);
            if(start_index==end_index) end_index++;
            if(end_index>=s.length()) break;
            if(s.charAt(end_index)=='('){
                left++;
            }else {
                right++;
            }
            System.out.println(start_index+" "+end_index+" "+left+" "+right+"xxxx");
            if(end_index>=s.length()-1){
                //清除多余（
                while(left>right&&start_index<s.length()){
                    if(s.charAt(start_index)=='('){
                        left--;
                    }else {
                        right--;
                    }

                    start_index++;
                    if(start_index>end_index) end_index++;
                }

            }
            if(end_index>=s.length())break;


            //更新最大数
            if(left==right&&s.charAt(start_index)=='('){

                cur_length=end_index-start_index+1;
                max_number=Math.max(cur_length,max_number);
                //System.out.println("Maxnumber=="+max_number);
            }

            if (end_index<s.length()-1) end_index++;
            if(end_index>=s.length())break;

        }
        return max_number;

    }
}
