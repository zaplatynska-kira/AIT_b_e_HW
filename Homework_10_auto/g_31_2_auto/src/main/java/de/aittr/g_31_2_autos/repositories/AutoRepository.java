package de.aittr.g_31_2_autos.repositories;

import de.aittr.g_31_2_autos.domain.Auto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutoRepository extends JpaRepository<Auto,Integer> {
   @Transactional
    void deleteByModel(String model);

   @Query(value  ="select avg(year) from auto;",nativeQuery = true)
double getAverageYear();

}
