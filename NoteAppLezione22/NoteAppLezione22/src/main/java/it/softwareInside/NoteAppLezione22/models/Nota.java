package it.softwareInside.NoteAppLezione22.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Nota {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id int id;
	
	@NotBlank
	@NotEmpty
	private String text;
	
	@NotBlank
	@NotEmpty
	private String autore;
	
	
	Nota(String text, String autore){
		setText(text);
		setAutore(autore);
	}
	
}
