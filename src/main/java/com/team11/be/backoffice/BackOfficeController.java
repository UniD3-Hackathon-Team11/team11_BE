package com.team11.be.backoffice;

import com.team11.be.domain.stage.dto.StageRequestDto;
import com.team11.be.domain.stage.dto.StageResponseDto;
import com.team11.be.domain.stage.service.StageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BackOfficeController {

    private final StageService stageService;

    @GetMapping("/backoffice/stages")
    public String getStages(Model model){
        List<StageResponseDto> stages = stageService.getAllStages();

        model.addAttribute("stages", stages);
        return "stages/stagesListPage";
    }

    @GetMapping("/backoffice/stages/create")
    public String createStagePage(){
        return "stages/stagesCreatePage";
    }

    @PostMapping("/backoffice/stages")
    public String createStage(StageRequestDto stageRequestDto){
        stageService.postStage(stageRequestDto);

        return "redirect:/backoffice/stages";
    }

    @GetMapping("/backoffice/stages/{id}/delete")
    public String createStage(@PathVariable Long id){
        stageService.deleteStage(id);

        return "redirect:/backoffice/stages";
    }
}
