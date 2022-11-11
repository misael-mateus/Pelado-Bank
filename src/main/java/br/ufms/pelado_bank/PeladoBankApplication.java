package br.ufms.pelado_bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PeladoBankApplication{

	public static void main(String[] args) {
		SpringApplication.run(PeladoBankApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		long startTime = System.nanoTime();
//		System.out.println("/* … O código que está sendo medido inicia … */");
//
//
//		// dorme por 5 segundos
//		TimeUnit.SECONDS.sleep(5);
//		System.out.println("/* … O código que está sendo medido termina … */");
//
//		long endTime = System.nanoTime();
//
//		// obtém a diferença entre os dois valores de tempo nano
//		long timeElapsed = endTime - startTime;
//
//		System.out.println("Execution time in nanoseconds: " + timeElapsed);
//		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
//	}

}
