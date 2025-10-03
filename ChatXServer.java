import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/////////////////////////////////////////////////////////////////////////////////
//
//  Class Name   :   Server
//  Description  :   Implements a server-side chat messenger which communicates
//                   with a client using socket programming. The server logs all
//                   chat messages into a timestamped text file for record keeping.
//
//  Author       :   Gaurav Subhash Kumbhar
//
/////////////////////////////////////////////////////////////////////////////////

class Server
{
    //////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name :   ServerSocket
    //  Description   :   Creates a server socket at port 5100, accepts client
    //                    connections, and facilitates two-way communication. 
    //                    Messages exchanged between server and client are also
    //                    stored in a log file with a timestamped filename.
    //
    //  Input         :   None (reads messages from client and console input)
    //  Output        :   Sends responses to client and writes to log file
    //
    //////////////////////////////////////////////////////////////////////////////
    public void ServerSocket() throws Exception
    {
        // Create a unique log file with current timestamp
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = "chat_" + timeStamp + ".txt";
        FileWriter fwobj = new FileWriter(fileName);

        // Create a server socket listening on port 5100
        ServerSocket ssobj = new ServerSocket(5100);
        System.out.println("Marvellous Server is Waiting at port number 5100");

        // Accept client connection request
        Socket sobj = ssobj.accept();
        System.out.println("Marvellous Server is Connected Successfully");

        // Output stream to send messages to client
        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        // Input stream to receive messages from client
        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        // Input stream to take messages from server console
        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("---------------------------------------------------------------");
        System.out.println("Marvellous Chat Messenger is ready to use");
        System.out.println("---------------------------------------------------------------");

        String str1 = null, str2 = null;

        // Continuous communication loop
        while((str1 = bobj1.readLine()) != null)
        {
            // Display message received from client
            System.out.println("Client Says : " + str1);

            // Read server response from console
            System.out.println("Enter the message for client : ");
            str2 = bobj2.readLine();

            // Send response to client
            pobj.println(str2);

            // Save chat messages into log file
            fwobj.write(" Client Says : " + str1 + "\n Server Says : " + str2 + "\n");
            fwobj.flush();
        }

        // Close file writer after chat ends
        fwobj.close();
    }
}

/////////////////////////////////////////////////////////////////////////////////
//
//  Class Name   :   ChatXServer
//  Description  :   Entry point for the server application. It creates an
//                   instance of Server class and starts the server socket.
//  Author       :   Gaurav Subhash Kumbhar
//
/////////////////////////////////////////////////////////////////////////////////

class ChatXServer
{
    public static void main(String A[]) throws Exception
    {
        Server sobj = new Server();
        sobj.ServerSocket();
    }    
}
