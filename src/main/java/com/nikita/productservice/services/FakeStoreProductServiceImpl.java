package com.nikita.productservice.services;

import com.nikita.productservice.client.fakestoreapi.FakeStoreClient;
import com.nikita.productservice.client.fakestoreapi.FakeStoreProductDto;
import com.nikita.productservice.dto.ProductDto;
import com.nikita.productservice.models.Category;
import com.nikita.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service


public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder,FakeStoreClient fakeStoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url,
                                                  @Nullable Object request,Class<T> responseType,
                                                  Object... uriVariables)
            throws RestClientException {
       RestTemplate restTemplate = restTemplateBuilder.requestFactory(
               HttpComponentsClientHttpRequestFactory.class).build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url,httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private Product ConvertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);

        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        product.setTitle(productDto.getTitle());
        return product;

    }



    @Override
    public List<Product> getAllProduct() {

        List<FakeStoreProductDto> fakeStoreProductDtos=fakeStoreClient.getAllProduct();

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto[]> l=restTemplate.getForEntity(
//                "https://fakestoreapi.com/products",
//                FakeStoreProductDto[].class
//        );
        List<Product> ans = new ArrayList<>();
        for (FakeStoreProductDto productDto:fakeStoreProductDtos){
            ans.add(ConvertFakeStoreProductDtoToProduct(productDto));

        }

//        for(FakeStoreProductDto productDto: l.getBody()){
//                ans.add(ConvertFakeStoreProductDtoToProduct(productDto));
//        }
        return ans;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                FakeStoreProductDto.class, productId);

        FakeStoreProductDto productDto = response.getBody();

        if(productDto==null){
            return Optional.empty();

        }


        return Optional.of(ConvertFakeStoreProductDtoToProduct(productDto));


    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.postForEntity("https://fakestoreapi.com/products", product,
                FakeStoreProductDto.class);
        FakeStoreProductDto productDto = response.getBody();

        return ConvertFakeStoreProductDtoToProduct(productDto);

    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        //RestTemplate restTemplate = restTemplateBuilder.build();
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class).build();


        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setId(productId);
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setTitle(product.getTitle());
//        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=requestForEntity(
//                HttpMethod.PATCH,
//                "https://fakestoreapi.com/products/{id}",
//                fakeStoreProductDto,
//                FakeStoreProductDto.class,
//                productId
//
//        );
        FakeStoreProductDto fakeStoreProductResponseDto=restTemplate.patchForObject(
               "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId

        );
        return ConvertFakeStoreProductDtoToProduct(fakeStoreProductResponseDto);


//        return ConvertFakeStoreProductDtoToProduct(fakeStoreProductDtoResponseEntity.getBody());
    }

    @Override
    public Product ReplaceProduct(Long productId, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
       return null;
    }


    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
