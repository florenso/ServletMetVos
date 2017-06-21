//Notes.java
package calcws;

import javax.jws.WebService;
import javax.jws.WebParam;
import java.util.List;
import java.util.ArrayList;

@WebService
public class Notes {
    

	public boolean addNote(@WebParam(name="text") String tekst){
		System.out.println("request addNote(" + tekst + ")");
		return false;
	}
	
	public boolean removeNote(@WebParam(name="id") int  noteId){
		System.out.println("request removeNote(" + noteId + ")");
		return false;
	}

	public List<Note> getNotes(){

	
		
		List<Note> allNotes = new ArrayList<Note>();
		Note theNote = new Note();
		allNotes.add(theNote);
		return allNotes;
	}
	

}