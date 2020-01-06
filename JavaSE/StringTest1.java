package StringDemo;
/**
 * 获取一个字符串在另一个字符串中出现的次数。
 *       比如：获取“ab”在 “abkkcadkabkebfkaabkskab” 中出现的次数
 */
public class StringTest1 {
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count=0;
        int index;
        if(mainLength >= subLength){
            while((index=mainStr.indexOf(subStr))!=-1){
                mainStr=mainStr.substring(index+subStr.length());
                count++;
            }
            return count;
        }else return 0;
    }

    public static void main(String[] args) {
        String mainStr = "abkkcadkabkebfkaabkskab";
        String subStr = "ab";
        StringTest1 test=new StringTest1();
        int count=test.getCount(mainStr,subStr);
        System.out.println(count);
    }
}
