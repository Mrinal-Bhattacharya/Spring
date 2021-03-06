package com.ps.services.impl;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.ps.base.PetType;
import com.ps.ents.Pet;
import com.ps.ents.User;
import com.ps.repos.PetRepo;
import com.ps.services.PetService;

@Component
public class SimplePetService extends SimpleAbstractService<Pet> implements PetService {

	private PetRepo repo;

	public SimplePetService(PetRepo repo) {
		this.repo = repo;
	}

	@Override
	public Pet createPet(User user, String name, int age, PetType petType, String rfid) {
		Pet pet = new Pet();
		pet.setOwner(user);
		pet.setName(name);
		pet.setAge(age);
		pet.setRfid(rfid);
		user.addPet(pet);
		repo.save(pet);
		return pet;
	}

	@Override
	public Set<Pet> findAllByOwner(User user) {
		return repo.findAllByOwner(user);
	}

	@Override
	public Pet findByOwner(User user, String name) {
		return repo.findByOwner(user, name);
	}

	public PetRepo getRepo() {
		return repo;
	}
}
