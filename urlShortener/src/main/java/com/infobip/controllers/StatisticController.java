package com.infobip.controllers;

import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.infobip.model.Account;
import com.infobip.repository.RepositoryAccount;

@RestController
@EnableWebMvc
@RequestMapping("/statistic")
public class StatisticController {

	@Autowired
	private RepositoryAccount accountRepository;

	/**
	 * Get statistics for some account Statistic contains map where key is
	 * registered url, value is number of total visits
	 * 
	 * @param accountId
	 *            account id
	 * @return
	 */
	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody String getVisitingStatistics(@PathVariable(name = "accountId") String accountId) {
		Account acc = accountRepository.getAccount(accountId);
		Map<String, Long> visitingStatistics = acc.getStatistics();
		return mapToJson(visitingStatistics);

	}

	/**
	 * Converting map to json format
	 * 
	 * @param visitingStatistics
	 *            map for converting
	 * @return json map in json string
	 */
	private String mapToJson(Map<String, Long> visitingStatistics) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(visitingStatistics);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

}
