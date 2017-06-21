//NoteServer.java
package server;

import javax.xml.ws.Endpoint;
import calcws.Notes;

public class NoteServer {
    
    public static void main(String[] args){

		
        Notes notitions = new Notes("");
        Endpoint.publish("http://localhost:9191/notitions", notitions); 
        System.out.println("http://localhost:9191/notitions published");
    }
}