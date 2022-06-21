package com.prabhattechtest.springboot.readers;

import com.prabhattechtest.springboot.model.Client;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientReaderTest {

    @Test
    public void getClient() throws Exception {
        StringBuilder line = new StringBuilder("315CL  432100020001SGXDC FUSGX NK    20100910JPY01B 0000000001 0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380     688032000092500000000             O");
        Client client = ClientReader.getClient(line);
        assertThat(client.getClientType()).isEqualTo("CL  ");
        assertThat(client.getClientNumber()).isEqualTo("4321");
        assertThat(client.getAccountNumber()).isEqualTo("0002");
        assertThat(client.getSubAccountNumber()).isEqualTo("0001");
    }
}
