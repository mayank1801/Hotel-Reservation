package pojos;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reservations")
public class ReservationPojo 
{
	
	@Column(name="hotelid")
	private String hotelId;
	
	@Column(name="hotelname")
	@NotEmpty(message = "Please select your hotel Name")
	private String hotelName;
	
	@Column(name="bookingid")
	@Id
	int bookingId;
	
	@NotEmpty(message = "Please select Check In Date")
	private String inDate;
	
	@NotEmpty(message = "Please select Check Out Date")
	private String outDate;
	
	
	
	@Column(name="checkindate")
	private Date checkInDate;
	
	@Column(name="checkoutdate")
	private Date checkOutDate;

	@Column(name="city")
	@NotEmpty(message = "Please select city")
	private String city;
	
	@Column(name="roomsreserved")
	@NotEmpty(message = "Please select no of rooms")
	private String roomsReserved;
	
	@Column(name="guestname")
	@NotEmpty(message = "Please enter Guest Name")
	private String guestName;
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	
	
	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	
	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	
	
	
	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	
	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}


	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	
	public String getRoomsReserved() {
		return roomsReserved;
	}

	public void setRoomsReserved(String roomsReserved) {
		this.roomsReserved = roomsReserved;
	}
	
}
