# Chat_Bot

# Overview
ChatX is a basic two-way chat application built in Java using Socket Programming.
It includes a Server and a Client that communicate over TCP on port 5100.
The server also saves chat history in a text file with a timestamped name.

# Features
Real-time chat between client and server.
Server logs chat history in a text file.
Simple console-based interface.
Ends when client types "end".

# How to Run
1. Compile the code
javac Server.java
javac Client.java
2. Start the Server
java ChatXServer
3. Start the Client (in another terminal)
java ChatXClient
4. Start Chatting 
Type a message in client console → server replies.
Chat ends when client types end.
Example Log File (Server Side)
Client Says : Hello Server
Server Says : Hello Client
Client Says : How are you?
Server Says : I am fine. How about you?

# Requirements
Java JDK 8 or higher
Terminal / Command Prompt

# Author
Gaurav Subhash Kumbhar
