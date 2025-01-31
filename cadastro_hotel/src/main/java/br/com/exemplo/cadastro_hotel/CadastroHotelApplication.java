package br.com.exemplo.cadastro_hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CadastroHotelApplication {
    public static void main(String[] args) {
        SpringApplication.run(CadastroHotelApplication.class, args);
    }

}
