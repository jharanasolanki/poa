import java.util.*;
public class NonRestoring {
    public static Scanner sc=null;
    public static String addBinary(String num1,String num2)
    {
        int n1=Integer.parseInt(num1,2);
        int n2=Integer.parseInt(num2,2);
        String sum=Integer.toBinaryString(n1+n2);
        if(sum.length()<num1.length())
        {
            while(sum.length()<num1.length())
                sum="0"+sum;
        }
        else if(sum.length()>num1.length())
        {
            sum=sum.substring(sum.length()-num1.length(), sum.length());
        }
        return sum;
    }
    public static String twoComp(String num,int l)
    {
        int n=Integer.parseInt(num,2);
        n=~n;
        n++;
        num=Integer.toBinaryString(n);
        return num.substring(num.length()-l,num.length());
    }
    public static void main(String[] args)
    {
        sc=new Scanner(System.in);
        int m,q;
        String bin_m,bin_q,neg_bin_m;
        int count,ct;
        String a="";
        q=sc.nextInt();
        m=sc.nextInt();
        bin_m=Integer.toBinaryString(m);
        bin_q=Integer.toBinaryString(q);
        while(bin_m.length()>bin_q.length())
            bin_q="0"+bin_q;
        while(bin_m.length()<bin_q.length())
            bin_m="0"+bin_m;
        count=bin_m.length()+1;
        bin_m="0"+bin_m;
        neg_bin_m=twoComp(bin_m, count);
        while (a.length()<count)
            a+="0";
        ct=count;
        System.out.println("bin_q: "+bin_q+" bin_m: "+bin_m+" neg_bin_m: "+neg_bin_m);
        while(ct-->0)
        {
            System.out.println("a: "+a+" q: "+bin_q);
            String temp=a+bin_q;
            temp=temp.substring(1,temp.length());
            a=temp.substring(0, count);
            if(a.substring(0,1).equals("0"))
            {
                
                temp=temp+"0";
                a=addBinary(a, neg_bin_m);
                bin_q=temp.substring(count, count*2-1);
            }
            else if(a.substring(0,1).equals("1"))
            {
                temp=temp+"1";
                a=addBinary(a, bin_m);
                bin_q=temp.substring(count, count*2-1);
            }
        }
    }
}
