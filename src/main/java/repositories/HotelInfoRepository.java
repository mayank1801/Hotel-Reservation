package repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pojos.HotelPojo;

@Repository
public interface HotelInfoRepository  extends CrudRepository<HotelPojo, Integer>{

	
	List<HotelPojo> findByCityOrderByPriceAsc(String city);
	
	@Query("select distinct t.city from HotelPojo t")
	ArrayList<String> findCities();
	
	@Query("select distinct t.hotelName from HotelPojo t where city= ?1 ")
	List<String> findHotels(String city);
	
	@Query("select totalRooms from HotelPojo t where city=?1 and hotelName=?2")
	String getTotalRooms(String city,String hotelName);
	
	
	@Query("select price from HotelPojo t where city=?1 and hotelName=?2")
	int getPrice(String city,String hotelName);
	
	
	
	
}
