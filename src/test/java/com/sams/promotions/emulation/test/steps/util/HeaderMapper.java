package com.sams.promotions.emulation.test.steps.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class HeaderMapper {

	public Map<String, Object> mapHeaders(String filePath) {

		Map<String, Object> requestHeader = null;
		BufferedReader bufferedReader;
		String line = "";
		try {
			requestHeader = new HashMap<String, Object>();
			bufferedReader = new BufferedReader(new FileReader(filePath));

			while ((line = bufferedReader.readLine()) != null) {
				String[] arrLine = line.split(":");
				requestHeader.put(arrLine[0].trim(), arrLine[1].trim());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return requestHeader;

	}

}
