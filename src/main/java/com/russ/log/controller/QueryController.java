package com.russ.log.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.russ.log.service.QueryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class QueryController {
	
	@Autowired
	private QueryService queryService;

	@Operation(summary = "Enter a correct Query To pass Command")
	@PostMapping("/EnterQuery")
	public List<Map<String, Object>> InputQuery(@RequestBody String query) {
		return queryService.runQuery(query);

	}
}
