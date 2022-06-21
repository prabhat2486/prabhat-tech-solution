package com.prabhattechtest.springboot.readers;

import com.prabhattechtest.springboot.model.Transaction;

import static com.prabhattechtest.springboot.utils.FieldDefinition.*;

public class TransactionReader {
    public static Transaction getTransaction(StringBuilder line){
        return new Transaction(
                LineReader.readField(line, QUANTITY_LONG_STARTS, QUANTITY_LONG_ENDS),
                LineReader.readField(line, QUANTITY_SHORT_STARTS, QUANTITY_SHORT_ENDS),
                LineReader.readField(line, QUANTITY_LONG_SIGN_STARTS, QUANTITY_LONG_SIGN_ENDS),
                LineReader.readField(line, QUANTITY_SHORT_SIGN_STARTS, QUANTITY_SHORT_SIGN_ENDS)
        );
    }
}
