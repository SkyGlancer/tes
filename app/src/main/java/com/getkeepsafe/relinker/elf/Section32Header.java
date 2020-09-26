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

public class Section32Header
extends Elf.SectionHeader {
    public Section32Header(ElfParser elfParser, Elf.Header header, int n) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)4);
        ByteOrder byteOrder = header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order(byteOrder);
        this.info = elfParser.readWord(byteBuffer, 28L + (header.shoff + (long)(n * header.shentsize)));
    }
}

