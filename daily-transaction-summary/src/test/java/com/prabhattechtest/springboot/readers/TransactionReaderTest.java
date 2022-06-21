package com.prabhattechtest.springboot.readers;

import com.prabhattechtest.springboot.model.Client;
import com.prabhattechtest.springboot.model.Transaction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionReaderTest {

    @Test
    public void getTransaction() throws Exception {
        StringBuilder line = new StringBuilder("315CL  432100020001SGXDC FUSGX NK    20100910JPY01B 0000000001 0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380     688032000092500000000             O");
        Transaction txn = TransactionReader.getTransaction(line);
        assertThat(txn.getSignQuantityShort()).isEqualTo(" ");
        assertThat(txn.getQuantityShort()).isEqualTo(0);
        assertThat(txn.getSignQuantityLong()).isEqualTo(" ");
        assertThat(txn.getQuantityLong()).isEqualTo(1);
        assertThat(txn.getNetTransactionAmount()).isEqualTo(1);
    }
}
