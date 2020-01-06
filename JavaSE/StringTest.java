package StringDemo;
//将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
public class StringTest {

    //方式一：转换为char[]
    public String reverse(String str,int startIndex,int endIndex){
        if(str!=null){
            char[] arr=str.toCharArray();
            for(int x=startIndex,y=endIndex;x<=y;x++,y--){
                char temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
            }
            String result=new String(arr);
            return result;
        }
        return null;
    }

    //方式二：使用StringBuffer/StringBuilder替换String
    public String reverse1(String str,int startIndex,int endIndex){
        if(str!=null) {
            StringBuffer buffer = new StringBuffer(str.length());
            buffer.append(str.substring(0,startIndex));
            for(int x=endIndex;x>=startIndex;x--){
                buffer.append(str.charAt(x));
            }
            buffer.append(str.substring(endIndex+1));
            return buffer.toString();
        }
        return null;
    }

    //方式三：使用String的拼接
    public String reverse2(String str,int startIndex,int endIndex){
        if(str != null){
            String reverse=str.substring(0,startIndex);
            for(int x=endIndex;x>=startIndex;x--){
                reverse+=str.charAt(x);
            }
            reverse+=str.substring(endIndex+1);
            return reverse;
        }
        return null;
    }

    public static void main(String[] args) {
        StringTest test=new StringTest();
        String str = "abcdefg";
        String result=test.reverse(str,2,5);
        System.out.println(result);
        String result1=test.reverse1(str,2,5);
        System.out.println(result1);
        String result2=test.reverse2(str,2,5);
        System.out.println(result2);
    }

}
