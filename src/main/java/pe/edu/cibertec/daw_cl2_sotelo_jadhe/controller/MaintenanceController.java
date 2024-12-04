package pe.edu.cibertec.daw_cl2_sotelo_jadhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.dto.FilmDetailDto;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.dto.FilmDto;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {

        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_edit";
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

}
