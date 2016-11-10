package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotellist")
public class HotelPojo 
{
	@Id
	@Column(name="autoid")
	private int id;
	
	@Column(name="hotelname")
	private String hotelName;
	
	

	@Column(name="city")
	private String city;
	
	@Column(name="roomtype")
	private String roomType;
	
	@Column(name="totalrooms")
	private int totalRooms;
	
	@Column(name="price")
	private int price;
	
	@Column(name="hotelid")
	private String hotelId;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	
	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	
	public int getTariffPerDay() {
		return price;
	}

	public void setTariffPerDay(int tariffPerDay) {
		this.price = tariffPerDay;
	}


	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	@Override
	public String toString() {
		return "HotelPojo [id=" + id + ", hotelName=" + hotelName + ", city=" + city + ", roomType=" + roomType
				+ ", totalRooms=" + totalRooms + ", price=" + price + ", hotelId=" + hotelId + "]";
	}
	
	
}
