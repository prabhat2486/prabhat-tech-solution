package com.prabhattechtest.springboot.readers;

import com.prabhattechtest.springboot.model.Client;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineReaderTest {

    @Test
    public void getLine() throws Exception {
        StringBuilder line = new StringBuilder("315CL  432100020001SGXDC FUSGX NK    20100910JPY01B 0000000001 0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380     688032000092500000000             O");

        assertThat(LineReader.readField(line, 1, 3)).isEqualTo("315");
    }
}
