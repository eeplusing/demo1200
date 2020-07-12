package com.eplusing.designpattern.builder;

import java.util.Arrays;
import java.util.List;

import com.eplusing.designpattern.builder.product.Media;
import com.eplusing.designpattern.builder.product.MediaItem;

import junit.framework.TestCase;

public class BuilderTest extends TestCase{

	private List input = Arrays.asList(new MediaItem[]{
			new MediaItem("item1"),
			new MediaItem("item2"),
			new MediaItem("item3"),
			new MediaItem("item4")
	});
	
	public void testBook(){
		MediaDirector md = new MediaDirector(new BookBuilder());
		
		Media book = md.produceMedia(input);
		String result = "book:" +  book;
		System.out.println(result);
		
		assertEquals(result, "book:[item1, item2, item3, item4]");
	}
	
	
	public void testMagazine(){
		MediaDirector md = new MediaDirector(new MagazineBuilder());
		
		Media magazine = md.produceMedia(input);
		String result = "book:" +  magazine;
		System.out.println(result);
		
		assertEquals(result, "magazine:[item1, item2, item3, item4]");
	}
	
	
	public void testWebSite(){
		MediaDirector md = new MediaDirector(new WebSiteBuilder());
		
		Media webSite = md.produceMedia(input);
		String result = "book:" +  webSite;
		System.out.println(result);
		
		assertEquals(result, "webSite:[item1, item2, item3, item4]");
	}
	
	
	public static void main(String[] a){
		
	}
	
	
	
}
