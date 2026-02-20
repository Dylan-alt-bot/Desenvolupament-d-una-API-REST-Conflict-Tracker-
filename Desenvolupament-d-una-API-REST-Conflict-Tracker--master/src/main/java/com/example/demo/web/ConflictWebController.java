package com.example.demo.web;

import com.example.demo.dto.ConflictDTO;
import com.example.demo.model.Conflict;
import com.example.demo.service.ConflictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ConflictWebController {

    private final ConflictService conflictService;

    @GetMapping("/web/conflicts")
    public String listConflicts(Model model) {

        List<ConflictDTO> conflicts = conflictService.findAll();

        model.addAttribute("conflicts", conflicts);

        return "conflicts";
    }
}
