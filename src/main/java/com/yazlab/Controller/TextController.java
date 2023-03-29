package com.yazlab.Controller;

import com.yazlab.Service.TextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TextController {
    private TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    @PostMapping("/addText")
    public String addText(@RequestParam("inputText") String inputText) {
        textService.TextCollection(inputText);
        return "Home";
    }


    @PostMapping("/takeResult")
    public String getResultPage(Model model) {
        model.addAttribute("inputText", textService.mainMergeTexts());
        return "Result";
    }
}
