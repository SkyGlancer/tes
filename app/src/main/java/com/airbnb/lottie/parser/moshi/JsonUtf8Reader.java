/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.ByteString
 *  okio.Options
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonDataException;
import com.airbnb.lottie.parser.moshi.JsonEncodingException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

final class JsonUtf8Reader
extends JsonReader {
    private static final ByteString CLOSING_BLOCK_COMMENT;
    private static final ByteString DOUBLE_QUOTE_OR_SLASH;
    private static final ByteString LINEFEED_OR_CARRIAGE_RETURN;
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_BUFFERED_NAME = 15;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 18;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 16;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 17;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private static final ByteString SINGLE_QUOTE_OR_SLASH;
    private static final ByteString UNQUOTED_STRING_TERMINALS;
    private final Buffer buffer;
    private int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private final BufferedSource source;

    static {
        SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8((String)"'\\");
        DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8((String)"\"\\");
        UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8((String)"{}[]:, \n\t\r\f/\\;#=");
        LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8((String)"\n\r");
        CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8((String)"*/");
    }

    JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.source = bufferedSource;
            this.buffer = bufferedSource.getBuffer();
            this.pushScope(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void checkLenient() throws IOException {
        if (this.lenient) {
            return;
        }
        throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private int doPeek() throws IOException {
        int n;
        int n2;
        block32 : {
            block37 : {
                block30 : {
                    block36 : {
                        block35 : {
                            block33 : {
                                block34 : {
                                    block31 : {
                                        block29 : {
                                            n = this.scopes[this.stackSize - 1];
                                            if (n != 1) break block29;
                                            this.scopes[this.stackSize - 1] = 2;
                                            break block30;
                                        }
                                        if (n != 2) break block31;
                                        int n3 = this.nextNonWhitespace(true);
                                        this.buffer.readByte();
                                        if (n3 != 44) {
                                            if (n3 != 59) {
                                                if (n3 == 93) {
                                                    this.peeked = 4;
                                                    return 4;
                                                }
                                                throw this.syntaxError("Unterminated array");
                                            }
                                            this.checkLenient();
                                        }
                                        break block30;
                                    }
                                    if (n == 3 || n == 5) break block32;
                                    if (n != 4) break block33;
                                    this.scopes[this.stackSize - 1] = 5;
                                    int n4 = this.nextNonWhitespace(true);
                                    this.buffer.readByte();
                                    if (n4 == 58) break block30;
                                    if (n4 != 61) break block34;
                                    this.checkLenient();
                                    if (this.source.request(1L) && this.buffer.getByte(0L) == 62) {
                                        this.buffer.readByte();
                                    }
                                    break block30;
                                }
                                throw this.syntaxError("Expected ':'");
                            }
                            if (n != 6) break block35;
                            this.scopes[this.stackSize - 1] = 7;
                            break block30;
                        }
                        if (n != 7) break block36;
                        if (this.nextNonWhitespace(false) == -1) {
                            this.peeked = 18;
                            return 18;
                        }
                        this.checkLenient();
                        break block30;
                    }
                    if (n == 8) break block37;
                }
                int n5 = this.nextNonWhitespace(true);
                if (n5 != 34) {
                    if (n5 != 39) {
                        if (n5 != 44 && n5 != 59) {
                            if (n5 != 91) {
                                if (n5 != 93) {
                                    if (n5 != 123) {
                                        int n6 = this.peekKeyword();
                                        if (n6 != 0) {
                                            return n6;
                                        }
                                        int n7 = this.peekNumber();
                                        if (n7 != 0) {
                                            return n7;
                                        }
                                        if (this.isLiteral(this.buffer.getByte(0L))) {
                                            this.checkLenient();
                                            this.peeked = 10;
                                            return 10;
                                        }
                                        throw this.syntaxError("Expected value");
                                    }
                                    this.buffer.readByte();
                                    this.peeked = 1;
                                    return 1;
                                }
                                if (n == 1) {
                                    this.buffer.readByte();
                                    this.peeked = 4;
                                    return 4;
                                }
                            } else {
                                this.buffer.readByte();
                                this.peeked = 3;
                                return 3;
                            }
                        }
                        if (n != 1 && n != 2) {
                            throw this.syntaxError("Unexpected value");
                        }
                        this.checkLenient();
                        this.peeked = 7;
                        return 7;
                    }
                    this.checkLenient();
                    this.buffer.readByte();
                    this.peeked = 8;
                    return 8;
                }
                this.buffer.readByte();
                this.peeked = 9;
                return 9;
            }
            throw new IllegalStateException("JsonReader is closed");
        }
        this.scopes[this.stackSize - 1] = 4;
        if (n == 5) {
            int n8 = this.nextNonWhitespace(true);
            this.buffer.readByte();
            if (n8 != 44) {
                if (n8 != 59) {
                    if (n8 == 125) {
                        this.peeked = 2;
                        return 2;
                    }
                    throw this.syntaxError("Unterminated object");
                }
                this.checkLenient();
            }
        }
        if ((n2 = this.nextNonWhitespace(true)) != 34) {
            if (n2 != 39) {
                if (n2 != 125) {
                    this.checkLenient();
                    if (this.isLiteral((char)n2)) {
                        this.peeked = 14;
                        return 14;
                    }
                    throw this.syntaxError("Expected name");
                }
                if (n != 5) {
                    this.buffer.readByte();
                    this.peeked = 2;
                    return 2;
                }
                throw this.syntaxError("Expected name");
            }
            this.buffer.readByte();
            this.checkLenient();
            this.peeked = 12;
            return 12;
        }
        this.buffer.readByte();
        this.peeked = 13;
        return 13;
    }

    private int findName(String string2, JsonReader.Options options) {
        int n = options.strings.length;
        for (int i = 0; i < n; ++i) {
            if (!string2.equals((Object)options.strings[i])) continue;
            this.peeked = 0;
            this.pathNames[-1 + this.stackSize] = string2;
            return i;
        }
        return -1;
    }

    private int findString(String string2, JsonReader.Options options) {
        int n = options.strings.length;
        for (int i = 0; i < n; ++i) {
            if (!string2.equals((Object)options.strings[i])) continue;
            this.peeked = 0;
            int[] arrn = this.pathIndices;
            int n2 = -1 + this.stackSize;
            arrn[n2] = 1 + arrn[n2];
            return i;
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean isLiteral(int var1_1) throws IOException {
        if (var1_1 == 9) return false;
        if (var1_1 == 10) return false;
        if (var1_1 == 12) return false;
        if (var1_1 == 13) return false;
        if (var1_1 == 32) return false;
        if (var1_1 == 35) ** GOTO lbl-1000
        if (var1_1 == 44) return false;
        if (var1_1 == 47 || var1_1 == 61) ** GOTO lbl-1000
        if (var1_1 == 123) return false;
        if (var1_1 == 125) return false;
        if (var1_1 == 58) return false;
        if (var1_1 == 59) ** GOTO lbl-1000
        switch (var1_1) {
            default: {
                return true;
            }
            case 92: lbl-1000: // 4 sources:
            {
                this.checkLenient();
            }
            case 91: 
            case 93: 
        }
        return false;
    }

    private int nextNonWhitespace(boolean bl) throws IOException {
        EOFException eOFException;
        block0 : do {
            int n = 0;
            BufferedSource bufferedSource;
            int n2;
            while ((bufferedSource = this.source).request((long)(n2 = n + 1))) {
                byte by = this.buffer.getByte((long)n);
                if (by != 10 && by != 32 && by != 13 && by != 9) {
                    this.buffer.skip((long)(n2 - 1));
                    if (by == 47) {
                        if (!this.source.request(2L)) {
                            return by;
                        }
                        this.checkLenient();
                        byte by2 = this.buffer.getByte(1L);
                        if (by2 != 42) {
                            if (by2 != 47) {
                                return by;
                            }
                            this.buffer.readByte();
                            this.buffer.readByte();
                            this.skipToEndOfLine();
                            continue block0;
                        }
                        this.buffer.readByte();
                        this.buffer.readByte();
                        if (this.skipToEndOfBlockComment()) continue block0;
                        throw this.syntaxError("Unterminated comment");
                    }
                    if (by == 35) {
                        this.checkLenient();
                        this.skipToEndOfLine();
                        continue block0;
                    }
                    return by;
                }
                n = n2;
            }
            break;
        } while (true);
        if (!bl) {
            return -1;
        }
        eOFException = new EOFException("End of input");
        throw eOFException;
    }

    private String nextQuotedValue(ByteString byteString) throws IOException {
        JsonEncodingException jsonEncodingException;
        long l;
        StringBuilder stringBuilder = null;
        while ((l = this.source.indexOfElement(byteString)) != -1L) {
            if (this.buffer.getByte(l) == 92) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.buffer.readUtf8(l));
                this.buffer.readByte();
                stringBuilder.append(this.readEscapeCharacter());
                continue;
            }
            if (stringBuilder == null) {
                String string2 = this.buffer.readUtf8(l);
                this.buffer.readByte();
                return string2;
            }
            stringBuilder.append(this.buffer.readUtf8(l));
            this.buffer.readByte();
            return stringBuilder.toString();
        }
        jsonEncodingException = this.syntaxError("Unterminated string");
        throw jsonEncodingException;
    }

    private String nextUnquotedValue() throws IOException {
        long l = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        if (l != -1L) {
            return this.buffer.readUtf8(l);
        }
        return this.buffer.readUtf8();
    }

    private int peekKeyword() throws IOException {
        String string2;
        int n;
        String string3;
        byte by = this.buffer.getByte(0L);
        if (by != 116 && by != 84) {
            if (by != 102 && by != 70) {
                if (by != 110 && by != 78) {
                    return 0;
                }
                n = 7;
                string2 = "null";
                string3 = "NULL";
            } else {
                n = 6;
                string2 = "false";
                string3 = "FALSE";
            }
        } else {
            n = 5;
            string2 = "true";
            string3 = "TRUE";
        }
        int n2 = string2.length();
        int n3 = 1;
        while (n3 < n2) {
            BufferedSource bufferedSource = this.source;
            int n4 = n3 + 1;
            if (!bufferedSource.request((long)n4)) {
                return 0;
            }
            byte by2 = this.buffer.getByte((long)n3);
            if (by2 != string2.charAt(n3) && by2 != string3.charAt(n3)) {
                return 0;
            }
            n3 = n4;
        }
        if (this.source.request((long)(n2 + 1)) && this.isLiteral(this.buffer.getByte((long)n2))) {
            return 0;
        }
        this.buffer.skip((long)n2);
        this.peeked = n;
        return n;
    }

    private int peekNumber() throws IOException {
        int n = 1;
        long l = 0L;
        int n2 = 0;
        int n3 = 0;
        boolean bl = true;
        boolean bl2 = false;
        do {
            int n4;
            block24 : {
                block28 : {
                    block19 : {
                        block20 : {
                            block27 : {
                                block21 : {
                                    block26 : {
                                        block22 : {
                                            block25 : {
                                                block18 : {
                                                    byte by;
                                                    block23 : {
                                                        BufferedSource bufferedSource;
                                                        if (!(bufferedSource = this.source).request((long)(n4 = n2 + 1))) break block18;
                                                        by = this.buffer.getByte((long)n2);
                                                        if (by == 43) break block19;
                                                        if (by == 69 || by == 101) break block20;
                                                        if (by == 45) break block21;
                                                        if (by == 46) break block22;
                                                        if (by < 48 || by > 57) break block23;
                                                        if (n3 != n && n3 != 0) {
                                                            if (n3 == 2) {
                                                                if (l == 0L) {
                                                                    return 0;
                                                                }
                                                                long l2 = 10L * l - (long)(by - 48);
                                                                boolean bl3 = l > -922337203685477580L || l == -922337203685477580L && l2 < l;
                                                                bl &= bl3;
                                                                l = l2;
                                                            } else if (n3 == 3) {
                                                                n3 = 4;
                                                            } else if (n3 == 5 || n3 == 6) {
                                                                n3 = 7;
                                                            }
                                                        } else {
                                                            l = -(by - 48);
                                                            n3 = 2;
                                                        }
                                                        break block24;
                                                    }
                                                    if (this.isLiteral(by)) break block25;
                                                }
                                                if (!(n3 != 2 || !bl || l == Long.MIN_VALUE && !bl2 || l == 0L && bl2)) {
                                                    if (!bl2) {
                                                        l = -l;
                                                    }
                                                    this.peekedLong = l;
                                                    this.buffer.skip((long)n2);
                                                    this.peeked = 16;
                                                    return 16;
                                                }
                                                if (n3 != 2 && n3 != 4 && n3 != 7) {
                                                    return 0;
                                                }
                                                this.peekedNumberLength = n2;
                                                this.peeked = 17;
                                                return 17;
                                            }
                                            return 0;
                                        }
                                        if (n3 != 2) break block26;
                                        n3 = 3;
                                        break block24;
                                    }
                                    return 0;
                                }
                                if (n3 != 0) break block27;
                                n3 = 1;
                                bl2 = true;
                                break block24;
                            }
                            if (n3 != 5) {
                                return 0;
                            }
                            break block28;
                        }
                        if (n3 != 2 && n3 != 4) {
                            return 0;
                        }
                        n3 = 5;
                        break block24;
                    }
                    if (n3 != 5) break;
                }
                n3 = 6;
            }
            n2 = n4;
            n = 1;
        } while (true);
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private char readEscapeCharacter() throws IOException {
        if (!this.source.request(1L)) {
            JsonEncodingException jsonEncodingException = this.syntaxError("Unterminated escape sequence");
            throw jsonEncodingException;
        }
        byte by = this.buffer.readByte();
        if (by == 10) return (char)by;
        if (by == 34) return (char)by;
        if (by == 39) return (char)by;
        if (by == 47) return (char)by;
        if (by == 92) return (char)by;
        if (by == 98) return '\b';
        if (by == 102) return '\f';
        if (by == 110) return '\n';
        if (by == 114) return '\r';
        if (by == 116) return '\t';
        if (by != 117) {
            if (this.lenient) {
                return (char)by;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid escape sequence: \\");
            stringBuilder.append((char)by);
            throw this.syntaxError(stringBuilder.toString());
        }
        if (!this.source.request(4L)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unterminated escape sequence at path ");
            stringBuilder.append(this.getPath());
            throw new EOFException(stringBuilder.toString());
        }
        int n = 0;
        char c = '\u0000';
        do {
            int n2;
            if (n >= 4) {
                this.buffer.skip(4L);
                return c;
            }
            byte by2 = this.buffer.getByte((long)n);
            char c2 = (char)(c << 4);
            if (by2 >= 48 && by2 <= 57) {
                n2 = by2 - 48;
            } else {
                int n3;
                if (by2 >= 97 && by2 <= 102) {
                    n3 = by2 - 97;
                } else {
                    if (by2 < 65 || by2 > 70) break;
                    n3 = by2 - 65;
                }
                n2 = n3 + 10;
            }
            c = (char)(c2 + n2);
            ++n;
        } while (true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\u");
        stringBuilder.append(this.buffer.readUtf8(4L));
        throw this.syntaxError(stringBuilder.toString());
    }

    private void skipQuotedValue(ByteString byteString) throws IOException {
        JsonEncodingException jsonEncodingException;
        long l;
        while ((l = this.source.indexOfElement(byteString)) != -1L) {
            if (this.buffer.getByte(l) == 92) {
                this.buffer.skip(l + 1L);
                this.readEscapeCharacter();
                continue;
            }
            this.buffer.skip(l + 1L);
            return;
        }
        jsonEncodingException = this.syntaxError("Unterminated string");
        throw jsonEncodingException;
    }

    private boolean skipToEndOfBlockComment() throws IOException {
        long l = this.source.indexOf(CLOSING_BLOCK_COMMENT);
        boolean bl = l != -1L;
        Buffer buffer = this.buffer;
        long l2 = bl ? l + (long)CLOSING_BLOCK_COMMENT.size() : buffer.size();
        buffer.skip(l2);
        return bl;
    }

    private void skipToEndOfLine() throws IOException {
        long l = this.source.indexOfElement(LINEFEED_OR_CARRIAGE_RETURN);
        Buffer buffer = this.buffer;
        long l2 = l != -1L ? l + 1L : buffer.size();
        buffer.skip(l2);
    }

    private void skipUnquotedValue() throws IOException {
        long l = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer = this.buffer;
        if (l == -1L) {
            l = buffer.size();
        }
        buffer.skip(l);
    }

    @Override
    public void beginArray() throws IOException {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 3) {
            this.pushScope(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_ARRAY but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.getPath());
        throw new JsonDataException(stringBuilder.toString());
    }

    @Override
    public void beginObject() throws IOException {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 1) {
            this.pushScope(3);
            this.peeked = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_OBJECT but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.getPath());
        throw new JsonDataException(stringBuilder.toString());
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.clear();
        this.source.close();
    }

    @Override
    public void endArray() throws IOException {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 4) {
            this.stackSize = -1 + this.stackSize;
            int[] arrn = this.pathIndices;
            int n2 = -1 + this.stackSize;
            arrn[n2] = 1 + arrn[n2];
            this.peeked = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_ARRAY but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.getPath());
        throw new JsonDataException(stringBuilder.toString());
    }

    @Override
    public void endObject() throws IOException {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 2) {
            this.stackSize = -1 + this.stackSize;
            this.pathNames[this.stackSize] = null;
            int[] arrn = this.pathIndices;
            int n2 = -1 + this.stackSize;
            arrn[n2] = 1 + arrn[n2];
            this.peeked = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_OBJECT but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.getPath());
        throw new JsonDataException(stringBuilder.toString());
    }

    @Override
    public boolean hasNext() throws IOException {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        return n != 2 && n != 4 && n != 18;
    }

    @Override
    public boolean nextBoolean() throws IOException {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 5) {
            this.peeked = 0;
            int[] arrn = this.pathIndices;
            int n2 = this.stackSize - 1;
            arrn[n2] = 1 + arrn[n2];
            return true;
        }
        if (n == 6) {
            this.peeked = 0;
            int[] arrn = this.pathIndices;
            int n3 = this.stackSize - 1;
            arrn[n3] = 1 + arrn[n3];
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a boolean but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.getPath());
        throw new JsonDataException(stringBuilder.toString());
    }

    @Override
    public double nextDouble() throws IOException {
        block13 : {
            double d;
            block9 : {
                int n;
                block12 : {
                    block11 : {
                        block10 : {
                            block8 : {
                                n = this.peeked;
                                if (n == 0) {
                                    n = this.doPeek();
                                }
                                if (n == 16) {
                                    this.peeked = 0;
                                    int[] arrn = this.pathIndices;
                                    int n2 = -1 + this.stackSize;
                                    arrn[n2] = 1 + arrn[n2];
                                    return this.peekedLong;
                                }
                                if (n != 17) break block8;
                                this.peekedString = this.buffer.readUtf8((long)this.peekedNumberLength);
                                break block9;
                            }
                            if (n != 9) break block10;
                            this.peekedString = this.nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                            break block9;
                        }
                        if (n != 8) break block11;
                        this.peekedString = this.nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
                        break block9;
                    }
                    if (n != 10) break block12;
                    this.peekedString = this.nextUnquotedValue();
                    break block9;
                }
                if (n != 11) break block13;
            }
            this.peeked = 11;
            try {
                d = Double.parseDouble((String)this.peekedString);
            }
            catch (NumberFormatException numberFormatException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a double but was ");
                stringBuilder.append(this.peekedString);
                stringBuilder.append(" at path ");
                stringBuilder.append(this.getPath());
                throw new JsonDataException(stringBuilder.toString());
            }
            if (!this.lenient && (Double.isNaN((double)d) || Double.isInfinite((double)d))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("JSON forbids NaN and infinities: ");
                stringBuilder.append(d);
                stringBuilder.append(" at path ");
                stringBuilder.append(this.getPath());
                throw new JsonEncodingException(stringBuilder.toString());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] arrn = this.pathIndices;
            int n = -1 + this.stackSize;
            arrn[n] = 1 + arrn[n];
            return d;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a double but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.getPath());
        throw new JsonDataException(stringBuilder.toString());
    }

    /*
     * Exception decompiling
     */
    @Override
    public int nextInt() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl162.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public String nextName() throws IOException {
        block8 : {
            String string2;
            block5 : {
                int n;
                block7 : {
                    block6 : {
                        block4 : {
                            n = this.peeked;
                            if (n == 0) {
                                n = this.doPeek();
                            }
                            if (n != 14) break block4;
                            string2 = this.nextUnquotedValue();
                            break block5;
                        }
                        if (n != 13) break block6;
                        string2 = this.nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                        break block5;
                    }
                    if (n != 12) break block7;
                    string2 = this.nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
                    break block5;
                }
                if (n != 15) break block8;
                string2 = this.peekedString;
            }
            this.peeked = 0;
            this.pathNames[-1 + this.stackSize] = string2;
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a name but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.getPath());
        throw new JsonDataException(stringBuilder.toString());
    }

    @Override
    public String nextString() throws IOException {
        block10 : {
            String string2;
            block5 : {
                int n;
                block9 : {
                    block8 : {
                        block7 : {
                            block6 : {
                                block4 : {
                                    n = this.peeked;
                                    if (n == 0) {
                                        n = this.doPeek();
                                    }
                                    if (n != 10) break block4;
                                    string2 = this.nextUnquotedValue();
                                    break block5;
                                }
                                if (n != 9) break block6;
                                string2 = this.nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                                break block5;
                            }
                            if (n != 8) break block7;
                            string2 = this.nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
                            break block5;
                        }
                        if (n != 11) break block8;
                        string2 = this.peekedString;
                        this.peekedString = null;
                        break block5;
                    }
                    if (n != 16) break block9;
                    string2 = Long.toString((long)this.peekedLong);
                    break block5;
                }
                if (n != 17) break block10;
                string2 = this.buffer.readUtf8((long)this.peekedNumberLength);
            }
            this.peeked = 0;
            int[] arrn = this.pathIndices;
            int n = -1 + this.stackSize;
            arrn[n] = 1 + arrn[n];
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a string but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.getPath());
        throw new JsonDataException(stringBuilder.toString());
    }

    @Override
    public JsonReader.Token peek() throws IOException {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        switch (n) {
            default: {
                throw new AssertionError();
            }
            case 18: {
                return JsonReader.Token.END_DOCUMENT;
            }
            case 16: 
            case 17: {
                return JsonReader.Token.NUMBER;
            }
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return JsonReader.Token.NAME;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return JsonReader.Token.STRING;
            }
            case 7: {
                return JsonReader.Token.NULL;
            }
            case 5: 
            case 6: {
                return JsonReader.Token.BOOLEAN;
            }
            case 4: {
                return JsonReader.Token.END_ARRAY;
            }
            case 3: {
                return JsonReader.Token.BEGIN_ARRAY;
            }
            case 2: {
                return JsonReader.Token.END_OBJECT;
            }
            case 1: 
        }
        return JsonReader.Token.BEGIN_OBJECT;
    }

    @Override
    public int selectName(JsonReader.Options options) throws IOException {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n >= 12) {
            if (n > 15) {
                return -1;
            }
            if (n == 15) {
                return this.findName(this.peekedString, options);
            }
            int n2 = this.source.select(options.doubleQuoteSuffix);
            if (n2 != -1) {
                this.peeked = 0;
                this.pathNames[-1 + this.stackSize] = options.strings[n2];
                return n2;
            }
            String string2 = this.pathNames[-1 + this.stackSize];
            String string3 = this.nextName();
            int n3 = this.findName(string3, options);
            if (n3 == -1) {
                this.peeked = 15;
                this.peekedString = string3;
                this.pathNames[-1 + this.stackSize] = string2;
            }
            return n3;
        }
        return -1;
    }

    @Override
    public void skipName() throws IOException {
        block4 : {
            block9 : {
                block6 : {
                    int n;
                    block8 : {
                        block7 : {
                            block5 : {
                                if (this.failOnUnknown) break block4;
                                n = this.peeked;
                                if (n == 0) {
                                    n = this.doPeek();
                                }
                                if (n != 14) break block5;
                                this.skipUnquotedValue();
                                break block6;
                            }
                            if (n != 13) break block7;
                            this.skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                            break block6;
                        }
                        if (n != 12) break block8;
                        this.skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                        break block6;
                    }
                    if (n != 15) break block9;
                }
                this.peeked = 0;
                this.pathNames[-1 + this.stackSize] = "null";
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a name but was ");
            stringBuilder.append((Object)this.peek());
            stringBuilder.append(" at path ");
            stringBuilder.append(this.getPath());
            throw new JsonDataException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot skip unexpected ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(" at ");
        stringBuilder.append(this.getPath());
        throw new JsonDataException(stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void skipValue() throws IOException {
        if (this.failOnUnknown) {
            var1_8 = new StringBuilder();
            var1_8.append("Cannot skip unexpected ");
            var1_8.append((Object)this.peek());
            var1_8.append(" at ");
            var1_8.append(this.getPath());
            var6_9 = new JsonDataException(var1_8.toString());
            throw var6_9;
        }
        var7_1 = 0;
        do {
            block20 : {
                if ((var8_2 = this.peeked) == 0) {
                    var8_2 = this.doPeek();
                }
                if (var8_2 != 3) break block20;
                this.pushScope(1);
                ** GOTO lbl19
            }
            if (var8_2 == 1) {
                this.pushScope(3);
lbl19: // 2 sources:
                ++var7_1;
            } else if (var8_2 == 4) {
                if (--var7_1 < 0) {
                    var21_3 = new StringBuilder();
                    var21_3.append("Expected a value but was ");
                    var21_3.append((Object)this.peek());
                    var21_3.append(" at path ");
                    var21_3.append(this.getPath());
                    throw new JsonDataException(var21_3.toString());
                }
                --this.stackSize;
            } else if (var8_2 == 2) {
                if (--var7_1 < 0) {
                    var16_4 = new StringBuilder();
                    var16_4.append("Expected a value but was ");
                    var16_4.append((Object)this.peek());
                    var16_4.append(" at path ");
                    var16_4.append(this.getPath());
                    throw new JsonDataException(var16_4.toString());
                }
                --this.stackSize;
            } else if (var8_2 != 14 && var8_2 != 10) {
                if (var8_2 != 9 && var8_2 != 13) {
                    if (var8_2 != 8 && var8_2 != 12) {
                        if (var8_2 == 17) {
                            this.buffer.skip((long)this.peekedNumberLength);
                        } else if (var8_2 == 18) {
                            var11_5 = new StringBuilder();
                            var11_5.append("Expected a value but was ");
                            var11_5.append((Object)this.peek());
                            var11_5.append(" at path ");
                            var11_5.append(this.getPath());
                            throw new JsonDataException(var11_5.toString());
                        }
                    } else {
                        this.skipQuotedValue(JsonUtf8Reader.SINGLE_QUOTE_OR_SLASH);
                    }
                } else {
                    this.skipQuotedValue(JsonUtf8Reader.DOUBLE_QUOTE_OR_SLASH);
                }
            } else {
                this.skipUnquotedValue();
            }
            this.peeked = 0;
        } while (var7_1 != 0);
        var9_6 = this.pathIndices;
        var10_7 = this.stackSize - 1;
        var9_6[var10_7] = 1 + var9_6[var10_7];
        this.pathNames[this.stackSize - 1] = "null";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JsonReader(");
        stringBuilder.append((Object)this.source);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

