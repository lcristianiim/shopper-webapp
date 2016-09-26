package com.shopper.restControllers;

import com.shopper.models.Family;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by internship on 26.09.2016.
 */
@RequestMapping(value = "/families")
public interface FamilyController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity getFamilies();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity saveFamilies(List<Family> families);
}