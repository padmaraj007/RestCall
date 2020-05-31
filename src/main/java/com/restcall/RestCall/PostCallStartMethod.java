package com.restcall.RestCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import com.example.KieContainerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostCallStartMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String username = "salaboy";
			String password = "salaboy";
			URL url = new URL(
					"http://localhost:8080/kie-server/services/rest/server/containers/rsystem-employee-management_1.0.1-SNAPSHOT");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			String encoded = Base64.getEncoder()
					.encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8)); // Java 8
			conn.setRequestProperty("Authorization", "Basic " + encoded);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String response = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				// System.out.println(output);
				response = response + output + "\n";

			}

			System.out.println(response);
			ObjectMapper mapper = new ObjectMapper();

			KieContainerResponse kieContainerResponse = mapper.readValue(response, KieContainerResponse.class);

			System.out.println(kieContainerResponse.getResult().getKieContainer().getContainerId());

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
