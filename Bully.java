import java.util.*;
class Bully{
	public static int N,co;
	public static int pro[]=new int[100];
	public static int status[]=new int[100];
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of processes");
		N=sc.nextInt();
		for(int i=0;i<N;i++){
			System.out.println("Enter the priority of process "+(i+1));
			pro[i]=sc.nextInt();
			System.out.println("Enter the status of process "+(i+1));
			status[i]=sc.nextInt();
		}
		System.out.println("Enter the process which starts election");
		int ele=sc.nextInt();
		elect(ele);
		System.out.println("The coordinator is "+co);
	}
	public static void elect(int ele){
		ele=ele-1;
		co=ele+1;
		for(int i=0;i<N;i++){
			if(pro[i]>pro[ele]){
				System.out.println("Process "+(ele+1)+" sends message to Process "+(i+1));
				if(status[i]==1){
					elect(i+1);
				}
			}
		}
	}

}