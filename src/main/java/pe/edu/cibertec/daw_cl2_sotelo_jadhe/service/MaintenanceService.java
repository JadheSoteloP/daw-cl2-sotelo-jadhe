package pe.edu.cibertec.daw_cl2_sotelo_jadhe.service;

import pe.edu.cibertec.daw_cl2_sotelo_jadhe.dto.FilmDetailDto;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);
}
