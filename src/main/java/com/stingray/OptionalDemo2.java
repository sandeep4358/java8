package com.stingray;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class OptionalDemo2 {
	public static void main(String[] args) {
		Mobile m1 = new Mobile(1212,"OnePlus5","OnePlus5",null);
		
		needToFetchTheMobileWidthOptional(m1);
		
	}
	
	public static int needToFetchTheMobileWidth(Mobile mobile) {
		if(mobile!=null) {
			MobileScreen screen = mobile.getScree();
			  if(screen!=null) {
				   ScreenResolution sresolution = screen.getSresolution();
				     if(sresolution!=null) {
				    	 	return sresolution.getWidth();
				     }
			  }
		}		
		return 0;	
	}
	
	public static void needToFetchTheMobileWidthOptional(Mobile mobile) {
		Optional<Mobile> optionalMobile = Optional.ofNullable(mobile);
		/*if(optionalMobile.isPresent())
		mobile mobile1 ;//=  optionalMobile.get();
		else
		System.out.println("Mobile is null");
		*/
	}

}


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class ScreenResolution{
	private int height;
	private int width;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class MobileScreen{
	private String size;
	private ScreenResolution sresolution;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Mobile{
	int mobileId;
	String name;
	String model;
	private MobileScreen scree;
	
}
