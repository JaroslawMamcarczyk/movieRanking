package com.mamra.start.remik.service;

import com.mamra.start.remik.domain.Part;
import com.mamra.start.remik.repository.PartRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class PartService {
    private PartRepository partRepository;
    PartService(PartRepository partRepository){this.partRepository=partRepository;}

    public List<Part> getParList(){
        return partRepository.findAll();
    }

    public void addPart(Part part){
        partRepository.save(part);
    }
}
