package pe.edu.cibertec.daw_cl2_sotelo_jadhe.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.entity.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {

    @Override
    @Cacheable(value = "filmsCache")
    Iterable<Film> findAll();

    @Override
    @CacheEvict(value = "filmsCache", allEntries = true)
    <S extends Film> S save(S entity);

    @Override
    @CacheEvict(value = "filmsCache", allEntries = true)
    void deleteById(Integer id);

}
