/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  android.util.Log
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  java.nio.channels.WritableByteChannel
 *  java.util.Locale
 */
package app.dukhaan.src.java.com.yalantis.ucrop.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Locale;

public class FileUtils {
    private static final String TAG = "FileUtils";

    private FileUtils() {
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void copyFile(String string2, String string3) throws IOException {
        void var3_6;
        FileChannel fileChannel2;
        FileChannel fileChannel;
        block7 : {
            block6 : {
                if (string2.equalsIgnoreCase(string3)) {
                    return;
                }
                fileChannel2 = null;
                FileChannel fileChannel3 = new FileInputStream(new File(string2)).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(new File(string3)).getChannel();
                    fileChannel3.transferTo(0L, fileChannel3.size(), (WritableByteChannel)fileChannel2);
                    fileChannel3.close();
                    if (fileChannel3 == null) break block6;
                }
                catch (Throwable throwable) {
                    FileChannel fileChannel4 = fileChannel2;
                    fileChannel2 = fileChannel3;
                    fileChannel = fileChannel4;
                }
                fileChannel3.close();
            }
            if (fileChannel2 == null) return;
            fileChannel2.close();
            return;
            break block7;
            catch (Throwable throwable) {
                fileChannel = null;
            }
        }
        if (fileChannel2 != null) {
            fileChannel2.close();
        }
        if (fileChannel == null) throw var3_6;
        fileChannel.close();
        throw var3_6;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static String getDataColumn(Context var0, Uri var1_1, String var2_2, String[] var3_3) {
        block14 : {
            block12 : {
                block13 : {
                    block11 : {
                        block9 : {
                            block10 : {
                                var4_4 = new String[]{"_data"};
                                var6_5 = var0.getContentResolver().query(var1_1, var4_4, var2_2, var3_3, null);
                                if (var6_5 == null) break block9;
                                try {
                                    if (!var6_5.moveToFirst()) break block9;
                                    var12_6 = var6_5.getString(var6_5.getColumnIndexOrThrow("_data"));
                                    if (var6_5 == null) break block10;
                                }
                                catch (IllegalArgumentException var5_7) {
                                    break block11;
                                }
                                var6_5.close();
                            }
                            return var12_6;
                        }
                        if (var6_5 != null) {
                            do {
                                var6_5.close();
                                return null;
                                break;
                            } while (true);
                        }
                        break block13;
                        catch (Throwable var7_10) {
                            var8_13 = null;
                            break block12;
                        }
                        catch (IllegalArgumentException var5_8) {
                            var6_5 = null;
                        }
                    }
                    try {
                        var9_14 = Locale.getDefault();
                        var10_15 = new Object[]{var5_9.getMessage()};
                        Log.i((String)"FileUtils", (String)String.format((Locale)var9_14, (String)"getDataColumn: _data - [%s]", (Object[])var10_15));
                        if (var6_5 != null) ** continue;
                    }
                    catch (Throwable var7_11) {
                        var8_13 = var6_5;
                    }
                }
                return null;
            }
            if (var8_13 == null) break block14;
            var8_13.close();
        }
        throw var7_12;
    }

    public static String getPath(Context context, Uri uri) {
        boolean bl = Build.VERSION.SDK_INT >= 19;
        if (bl && DocumentsContract.isDocumentUri((Context)context, (Uri)uri)) {
            if (FileUtils.isExternalStorageDocument(uri)) {
                String[] arrstring = DocumentsContract.getDocumentId((Uri)uri).split(":");
                if ("primary".equalsIgnoreCase(arrstring[0])) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)Environment.getExternalStorageDirectory());
                    stringBuilder.append("/");
                    stringBuilder.append(arrstring[1]);
                    return stringBuilder.toString();
                }
            } else if (FileUtils.isDownloadsDocument(uri)) {
                String string2 = DocumentsContract.getDocumentId((Uri)uri);
                if (!TextUtils.isEmpty((CharSequence)string2)) {
                    try {
                        String string3 = FileUtils.getDataColumn(context, ContentUris.withAppendedId((Uri)Uri.parse((String)"content://downloads/public_downloads"), (long)Long.valueOf((String)string2)), null, null);
                        return string3;
                    }
                    catch (NumberFormatException numberFormatException) {
                        Log.i((String)TAG, (String)numberFormatException.getMessage());
                        return null;
                    }
                }
            } else if (FileUtils.isMediaDocument(uri)) {
                Uri uri2;
                String[] arrstring = DocumentsContract.getDocumentId((Uri)uri).split(":");
                String string4 = arrstring[0];
                if ("image".equals((Object)string4)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals((Object)string4)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else {
                    boolean bl2 = "audio".equals((Object)string4);
                    uri2 = null;
                    if (bl2) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                }
                String[] arrstring2 = new String[]{arrstring[1]};
                return FileUtils.getDataColumn(context, uri2, "_id=?", arrstring2);
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (FileUtils.isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return FileUtils.getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals((Object)uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals((Object)uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals((Object)uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals((Object)uri.getAuthority());
    }
}

