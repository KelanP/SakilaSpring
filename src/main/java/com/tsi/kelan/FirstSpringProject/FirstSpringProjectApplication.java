package com.tsi.kelan.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;



@SpringBootApplication
@RestController
@RequestMapping("/home")


public class FirstSpringProjectApplication {

	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringProjectApplication.class, args);
	}


	public FirstSpringProjectApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}


//Used to retrieve all actors in the database
	@GetMapping("/all_actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	//@DeleteMapping("Delete")
	//public void @ResponseBody



}
