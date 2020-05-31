package com.restcall.RestCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.example.KieContainerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jbpm.request.ComJbpmWorkspaceApiCallingEmployee;
import com.jbpm.request.Employee;
import com.jbpm.request.Employee_;

public class PostCallNewInstance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String username = "wbadmin";
			String password = "wbadmin";
			
			ComJbpmWorkspaceApiCallingEmployee emp = new ComJbpmWorkspaceApiCallingEmployee();
			
			emp.setAddress("nappur");
			emp.setAge(20);
			emp.setId(2);
			emp.setName("padam");
			emp.setSalary(200);
			
			Employee_ emp1 = new Employee_();
			emp1.setComJbpmWorkspaceApiCallingEmployee(emp);
			
			
			Employee emp2 = new Employee();
			emp2.setEmployee(emp1);
	
			
	        ObjectMapper mapper = new ObjectMapper();

			 String jsonString = mapper.writeValueAsString(emp2);
			 System.out.println("data object " +jsonString);
					 
			
			URL url = new URL("http://localhost:8080/kie-server/services/rest/server/containers/api-calling_1.0.2-SNAPSHOT/processes/api-calling.api-call/instances");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));  //Java 8
			conn.setRequestProperty("Authorization", "Basic "+encoded);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			
			OutputStream os = conn.getOutputStream();
			os.write(jsonString.getBytes());
			os.flush();

			
			if (conn.getResponseCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String response = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

			//	System.out.println(output);
				response = response + output+"\n" ;
			
			
			}
			 
			System.out.println(response);
//	        ObjectMapper mapper = new ObjectMapper();

	       // KieContainerResponse kieContainerResponse = mapper.readValue(response, KieContainerResponse.class);
            
           //System.out.println(kieContainerResponse.getResult().getKieContainer().getContainerId());
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}


	}

}
