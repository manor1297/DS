import java.util.*;
class Table
{
	synchronized public void PrintTable(int n)
	{
		int i;
		for(i=1;i<=10;i++)
		{
			System.out.println(n+"*"+i+"="+n*i);
		}
	}
}
class Thread1 extends Thread
{
	Table obj;
	Thread1(Table obj)
	{
		this.obj=obj;
	}
	public void run()
	{
		obj.PrintTable(7);
	}
}
class Thread2 extends Thread
{
	Table obj;
	Thread2(Table obj)
	{
		this.obj=obj;
	}
	
	public void run()
	{
		obj.PrintTable(17);
	}
}
class Thread3 extends Thread
{
	Table obj;
	Thread3(Table obj)
	{
		this.obj=obj;
	}
	public void run()
	{
		obj.PrintTable(13);
	}
}
class Thread4 extends Thread
{
	Table obj;
	Thread4(Table obj)
	{
		this.obj=obj;
	}
	public void run()
	{
		obj.PrintTable(9);
	}
}
class Demo
{
	public static void main(String args[])
	{
	Table obj=new Table();
	Thread1 T1=new Thread1(obj);
	Thread2 T2=new Thread2(obj);
	Thread3 T3=new Thread3(obj);
	Thread4 T4=new Thread4(obj);
	T1.start();
	T2.start();
	T3.start();
	T4.start();
	
	
	}
}
