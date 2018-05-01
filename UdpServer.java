import java.io.*;
import java.net.*;
public class UdpServer
{
public static DatagramSocket ds;
public static int clientport=1789,serverport=1790;
public static void main(String args[])throws Exception
{
byte buffer[]=new byte[1024];
int ret=0;
String temp=" ";
ds=new DatagramSocket(serverport);
BufferedReader b= new BufferedReader(new InputStreamReader(System.in));
InetAddress ia= InetAddress.getByName("localhost");
while(true)
{
DatagramPacket p=new DatagramPacket(buffer,buffer.length);
ds.receive(p);
String psx=new String(p.getData(),0,p.getLength());
ret=Integer.parseInt(psx);
int i;
int f=1;
for(i=1;i<=ret;i++)
{
	f=f*i;
}

String pa=Integer.toString(f);

temp=psx.concat("'s factorial is "+ pa);


buffer=temp.getBytes();
ret=temp.length();
ds.send(new DatagramPacket(buffer,ret,ia,clientport));
}
}
}
