package com.neo.user.util;


import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author By15
 * @date 2021/9/14 14:36
 */
@Data
public class Response {

	private static final Integer RESPONSE_SUCCESS = HttpStatus.OK.value();

	private static final Integer RESPONSE_FAIL = HttpStatus.BAD_REQUEST.value();

	private int status;

	private Object data;

	private String message;

	private Response(){

	}

	public static Response sucess(Object data){
		Response response = new Response();
		response.setData(data);
		response.setStatus(RESPONSE_SUCCESS);
		return response;
	}

	public static Response fail(Object data){
		Response response = new Response();
		response.setData(data);
		response.setStatus(RESPONSE_FAIL);
		return response;
	}

}
