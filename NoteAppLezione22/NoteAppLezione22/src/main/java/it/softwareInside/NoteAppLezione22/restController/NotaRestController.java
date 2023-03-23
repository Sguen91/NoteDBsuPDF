package it.softwareInside.NoteAppLezione22.restController;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import it.softwareInside.NoteAppLezione22.models.Nota;
import it.softwareInside.NoteAppLezione22.service.NotaService;
import it.softwareInside.NoteAppLezione22.util.GeneratePdf;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class NotaRestController {
	
	@Autowired
	GeneratePdf generatePdf;
	
	@Autowired
	NotaService notaService;
	
	@PostMapping("/addNota")
	public boolean addNota(@RequestBody  Nota nota) {
		return notaService.addNota(nota);
	}
	
	@DeleteMapping("/deleteNota")
	public Nota deleteNota(@RequestParam int id) {
		return notaService.deleteNote(id);
	}
	
	@DeleteMapping("/deleteAll")
	public boolean deleteAll() {
		return notaService.deleteAll();
	}
	
	@PostMapping("/update")
	public boolean updateNota(@RequestBody Nota nota) {
		return notaService.updateNota(nota);
	}
	
	@GetMapping("/getAllNote")
	public Iterable<Nota> getAll() {
		return notaService.getAllNotes();
	
	}
	
	@GetMapping("/pdf")
    public void exportToPDF(HttpServletResponse response, @RequestParam("id") int id) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        
        Nota nota = new Nota(10, "ciao", "mauro");
        
        GeneratePdf exporter = new GeneratePdf(nota);
        exporter.export(response, id);
	
}
}

