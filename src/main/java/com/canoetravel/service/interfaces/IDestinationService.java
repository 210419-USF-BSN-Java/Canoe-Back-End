package com.canoetravel.service.interfaces;

import java.util.List;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.User;

public interface IDestinationService {
	public Destination saveDestination(Destination dest, User user);
	public List<Destination> getAllDestination();
	public Destination updateDestination(Destination dest);
	public Destination deleteDestination(Destination dest);

}
