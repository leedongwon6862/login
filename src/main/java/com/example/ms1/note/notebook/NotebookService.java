package com.example.ms1.note.notebook;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookService {
    private final NotebookRepository notebookRepository;

    public Notebook getNotebook(Long notebookId) {
        return notebookRepository.findById(notebookId).orElseThrow();
    }

    public List<Notebook> getNotebookList() {
        return notebookRepository.findAll();
    }

    public Notebook save(Notebook notebook) {
        return notebookRepository.save(notebook);
    }

    public void delete(Long id) {
        Notebook notebook = getNotebook (id);
        notebookRepository.deleteById (id);
    }

    public void update(Long id, String name) {
        Notebook notebook = getNotebook (id);
        notebook.setName (name);
        notebookRepository.save (notebook);
    }
}
