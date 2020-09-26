/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Business
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.network.model;

import app.dukhaan.data.model.Business;
import app.dukhaan.network.model.BaseResponse;
import java.util.List;

public class LoginResponse
extends BaseResponse {
    public Data data;

    public Business getBusiness() {
        if (this.data.business != null && this.data.business.size() > 0) {
            return (Business)this.data.business.get(0);
        }
        return null;
    }

    public String getToken() {
        Data data = this.data;
        if (data != null) {
            return data.token;
        }
        return null;
    }

}

