package com.koreait.studysystem.mapper;

import com.koreait.studysystem.dto.Study;
import com.koreait.studysystem.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findByUsername(String username);
    List<Study> getMyCreatedStudies(Long userId);
    List<Study> getMyAppliedStudies(Long userId);
}
