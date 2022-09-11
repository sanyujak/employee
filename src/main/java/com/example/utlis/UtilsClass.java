package com.example.utlis;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.Exception.CustomException;


/**
 * @author Sanyuja Kharat
 *
 */
@Component
public class UtilsClass {

	public boolean utilmethod(String email) throws CustomException {

		String pattern = "^[_A-Za-z0-9-]*[a-zA-Z]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		boolean status = StringUtils.isEmpty(email);
		if (status)
			throw new CustomException("Email id is empty");

		return Pattern.matches(pattern, email);
	}

}
