package com.infobip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.infobip.model.URL;
import com.infobip.repository.URLRepository;

/**
 * Controller for view that is used for redirecting.
 * Used for communication with client
 * @author Jelena
 *
 */
@Controller
public class UserController {

	@Autowired
	URLRepository urlRepository;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String showForm() {
		return "redirect";
	}

	/**
	 * Redirecting to url or staying on this view
	 * @param url url to be redirected
	 * @param model view Model
	 * @return {@link RedirectView} if redirecting sucessfully
	 */
	@RequestMapping(value = "/redirect", method = RequestMethod.POST)
	public Object showFormPost(@RequestParam("url") String url, ModelMap model) {

		url = url.trim();
		
		if (isValidURL(url)) {
			URL shortUrl = urlRepository.getURLByShortURL(url);
			shortUrl.visited();
			
			if(shortUrl.getRedirectType() == 301){
				RedirectView rv = new RedirectView(shortUrl.getUrl());
				rv.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
				return rv;
			}else{
				model.addAttribute("errorMsg", "The requested url " + url + " resides temporarily under a different URI. Try later");
				return "redirect";
			}		


		} else {
			 model.addAttribute("errorMsg", "Short url " + url  + " does not exists, please try again.");
			return "redirect";
		}

	}
	

	/**
	 * Check if short url is valid
	 * @param shortUrl
	 * @return true if url is valid, otherwise false
	 */
	private boolean isValidURL(String shortUrl) {
		return urlRepository.shortURLExists(shortUrl);
	}
}
