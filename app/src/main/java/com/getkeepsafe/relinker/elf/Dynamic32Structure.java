/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 */
package app.dukhaan.src.java.com.getkeepsafe.relinker.elf;

import com.getkeepsafe.relinker.elf.Elf;
import com.getkeepsafe.relinker.elf.ElfParser;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Dynamic32Structure
extends Elf.DynamicStructure {
    public Dynamic32Structure(ElfParser elfParser, Elf.Header header, long l, int n) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)4);
        ByteOrder byteOrder = header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order(byteOrder);
        long l2 = l + (long)(n * 8);
        this.tag = elfParser.readWord(byteBuffer, l2);
        this.val = elfParser.readWord(byteBuffer, l2 + 4L);
    }
}

