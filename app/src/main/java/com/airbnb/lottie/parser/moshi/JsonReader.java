/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.parser.moshi.JsonUtf8Reader
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.ByteString
 *  okio.Options
 */
package app.dukhaan.src.java.com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonDataException;
import com.airbnb.lottie.parser.moshi.JsonEncodingException;
import com.airbnb.lottie.parser.moshi.JsonScope;
import com.airbnb.lottie.parser.moshi.JsonUtf8Reader;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public abstract class JsonReader
implements Closeable {
    private static final String[] REPLACEMENT_CHARS = new String[128];
    boolean failOnUnknown;
    boolean lenient;
    int[] pathIndices = new int[32];
    String[] pathNames = new String[32];
    int[] scopes = new int[32];
    int stackSize;

    static {
        for (int i = 0; i <= 31; ++i) {
            String[] arrstring = REPLACEMENT_CHARS;
            Object[] arrobject = new Object[]{i};
            arrstring[i] = String.format((String)"\\u%04x", (Object[])arrobject);
        }
        String[] arrstring = REPLACEMENT_CHARS;
        arrstring[34] = "\\\"";
        arrstring[92] = "\\\\";
        arrstring[9] = "\\t";
        arrstring[8] = "\\b";
        arrstring[10] = "\\n";
        arrstring[13] = "\\r";
        arrstring[12] = "\\f";
    }

    JsonReader() {
    }

    public static JsonReader of(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    private static void string(BufferedSink bufferedSink, String string2) throws IOException {
        String[] arrstring = REPLACEMENT_CHARS;
        bufferedSink.writeByte(34);
        int n = string2.length();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            String string3;
            char c = string2.charAt(i);
            if (c < '') {
                string3 = arrstring[c];
                if (string3 == null) {
                    continue;
                }
            } else if (c == '\u2028') {
                string3 = "\\u2028";
            } else {
                if (c != '\u2029') continue;
                string3 = "\\u2029";
            }
            if (n2 < i) {
                bufferedSink.writeUtf8(string2, n2, i);
            }
            bufferedSink.writeUtf8(string3);
            n2 = i + 1;
        }
        if (n2 < n) {
            bufferedSink.writeUtf8(string2, n2, n);
        }
        bufferedSink.writeByte(34);
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    final void pushScope(int n) {
        int n2 = this.stackSize;
        int[] arrn = this.scopes;
        if (n2 == arrn.length) {
            if (n2 != 256) {
                this.scopes = Arrays.copyOf((int[])arrn, (int)(2 * arrn.length));
                Object[] arrobject = this.pathNames;
                this.pathNames = (String[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
                int[] arrn2 = this.pathIndices;
                this.pathIndices = Arrays.copyOf((int[])arrn2, (int)(2 * arrn2.length));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Nesting too deep at ");
                stringBuilder.append(this.getPath());
                throw new JsonDataException(stringBuilder.toString());
            }
        }
        int[] arrn3 = this.scopes;
        int n3 = this.stackSize;
        this.stackSize = n3 + 1;
        arrn3[n3] = n;
    }

    public abstract int selectName(Options var1) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    final JsonEncodingException syntaxError(String string2) throws JsonEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" at path ");
        stringBuilder.append(this.getPath());
        throw new JsonEncodingException(stringBuilder.toString());
    }

    public static final class Options {
        final okio.Options doubleQuoteSuffix;
        final String[] strings;

        private Options(String[] arrstring, okio.Options options) {
            this.strings = arrstring;
            this.doubleQuoteSuffix = options;
        }

        public static /* varargs */ Options of(String ... arrstring) {
            ByteString[] arrbyteString = new ByteString[arrstring.length];
            Buffer buffer = new Buffer();
            int n = 0;
            do {
                if (n >= arrstring.length) break;
                JsonReader.string((BufferedSink)buffer, arrstring[n]);
                buffer.readByte();
                arrbyteString[n] = buffer.readByteString();
                ++n;
            } while (true);
            try {
                Options options = new Options((String[])arrstring.clone(), okio.Options.of((ByteString[])arrbyteString));
                return options;
            }
            catch (IOException iOException) {
                AssertionError assertionError;
                assertionError = new AssertionError((Object)iOException);
                throw assertionError;
            }
        }
    }

    public static final class Token
    extends Enum<Token> {
        private static final /* synthetic */ Token[] $VALUES;
        public static final /* enum */ Token BEGIN_ARRAY;
        public static final /* enum */ Token BEGIN_OBJECT;
        public static final /* enum */ Token BOOLEAN;
        public static final /* enum */ Token END_ARRAY;
        public static final /* enum */ Token END_DOCUMENT;
        public static final /* enum */ Token END_OBJECT;
        public static final /* enum */ Token NAME;
        public static final /* enum */ Token NULL;
        public static final /* enum */ Token NUMBER;
        public static final /* enum */ Token STRING;

        static {
            Token token;
            BEGIN_ARRAY = new Token();
            END_ARRAY = new Token();
            BEGIN_OBJECT = new Token();
            END_OBJECT = new Token();
            NAME = new Token();
            STRING = new Token();
            NUMBER = new Token();
            BOOLEAN = new Token();
            NULL = new Token();
            END_DOCUMENT = token = new Token();
            Token[] arrtoken = new Token[]{BEGIN_ARRAY, END_ARRAY, BEGIN_OBJECT, END_OBJECT, NAME, STRING, NUMBER, BOOLEAN, NULL, token};
            $VALUES = arrtoken;
        }

        public static Token valueOf(String string2) {
            return (Token)Enum.valueOf(Token.class, (String)string2);
        }

        public static Token[] values() {
            return (Token[])$VALUES.clone();
        }
    }

}

