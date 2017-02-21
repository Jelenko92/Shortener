package com.infobip.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.infobip.json.requests.URLRegistration;
import com.infobip.json.responses.URLRegistrationResponse;
import com.infobip.model.factory.URLFactory;
import com.infobip.repository.URLRepository;

/**
 * 
 * @author Jelena
 *
 */
@RestController
@EnableWebMvc
public class UrlController {

	@Autowired
	private URLRepository urlRepository;
	
	@Autowired
	URLFactory urlFactory;
	
	/**
	 * Registering new url
	 * @param request
	 * @param principal authentification principal
	 * @return {@link URLRegistrationResponse}
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public URLRegistrationResponse account(@RequestBody  URLRegistration request, Principal principal) {
		String accountId = principal.getName();
		String shortUrl = urlRepository.addURL(request.getUrl(), accountId, request.getRedirectType());
		URLRegistrationResponse response = new URLRegistrationResponse();
		response.setShortUrl(shortUrl);
		return response;
    }
	
	
	
}
