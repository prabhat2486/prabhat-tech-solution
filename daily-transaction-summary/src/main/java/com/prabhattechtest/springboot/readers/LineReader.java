package com.prabhattechtest.springboot.readers;


public class LineReader {

    public static String readField(StringBuilder line, int fieldStart, int fieldEnds){
        return line.substring(fieldStart-1, fieldEnds);
    }
}
