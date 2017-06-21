package client;
import notitions.*;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class NoteServiceClient extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField noteField;
	private JTextField removeNoteField;
	
	
	private JLabel resultField;
	private NotesService service;
	private Notes noteProxy;
	
	public NoteServiceClient(){
		super("Note Client Database");
		service = new NotesService();
        noteProxy = service.getNotesPort();
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 200);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 2));
		p1.add(new JLabel("What is your note?"));
		noteField = new JTextField();
		noteField.setText("Type your note here...");
		p1.add(noteField);
		
		p1.add(new JLabel("Remove Note ID"));
		removeNoteField = new JTextField();
		removeNoteField.setText("Note ID");
		p1.add(removeNoteField);
		
		p1.add(new JLabel("Result"));
		resultField = new JLabel("Unknown");
		p1.add(resultField);
		

		JButton jb = new JButton("Add Note");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(noteField != null){
				System.out.println("NoteField: " + noteField.getText().trim());
				boolean result = noteProxy.addNote(noteField.getText().trim());
				if(resultField != null){
					
					resultField.setText(Boolean.toString(result));	
				}
				
				System.out.println("Pressed button!!");	
				}
			}
		});
		p1.add(jb);
		
		
		JButton jb1 = new JButton("Remove Note");
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(noteField != null){
				boolean result = noteProxy.removeNote(Integer.parseInt(removeNoteField.getText().trim())); 
				
				if(resultField != null){
					
					resultField.setText(Boolean.toString(result));	
				}
				
				System.out.println("Pressed remove button!!");	
				}
			}
		});
		p1.add(jb1);
		
		getContentPane().add(p1, BorderLayout.NORTH);
	}
	
/*	public static void testRemoteServer(){
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
	*/
	public static void main(String args[])
	{
    	NoteServiceClient dsd = new NoteServiceClient();
		dsd.setVisible(true);
		//testRemoteServer();
       

	}
}

