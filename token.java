import java.util.*;
class Token{
	public static int N,co=-1;
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
			int list[]=new int[N];
			for(int i=0;i<N;i++)
				list[i]=-1;
			int i=ele-1,j=0;
			while(true){
				if(j==N)
					break;
				if(status[i]==1){
					list[i]=pro[i];
					if(co<pro[i])
						co=i+1;
				}
				for(int k=0;k<N;k++){
					System.out.print(" "+list[k]+" ");
				}
				System.out.println();
				if(i==4)
					i=0;
				else
					i=i%(N-1)+1;
				j++;
			}

		}
}