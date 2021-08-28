package com.kluev.catalogs;

import com.kluev.catalogs.executors.TableExecutorContainer;
import com.kluev.catalogs.servises.RequestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

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
				String[] strings = RequestService.parseRequest(content);
				TableExecutorContainer tableExecutorContainer = configurableApplicationContext.getBean(TableExecutorContainer.class);
				tableExecutorContainer.retrieveExecutor(strings[1]).execute(strings[0], strings[2]);
				System.out.println("Данне в таблице " + strings[1] + " изменены, выполнена команда " + strings[0]);
			} catch (IOException e) {
				System.out.println("Введен некорректный путь!");
			}
		}
	}

}
