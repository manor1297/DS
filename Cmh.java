import java.util.*;
class CMH{
	public static int dead;
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int graph[][]=new int[5][5];
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				graph[i][j]=0;
		System.out.println("Enter the no of links");
		int links=sc.nextInt();
		while(links!=0){
			System.out.println("Enter link i j");
			int i=sc.nextInt();
			int j=sc.nextInt();
			graph[i-1][j-1]=1;
			links--;
		}
		System.out.println("Enter the initiator process");
		int init=sc.nextInt();
		init=init-1;
		sendProbe(init,graph);
		if(dead==1){
			System.out.println("Deadlock");
		}
		else
			System.out.println("No Deadlock");
	}
	public static void sendProbe(int init,int graph[][]){
		int flag[]=new int[5];
			for(int i=0;i<5;i++)
				flag[i]=0;	
			for(int i=0;i<5;i++)
				if(graph[init][i]==1)
					flag[i]=1;
			if(flag[0]!=1){
				for(int i=0;i<5;i++){
					if(flag[i]==1){
						System.out.println("Probe from "+(init+1)+"to "+(i+1));
						sendProbe(i,graph);
					}
				}
			}
			else{
				for(int i=0;i<5;i++){
					if(flag[i]==1){
						System.out.println("Probe from "+(init+1)+"to "+(i+1));
					}
				}
				dead=1;
				return;
			}
		}
}