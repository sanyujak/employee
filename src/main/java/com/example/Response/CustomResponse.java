package com.example.Response;



/**
 * @author Sanyuja Kharat
 *
 */
public class CustomResponse {
	
	int code;
	String message;
	Object response_body;
	
	
	
	public CustomResponse(int code, String message, Object response_body) {
		super();
		this.code = code;
		this.message = message;
		this.response_body = response_body;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResponse_body() {
		return response_body;
	}
	public void setResponse_body(Object response_body) {
		this.response_body = response_body;
	}
	@Override
	public String toString() {
		return "CustomResponse [code=" + code + ", message=" + message + ", response_body=" + response_body + "]";
	}
	
	
	
	
	
	
	
    
	
	

}
