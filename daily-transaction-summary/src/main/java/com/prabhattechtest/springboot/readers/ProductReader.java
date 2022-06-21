package com.prabhattechtest.springboot.readers;

import com.prabhattechtest.springboot.model.Product;

import static com.prabhattechtest.springboot.utils.FieldDefinition.*;

public class ProductReader {

    public static Product getProduct(StringBuilder line){
        return new Product(
                LineReader.readField(line, EXCHANGE_CODE_STARTS, EXCHANGE_CODE_ENDS),
                LineReader.readField(line, PRODUCT_GROUP_CODE_STARTS, PRODUCT_GROUP_CODE_ENDS),
                LineReader.readField(line, SYMBOL_STARTS, SYMBOL_ENDS),
                LineReader.readField(line, EXPIRATION_DATE_STARTS, EXPIRATION_DATE_ENDS)
        );
    }
}
