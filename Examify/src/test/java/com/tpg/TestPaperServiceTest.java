package com.tpg;

import com.tpg.entity.Section;
import com.tpg.entity.TestPaper;
import com.tpg.repository.TestPaperRepository;
import com.tpg.service.TestPaperService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestPaperServiceTest {

    @Mock
    private TestPaperRepository testPaperRepository;

    @InjectMocks
    private TestPaperService testPaperService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTestPapers() {
        List<TestPaper> testPapers = new ArrayList<>();
        when(testPaperRepository.findAll()).thenReturn(testPapers);

        List<TestPaper> retrievedTestPapers = testPaperService.getAllTestPapers();

        assertNotNull(retrievedTestPapers);
        assertEquals(0, retrievedTestPapers.size());
    }

    @Test
    public void testCreateTestPaperWithSections() {
        List<Section> sections = new ArrayList<>();
        Section section1 = new Section();
        Section section2 = new Section();
        sections.add(section1);
        sections.add(section2);

        TestPaper testPaper = testPaperService.createTestPaperWithSections(sections);

        assertNotNull(testPaper);
        assertEquals(sections, testPaper.getSections());
    }

    // You can write additional test methods for other operations in your TestPaperService as needed.
}
