package Util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilePointer {
    private long startOffset;
    private long endOffset;

    public int getBufferSize(){
        return (int) ((endOffset - startOffset));
    }
}
