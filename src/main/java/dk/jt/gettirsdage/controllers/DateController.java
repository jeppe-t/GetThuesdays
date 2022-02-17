package dk.jt.gettirsdage.controllers;

import dk.jt.gettirsdage.config.Main;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DateController {

    Main main = new Main();


    @GetMapping("/")
    public String thuesdays(Model model){
        //Show all days in marts
        List totalDaysMarts = main.daysInMarts();
        model.addAttribute("totalMarts", totalDaysMarts.size());
        //Show all thuesdays
        List<LocalDate> thuesdays = main.toStream().collect(Collectors.toList());
        model.addAttribute("marts", thuesdays);
        model.addAttribute("martsLength", thuesdays.size());
        return "index";
    }


}
