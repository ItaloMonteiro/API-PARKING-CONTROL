package com.api.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //vai criar um bean do tipo controller para que seja gerado a dependência quando for necessário.
public class ParkingControlApplication {
// nesta classe que inicializaremos a aplicação
	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
	}

	@GetMapping("/") //este método mapea o que fizemos, é tipo a URL
	public String index(){
		return "Olá Mundo!";
	}
}
