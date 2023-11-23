package com.tpg;

import com.tpg.entity.Subject;
import com.tpg.repository.SubjectRepository;
import com.tpg.service.SubjectService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SubjectServiceTest {

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectService subjectService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindById() {
        int subjectId = 1;
        Subject subject = new Subject(subjectId, "Sample Subject");

        when(subjectRepository.findById(subjectId)).thenReturn(Optional.of(subject));

        Subject foundSubject = subjectService.findById(subjectId);

        assertNotNull(foundSubject);
        assertEquals(subjectId, foundSubject.getSubjectId());
        assertEquals("Sample Subject", foundSubject.getSubject_name());
    }

    @Test
    public void testFindByIdNotFound() {
        int subjectId = 1;

        when(subjectRepository.findById(subjectId)).thenReturn(Optional.empty());

        Subject foundSubject = subjectService.findById(subjectId);

        assertNull(foundSubject);
    }

    @Test
    public void testSave() {
        Subject subject = new Subject(1, "Sample Subject");

        when(subjectRepository.save(any(Subject.class))).thenReturn(subject);

        Subject savedSubject = subjectService.save(subject);

        assertNotNull(savedSubject);
        assertEquals(subject.getSubjectId(), savedSubject.getSubjectId());
        assertEquals(subject.getSubject_name(), savedSubject.getSubject_name());
    }

    @Test
    public void testDeleteById() {
        int subjectId = 1;
        subjectService.deleteById(subjectId);

        verify(subjectRepository, times(1)).deleteById(subjectId);
    }

    @Test
    public void testFindAll() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1, "Subject 1"));
        subjects.add(new Subject(2, "Subject 2"));

        when(subjectRepository.findAll()).thenReturn(subjects);

        List<Subject> retrievedSubjects = subjectService.findAll();

        assertNotNull(retrievedSubjects);
        assertEquals(2, retrievedSubjects.size());
    }
}

