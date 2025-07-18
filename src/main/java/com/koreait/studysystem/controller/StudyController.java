package com.koreait.studysystem.controller;

import com.koreait.studysystem.dto.Study;
import com.koreait.studysystem.dto.User;
import com.koreait.studysystem.mapper.UserMapper;
import com.koreait.studysystem.service.StudyService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;
    private final UserMapper userMapper;

    @GetMapping("/studies")
    public String listStudies(Model model) {
        model.addAttribute("studies", studyService.getAllStudies());
        return "list";
    }

    @GetMapping("/studies/new")
    public String showCreateForm(Model model) {
        model.addAttribute("study", new Study());
        return "create";
    }

    @PostMapping("/studies")
    public String createStudy(@ModelAttribute Study study, Authentication auth) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        User user = userMapper.findByUsername(username);

        study.setCreatorId(user.getId());
        studyService.createStudy(study);
        return "redirect:/list";
    }

    @GetMapping("/studies/{id}")
    public String studyDetail(@PathVariable Long id, Model model) {
        model.addAttribute("study", studyService.getStudyById(id));
        return "detail";
    }

    @PostMapping("/studies/{id}/apply")
    public String applyToStudy(@PathVariable Long id, Authentication auth, Model model) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        User user = userMapper.findByUsername(username);

        boolean applied = studyService.applyToStudy(user.getId(), id);
        if (!applied) {
            model.addAttribute("error", "이미 신청하였습니다.");
        }
        return "redirect:/studies/" + id;
    }
}
