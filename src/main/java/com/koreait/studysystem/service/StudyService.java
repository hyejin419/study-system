package com.koreait.studysystem.service;

import com.koreait.studysystem.dto.Study;
import com.koreait.studysystem.dto.StudyApplication;
import com.koreait.studysystem.mapper.StudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyMapper studyMapper;

    public void createStudy(Study study) {
        studyMapper.createStudy(study);
    }

    public List<Study> getAllStudies() {
        return studyMapper.getAllStudies();
    }

    public Study getStudyById(Long id) {
        return studyMapper.getStudyById(id);
    }

    public boolean applyToStudy(Long userId, Long studyId) {
        if (studyMapper.hasUserAlreadyApplied(userId, studyId)) {
            return false; // 이미 신청함
        }
        StudyApplication app = new StudyApplication();
        app.setUserId(userId);
        app.setStudyId(studyId);
        studyMapper.applyToStudy(app);
        return true;
    }
}
