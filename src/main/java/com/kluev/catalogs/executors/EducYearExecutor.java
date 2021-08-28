package com.kluev.catalogs.executors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kluev.catalogs.entities.EducYear;
import com.kluev.catalogs.servises.EducYearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.kluev.catalogs.executors.Commands.*;

@Component
public class EducYearExecutor implements Executor {
    @Autowired
    private EducYearServiceImpl educYearService;

    @Override
    public void execute(String command, String json) {
       EducYear educYear = deserialization(json);
       if(ADD.getCommandName().equals(command) ||
               EDIT.getCommandName().equals(command)) {
           educYearService.save(educYear);
       }
       else if(DELETE.getCommandName().equals(command)) {
            educYearService.delete(educYear);
       }
    }

    @Override
    public EducYear deserialization(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        EducYear educYear = new EducYear();
        try {
            educYear = objectMapper.readValue(json, EducYear.class);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка сериализации");
        }
        return educYear;
    }
}
