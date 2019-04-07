package eu.smallAllegro.springmvcfirst.controllers.rest;


import eu.smallAllegro.springmvcfirst.domain.Product;
import eu.smallAllegro.springmvcfirst.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ApiProduct {

    @Autowired
    private ProductService service;

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE/*, consumes = MediaType.APPLICATION_JSON_VALUE*//*W chromie nie działa consumes */)
    public List<Product> getAllProductsJson() {
        return service.listAllProducts();
    }

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_XML_VALUE/*, consumes = MediaType.APPLICATION_XML_VALUE*//*W chromie nie działa consumes */)
    public List<Product> getAllProductsXML() {
        return service.listAllProducts();
    }

    @RequestMapping(value = "/p/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Product getProductBy(@PathVariable String id) {
        Product p = service.getProductById(Integer.parseInt(id));
        Optional<Product> result = Optional.ofNullable(p);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping ( value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus ( value = HttpStatus.OK)
    public void addProduct (@RequestBody Product product) {
        service.saveOrUpdateProduct(product);
    }
}
