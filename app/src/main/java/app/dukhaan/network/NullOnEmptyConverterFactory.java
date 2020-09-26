/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  okhttp3.ResponseBody
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 */
package app.dukhaan.network;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class NullOnEmptyConverterFactory
extends Converter.Factory {
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] arrannotation, Retrofit retrofit) {
        return new Converter<ResponseBody, Object>(retrofit.nextResponseBodyConverter((Converter.Factory)this, type, arrannotation)){
            final /* synthetic */ Converter val$delegate;
            {
                this.val$delegate = converter;
            }

            public Object convert(ResponseBody responseBody) throws IOException {
                if (responseBody.contentLength() == 0L) {
                    return null;
                }
                return this.val$delegate.convert((Object)responseBody);
            }
        };
    }

}

