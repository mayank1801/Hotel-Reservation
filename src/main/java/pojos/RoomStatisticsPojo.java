package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="roomstatistics")
public class RoomStatisticsPojo 
{
	@Id
	private int id;
	
	private String hotelId;
	
	private String bookingDate;
	
	private int vacantRooms;

	@Column(name="autoid")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="hotelid")
	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	@Column(name="bookingdate")
	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Column(name="vacantrooms")
	public int getVacantRooms() {
		return vacantRooms;
	}

	public void setVacantRooms(int vacantRooms) {
		this.vacantRooms = vacantRooms;
	}
	
}
