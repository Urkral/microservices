package application;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product documentToApi(ProductDocument document);

    ProductDocument apiToDocument(Product api);

    List<Product> documentListToApiList(List<ProductDocument> documents);
}
