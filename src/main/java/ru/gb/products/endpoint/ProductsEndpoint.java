package ru.gb.products.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.gb.products.model.ProductsRequest;
import ru.gb.products.model.ProductsResponse;
import ru.gb.products.service.ProductService;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class ProductsEndpoint {

    @Autowired
    ProductService productService;

    private static final String NAMESPACE = "http://localhost:8080/api/products";

    @PayloadRoot(namespace = NAMESPACE, localPart = "productsRequest")
    @ResponsePayload
    public ProductsResponse getProducts(@RequestPayload ProductsRequest request)
            throws DatatypeConfigurationException {
        ProductsResponse response = new ProductsResponse();
        response.setProducts(productService.getProducts(request.getTitle()));
        return response;
    }
}
