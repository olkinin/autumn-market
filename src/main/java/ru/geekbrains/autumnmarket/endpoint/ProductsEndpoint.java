package ru.geekbrains.autumnmarket.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.autumnmarket.soap.GetAllProductRequest;
import ru.geekbrains.autumnmarket.soap.GetAllProductResponse;
import ru.geekbrains.autumnmarket.soap.GetProductByIdRequest;
import ru.geekbrains.autumnmarket.soap.GetProductByIdResponse;
import ru.geekbrains.autumnmarket.soapServiceAndRepository.SoapProductService;

@Endpoint
@RequiredArgsConstructor
public class ProductsEndpoint {

    private static final String NAMESPACE_URI = "http://autumn-market-Security/products";
    private final SoapProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getProductById(@RequestPayload GetProductByIdRequest request) {
        GetProductByIdResponse response = new GetProductByIdResponse();
        response.setId(productService.getById(request.getId()));
        return response;
    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductRequest")
    @ResponsePayload
    public GetAllProductResponse getAllProducts(@RequestPayload GetAllProductRequest request) {
        GetAllProductResponse response = new GetAllProductResponse();
        productService.getAllProducts().forEach(response.getId()::add);
        return response;
    }
}

