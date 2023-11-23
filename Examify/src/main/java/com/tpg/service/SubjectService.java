package com.tpg.service;

import java.util.List;

import com.tpg.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpg.entity.Subject;
import com.tpg.repository.SubjectRepository;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject findById(Integer subject_id) {
        return subjectRepository.findById(subject_id).orElse(null);
    }

    public Subject save(Subject subject) {
        Subject existingSubject = subjectRepository.findByActualSub(subject.getSubject_name());
        if (existingSubject != null) {
            // Question with the same content already exists, return an error message
            throw new DuplicateException("Subject already exists");
        }
        return subjectRepository.save(subject);
    }


    public void deleteById(Integer subject_id) {
        subjectRepository.deleteById(subject_id);
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

}
