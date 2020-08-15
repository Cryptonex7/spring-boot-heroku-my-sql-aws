package com.anujeetchatterjee.sqlmsqlv2.service;

import com.anujeetchatterjee.sqlmsqlv2.models.Citizen;
import com.anujeetchatterjee.sqlmsqlv2.helper.CSVHelper;
import com.anujeetchatterjee.sqlmsqlv2.repository.CitizenRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository repository;

    public Citizen addCitizen(@NotNull Citizen citizen) {
        return repository.save(citizen);
    }

    public List<Citizen> addCitizens(List<Citizen> citizens) {
        return repository.saveAll(citizens);
    }

    public String uploadCSV(MultipartFile file) {
        try{
            List<Citizen> citizens = CSVHelper.csvToCitizens(file.getInputStream());
            System.out.println("CSV:" + citizens);
            repository.saveAll(citizens);
            return "CSV Uploaded.";
        } catch (IOException e) {
            throw new RuntimeException("Failed to Upload CSV Data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream downloadCSV() {
        List<Citizen> citizens = repository.findAll();

        ByteArrayInputStream in = CSVHelper.citizensToCSV(citizens);
        return in;
    }

    public List<Citizen> getCitizens() {
        return repository.findAll();
    }

    public Citizen getCitizenByID(@NotNull int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Citizen> getCitizensByName(@NotNull String name) {
        return repository.findByName(name);
    }

    public String deleteCitizen(@NotNull int id) {
        repository.deleteById(id);
        return "Deleted Citizen with ID:" + id + ": " + getCitizenByID(id).getName();
    }

    public String updateCitizen(Citizen updatedCitizen) {
        Citizen existingCitizen = getCitizenByID(updatedCitizen.getId());
        if (existingCitizen != null) {
            existingCitizen.setAge(updatedCitizen.getAge());
            existingCitizen.setName(updatedCitizen.getName());
            existingCitizen.setGender(updatedCitizen.getGender());
            repository.save(existingCitizen);
            return "Updated Citizen with ID:"
                    + existingCitizen.getId() + ": "
                    + getCitizenByID(existingCitizen.getId()).getName() + " of Age: "
                    + getCitizenByID(existingCitizen.getId()).getAge() + " who is: "
                    + getCitizenByID(existingCitizen.getId()).getGender();
        }
        return "Citizen with ID:" + updatedCitizen.getId() + " not found.";
    }

}
