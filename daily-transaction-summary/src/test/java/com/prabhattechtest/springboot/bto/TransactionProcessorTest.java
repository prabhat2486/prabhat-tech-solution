package com.prabhattechtest.springboot.bto;

import com.prabhattechtest.springboot.model.DailySummary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionProcessorTest {


    @Test
    void getDailySummary() throws IOException, URISyntaxException {
        TransactionProcessor txnProcessor = new TransactionProcessor();
        ArrayList<DailySummary> dailySummary = txnProcessor.getDailySummary();
        assertThat(dailySummary.size() > 0);
    }
}