package es.luis.prueba.adapter.controller;


import es.luis.prueba.domain.model.Nota;
import es.luis.prueba.domain.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaService noteService;

    @GetMapping
    public List<Nota> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public Nota createNote(@Valid @RequestBody Nota note) {
        return noteService.createOrUpdateNote(note);
    }
}