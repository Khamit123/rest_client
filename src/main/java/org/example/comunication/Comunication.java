package org.example.comunication;

import org.example.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class Comunication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/employees";

    public List<Employees> getEmployees() {
        ResponseEntity<List<Employees>> response
                = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employees>>() {
        });
        return response.getBody();
    }

    public Employees getEmployeeById(int id) {
        Employees employees = null;
        try {
            employees = restTemplate.getForObject(URL + "/" + id, Employees.class);
        } catch (HttpClientErrorException e) {

            System.out.println(e.getMessage());
        }
        return employees;
    }

    public Employees addEmployee(Employees employees) {
        ResponseEntity<Employees> response = restTemplate.postForEntity(URL, employees, Employees.class);
        return response.getBody();
    }
    public String deleteEmployee(int id) {
        ResponseEntity<String> response = restTemplate.exchange(URL+"/"+id,HttpMethod.DELETE ,null, String.class);
        return response.getBody();
    }
}
