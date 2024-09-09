package es.luis.prueba.domain.service;


import es.luis.prueba.domain.model.Nota;
import es.luis.prueba.domain.reporitoy.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> getAllNotes() {
        return notaRepository.findAll();
    }

    public Nota createOrUpdateNote(Nota note) {
        return notaRepository.save(note);
    }
}