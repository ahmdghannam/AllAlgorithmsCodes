package cse.algorithms;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

    }
    // quick sort
    public static void quickSort(int[] arr){
        quickSort(arr, 0,arr.length-1);
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int addFirst=low;

        for(int i=low;i<high;i++){
            if(arr[i]<pivot){
                swapTwoElements(addFirst++,i,arr);
            }
        }
        swapTwoElements(addFirst,high,arr);
        return addFirst;

    }
    public static void quickSort(int[] arr, int low, int high){

        if(low<high){     //checks if the array is more than one item
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }

    }

    // insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    // selection sort
    public static void selectionSort(int[] arr) {
        int small;
        for (int i = 0; i <arr.length - 1; i++)
        {
            small = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                //if current position is less than previous smallest
                if (arr[j] < arr[small])
                {
                    small = j;

                    //swap values
                    int temp = arr[i];
                    arr[i] = arr[small];
                    arr[small] = temp;
                }
            }
        }
    }

    //merge sort
    public static void mergeSort(int[] a) {
        mergeSort(a,a.length);
    }
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        mergeTwoSortedArrays(a, l, r, mid, n - mid);
    }
    public static void mergeTwoSortedArrays(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    // bubble sort
    public static void bubbleSort(int[]a) {
        for (int i = 0; i < a.length; i++) {
            boolean sorted = true;
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) {
                    int h = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = h;
                    sorted = false;
                }
            }
            if (sorted) return;
        }
    }

    //search

    // sequential search
    public static int sequentialSearch(int []a,int key){
        for (int i = 0; i < a.length; i++) {
            if(a[i]==key)return i;
        }
        return -1;
    }

    // binary search
    public static int binarySearch(int []a,int k){
        return binarySearch(a,k,0,a.length-1);
    }
    public static int binarySearch(int []a,int k,int start,int end){
        int mid=(start+end)/2;
        if(a[mid]==k) return mid;
        return a[mid]>k ? binarySearch(a,k,start,mid-1):binarySearch(a,k,mid+1,end);
    }

    //selection problem
    public static int selectionProblem(int []a,int k){
        int c=0;
        for (int item:a) {
            if(item<k)
                c++;
        }
        return c;
    }

    // greatest common divisor (gcd)
    public static  int euclidGcd(int a, int b){

        return b==0 ? a : euclidGcd(b,a%b);

    }
    public static int bruteForceGcd(int m, int n){
        // checks all numbers from the min to one to find the gcd
        int t=Math.min(m,n);
        while (!((m%t==0)&&(n%t==0))){
            t--;

        }
        return t;
    }

    // fibonacci series
    public static int fibBruteForce(int x){
        return x==0||x==1?x:fibBruteForce(x-1)+fibBruteForce(x-2);
    }
    public static int fibDynamicProgramming(int x){
        ArrayList<Integer> fib=new ArrayList<>();
        fib.add(0);
        fib.add(1);
        for (int i = 2; i <= x; i++) {
            fib.add(i,fib.get(i-1)+fib.get(i-2));
        }
        return fib.get(x);
    }

    // matrix multiplication
    public static int[][] bruteForceMatrixMultiplication(int[][] a, int[][] b){

        int [][]c=new int[a.length][a.length];

        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < a.length; j++) {
                c[i][j]=0;
                for (int k = 0; k < a.length; k++) {
                    c[i][j]+=a[i][k]+b[k][j];
                }
            }
        }
        return c;
    }

    // checking a number if it is a prime or not
    public static boolean bruteForceCheckPrime(int a){
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if(a%i==0)
                return false;
        }
        return true;
    }

    //find all prime numbers smaller than or equal n
    public static ArrayList<Integer> primes_sieveOfEratosthenes(int n){
        // this method returns the prime numbers which they are <= n

        int []A=new int[n];
        int j;
        // filling the array
        for (int p=2;p<=n;p++) {
            A[p-2]=p;
        }
        // eliminates the prime numbers by assign zero in it is position
        for (int p = 2; p <=Math.sqrt(n); p++) {
            if(A[p]!=0){ // if statement so no need to delete multiples of numbers they are a multiples so its multiples have been deleted , ex : number 4
                j=p*p;
                while (j<=n) {  // the first multiple of a number we should consider deleting is number^2 , because smaller numbers have been deleted , and surly the number^2 must be smaller than n
                    A[j-2] = 0; // j-2 not j due to my arrangement of the array
                    j += p;  // to eliminate multiples bigger than number^2
                }
            }
        }
        // fill the needed values (prime numbers) in the array list
        ArrayList<Integer> L=new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if(A[p]!=0){
                L.add(A[p]);
            }
        }

        return L;
    }

    // closet pair
    // check the Point class in same package cse.algorithms
    public static int closetDistance(ArrayList<Point>points){
        int d=  Integer.MAX_VALUE;
        for (int i = 0; i <points.size()-1; i++) {
            for (int j = i+1; j < points.size(); j++) {
                d=Math.min
                        (d,
                                (int)Math.sqrt(
                                        (points.get(i).getX()-points.get(j).getX())*
                                                (points.get(i).getX()-points.get(j).getX())
                                                +(points.get(i).getY()-points.get(j).getY())*
                                                (points.get(i).getY()-points.get(j).getY())));
            }
        }
        return d;
    }

    // max value
    public static int maxElement(int []a){
        // time complexity = n-1
        int max=a[0];
        for (int i = 1; i < a.length; i++) {
            if(a[i]>max) max=a[i];
        }
        return max;
    }
    // max and min values in one loop
    public static int[] minMax(int[] a, int start, int end) {
        int min=a[start];
        int max =a[start];
        for (int i = start; i <= end; i++) {
            if(a[i]>max)max=a[i];
            if(a[i]<min)min=a[i];
        }

        return new int[]{min,max};
    }
    
    //checks if all elements in the array are identical
    public static  boolean uniqueElement(int []a){
        boolean u=false;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]==a[j]) return false;

            }
        }
        return true;
    }

    // factorial
    public  static int bruteForceFactorial(int n){
        return n==0?1: bruteForceFactorial(n-1)*n;
    }

    //string matching
    public static int bruteForceStringMatching(String toCompare,String text){
        // this method returns the index of first character if exists or -1 if not
        for (int i = 0; i <= (text.length()-toCompare.length()); i++) {
            int j=0;
            while (j<toCompare.length()&&text.charAt(i+j)==toCompare.charAt(j)){
                j++;
            }
            if(j == toCompare.length() )return i;
        }
        return -1;
    }
    public static ArrayList<Integer> improvedBruteForceStringMatching(String toCompare, String text){
        // this method returns all the indexes of first character if exists or empty array list
        ArrayList<Integer> arrayList=new ArrayList<>();

        for (int i = 0; i <= (text.length()-toCompare.length()); i++) {
            int j=0;
            while (j<toCompare.length()&&text.charAt(i+j)==toCompare.charAt(j)){
                j++;
            }
            if(j == toCompare.length() )arrayList.add(i);
        }
        return arrayList;
    }

    // example in slides alternating disks
    public static void alternatingDisks (boolean []a){
        for (int i = 0; i < a.length; i++) {
            boolean sorted=true;
            for (int j = 1; j < a.length-i; j++) {

                if(a[j]&&!a[j-1])
                {
                    boolean y=a[j];
                    a[j]=a[j-1];
                    a[j-1]=y;
                    sorted=false;
                }
            }
            if (sorted)return;

        }
    }
    //array for testing
    private static void booleanArray() {
        boolean[]a=new boolean[]{false,true,false,true,false,true,false,true};
        for (boolean b: a) {
            if(b) System.out.print("white\t");
            else System.out.print("black\t");
        }

        System.out.println();
        alternatingDisks(a);
        for (boolean b: a) {
            if(b) System.out.print("white\t");
            else System.out.print("black\t");
        }
    }

    public static void swapTwoElements(int index, int index2, int[] a) {
        int t=a[index2];
        a[index2]=a[index];
        a[index]=t;

    }
}
