package com.lautarobravo.aune_interview;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class AuneInterviewApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce el nombre del archivo (text.md): ");
		String name = scanner.nextLine();

		String content = readFile(name);

		var app = new AppReader();
		if (content != null){
			var result = app.evaluate(content);

			for(Map.Entry<String, Integer> word : result.entrySet()){
				System.out.println(word.getKey() + " " + word.getValue());
			}
		}

		//TODO:
		//1. Todos los (, ", ! sacarlos con el mismo replaces.
		//2. Sacar los numeros
	}


	private static String readFile(String name) {
		StringBuilder content = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(name))) {
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
			return null;
		}
		return content.toString();
	}

}
