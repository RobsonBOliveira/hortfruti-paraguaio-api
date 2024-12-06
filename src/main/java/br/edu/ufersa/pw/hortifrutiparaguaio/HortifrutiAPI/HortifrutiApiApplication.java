package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class HortifrutiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HortifrutiApiApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner{
		@Value("${var1:valor default no classe app!	}")
		String teste;
		@Override
		public void run(ApplicationArguments args) throws Exception {
			System.out.println("Sistema Rodando com " + teste);
		}
	}
}
