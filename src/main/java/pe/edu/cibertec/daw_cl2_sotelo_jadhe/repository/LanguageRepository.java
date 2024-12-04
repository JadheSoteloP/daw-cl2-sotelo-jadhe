package pe.edu.cibertec.daw_cl2_sotelo_jadhe.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.daw_cl2_sotelo_jadhe.entity.Language;
import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Integer>
{
    List<Language> findAll();
}

