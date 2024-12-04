package pe.edu.cibertec.daw_cl2_sotelo_jadhe.service;

import pe.edu.cibertec.daw_cl2_sotelo_jadhe.dto.FilmDetailDto;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.dto.FilmDto;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.entity.Language;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    void createFilm(FilmDetailDto filmDetailDto);

    List<Language> findAllLanguages();

}
