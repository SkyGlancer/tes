/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package app.dukhaan.src.java.io.branch.referral;

import java.io.UnsupportedEncodingException;

class Base64 {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    private Base64() {
    }

    public static byte[] decode(String string2, int n) {
        return Base64.decode(string2.getBytes(), n);
    }

    public static byte[] decode(byte[] arrby, int n) {
        return Base64.decode(arrby, 0, arrby.length, n);
    }

    public static byte[] decode(byte[] arrby, int n, int n2, int n3) {
        Decoder decoder = new Decoder(n3, new byte[n2 * 3 / 4]);
        if (decoder.process(arrby, n, n2, true)) {
            if (decoder.op == decoder.output.length) {
                return decoder.output;
            }
            byte[] arrby2 = new byte[decoder.op];
            System.arraycopy((Object)decoder.output, (int)0, (Object)arrby2, (int)0, (int)decoder.op);
            return arrby2;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] encode(byte[] arrby, int n) {
        return Base64.encode(arrby, 0, arrby.length, n);
    }

    public static byte[] encode(byte[] arrby, int n, int n2, int n3) {
        Encoder encoder = new Encoder(n3, null);
        int n4 = 4 * (n2 / 3);
        boolean bl = encoder.do_padding;
        int n5 = 2;
        if (bl) {
            if (n2 % 3 > 0) {
                n4 += 4;
            }
        } else {
            int n6 = n2 % 3;
            if (n6 != 1) {
                if (n6 == n5) {
                    n4 += 3;
                }
            } else {
                n4 += 2;
            }
        }
        if (encoder.do_newline && n2 > 0) {
            int n7 = 1 + (n2 - 1) / 57;
            if (!encoder.do_cr) {
                n5 = 1;
            }
            n4 += n7 * n5;
        }
        encoder.output = new byte[n4];
        encoder.process(arrby, n, n2, true);
        return encoder.output;
    }

    public static String encodeToString(byte[] arrby, int n) {
        try {
            String string2 = new String(Base64.encode(arrby, n), "US-ASCII");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError((Object)unsupportedEncodingException);
        }
    }

    public static String encodeToString(byte[] arrby, int n, int n2, int n3) {
        try {
            String string2 = new String(Base64.encode(arrby, n, n2, n3), "US-ASCII");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError((Object)unsupportedEncodingException);
        }
    }

    static abstract class Coder {
        public int op;
        public byte[] output;

        Coder() {
        }

        public abstract int maxOutputSize(int var1);

        public abstract boolean process(byte[] var1, int var2, int var3, boolean var4);
    }

    static class Decoder
    extends Coder {
        private static final int[] DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int n, byte[] arrby) {
            this.output = arrby;
            int[] arrn = (n & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.alphabet = arrn;
            this.state = 0;
            this.value = 0;
        }

        @Override
        public int maxOutputSize(int n) {
            return 10 + n * 3 / 4;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public boolean process(byte[] var1_1, int var2_2, int var3_3, boolean var4_4) {
            var5_5 = this.state;
            if (var5_5 == 6) {
                return false;
            }
            var6_6 = var3_3 + var2_2;
            var7_7 = this.value;
            var8_8 = this.output;
            var9_9 = this.alphabet;
            var10_10 = var7_7;
            var11_11 = 0;
            var12_12 = var5_5;
            var13_13 = var2_2;
            while (var13_13 < var6_6) {
                block34 : {
                    block31 : {
                        block36 : {
                            block35 : {
                                block32 : {
                                    block33 : {
                                        if (var12_12 == 0) {
                                            while ((var20_18 = var13_13 + 4) <= var6_6 && (var10_10 = var9_9[255 & var1_1[var13_13]] << 18 | var9_9[255 & var1_1[var13_13 + 1]] << 12 | var9_9[255 & var1_1[var13_13 + 2]] << 6 | var9_9[255 & var1_1[var13_13 + 3]]) >= 0) {
                                                var8_8[var11_11 + 2] = (byte)var10_10;
                                                var8_8[var11_11 + 1] = (byte)(var10_10 >> 8);
                                                var8_8[var11_11] = (byte)(var10_10 >> 16);
                                                var11_11 += 3;
                                                var13_13 = var20_18;
                                            }
                                            if (var13_13 >= var6_6) break;
                                        }
                                        var16_14 = var13_13 + 1;
                                        var17_15 = var9_9[255 & var1_1[var13_13]];
                                        if (var12_12 == 0) break block31;
                                        if (var12_12 == 1) break block32;
                                        if (var12_12 == 2) break block33;
                                        if (var12_12 != 3) {
                                            if (var12_12 != 4) {
                                                if (var12_12 == 5 && var17_15 != -1) {
                                                    this.state = 6;
                                                    return false;
                                                }
                                            } else if (var17_15 == -2) {
                                                ++var12_12;
                                            } else if (var17_15 != -1) {
                                                this.state = 6;
                                                return false;
                                            }
                                        } else if (var17_15 >= 0) {
                                            var19_17 = var17_15 | var10_10 << 6;
                                            var8_8[var11_11 + 2] = (byte)var19_17;
                                            var8_8[var11_11 + 1] = (byte)(var19_17 >> 8);
                                            var8_8[var11_11] = (byte)(var19_17 >> 16);
                                            var11_11 += 3;
                                            var10_10 = var19_17;
                                            var12_12 = 0;
                                        } else if (var17_15 == -2) {
                                            var8_8[var11_11 + 1] = (byte)(var10_10 >> 2);
                                            var8_8[var11_11] = (byte)(var10_10 >> 10);
                                            var11_11 += 2;
                                            var12_12 = 5;
                                        } else if (var17_15 != -1) {
                                            this.state = 6;
                                            return false;
                                        }
                                        break block34;
                                    }
                                    if (var17_15 >= 0) break block35;
                                    if (var17_15 == -2) {
                                        var18_16 = var11_11 + 1;
                                        var8_8[var11_11] = (byte)(var10_10 >> 4);
                                        var11_11 = var18_16;
                                        var12_12 = 4;
                                    } else if (var17_15 != -1) {
                                        this.state = 6;
                                        return false;
                                    }
                                    break block34;
                                }
                                if (var17_15 < 0) break block36;
                            }
                            var17_15 |= var10_10 << 6;
                            ** GOTO lbl-1000
                        }
                        if (var17_15 != -1) {
                            this.state = 6;
                            return false;
                        }
                        break block34;
                    }
                    if (var17_15 >= 0) lbl-1000: // 2 sources:
                    {
                        ++var12_12;
                        var10_10 = var17_15;
                    } else if (var17_15 != -1) {
                        this.state = 6;
                        return false;
                    }
                }
                var13_13 = var16_14;
            }
            if (!var4_4) {
                this.state = var12_12;
                this.value = var10_10;
                this.op = var11_11;
                return true;
            }
            if (var12_12 == 1) {
                this.state = 6;
                return false;
            }
            if (var12_12 != 2) {
                if (var12_12 != 3) {
                    if (var12_12 == 4) {
                        this.state = 6;
                        return false;
                    }
                } else {
                    var15_19 = var11_11 + 1;
                    var8_8[var11_11] = (byte)(var10_10 >> 10);
                    var11_11 = var15_19 + 1;
                    var8_8[var15_19] = (byte)(var10_10 >> 2);
                }
            } else {
                var14_20 = var11_11 + 1;
                var8_8[var11_11] = (byte)(var10_10 >> 4);
                var11_11 = var14_20;
            }
            this.state = var12_12;
            this.op = var11_11;
            return true;
        }
    }

    static class Encoder
    extends Coder {
        private static final byte[] ENCODE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int n, byte[] arrby) {
            this.output = arrby;
            int n2 = n & 1;
            boolean bl = true;
            boolean bl2 = n2 == 0;
            this.do_padding = bl2;
            boolean bl3 = (n & 2) == 0;
            this.do_newline = bl3;
            if ((n & 4) == 0) {
                bl = false;
            }
            this.do_cr = bl;
            byte[] arrby2 = (n & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.alphabet = arrby2;
            this.tail = new byte[2];
            this.tailLen = 0;
            int n3 = this.do_newline ? 19 : -1;
            this.count = n3;
        }

        @Override
        public int maxOutputSize(int n) {
            return 10 + n * 8 / 5;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public boolean process(byte[] var1_1, int var2_2, int var3_3, boolean var4_4) {
            block31 : {
                block29 : {
                    block32 : {
                        block33 : {
                            block34 : {
                                block30 : {
                                    block28 : {
                                        block26 : {
                                            block27 : {
                                                block25 : {
                                                    block24 : {
                                                        var5_5 = this.alphabet;
                                                        var6_6 = this.output;
                                                        var7_7 = this.count;
                                                        var8_8 = var3_3 + var2_2;
                                                        var9_9 = this.tailLen;
                                                        var10_10 = 0;
                                                        if (var9_9 == 1) break block24;
                                                        if (var9_9 != 2 || (var48_11 = var2_2 + 1) > var8_8) ** GOTO lbl-1000
                                                        var49_12 = this.tail;
                                                        var12_13 = (255 & var49_12[0]) << 16 | (255 & var49_12[1]) << 8 | 255 & var1_1[var2_2];
                                                        this.tailLen = 0;
                                                        var11_14 = var48_11;
                                                        break block25;
                                                    }
                                                    if (var2_2 + 2 <= var8_8) {
                                                        var45_15 = (255 & this.tail[0]) << 16;
                                                        var46_16 = var2_2 + 1;
                                                        var47_17 = var45_15 | (255 & var1_1[var2_2]) << 8;
                                                        var11_14 = var46_16 + 1;
                                                        var12_13 = var47_17 | 255 & var1_1[var46_16];
                                                        this.tailLen = 0;
                                                    } else lbl-1000: // 2 sources:
                                                    {
                                                        var11_14 = var2_2;
                                                        var12_13 = -1;
                                                    }
                                                }
                                                if (var12_13 == -1) break block26;
                                                var6_6[0] = var5_5[63 & var12_13 >> 18];
                                                var6_6[1] = var5_5[63 & var12_13 >> 12];
                                                var6_6[2] = var5_5[63 & var12_13 >> 6];
                                                var6_6[3] = var5_5[var12_13 & 63];
                                                if (--var7_7 != 0) break block27;
                                                if (this.do_cr) {
                                                    var44_18 = 5;
                                                    var6_6[4] = 13;
                                                } else {
                                                    var44_18 = 4;
                                                }
                                                break block28;
                                            }
                                            var13_19 = 4;
                                            ** GOTO lbl49
                                        }
                                        var13_19 = 0;
                                        ** GOTO lbl49
                                    }
                                    var13_19 = var44_18 + 1;
                                    var6_6[var44_18] = 10;
                                    block0 : do {
                                        var7_7 = 19;
lbl49: // 4 sources:
                                        while ((var14_23 = var11_14 + 3) <= var8_8) {
                                            var41_20 = (255 & var1_1[var11_14]) << 16 | (255 & var1_1[var11_14 + 1]) << 8 | 255 & var1_1[var11_14 + 2];
                                            var6_6[var13_19] = var5_5[63 & var41_20 >> 18];
                                            var6_6[var13_19 + 1] = var5_5[63 & var41_20 >> 12];
                                            var6_6[var13_19 + 2] = var5_5[63 & var41_20 >> 6];
                                            var6_6[var13_19 + 3] = var5_5[var41_20 & 63];
                                            var13_19 += 4;
                                            if (--var7_7 == 0) {
                                                if (this.do_cr) {
                                                    var43_22 = var13_19 + 1;
                                                    var6_6[var13_19] = 13;
                                                    var13_19 = var43_22;
                                                }
                                                var42_21 = var13_19 + 1;
                                                var6_6[var13_19] = 10;
                                                var13_19 = var42_21;
                                                var11_14 = var14_23;
                                                continue block0;
                                            }
                                            var11_14 = var14_23;
                                        }
                                        break;
                                    } while (true);
                                    if (!var4_4) break block29;
                                    var20_24 = this.tailLen;
                                    if (var11_14 - var20_24 != var8_8 - 1) break block30;
                                    if (var20_24 > 0) {
                                        var36_25 = this.tail[0];
                                        var10_10 = 1;
                                    } else {
                                        var36_25 = var1_1[var11_14];
                                    }
                                    var37_26 = (var36_25 & 255) << 4;
                                    this.tailLen -= var10_10;
                                    var38_27 = var13_19 + 1;
                                    var6_6[var13_19] = var5_5[63 & var37_26 >> 6];
                                    var13_19 = var38_27 + 1;
                                    var6_6[var38_27] = var5_5[var37_26 & 63];
                                    if (this.do_padding) {
                                        var40_28 = var13_19 + 1;
                                        var6_6[var13_19] = 61;
                                        var13_19 = var40_28 + 1;
                                        var6_6[var40_28] = 61;
                                    }
                                    if (!this.do_newline) break block31;
                                    if (this.do_cr) {
                                        var39_29 = var13_19 + 1;
                                        var6_6[var13_19] = 13;
                                        var13_19 = var39_29;
                                    }
                                    var21_30 = var13_19 + 1;
                                    var6_6[var13_19] = 10;
                                    break block32;
                                }
                                if (var11_14 - var20_24 != var8_8 - 2) break block33;
                                if (var20_24 > 1) {
                                    var25_31 = this.tail[0];
                                    var10_10 = 1;
                                } else {
                                    var23_32 = var11_14 + 1;
                                    var24_33 = var1_1[var11_14];
                                    var11_14 = var23_32;
                                    var25_31 = var24_33;
                                }
                                var26_34 = (var25_31 & 255) << 10;
                                if (this.tailLen > 0) {
                                    var34_35 = this.tail;
                                    var35_36 = var10_10 + 1;
                                    var27_37 = var34_35[var10_10];
                                    var10_10 = var35_36;
                                } else {
                                    var27_37 = var1_1[var11_14];
                                }
                                var28_38 = var26_34 | (var27_37 & 255) << 2;
                                this.tailLen -= var10_10;
                                var29_39 = var13_19 + 1;
                                var6_6[var13_19] = var5_5[63 & var28_38 >> 12];
                                var30_40 = var29_39 + 1;
                                var6_6[var29_39] = var5_5[63 & var28_38 >> 6];
                                var31_41 = var30_40 + 1;
                                var6_6[var30_40] = var5_5[var28_38 & 63];
                                if (this.do_padding) {
                                    var33_42 = var31_41 + 1;
                                    var6_6[var31_41] = 61;
                                    var31_41 = var33_42;
                                }
                                if (!this.do_newline) break block34;
                                if (this.do_cr) {
                                    var32_43 = var31_41 + 1;
                                    var6_6[var31_41] = 13;
                                    var31_41 = var32_43;
                                }
                                var21_30 = var31_41 + 1;
                                var6_6[var31_41] = 10;
                                break block32;
                            }
                            var13_19 = var31_41;
                            break block31;
                        }
                        if (!this.do_newline || var13_19 <= 0 || var7_7 == 19) break block31;
                        if (this.do_cr) {
                            var22_44 = var13_19 + 1;
                            var6_6[var13_19] = 13;
                            var13_19 = var22_44;
                        }
                        var21_30 = var13_19 + 1;
                        var6_6[var13_19] = 10;
                    }
                    var13_19 = var21_30;
                    break block31;
                }
                if (var11_14 == var8_8 - 1) {
                    var18_45 = this.tail;
                    var19_46 = this.tailLen;
                    this.tailLen = var19_46 + 1;
                    var18_45[var19_46] = var1_1[var11_14];
                } else if (var11_14 == var8_8 - 2) {
                    var15_47 = this.tail;
                    var16_48 = this.tailLen;
                    this.tailLen = var17_49 = var16_48 + 1;
                    var15_47[var16_48] = var1_1[var11_14];
                    this.tailLen = var17_49 + 1;
                    var15_47[var17_49] = var1_1[var11_14 + 1];
                }
            }
            this.op = var13_19;
            this.count = var7_7;
            return true;
        }
    }

}

