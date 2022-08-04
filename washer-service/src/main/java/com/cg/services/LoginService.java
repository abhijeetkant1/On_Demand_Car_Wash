package com.cg.services;



import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.repository.WasherRepo;
import com.cg.models.WasherLogin;
import com.cg.models.Washers;


@Service
public class LoginService {
	@Autowired
	private WasherRepo washerRepository;

	public String userWasher(WasherLogin login) {
		ArrayList<Washers> list = (ArrayList<Washers>) washerRepository.findAll();
		int count = 0;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getName().equals(login.getName())
					&& list.get(i).getPassword().equals(login.getPassword())) {

				count++;
			}
		}

		if (count == 1) {
			return "logged in";
		} else {
			return "wrong credentials";
		}

	}

}
