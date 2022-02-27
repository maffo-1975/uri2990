package com.devsuperior.uri2990;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<EmpregadoDeptProjection> list1 = repository.search1();
		System.out.println("\n*** RESULTADO SQL RAIZ NOT IN:");
		list1.stream().map(x -> new EmpregadoDeptDTO(x)).forEach(System.out::println);

		System.out.println("\n\n");

		List<EmpregadoDeptDTO> list2 = repository.search2();
		System.out.println("\n*** RESULTADO JPQL:");
		list2.stream().forEach(System.out::println);

		System.out.println("\n\n");

		List<EmpregadoDeptProjection> list3 = repository.search3();
		System.out.println("\n*** RESULTADO SQL RAIZ LEFT JOIN:");
		list3.stream().map(x -> new EmpregadoDeptDTO(x)).forEach(System.out::println);

	}

}
