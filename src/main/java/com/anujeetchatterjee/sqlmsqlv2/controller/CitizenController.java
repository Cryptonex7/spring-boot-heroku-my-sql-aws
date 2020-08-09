package com.anujeetchatterjee.sqlmsqlv2.controller;

import com.anujeetchatterjee.sqlmsqlv2.entity.Citizen;
import com.anujeetchatterjee.sqlmsqlv2.helper.CSVHelper;
import com.anujeetchatterjee.sqlmsqlv2.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
    @Autowired
    private CitizenService service;

    @PostMapping("/add")
    public Citizen addCitizen(@RequestBody Citizen citizen){
        return service.addCitizen(citizen);
    }

    @PostMapping("/addMultiple")
    public List<Citizen> addCitizen(@RequestBody List<Citizen> citizens){
        return service.addCitizens(citizens);
    }

    @PostMapping("/uploadCSV")
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file){
        if(CSVHelper.hasCSVFormat(file)){
            try{
                service.uploadCSV(file);
                return ResponseEntity.status(HttpStatus.OK).body("File Uploaded");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Could Not Upload File!");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload a CSV File.");
    }

    @GetMapping("/downloadCSV")
    public ResponseEntity<Resource> downloadCSV() {
        InputStreamResource file = new InputStreamResource(service.downloadCSV());
        return ResponseEntity.ok()
                .header(
                    HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=citizen_"
                            + Instant.now().getEpochSecond() + ".csv"
                )
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

    @GetMapping("")
    public List<Citizen> getCitizens() {
        return service.getCitizens();
    }

    @GetMapping("/byName/{name}")
    public List<Citizen> getCitizensByName(@PathVariable String name) {
        return service.getCitizensByName(name);
    }

    @GetMapping("/byID/{id}")
    public Citizen getCitizenByID(@PathVariable int id) {
        return service.getCitizenByID(id);
    }

    @PutMapping("/update")
    public String updateCitizen(@RequestBody Citizen updatedCitizen){
        return service.updateCitizen(updatedCitizen);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCitizen(@PathVariable int id){
        return service.deleteCitizen(id);
    }
}
