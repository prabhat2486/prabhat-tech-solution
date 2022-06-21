package com.prabhattechtest.springboot.readers;

import com.prabhattechtest.springboot.model.Client;

import static com.prabhattechtest.springboot.utils.FieldDefinition.*;

public class ClientReader {

    public static Client getClient(StringBuilder line){
        return new Client(
                LineReader.readField(line, CLIENT_TYPE_STARTS, CLIENT_TYPE_ENDS),
                LineReader.readField(line, CLIENT_NUMBER_STARTS, CLIENT_NUMBER_ENDS),
                LineReader.readField(line, ACCOUNT_NUMBER_STARTS, ACCOUNT_NUMBER_ENDS),
                LineReader.readField(line, SUB_ACCOUNT_NUMBER_STARTS, SUB_ACCOUNT_NUMBER_ENDS)
        );
    }
}
