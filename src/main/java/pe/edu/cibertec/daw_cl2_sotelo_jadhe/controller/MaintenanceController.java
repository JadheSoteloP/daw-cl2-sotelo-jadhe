package pe.edu.cibertec.daw_cl2_sotelo_jadhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.dto.FilmDetailDto;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.dto.FilmDto;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.service.MaintenanceService;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.entity.Language;


import java.util.Date;
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

    @GetMapping("/new")
    public String newFilm(Model model) {
        FilmDetailDto filmDetailDto = new FilmDetailDto(null, "", "", null, null, "", null, null, null, null, "", "", new Date());
        model.addAttribute("film", filmDetailDto);

        List<Language> languages = maintenanceService.findAllLanguages();
        model.addAttribute("languages", languages);

        return "maintenance_new";
    }

    @PostMapping("/new")
    public String saveNewFilm(@ModelAttribute FilmDetailDto filmDetailDto) {
        maintenanceService.createFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            maintenanceService.deleteFilmById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Película eliminada exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "No se pudo eliminar la película: " + e.getMessage());
        }
        return "redirect:/maintenance/start";
    }

}
