package com.prabhattechtest.springboot.readers;

import com.prabhattechtest.springboot.model.Client;
import com.prabhattechtest.springboot.model.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductReaderTest {

    @Test
    public void getProduct() throws Exception {
        StringBuilder line = new StringBuilder("315CL  432100020001SGXDC FUSGX NK    20100910JPY01B 0000000001 0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380     688032000092500000000             O");
        Product product = ProductReader.getProduct(line);
        assertThat(product.getExchangeCode()).isEqualTo("SGX ");
        assertThat(product.getProductGroup()).isEqualTo("FU");
        assertThat(product.getExpirationDate()).isEqualTo("20100910");
        assertThat(product.getSymbol()).isEqualTo("NK    ");
    }
}
