package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojos.HotelPojo;
import repositories.RoomReservationRepository;
import repositories.HotelInfoRepository;

@Service
public class RoomReservationService {

	
	@Autowired
	private HotelInfoRepository repository;
	
	public String getTotalRooms(String city,String hotelName)
	{
		
		return repository.getTotalRooms(city, hotelName);
		
	}
	
	public List<HotelPojo> getLowestPriceHotels(String city)
	{
		System.out.println("city is "+city);
		return repository.findByCityOrderByPriceAsc(city);
		
	}
	
	public ArrayList<String> getCities()
	{
	
		return repository.findCities();
		
	}
	
	public List<String> getHotels(String city)
	{
	
		return repository.findHotels(city);
		
	}
	
	public int getPrice(String city,String hotelName)
	{
	
		return repository.getPrice(city, hotelName);
		
	}
	
}
