package com.kluev.catalogs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kluev.catalogs.entities.EducYear;
import com.kluev.catalogs.executors.Executor;
import com.kluev.catalogs.executors.TableExecutorContainer;
import com.kluev.catalogs.repositories.EducYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Scanner;

@SpringBootApplication
public class CatalogsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =  SpringApplication.run(CatalogsApplication.class, args);
		while (true) {
			System.out.println("Введите путь к файлу или введите q для завершения");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				String filePath =  reader.readLine();
				if(filePath.equals("q")) {
					break;
				}
				String content = Files.readString(Paths.get(filePath));
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
				Gson gson = gsonBuilder.setPrettyPrinting().create();
				EducYear educYear = gson.fromJson(content, EducYear.class);
				System.out.println(educYear);
				EducYearRepository educYearRepository = configurableApplicationContext.getBean(EducYearRepository.class);
				educYearRepository.save(educYear);
//				Executor executor = new TableExecutorContainer().retrieveExecutor("EDUC_YEAR");
//				executor.execute(educYear);
			} catch (IOException e) {
				System.out.println("Введен некорректный путь!");
			}
		}
	}

}
