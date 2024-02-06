package de.aittr.g_31_2_autos.services;

import de.aittr.g_31_2_autos.domain.Auto;
import de.aittr.g_31_2_autos.repositories.AutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class AutoService {

    private AutoRepository repository;

    public AutoService(AutoRepository repository) {
        this.repository = repository;
    }

    public List<Auto>getAll(){
        return repository.findAll();
    }


    public void deleteByModel(String model) {
        repository.deleteByModel(model);
    }



    public double getAverageYear() {
        return repository.getAverageYear();
    }
}



