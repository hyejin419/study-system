package com.koreait.studysystem.mapper;

import com.koreait.studysystem.dto.Study;
import com.koreait.studysystem.dto.StudyApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyMapper {
    void createStudy(Study study);
    List<Study> getAllStudies();
    Study getStudyById(Long id);
    void applyToStudy(StudyApplication application);
    boolean hasUserAlreadyApplied(@Param("userId") Long userId, @Param("studyId") Long studyId);
}
