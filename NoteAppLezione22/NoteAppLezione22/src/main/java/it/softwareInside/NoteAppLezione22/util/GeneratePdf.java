package it.softwareInside.NoteAppLezione22.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import it.softwareInside.NoteAppLezione22.models.Nota;
import it.softwareInside.NoteAppLezione22.repository.NotaRepository;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class GeneratePdf {

	@Autowired
	NotaRepository notaRepository;
	
	private Nota nota;

	public GeneratePdf(Nota nota) {
		this.nota = nota;
		
	}

	public void export(HttpServletResponse response, int id) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		
		this.nota = notaRepository.findById(id).get();

		Paragraph p = new Paragraph("Nota: " + nota);
		
		

		p.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(p);

		document.close();

	}

}
