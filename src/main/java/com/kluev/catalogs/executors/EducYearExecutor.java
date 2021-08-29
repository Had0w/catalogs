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

    private EducYearServiceImpl educYearService;

    @Autowired
    public void setEducYearService(EducYearServiceImpl educYearService) {
        this.educYearService = educYearService;
    }

    @Override
    public void execute(String command, String json) {
       EducYear educYear = deserialization(json);
       if(educYear.getId() == 0) {
           System.out.println("Данные не были обновлены");
       }
       else {
           if (ADD.getCommandName().equals(command) ||
                   EDIT.getCommandName().equals(command)) {
               educYearService.save(educYear);
           } else if (DELETE.getCommandName().equals(command)) {
               educYearService.delete(educYear);
           }
       }
    }

    @Override
    public EducYear deserialization(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        EducYear educYear = new EducYear();
        try {
            educYear = objectMapper.readValue(json, EducYear.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return educYear;
    }
}
