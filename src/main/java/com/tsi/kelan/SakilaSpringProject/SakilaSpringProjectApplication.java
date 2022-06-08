package com.tsi.kelan.SakilaSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})
@RestController
@RequestMapping("/home")


public class SakilaSpringProjectApplication {

	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(SakilaSpringProjectApplication.class, args);
	}


	public SakilaSpringProjectApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}


//CRUD METHODS FOR ACTOR TABLE
	@GetMapping("/all_actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/actor/{id}") //request will look like ".../actor/?id=1"
	public @ResponseBody
	Optional<Actor> getActorById(@PathVariable(value="id") int id){
		return actorRepository.findById(id);};

	@DeleteMapping("/actor/delete/{id}")
	public @ResponseBody String deleteActorById(@PathVariable(value="id")int id){
		String displayActor = String.valueOf(actorRepository.findById(id));
		actorRepository.deleteById(id);
		return displayActor + "\n----- This item has been deleted -----";
	}


	@PutMapping("/actor/update/{id}")
	public @ResponseBody
	Actor updateActorById(@PathVariable(value="id") int id, @RequestBody Actor actor){
		Actor newActor = actorRepository.save(actor);
		return actorRepository.save(newActor);};


	@PostMapping("/actor/create")
	public @ResponseBody
	Actor createNewActor(@RequestBody Actor actor){
		Actor newActor = actorRepository.save(actor);
		return newActor;
	}

}
