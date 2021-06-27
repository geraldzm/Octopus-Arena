package Util;

import lombok.Data;
import java.io.Serializable;

@Data
public class FilePointer implements Serializable {
    private long startOffset;
    private long endOffset;

    public int getBufferSize(){
        return (int) ((endOffset - startOffset));
    }

    public void copy(FilePointer filePointer) {
        startOffset = filePointer.startOffset;
        endOffset = filePointer.endOffset;
    }

}
