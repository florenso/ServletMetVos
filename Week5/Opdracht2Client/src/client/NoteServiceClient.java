package client;
import notitions.*;
import java.util.List;

class NoteServiceClient {
	
	public static void main(String args[])
	{
    	NotesService service = new NotesService();
        Notes noteProxy = service.getNotesPort();

       
        System.out.println("Adding Note to database - from client");
		boolean result = noteProxy.addNote("This is a test note from Koen");
		System.out.println("Result of addition: " + result);

        System.out.println("Getting all notes from client");
		List<Note> allResultsNotes = noteProxy.getNotes();
		System.out.println("Result of getAllNotes: " + allResultsNotes.toString());
		
		for(Note ct : allResultsNotes){
			System.out.println("We found a note: " + ct.getText() + " created at date: " + ct.getDate().toString());
		}
	}
}