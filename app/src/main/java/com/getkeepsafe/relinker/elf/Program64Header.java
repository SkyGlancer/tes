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

public class Program64Header
extends Elf.ProgramHeader {
    public Program64Header(ElfParser elfParser, Elf.Header header, long l) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)8);
        ByteOrder byteOrder = header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order(byteOrder);
        long l2 = header.phoff + l * (long)header.phentsize;
        this.type = elfParser.readWord(byteBuffer, l2);
        this.offset = elfParser.readLong(byteBuffer, 8L + l2);
        this.vaddr = elfParser.readLong(byteBuffer, 16L + l2);
        this.memsz = elfParser.readLong(byteBuffer, l2 + 40L);
    }
}

