package repositories;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pojos.HotelPojo;
import pojos.ReservationPojo;

@Repository
public interface RoomReservationRepository  extends CrudRepository<ReservationPojo, Integer>{

	/*@Query("select sum(roomsReserved) from ReservationPojo r where r.city=?1 and r.hotelName=?2 and ((?3 between r.checkInDate AND r.checkOutDate) or"
			+ "  (?4 between r.checkInDate AND r.checkOutDate))")
	String getNoOfRooms(String city,String hotelName,String string,String string2);*/
	
	@Query("select sum(roomsReserved) from ReservationPojo r where r.city=?1 and r.hotelName=?2 and ((?3 between r.checkInDate AND r.checkOutDate) or"
			+ "  (?4 between r.checkInDate AND r.checkOutDate) or (?3<r.checkInDate and ?4>r.checkOutDate))")
	String getNoOfRooms(String city,String hotelName,Date date,Date date2);
	
	@Query("select max(r.bookingId) from ReservationPojo r")
	int getMaxBookingId();
	
}
