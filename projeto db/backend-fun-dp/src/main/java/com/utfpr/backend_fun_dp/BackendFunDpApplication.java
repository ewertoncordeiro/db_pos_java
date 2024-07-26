package com.utfpr.backend_fun_dp;

import com.utfpr.backend_fun_dp.entity.Departamento;
import com.utfpr.backend_fun_dp.entity.Funcionario;
import com.utfpr.backend_fun_dp.repository.DepartamentoRepository;
import com.utfpr.backend_fun_dp.service.DepartamentoService;
import com.utfpr.backend_fun_dp.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BackendFunDpApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendFunDpApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendFunDpApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(DepartamentoService departamentoService) {


		return (arg) -> {
		//	log.info("getFuncionariosByDepartamentoNome");
		//	for (Funcionario f : funcionarioService.getFuncionariosByDepartamentoNome("suporte")) {
		//		log.info(f.toString());

				log.info("getFirstDepartamento");
				Departamento f = departamentoService.getFirstDepartamento(); {
					//log.info(f.toString());

				//diogo
			//		log.info("getFuncionariosByDepartamentoNome");
			//		 Departamento z = departamentoService.getFirstDepartamento();
			//				log.info(z.toString());
		//	};



}}





