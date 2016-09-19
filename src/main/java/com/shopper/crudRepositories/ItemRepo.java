package com.shopper.crudRepositories;

import com.shopper.models.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by internship on 19.09.2016.
 */
public interface ItemRepo extends CrudRepository<Item, Long> {
}
