package es.softtek.jwtDemo;

import es.luis.prueba.domain.model.Nota;
import es.luis.prueba.domain.reporitoy.NotaRepository;
import es.luis.prueba.domain.service.NotaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtDemoApplicationTests {
	private NotaRepository noteRepository = Mockito.mock(NotaRepository.class);
	private NotaService noteService = new NotaService();

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateNote() {
		Nota note = new Nota();
		note.setTitle("Test Note");
		note.setContent("Test Content");

		Mockito.when(noteRepository.save(note)).thenReturn(note);
		Nota createdNote = noteService.createOrUpdateNote(note);

		assertEquals("Test Note", createdNote.getTitle());
	}
}

