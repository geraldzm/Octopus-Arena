package Util;

import lombok.Data;

@Data
public class FilePointer {
    private long startOffset;
    private long endOffset;

    public int getBufferSize(){
        return (int) ((endOffset - startOffset));
    }

}
