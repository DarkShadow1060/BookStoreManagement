package com.nagarro.bookmanagement.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.nagarro.bookmanagementsystem.entities.BookEntity;

public class JSONresolver {
	

	private URL seatURL ;
	
	public JSONresolver(String getUrl) throws MalformedURLException {
		
		this.seatURL =  new URL(getUrl);
	}
	
	public void convertJSON(ModelAndView m) throws Exception {
		// Return the JSON Response from the API
		try(BufferedReader br= new BufferedReader(new InputStreamReader(seatURL.openStream(), StandardCharsets.UTF_8))) {
			jsonToBean(m, br);
		}
		catch(Exception e) {
			System.out.println("cant read null values");
		}
		
	}

	private void jsonToBean(ModelAndView m, BufferedReader br) throws IOException {
		String readAPIResponse =" ";
		StringBuilder jsonString = new StringBuilder();
		while ((readAPIResponse = br.readLine()) != null) {
			jsonString.append(readAPIResponse);
		}
		JSONArray jsonArray = new JSONArray(jsonString.toString());
		@SuppressWarnings("unchecked" )
		List<LinkedTreeMap> yourList = new Gson().fromJson(jsonArray.toString(), ArrayList.class);
		List<BookEntity> bk = new ArrayList<>();

		for (LinkedTreeMap l : yourList) {
			BookEntity book = new BookEntity();
			book.setBookCode(String.valueOf(String.valueOf(l.get("bookCode"))));
			book.setBookName(String.valueOf(String.valueOf(l.get("bookName"))));
			book.setAuthorName(String.valueOf(String.valueOf(l.get("authorName"))));
			book.setCurrDate(String.valueOf(String.valueOf(l.get("currDate"))));
			bk.add(book);
		}
		m.addObject("book", bk);
		System.out.println(bk);
	}
}
