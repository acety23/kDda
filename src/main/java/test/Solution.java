package test;// 代码中已指定的类名、方法名、参数名，请勿修改，直接返回方法规定的值即可


class Solution {
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(4));
//        String num1 = "99";
//        String num2 = "1";
//        System.out.println(new Solution().addStrings(num1, num2));
        boolean empty = "".isBlank();
        "".trim();

    }
    public String addStrings(String num1, String num2) {

        // write your code here.
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        int add = 0;
        if(len1 > len2) {
          int i = 0;
          for(i = 0; i < len2; i++) {
            int index1 = len1 - 1 - i;
            int index2 = len2 - 1 - i;
            int n1 = Integer.valueOf(num1Chars[index1] - '0');
            int n2 = Integer.valueOf(num2Chars[index2] - '0');
            int sum = n1 + n2 + add;
            if(sum > 9) {
              add = 1;
            } else {
              add = 0;
            }
            num1Chars[index1] = (char)((sum % 10) + '0');
          }
          if(add != 0) {
            int j = len1 - 1 - i;
            for(j = len1 - 1 - i; j >= 0; j--) {
              int n1 = Integer.valueOf(num1Chars[j] - '0');
              int sum = n1 + add;
              if(sum > 0) {
                add = 1;
              } else {
                add = 0;
              }
              num1Chars[j] = (char)((sum % 10) + '0');
            }
          }
          String res = new String(num1Chars);
          if(add == 0) {
            return res;
          } else {
            return '1' + res;
          }
        }
        return "";
    }
}