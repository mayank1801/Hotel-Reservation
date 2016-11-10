package controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



import pojos.HotelPojo;
import pojos.ReservationPojo;
import repositories.RoomReservationRepository;
import repositories.HotelInfoRepository;
import services.RoomReservationService;



@Controller
public class RoomReservationController {
	
	@Autowired
	private RoomReservationService service;
	
	@Autowired
	private RoomReservationRepository reservationRepository;

	@RequestMapping("/")
	public String home()
	{
		System.out.println("in room controller");
		return "index";
	}
	
	@RequestMapping("/getCities")
	public @ResponseBody List<String> getCities(Model map)
	{
		ArrayList<String> cities = (ArrayList<String>) service.getCities();
		map.addAttribute("cities", cities);
		List<String> cityList=cities;
		System.out.println("getting citylist");
		System.out.println(cityList);
 		return cityList;
	}
	
	
	
	
	
	@RequestMapping("/viewCities")
	public String viewCities(Model map)
	{
		
 		return "cities";
	}
	
	@RequestMapping("/bookRoom")
	public String bookRoom(Model map)
	{
		ArrayList<String> cities = (ArrayList<String>) service.getCities();
		map.addAttribute("cities", cities);
		ReservationPojo p=new ReservationPojo();
		map.addAttribute("reservationForm",p );
 		return "bookRoom";
	}
	
	@RequestMapping("/cancelBooking")
	public String cancelBooking(Model map)
	{
		System.out.println("getting index page");
 		return "index";
	}
	
	
	
	
	
	
	@RequestMapping("/lowestPricedHotels")
    public String getLowestPriceHotels(@RequestParam String city,Model map)
    {
		
		
		ArrayList<HotelPojo> list=(ArrayList<HotelPojo>) service.getLowestPriceHotels(city);
		
		for(HotelPojo p:list)
		{
			p.toString();
		}
		map.addAttribute("hotelList", service.getLowestPriceHotels(city));
    	return "viewLowestPriceHotels";
    }
	
	@RequestMapping("/getHotels")
    public @ResponseBody List<String> getHotels(@RequestParam String city,Model map)
    {
		System.out.println("city to query is "+city);
    	/*List<HotelPojo>hotelList= service.getHotels(city);
    	
    	List<String> hotelNames=new ArrayList<String>();
    	
    	for(HotelPojo h:hotelList)
    	{
    		hotelNames.add(h.getHotelName());
    	}*/
    	return service.getHotels(city);
    }
	
	@RequestMapping("/getTotalRooms")
    public @ResponseBody String getTotalRooms(@RequestParam String city,@RequestParam String hotelName)
    {
		
    	
    	return service.getTotalRooms(city, hotelName);
    }
	
	
	@RequestMapping("/reserveRoom")
    public String bookRoom(@Valid @ModelAttribute("reservationForm")  ReservationPojo reservationForm,BindingResult result,Model map)
    {
//		if(reservationForm.getCheckInDate() != null)
//		if(reservationForm.getCheckInDate().compareTo(reservationForm.getCheckOutDate())>0)
//		{
//			ObjectError error = new ObjectError("checkOutDate","check out gate must be greater than check in date");
//			result.addError(error);
//		}
		
		
		System.out.println("Booking ID"+reservationForm.getBookingId());
		if(result.hasErrors())
		{
			ArrayList<String> cities = (ArrayList<String>) service.getCities();
			map.addAttribute("cities", cities);
			/*ReservationPojo p=new ReservationPojo();
			map.addAttribute("reservationForm",p );*/
			return "bookRoom";
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			reservationForm.setCheckInDate(new java.sql.Date(formatter.parse(reservationForm.getInDate()).getTime()));
		} catch (ParseException e) {
			ObjectError error = new ObjectError("inDate","Please Enter Valid Check In Date");
			result.addError(error);
			e.printStackTrace();
		}
		
		try {
			reservationForm.setCheckOutDate(new java.sql.Date(formatter.parse(reservationForm.getOutDate()).getTime()));
		} catch (ParseException e) {
			ObjectError error = new ObjectError("outDate","Please Enter Valid Check out Date");
			result.addError(error);
			e.printStackTrace();
		}
		
		int bookingIdCounter=reservationRepository.getMaxBookingId();
		
		reservationForm.setBookingId(bookingIdCounter+1);
		reservationRepository.save(reservationForm);
		map.addAttribute("reservationInfo",reservationForm );
		int price=service.getPrice(reservationForm.getCity(), reservationForm.getHotelName());
		int totalCost=price*(Integer.parseInt(reservationForm.getRoomsReserved()));
		map.addAttribute("totalCost",totalCost);
		return "viewBookingInfo";
    }
	
	@RequestMapping("/checkRoomAvailability")
    public @ResponseBody String checkRoomAvailability(@RequestParam String city,@RequestParam String hotelName,@RequestParam String inDate,@RequestParam String outDate) throws ParseException
    {
		
		System.out.println("city"+city+" in date "+inDate+"  hotelname"+ hotelName+" outDate"+outDate);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		 Date d=formatter.parse(inDate);
		 System.out.println("SQL Date "+new java.sql.Date(d.getTime()));
		 System.out.println("formatter format "+formatter.format(d));
		 System.out.println(" d is "+d+"    truncated date is "+truncateTime(d));
		//System.out.println("city"+city+" in date "+inDate+"  hotelname"+ hotelName+" outDate"+outDate);
		System.out.println("in date"+inDate+"  outDate "+outDate+" formatter  "+formatter.parse(inDate)+"  "+formatter.parse(outDate));
		System.out.println("going into getNoOfRooms");
		return reservationRepository.getNoOfRooms(city, hotelName,new java.sql.Date(formatter.parse(inDate).getTime()) ,new java.sql.Date(formatter.parse(outDate).getTime()));
		
    }
	
	public static Date truncateTime (Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime( date);
	    cal.set( Calendar.HOUR_OF_DAY, 0);
	    cal.set( Calendar.MINUTE, 0);
	    cal.set( Calendar.SECOND, 0);
	    cal.set( Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}
	
}
