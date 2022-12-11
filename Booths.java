import java.util.*;
public class Booths {

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
        num=num.substring(num.length()-l,num.length());
        return num;
    }
    public static void main(String[] args)
    {
        sc=new Scanner(System.in);
        int m,q,count;
        String bin_m,bin_q,neg_bin_m;
        m=sc.nextInt();
        q=sc.nextInt();
        bin_m=Integer.toBinaryString(Math.abs(m));
        bin_q=Integer.toBinaryString(Math.abs(q));
        if(Math.abs(m)>Math.abs(q))
        {
            count=bin_m.length()+1;
            bin_m="0"+bin_m;
            while(bin_q.length()<bin_m.length())
                bin_q="0"+bin_q; 
        }
        else
        {
            count=bin_q.length()+1;
            bin_q="0"+bin_q;
            while(bin_m.length()<bin_q.length())
                bin_m="0"+bin_m; 
        }
        if(m<0)
        {
            neg_bin_m=bin_m;
            bin_m=twoComp(bin_m,count);
        }
        else
            neg_bin_m=twoComp(bin_m,count);
        if(q<0)
            bin_q=twoComp(bin_q,count);
        System.out.println("bin_m: "+bin_m+" neg_bin_m: "+neg_bin_m+" bin_q: "+bin_q);
        String a="";
        while(a.length()<count)
            a=a+"0";
        String q1="0";
        int ct=count;
        while(ct>0)
        {
            System.out.println("a: "+a+" q: "+bin_q+" q1: "+q1);
            if(bin_q.substring(count-1, count).equals("0") && q1.equals("1"))
                a=addBinary(a,bin_m);
            else if(bin_q.substring(count-1, count).equals("1") && q1.equals("0"))
                a=addBinary(a,neg_bin_m);
            String temp=a+bin_q+q1;
            temp=a.substring(0, 1)+temp.substring(0,temp.length()-1);
            a=temp.substring(0, count);
            bin_q=temp.substring(count, 2*count);
            q1=temp.substring(temp.length()-1,temp.length());
            ct--;
        }
        int ans=1;
        String sum=a+bin_q;
        if(sum.substring(0,1).equals("1"))
        {
            sum=twoComp(sum, count*2);
            ans*=-1;
        }
        ans*=Integer.parseInt(sum,2);
        System.out.println("ans: "+ans);
    }
}
