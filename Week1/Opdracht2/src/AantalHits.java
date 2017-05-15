import java.io.PrintWriter;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AantalHits extends HttpServlet {
	private int aantal = 0;
	private String full_path = System.getProperty("catalina.base");
	
	
	public void init() throws ServletException {
		super.init();
		log("servlet init");

		String content = "";

		try {
			content = new String(Files.readAllBytes(Paths.get(full_path + "\\aantal_hints.txt")));
		} catch (IOException e1) {
			content = "0";
		}
		try {
			aantal = Integer.parseInt(content);
		} catch (Exception e) {
		}
		
	}
	
	public void writeAantalHints(){
		log("WRITING AANTAL_HINTS TO FILE.");
		
		log("Full path:"+full_path);
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(			  
	              new FileOutputStream(full_path + "\\aantal_hints.txt"), "utf-8"))) {
		   writer.write(String.valueOf(aantal));
		   log("Aantal hints: " + String.valueOf(aantal));
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void destroy() {
		log("servlet destroy");
		
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String s1 = "<html>\n" + "   <head>\n" + "       <title>\n" + "          Aantal pagina hits\n"
				+ "       </title>\n" + "   </head>\n" + "   <body bgcolor=\"#8AAFED\">\n" + "      <center>\n"
				+ "         <h1>\n";

		String s2 = "";
		synchronized (this) {
			aantal += 1;
			writeAantalHints();
			s2 = "           Test: " + aantal + "\n";
		}
		String s3 = "         </h1>\n" + "      HALLO MATTHIJS!!!</center>\n" + "   </body>\n" + "</html>\n";
		out.print(s1 + s2 + s3);
	}
}