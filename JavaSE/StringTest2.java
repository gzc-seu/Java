package StringDemo;

import javax.print.attribute.standard.MediaSizeName;
import java.util.Arrays;

/**
 * 获取两个字符串中最大相同子串。比如：
 *    str1 = "abcwerthelloyuiodefabcdef";str2 = "cvhellobnm"
 *    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 */
public class StringTest2 {
    //前提：两个字符串中只有一个最大相同子串
    public String getMaxSameString(String str1,String str2){
        if(str1!=null&&str2!=null){
            String maxstr=(str1.length()>=str2.length())?str1:str2;
            String minstr=(str1.length()<str2.length())?str1:str2;
            int length=minstr.length();
            for(int i=0;i<length;i++){
                for(int x=0,y=length-i;y<=length;x++,y++){
                    String str=minstr.substring(x,y);
                    if(maxstr.contains(str)) return str;
                }
            }
        }
        return null;
    }

    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameString1(String str1, String str2){
        if(str1!=null&&str2!=null){
            StringBuffer sBuffer=new StringBuffer();
            String maxstr=(str1.length()>=str2.length())?str1:str2;
            String minstr=(str1.length()<str2.length())?str1:str2;
            int length=minstr.length();
            for(int i=0;i<length;i++){
                for(int x=0,y=length-i;y<=length;x++,y++){
                    String str=minstr.substring(x,y);
                    if(maxstr.contains(str)) {
                        sBuffer.append(str+",");
                    }
                }
                if(sBuffer.length()!=0) break;
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }
        return null;
    }

    public static void main(String[] args) {
        String str1 = "abcwerthello1yuiodefabcdef";
        String str2 = "cvhello1bnmabcdef";
        StringTest2 test=new StringTest2();
        String result=test.getMaxSameString(str1,str2);
        System.out.println(result);
        String[] result1=test.getMaxSameString1(str1,str2);
        System.out.println(Arrays.toString(result1));
    }
}