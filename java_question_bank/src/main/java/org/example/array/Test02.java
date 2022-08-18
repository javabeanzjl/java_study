package org.example.array;

public class Test02{
    public static void main(String[] args){
        int[] a={9,8,7,2,1,6,5,4,3};
        doSomething(a,0,a.length-1);
        for(int i=0;i<=a.length-1;i++)
            System.out.print(a[i]+" ");
    }
    private static void doSomething(int[] a,int start,int end){
        if(start<end){
            int p=core(a,start,end);
            doSomething(a,start,p-1);
            doSomething(a,p+1,end);//
        }
    }
    private static int core(int[] a,int start,int end)
    {
        int x=a[end];
        int i=start;
        /*
        * 都跟end位上的数进行比较
        * 若比end位上的数大，则
        * */
        for(int j=start;j<=end-1;j++){  
            // 当这个条件不满足时，此时的i就是比end位数小的数的下标
            // 当不满足后的满足时，就会交换，a[i]这个位置存储的就是比a[end]大的了。
            // 这样一循环结束后，a[end]的数就会是最小的。
            if(a[j]>=x){
                // 第i位和第j位数字换
                swap(a,i,j);
                i++;// 交换次数
            }
        }
        // i就是应该成功存储的位置
        swap(a,i,end);
        return i;
    }

    // 将第i位数字和j位数字调换位置
    private static void swap(int[] a,int i,int j)
    {
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
