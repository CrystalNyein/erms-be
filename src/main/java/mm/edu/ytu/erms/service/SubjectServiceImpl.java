package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Subject;

import mm.edu.ytu.erms.repository.SubjectRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Page<Subject> getAll(Pageable page) {
        return subjectRepository.findAll(page);
    }

    @Override
    public List<Subject> getSome(String code) {
        return subjectRepository.findByCodeContains(code);
    }

    @Override
    public Subject getByCode(String code) {
        return subjectRepository.getOne(code);
    }

    @Override
    public Subject getByName(String name) {
        return subjectRepository.findByName(name);
    }

    @Override
    public Subject create(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    public Subject update(Subject subject) {
        Subject oldData = subjectRepository.getOne(subject.getCode());
        BeanUtils.copyProperties(subject, oldData);
        return subjectRepository.saveAndFlush(oldData);
    }

    @Override
    public void delete(String code) {
        subjectRepository.deleteById(code);
    }
}
