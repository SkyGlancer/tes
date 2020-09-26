/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package app.dukhaan.src.java.com.getkeepsafe.relinker.elf;

import com.getkeepsafe.relinker.elf.Elf;
import com.getkeepsafe.relinker.elf.Elf32Header;
import com.getkeepsafe.relinker.elf.Elf64Header;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ElfParser
implements Closeable,
Elf {
    private final int MAGIC = 1179403647;
    private final FileChannel channel;

    public ElfParser(File file) throws FileNotFoundException {
        if (file != null && file.exists()) {
            this.channel = new FileInputStream(file).getChannel();
            return;
        }
        throw new IllegalArgumentException("File is null or does not exist");
    }

    private long offsetFromVma(Elf.Header header, long l, long l2) throws IOException {
        IllegalStateException illegalStateException;
        for (long i = 0L; i < l; ++i) {
            Elf.ProgramHeader programHeader = header.getProgramHeader(i);
            if (programHeader.type != 1L || programHeader.vaddr > l2 || l2 > programHeader.vaddr + programHeader.memsz) continue;
            return l2 - programHeader.vaddr + programHeader.offset;
        }
        illegalStateException = new IllegalStateException("Could not map vma to file offset!");
        throw illegalStateException;
    }

    public void close() throws IOException {
        this.channel.close();
    }

    public Elf.Header parseHeader() throws IOException {
        this.channel.position(0L);
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)8);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        if (this.readWord(byteBuffer, 0L) == 1179403647L) {
            short s = this.readByte(byteBuffer, 4L);
            boolean bl = this.readByte(byteBuffer, 5L) == 2;
            if (s == 1) {
                return new Elf32Header(bl, this);
            }
            if (s == 2) {
                return new Elf64Header(bl, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> parseNeededDependencies() throws IOException {
        Elf.Header header;
        long l;
        int n;
        long l2;
        ByteBuffer byteBuffer;
        ArrayList arrayList;
        block10 : {
            this.channel.position(0L);
            arrayList = new ArrayList();
            header = this.parseHeader();
            byteBuffer = ByteBuffer.allocate((int)8);
            ByteOrder byteOrder = header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
            byteBuffer.order(byteOrder);
            l = header.phnum;
            n = 0;
            if (l == 65535L) {
                l = header.getSectionHeader((int)0).info;
            }
            for (long i = 0L; i < l; ++i) {
                Elf.ProgramHeader programHeader = header.getProgramHeader(i);
                if (programHeader.type != 2L) continue;
                l2 = programHeader.offset;
                break block10;
            }
            l2 = 0L;
        }
        if (l2 == 0L) {
            return Collections.unmodifiableList((List)arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long l3 = 0L;
        do {
            Elf.DynamicStructure dynamicStructure = header.getDynamicStructure(l2, n);
            long l4 = l2;
            if (dynamicStructure.tag == 1L) {
                arrayList2.add((Object)dynamicStructure.val);
            } else if (dynamicStructure.tag == 5L) {
                l3 = dynamicStructure.val;
            }
            ++n;
            if (dynamicStructure.tag == 0L) {
                if (l3 != 0L) {
                    long l5 = this.offsetFromVma(header, l, l3);
                    Iterator iterator = arrayList2.iterator();
                    while (iterator.hasNext()) {
                        arrayList.add((Object)this.readString(byteBuffer, l5 + (Long)iterator.next()));
                    }
                    return arrayList;
                }
                throw new IllegalStateException("String table offset not found!");
            }
            l2 = l4;
        } while (true);
    }

    protected void read(ByteBuffer byteBuffer, long l, int n) throws IOException {
        int n2;
        byteBuffer.position(0);
        byteBuffer.limit(n);
        for (long i = 0L; i < (long)n; i += (long)n2) {
            n2 = this.channel.read(byteBuffer, l + i);
            if (n2 != -1) {
                continue;
            }
            throw new EOFException();
        }
        byteBuffer.position(0);
    }

    protected short readByte(ByteBuffer byteBuffer, long l) throws IOException {
        this.read(byteBuffer, l, 1);
        return (short)(255 & byteBuffer.get());
    }

    protected int readHalf(ByteBuffer byteBuffer, long l) throws IOException {
        this.read(byteBuffer, l, 2);
        return 65535 & byteBuffer.getShort();
    }

    protected long readLong(ByteBuffer byteBuffer, long l) throws IOException {
        this.read(byteBuffer, l, 8);
        return byteBuffer.getLong();
    }

    protected String readString(ByteBuffer byteBuffer, long l) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        do {
            long l2 = 1L + l;
            short s = this.readByte(byteBuffer, l);
            if (s == 0) break;
            stringBuilder.append((char)s);
            l = l2;
        } while (true);
        return stringBuilder.toString();
    }

    protected long readWord(ByteBuffer byteBuffer, long l) throws IOException {
        this.read(byteBuffer, l, 4);
        return 0xFFFFFFFFL & (long)byteBuffer.getInt();
    }
}

