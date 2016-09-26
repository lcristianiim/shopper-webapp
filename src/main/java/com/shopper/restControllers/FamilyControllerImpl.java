package com.shopper.restControllers;

import com.shopper.models.Family;
import com.shopper.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by internship on 26.09.2016.
 */
@RestController
public class FamilyControllerImpl implements FamilyController {

    @Autowired
    private FamilyService familyService;

    @Override
    public ResponseEntity getFamilies() {
        return ResponseEntity.ok().body(familyService.findAll());
    }

    @Override
    public ResponseEntity saveFamilies(@RequestBody List<Family> families) {
        Iterable<Family> savedFamilies = familyService.save(families);
        return ResponseEntity.ok().body(savedFamilies);
    }
}