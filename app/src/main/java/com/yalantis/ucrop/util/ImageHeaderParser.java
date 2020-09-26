/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.ExifInterface
 *  android.text.TextUtils
 *  android.util.Log
 *  com.yalantis.ucrop.util.ImageHeaderParser$StreamReader
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.charset.Charset
 */
package app.dukhaan.src.java.com.yalantis.ucrop.util;

import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/*
 * Exception performing whole class analysis.
 */
public class ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT;
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    public static final int UNKNOWN_ORIENTATION = -1;
    private final Reader reader;

    static {
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName((String)"UTF-8"));
        BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.reader = new /* Unavailable Anonymous Inner Class!! */;
    }

    private static int calcTagOffset(int n, int n2) {
        return n + 2 + n2 * 12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void copyExif(ExifInterface exifInterface, int n, int n2, String string2) {
        int n3;
        ExifInterface exifInterface2;
        String[] arrstring = new String[]{"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ISOSpeedRatings", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        try {
            exifInterface2 = new ExifInterface(string2);
            n3 = 0;
        }
        catch (IOException iOException) {
            Log.d((String)TAG, (String)iOException.getMessage());
            return;
        }
        do {
            if (n3 >= 22) {
                exifInterface2.setAttribute("ImageWidth", String.valueOf((int)n));
                exifInterface2.setAttribute("ImageLength", String.valueOf((int)n2));
                exifInterface2.setAttribute("Orientation", "0");
                exifInterface2.saveAttributes();
                return;
            }
            String string3 = arrstring[n3];
            String string4 = exifInterface.getAttribute(string3);
            if (!TextUtils.isEmpty((CharSequence)string4)) {
                exifInterface2.setAttribute(string3, string4);
            }
            ++n3;
        } while (true);
    }

    private static boolean handles(int n) {
        return (n & 65496) == 65496 || n == 19789 || n == 18761;
        {
        }
    }

    private boolean hasJpegExifPreamble(byte[] arrby, int n) {
        boolean bl = arrby != null && n > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (bl) {
            byte[] arrby2;
            for (int i = 0; i < (arrby2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES).length; ++i) {
                if (arrby[i] == arrby2[i]) continue;
                return false;
            }
        }
        return bl;
    }

    private int moveToExifSegmentAndGetLength() throws IOException {
        int n;
        block7 : {
            long l;
            short s;
            long l2;
            Reader reader;
            do {
                short s2;
                if ((s2 = this.reader.getUInt8()) != 255) {
                    if (Log.isLoggable((String)TAG, (int)3)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown segmentId=");
                        stringBuilder.append((int)s2);
                        Log.d((String)TAG, (String)stringBuilder.toString());
                    }
                    return -1;
                }
                s = this.reader.getUInt8();
                if (s == 218) {
                    return -1;
                }
                if (s == 217) {
                    if (Log.isLoggable((String)TAG, (int)3)) {
                        Log.d((String)TAG, (String)"Found MARKER_EOI in exif segment");
                    }
                    return -1;
                }
                n = -2 + this.reader.getUInt16();
                if (s == 225) break block7;
            } while ((l2 = (reader = this.reader).skip(l = (long)n)) == l);
            if (Log.isLoggable((String)TAG, (int)3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to skip enough data, type: ");
                stringBuilder.append((int)s);
                stringBuilder.append(", wanted to skip: ");
                stringBuilder.append(n);
                stringBuilder.append(", but actually skipped: ");
                stringBuilder.append(l2);
                Log.d((String)TAG, (String)stringBuilder.toString());
            }
            return -1;
        }
        return n;
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short s = randomAccessReader.getInt16(6);
        if (s == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (s == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable((String)TAG, (int)3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown endianness = ");
                stringBuilder.append((int)s);
                Log.d((String)TAG, (String)stringBuilder.toString());
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int n = 6 + randomAccessReader.getInt32(10);
        int n2 = randomAccessReader.getInt16(n);
        for (int i = 0; i < n2; ++i) {
            int n3 = ImageHeaderParser.calcTagOffset(n, i);
            short s2 = randomAccessReader.getInt16(n3);
            if (s2 != 274) continue;
            short s3 = randomAccessReader.getInt16(n3 + 2);
            if (s3 >= 1 && s3 <= 12) {
                int n4;
                int n5 = randomAccessReader.getInt32(n3 + 4);
                if (n5 < 0) {
                    if (!Log.isLoggable((String)TAG, (int)3)) continue;
                    Log.d((String)TAG, (String)"Negative tiff component count");
                    continue;
                }
                if (Log.isLoggable((String)TAG, (int)3)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Got tagIndex=");
                    stringBuilder.append(i);
                    stringBuilder.append(" tagType=");
                    stringBuilder.append((int)s2);
                    stringBuilder.append(" formatCode=");
                    stringBuilder.append((int)s3);
                    stringBuilder.append(" componentCount=");
                    stringBuilder.append(n5);
                    Log.d((String)TAG, (String)stringBuilder.toString());
                }
                if ((n4 = n5 + BYTES_PER_FORMAT[s3]) > 4) {
                    if (!Log.isLoggable((String)TAG, (int)3)) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Got byte count > 4, not orientation, continuing, formatCode=");
                    stringBuilder.append((int)s3);
                    Log.d((String)TAG, (String)stringBuilder.toString());
                    continue;
                }
                int n6 = n3 + 8;
                if (n6 >= 0 && n6 <= randomAccessReader.length()) {
                    if (n4 >= 0 && n4 + n6 <= randomAccessReader.length()) {
                        return randomAccessReader.getInt16(n6);
                    }
                    if (!Log.isLoggable((String)TAG, (int)3)) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Illegal number of bytes for TI tag data tagType=");
                    stringBuilder.append((int)s2);
                    Log.d((String)TAG, (String)stringBuilder.toString());
                    continue;
                }
                if (!Log.isLoggable((String)TAG, (int)3)) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal tagValueOffset=");
                stringBuilder.append(n6);
                stringBuilder.append(" tagType=");
                stringBuilder.append((int)s2);
                Log.d((String)TAG, (String)stringBuilder.toString());
                continue;
            }
            if (!Log.isLoggable((String)TAG, (int)3)) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Got invalid format code = ");
            stringBuilder.append((int)s3);
            Log.d((String)TAG, (String)stringBuilder.toString());
        }
        return -1;
    }

    private int parseExifSegment(byte[] arrby, int n) throws IOException {
        int n2 = this.reader.read(arrby, n);
        if (n2 != n) {
            if (Log.isLoggable((String)TAG, (int)3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to read exif segment data, length: ");
                stringBuilder.append(n);
                stringBuilder.append(", actually read: ");
                stringBuilder.append(n2);
                Log.d((String)TAG, (String)stringBuilder.toString());
            }
            return -1;
        }
        if (this.hasJpegExifPreamble(arrby, n)) {
            return ImageHeaderParser.parseExifSegment(new RandomAccessReader(arrby, n));
        }
        if (Log.isLoggable((String)TAG, (int)3)) {
            Log.d((String)TAG, (String)"Missing jpeg exif preamble");
        }
        return -1;
    }

    public int getOrientation() throws IOException {
        int n = this.reader.getUInt16();
        if (!ImageHeaderParser.handles(n)) {
            if (Log.isLoggable((String)TAG, (int)3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Parser doesn't handle magic number: ");
                stringBuilder.append(n);
                Log.d((String)TAG, (String)stringBuilder.toString());
            }
            return -1;
        }
        int n2 = this.moveToExifSegmentAndGetLength();
        if (n2 == -1) {
            if (Log.isLoggable((String)TAG, (int)3)) {
                Log.d((String)TAG, (String)"Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        return this.parseExifSegment(new byte[n2], n2);
    }

    private static class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] arrby, int n) {
            this.data = (ByteBuffer)ByteBuffer.wrap((byte[])arrby).order(ByteOrder.BIG_ENDIAN).limit(n);
        }

        public short getInt16(int n) {
            return this.data.getShort(n);
        }

        public int getInt32(int n) {
            return this.data.getInt(n);
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    private static interface Reader {
        public int getUInt16() throws IOException;

        public short getUInt8() throws IOException;

        public int read(byte[] var1, int var2) throws IOException;

        public long skip(long var1) throws IOException;
    }

}

