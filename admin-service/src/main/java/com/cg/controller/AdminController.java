package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.models.Admin;
import com.cg.services.AdminService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
    @Autowired
	private AdminService service;
    
    //Admin operations
    @PostMapping("/addadmin")
    @ApiOperation(value="Adds new admin")
    public String saveAdmin(@RequestBody Admin admin)
    {
    	service.saveAdmin(admin);
		return "Registration Succefully";
    }
	
	
}
