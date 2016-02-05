package com.mkyong.common.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value = { Throwable.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody void badRequest(HttpServletRequest request, @ModelAttribute Object model,
			Throwable e) {
		printHeader(request);
		printPayload(request);
		System.out.println("Exception : "+e.toString());
	}

	private void printHeader(HttpServletRequest request) {
		
		System.out.println(request.getCharacterEncoding());
		
	}

	private Employee buildEmployee() {
		Employee e = new Employee();
		e.setName("name");
		e.setId(11);
		e.setDepartment("dept");
		return e;
	}

	private void printPayload(HttpServletRequest request) {

		try {
			/*
			 * StringBuilder sb = new StringBuilder(); BufferedReader reader =
			 * request.getReader(); try { String line; while ((line =
			 * reader.readLine()) != null) { sb.append(line).append('\n'); } }
			 * finally { reader.close(); }
			 */

			ObjectMapper mapper = new ObjectMapper();
			String sb = mapper.readValue(request.getInputStream(), String.class);
			System.out.println(sb);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}