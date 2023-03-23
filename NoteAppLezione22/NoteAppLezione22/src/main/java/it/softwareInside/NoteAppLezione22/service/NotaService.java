package it.softwareInside.NoteAppLezione22.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.softwareInside.NoteAppLezione22.models.Nota;
import it.softwareInside.NoteAppLezione22.repository.NotaRepository;
import jakarta.validation.Valid;

@Service
public class NotaService {
	
	@Autowired
	NotaRepository notaRepository;
	
	/*
	 * metodo per aggiungere una nota al db.
	 */
	public boolean addNota(@Valid Nota nota) {
		try {
			
			notaRepository.save(nota);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	/*
	 * metodo per stampare la lista del db
	 */
	public Iterable<Nota> getAllNotes(){
		return notaRepository.findAll();
	}
	/*
	 * metodo per stampare un singolo record del db con id
	 */
	public Nota getNote(int id) {
		
		 try {
			 
			 return notaRepository.findById(id).get();
			
		} catch (Exception e) {
			return null;
		}
	}
	/*
	 * metodo per cancellare tutti i record del db
	 */
	public boolean deleteAll() {
		
		try {
			
			notaRepository.deleteAll();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	/*
	 * metodo per cancellare un singolo record tramite id
	 */
	public Nota deleteNote(int id) {
		
		Nota nota = notaRepository.findById(id).get();
		
		try {
			
			notaRepository.deleteById(id);
			return nota;
			
		} catch (Exception e) {
			return null;
		}
	}
	/*
	 * metodo per modificare un record
	 */
	public boolean updateNota(@Valid Nota nota) {
		
		return addNota(nota);
	}
	
	
}

