package com.russ.log.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.russ.log.exception.InvalidQueryException;

@Service
public class QueryService {
	


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
   
	public boolean isValidSql(String sql) {
		try {
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	
	public List<Map<String, Object>> runQuery(String query) {
		String[] blockedKeywords = { "UPDATE", "CREATE", "DELETE" };
		String patternString = "\\b(" + String.join("|", blockedKeywords) + ")\\b";

		if (query.matches("(?i).*" + patternString + ".*")) {
			List<Map<String, Object>> emptyMap = new ArrayList<>();
			return emptyMap;
		} else {
			if (!isValidSql(query)) {
				throw new InvalidQueryException("Invalid query: " + query);
			}

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

			return rows;
		}
	}
}
