import java.net.*;
import java.io.*;

/////////////////////////////////////////////////////////////////////////////////
//
//  Class Name   :   Client
//  Description  :   Implements a client-side chat messenger which connects to 
//                   the server using socket programming. The client exchanges 
//                   messages with the server until the user types "end".
//
//  Author       :   Gaurav Subhash Kumbhar
//
/////////////////////////////////////////////////////////////////////////////////

class Client 
{
    //////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name :   ClientSocket
    //  Description   :   Establishes a connection to the server at port 5100, 
    //                    sends user messages to the server, and displays server 
    //                    responses. The chat continues until the client enters "end".
    //
    //  Input         :   Messages typed by client through console
    //  Output        :   Sends messages to server and displays server responses
    //
    //////////////////////////////////////////////////////////////////////////////
    public void ClientSocket() throws Exception
    {
        // Try to establish connection with server at localhost:5100
        System.out.println("Marvellous Client is ready to connect with the server");
        Socket sobj = new Socket("localhost", 5100);
        System.out.println("Marvellous Client is successfully connected with the server.");

        // Output stream to send messages to server
        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        // Input stream to receive messages from server
        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        // Input stream to take client messages from console
        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("---------------------------------------------------------------");
        System.out.println("Marvellous Chat Messenger is ready to use");
        System.out.println("---------------------------------------------------------------");

        String str1 = null, str2 = null;

        // Continuous communication loop until client types "end"
        while(!(str2 = bobj2.readLine()).equals("end"))
        {
            // Send client message to server
            pobj.println(str2);

            // Receive and display server response
            str1 = bobj1.readLine();
            System.out.println("Server Says : " + str1);

            // Prompt client for next message
            System.out.println("Enter the message for Server : ");
        }
    }
}

/////////////////////////////////////////////////////////////////////////////////
//
//  Class Name   :   ChatXClient
//  Description  :   Entry point for the client application. It creates an
//                   instance of Client class and starts the client socket.
//  Author       :   Gaurav Subhash Kumbhar
//
/////////////////////////////////////////////////////////////////////////////////

class ChatXClient
{
    public static void main(String A[]) throws Exception
    {
        Client cobj = new Client();
        cobj.ClientSocket();
    }
}
