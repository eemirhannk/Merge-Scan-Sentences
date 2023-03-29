package com.yazlab.Controller;

import com.yazlab.Entity.Input;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private Input input ;

    public MainController(Input input) {
        this.input = input;
    }

    @GetMapping("/home")
    public String getHomePage(Model model){

        return "Home";
    }

}
