import de.yadrone.base.*;
import gnu.io.*;
import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Main 
 
{private static InputStream inStream;
public static void main(String[] args)
{

try {
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("/dev/ttyACM0");
            SerialPort serialPort = (SerialPort) portId.open("GPS application", 5000);
            // Change baud rate if not 115200
            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, 
                 SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            inStream = serialPort.getInputStream();
            String reading ="";
int a=0;
            while(a<1000) {
                if(inStream.available() > 0) {
                    int b = inStream.read();
                    System.out.print((char)b);
a=a+1;
                }
            }
        } catch (Exception ex) {
                ex.printStackTrace();
        }
System.out.println(" Enter 1 to go to Myers");
System.out.println(" Enter 2. Towers");
System.out.println(" Enter 3. Kelly");
System.out.println(" Enter 4.Race");
Scanner in = new Scanner(System.in);
System.out.printf(" Enter choice");
int n=in.nextInt();
int speed = 30;
IARDrone drone = null;
    try
    {
       drone = new ARDrone();
    drone.start();
    }
  catch (Exception exc)
	{
		exc.printStackTrace();
	}
switch(n)
{
case 1: drone.getNavDataManager();
		drone.getCommandManager().takeOff().doFor(10000);
        drone.getCommandManager().goRight(speed).doFor(5000);
        drone.getCommandManager().forward(speed).doFor(2000);
        drone.getCommandManager().hover().doFor(1000);
        drone.getCommandManager().landing();
        break;
case 2: drone.getNavDataManager();
		//int speed = 30;
		drone.getCommandManager().takeOff().doFor(10000);
		drone.getCommandManager().forward(speed).doFor(20000);
		drone.getCommandManager().goLeft(speed).doFor(10000);
		drone.getCommandManager().hover().doFor(1000);
        drone.getCommandManager().landing();
        break;
case 3: drone.getNavDataManager();
		//int speed = 30;
		drone.getCommandManager().takeOff().doFor(10000);
        drone.getCommandManager().forward(speed).doFor(10000);
        drone.getCommandManager().forward(speed).doFor(10000);
        drone.getCommandManager().goRight(speed).doFor(2000);
        drone.getCommandManager().hover().doFor(1000);
        drone.getCommandManager().landing();
        break;
case 4: System.out.println(" We are here");
		break;
} 
      
        
}
}

