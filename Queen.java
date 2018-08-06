import java.util.*;
class Queen
{
	public void horz(int posx,int posy,int mat[][]){
		int i=posx;
			for(int j=posy;j<4;j++){
				mat[i][j]=1;
			}
			for(int j=posy;j>=0;j--){
				mat[i][j]=1;
			}
	}
	public void vert(int posx,int posy,int mat[][]){
		int j=posy;
			for(int i=posx;i<4;i++){
				mat[i][j]=1;
			}
			for(int i=posx;i>=0;i--){
				mat[i][j]=1;
			}
	}
	public void dia1(int posx,int posy,int mat[][]){
		int i=posx;
			for(int j=posy;j<4;j++){
				mat[i][j]=1;
				i++;
			}
	}
	public void dia2(int posx,int posy,int mat[][]){
		for(int i=posx;i>=0;i--)
			for(int j=posy;j>=0;j--){
				mat[i][j]=1;
			}
	}
	public void dia3(int posx,int posy,int mat[][]){
		for(int i=posx;i>=0;i--)
			for(int j=posy;j<4;j++){
				mat[i][j]=1;
			}
	}
	public void dia4(int posx,int posy,int mat[][]){
		for(int i=posx;i<4;i++)
			for(int j=posy;j>=0;j--){
				mat[i][j]=1;
			}
	}
	public boolean ishorz(int posx,int posy,int mat[][]){
		int i=posx;
			for(int j=posy;j<4;j++){
				if(mat[i][j]==1)
					return false;
			}
			for(int j=posy;j>=0;j--){
				if(mat[i][j]==1)
					return false;
			}
		return true;
	}
	public boolean isVert(int posx,int posy,int mat[][]){
		int j=posy;
			for(int i=posx;i<4;i++){
				if(mat[i][j]==1)
					return false;
			}
			for(int i=posx;i>=0;i--){
				if(mat[i][j]==1)
					return false;
			}
		return true;
	}
	public boolean isDia1(int posx,int posy,int mat[][]){
		for(int i=posx;i<4;i++)
			for(int j=posy;j<4;j++){
				if(mat[i][j]==1)
					return false;
			}
		return true;
	}
	public boolean isDia2(int posx,int posy,int mat[][]){
		for(int i=posx;i>=0;i--)
			for(int j=posy;j>=0;j--){
				if(mat[i][j]==1)
					return false;
			}
		return true;
	}
	public boolean isDia3(int posx,int posy,int mat[][]){
		for(int i=posx;i>=0;i--)
			for(int j=posy;j<4;j++){
				if(mat[i][j]==1)
					return false;
			}
		return true;
	}
	public boolean isDia4(int posx,int posy,int mat[][]){
		for(int i=posx;i<4;i++)
			for(int j=posy;j>=0;j--){
				if(mat[i][j]==1)
					return false;
			}
		return true;
	}
	public boolean isPossible(int posx,int posy,int mat[][]){
			if(ishorz(posx,posy,mat) && isVert(posx,posy,mat) && isDia1(posx,posy,mat) && isDia2(posx,posy,mat) && isDia3(posx,posy,mat) && isDia4(posx,posy,mat))
				return true;
			else
				return false;
	}
	public void display(int mat[][]){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int mat[][]=new int[4][4];
		int n = 0;
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++){
				mat[i][j]=0;
			}
		Queen obj=new Queen();
		obj.display(mat);
		do{
		System.out.println("Enter the position");
		int posx = sc.nextInt();
		int posy = sc.nextInt();
		if((mat[posx][posy]!=1) && obj.isPossible(posx,posy,mat)){
			mat[posx][posy]=1;
			obj.horz(posx,posy,mat);
			obj.vert(posx,posy,mat);
			obj.dia1(posx,posy,mat);
			//obj.dia2(posx,posy,mat);
			//obj.dia3(posx,posy,mat);
			//obj.dia4(posx,posy,mat);
			n++;
			System.out.println("Queen no: "+n+" Inserted");
			obj.display(mat);
		}
		else
		{
			System.out.println("Queen not inserted");
		}
		}
		while(n!=4);
	}
}
