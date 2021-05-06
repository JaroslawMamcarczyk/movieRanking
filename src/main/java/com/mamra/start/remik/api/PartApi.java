package com.mamra.start.remik.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.remik.domain.Part;
import com.mamra.start.remik.service.PartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PartApi {
    private PartService partService;
    private ObjectMapper objectMapper;

    PartApi(PartService partService, ObjectMapper objectMapper){
        this.partService = partService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/part")
    public ResponseEntity getPlayers() throws JsonProcessingException {
        List<Part> partList = partService.getParList();
        return ResponseEntity.ok(objectMapper.writeValueAsString(partList));
    }

    @PostMapping("/part/add")
    public ResponseEntity addPlayer(@RequestBody Part part) throws JsonProcessingException {
        partService.addPart(part);
        return ResponseEntity.ok("OK");
    }
}
