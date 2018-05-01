import java.io.*;
import java.net.*;
public class UdpClient
{
public static DatagramSocket ds;
public static int clientport=1789,serverport=1790;
public static byte buffer[]=new byte[1024];
public static byte bufferr[]=new byte[1024];
public static int a=0;
public static void main(String args[]) throws Exception{
ds=new DatagramSocket(clientport);
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
InetAddress ia=InetAddress.getByName("localhost");
System.out.println("Enter a no.");
try
{
String str=new String(b.readLine());
buffer = str.getBytes();
a=str.length();
ds.send(new DatagramPacket(buffer,a,ia,serverport));
a=bufferr.length;
DatagramPacket p=new DatagramPacket(bufferr,a);
ds.receive(p);
String psx=new String(p.getData(),0,p.getLength());
System.out.println(psx);
b.close();
ds.close();
}
catch(Exception e)
{}
}
}
