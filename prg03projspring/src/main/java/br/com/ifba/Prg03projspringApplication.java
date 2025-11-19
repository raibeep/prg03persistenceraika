package br.com.ifba;

import br.com.ifba.curso.view.CursoListar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Prg03projspringApplication {

	public static void main(String[] args) {
		//inicializa o spring boot
            ConfigurableApplicationContext context = 
                    new SpringApplicationBuilder(Prg03projspringApplication.class).
                    headless(false).run(args);
            //abre a tela swing
            CursoListar telaCursoListar = context.getBean(CursoListar.class);
            telaCursoListar.setVisible(true);
	}

}
