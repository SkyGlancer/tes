/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Iterator
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.text.TextUtils;
import io.branch.referral.Defines;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BranchLinkData
extends JSONObject {
    private String alias;
    private String campaign;
    private String channel;
    private int duration;
    private String feature;
    private JSONObject params;
    private String stage;
    private Collection<String> tags;
    private int type;

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        BranchLinkData branchLinkData = (BranchLinkData)((Object)object);
        String string2 = this.alias;
        if (string2 == null ? branchLinkData.alias != null : !string2.equals((Object)branchLinkData.alias)) {
            return false;
        }
        String string3 = this.channel;
        if (string3 == null ? branchLinkData.channel != null : !string3.equals((Object)branchLinkData.channel)) {
            return false;
        }
        String string4 = this.feature;
        if (string4 == null ? branchLinkData.feature != null : !string4.equals((Object)branchLinkData.feature)) {
            return false;
        }
        JSONObject jSONObject = this.params;
        if (jSONObject == null ? branchLinkData.params != null : !jSONObject.equals((Object)branchLinkData.params)) {
            return false;
        }
        String string5 = this.stage;
        if (string5 == null ? branchLinkData.stage != null : !string5.equals((Object)branchLinkData.stage)) {
            return false;
        }
        String string6 = this.campaign;
        if (string6 == null ? branchLinkData.campaign != null : !string6.equals((Object)branchLinkData.campaign)) {
            return false;
        }
        if (this.type != branchLinkData.type) {
            return false;
        }
        if (this.duration != branchLinkData.duration) {
            return false;
        }
        Collection<String> collection = this.tags;
        return !(collection == null ? branchLinkData.tags != null : !collection.toString().equals((Object)branchLinkData.tags.toString()));
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCampaign() {
        return this.campaign;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getFeature() {
        return this.feature;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public JSONObject getLinkDataJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean bl = TextUtils.isEmpty((CharSequence)this.channel);
            if (!bl) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("~");
                stringBuilder.append(Defines.LinkParam.Channel.getKey());
                jSONObject.put(stringBuilder.toString(), (Object)this.channel);
            }
            if (!TextUtils.isEmpty((CharSequence)this.alias)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("~");
                stringBuilder.append(Defines.LinkParam.Alias.getKey());
                jSONObject.put(stringBuilder.toString(), (Object)this.alias);
            }
            if (!TextUtils.isEmpty((CharSequence)this.feature)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("~");
                stringBuilder.append(Defines.LinkParam.Feature.getKey());
                jSONObject.put(stringBuilder.toString(), (Object)this.feature);
            }
            if (!TextUtils.isEmpty((CharSequence)this.stage)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("~");
                stringBuilder.append(Defines.LinkParam.Stage.getKey());
                jSONObject.put(stringBuilder.toString(), (Object)this.stage);
            }
            if (!TextUtils.isEmpty((CharSequence)this.campaign)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("~");
                stringBuilder.append(Defines.LinkParam.Campaign.getKey());
                jSONObject.put(stringBuilder.toString(), (Object)this.campaign);
            }
            if (this.has(Defines.LinkParam.Tags.getKey())) {
                jSONObject.put(Defines.LinkParam.Tags.getKey(), (Object)this.getJSONArray(Defines.LinkParam.Tags.getKey()));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("~");
            stringBuilder.append(Defines.LinkParam.Type.getKey());
            jSONObject.put(stringBuilder.toString(), this.type);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("~");
            stringBuilder2.append(Defines.LinkParam.Duration.getKey());
            jSONObject.put(stringBuilder2.toString(), this.duration);
            return jSONObject;
        }
        catch (JSONException jSONException) {}
        return jSONObject;
    }

    public JSONObject getParams() {
        return this.params;
    }

    public String getStage() {
        return this.stage;
    }

    public Collection<String> getTags() {
        return this.tags;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int n = 19 * (19 + this.type);
        String string2 = this.alias;
        int n2 = string2 == null ? 0 : string2.toLowerCase().hashCode();
        int n3 = 19 * (n + n2);
        String string3 = this.channel;
        int n4 = string3 == null ? 0 : string3.toLowerCase().hashCode();
        int n5 = 19 * (n3 + n4);
        String string4 = this.feature;
        int n6 = string4 == null ? 0 : string4.toLowerCase().hashCode();
        int n7 = 19 * (n5 + n6);
        String string5 = this.stage;
        int n8 = string5 == null ? 0 : string5.toLowerCase().hashCode();
        int n9 = 19 * (n7 + n8);
        String string6 = this.campaign;
        int n10 = string6 == null ? 0 : string6.toLowerCase().hashCode();
        int n11 = 19 * (n9 + n10);
        JSONObject jSONObject = this.params;
        int n12 = jSONObject == null ? 0 : jSONObject.toString().toLowerCase().hashCode();
        int n13 = 19 * (n11 + n12) + this.duration;
        Collection<String> collection = this.tags;
        if (collection != null) {
            for (String string7 : collection) {
                n13 = n13 * 19 + string7.toLowerCase().hashCode();
            }
        }
        return n13;
    }

    public void putAlias(String string2) throws JSONException {
        if (string2 != null) {
            this.alias = string2;
            this.put(Defines.LinkParam.Alias.getKey(), (Object)string2);
        }
    }

    public void putCampaign(String string2) throws JSONException {
        if (string2 != null) {
            this.campaign = string2;
            this.put(Defines.LinkParam.Campaign.getKey(), (Object)string2);
        }
    }

    public void putChannel(String string2) throws JSONException {
        if (string2 != null) {
            this.channel = string2;
            this.put(Defines.LinkParam.Channel.getKey(), (Object)string2);
        }
    }

    public void putDuration(int n) throws JSONException {
        if (n > 0) {
            this.duration = n;
            this.put(Defines.LinkParam.Duration.getKey(), n);
        }
    }

    public void putFeature(String string2) throws JSONException {
        if (string2 != null) {
            this.feature = string2;
            this.put(Defines.LinkParam.Feature.getKey(), (Object)string2);
        }
    }

    public void putParams(JSONObject jSONObject) throws JSONException {
        this.params = jSONObject;
        this.put(Defines.LinkParam.Data.getKey(), (Object)jSONObject);
    }

    public void putStage(String string2) throws JSONException {
        if (string2 != null) {
            this.stage = string2;
            this.put(Defines.LinkParam.Stage.getKey(), (Object)string2);
        }
    }

    public void putTags(Collection<String> collection) throws JSONException {
        if (collection != null) {
            this.tags = collection;
            JSONArray jSONArray = new JSONArray();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)((String)iterator.next()));
            }
            this.put(Defines.LinkParam.Tags.getKey(), (Object)jSONArray);
        }
    }

    public void putType(int n) throws JSONException {
        if (n != 0) {
            this.type = n;
            this.put(Defines.LinkParam.Type.getKey(), n);
        }
    }
}

