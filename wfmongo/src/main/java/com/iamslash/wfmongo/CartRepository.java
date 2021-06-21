package com.iamslash.wfmongo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author iamslash
 */
public interface CartRepository extends ReactiveCrudRepository<Cart, String> {

}