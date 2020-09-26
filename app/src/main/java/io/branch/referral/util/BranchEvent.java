/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.branch.referral.Branch
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral.util;

import android.content.Context;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import io.branch.referral.util.AdType;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.CurrencyType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BranchEvent {
    private final List<BranchUniversalObject> buoList;
    private final JSONObject customProperties = new JSONObject();
    private final String eventName;
    private final boolean isStandardEvent;
    private final JSONObject standardProperties = new JSONObject();
    private final HashMap<String, Object> topLevelProperties = new HashMap();

    public BranchEvent(BRANCH_STANDARD_EVENT bRANCH_STANDARD_EVENT) {
        this(bRANCH_STANDARD_EVENT.getName());
    }

    public BranchEvent(String string2) {
        boolean bl;
        this.eventName = string2;
        BRANCH_STANDARD_EVENT[] arrbRANCH_STANDARD_EVENT = BRANCH_STANDARD_EVENT.values();
        int n = arrbRANCH_STANDARD_EVENT.length;
        int n2 = 0;
        do {
            bl = false;
            if (n2 >= n) break;
            if (string2.equals((Object)arrbRANCH_STANDARD_EVENT[n2].getName())) {
                bl = true;
                break;
            }
            ++n2;
        } while (true);
        this.isStandardEvent = bl;
        this.buoList = new ArrayList();
    }

    private BranchEvent addStandardProperty(String string2, Object object) {
        if (object != null) {
            try {
                this.standardProperties.put(string2, object);
                return this;
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                return this;
            }
        }
        this.standardProperties.remove(string2);
        return this;
    }

    private BranchEvent addTopLevelProperty(String string2, Object object) {
        if (!this.topLevelProperties.containsKey((Object)string2)) {
            this.topLevelProperties.put((Object)string2, object);
            return this;
        }
        this.topLevelProperties.remove((Object)string2);
        return this;
    }

    public BranchEvent addContentItems(List<BranchUniversalObject> list) {
        this.buoList.addAll(list);
        return this;
    }

    public /* varargs */ BranchEvent addContentItems(BranchUniversalObject ... arrbranchUniversalObject) {
        Collections.addAll(this.buoList, (Object[])arrbranchUniversalObject);
        return this;
    }

    public BranchEvent addCustomDataProperty(String string2, String string3) {
        try {
            this.customProperties.put(string2, (Object)string3);
            return this;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return this;
        }
    }

    public String getEventName() {
        return this.eventName;
    }

    public boolean logEvent(Context context) {
        Defines.RequestPath requestPath = this.isStandardEvent ? Defines.RequestPath.TrackStandardEvent : Defines.RequestPath.TrackCustomEvent;
        String string2 = requestPath.getPath();
        if (Branch.getInstance() != null) {
            Branch.getInstance().handleNewRequest((ServerRequest)new ServerRequestLogEvent(context, string2));
            return true;
        }
        return false;
    }

    public BranchEvent setAdType(AdType adType) {
        return this.addStandardProperty(Defines.Jsonkey.AdType.getKey(), adType.getName());
    }

    public BranchEvent setAffiliation(String string2) {
        return this.addStandardProperty(Defines.Jsonkey.Affiliation.getKey(), string2);
    }

    public BranchEvent setCoupon(String string2) {
        return this.addStandardProperty(Defines.Jsonkey.Coupon.getKey(), string2);
    }

    public BranchEvent setCurrency(CurrencyType currencyType) {
        return this.addStandardProperty(Defines.Jsonkey.Currency.getKey(), currencyType.toString());
    }

    public BranchEvent setCustomerEventAlias(String string2) {
        return this.addTopLevelProperty(Defines.Jsonkey.CustomerEventAlias.getKey(), string2);
    }

    public BranchEvent setDescription(String string2) {
        return this.addStandardProperty(Defines.Jsonkey.Description.getKey(), string2);
    }

    public BranchEvent setRevenue(double d) {
        return this.addStandardProperty(Defines.Jsonkey.Revenue.getKey(), d);
    }

    public BranchEvent setSearchQuery(String string2) {
        return this.addStandardProperty(Defines.Jsonkey.SearchQuery.getKey(), string2);
    }

    public BranchEvent setShipping(double d) {
        return this.addStandardProperty(Defines.Jsonkey.Shipping.getKey(), d);
    }

    public BranchEvent setTax(double d) {
        return this.addStandardProperty(Defines.Jsonkey.Tax.getKey(), d);
    }

    public BranchEvent setTransactionID(String string2) {
        return this.addStandardProperty(Defines.Jsonkey.TransactionID.getKey(), string2);
    }

    private class ServerRequestLogEvent
    extends ServerRequest {
        ServerRequestLogEvent(Context context, String string2) {
            super(context, string2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Defines.Jsonkey.Name.getKey(), (Object)BranchEvent.this.eventName);
                if (BranchEvent.this.customProperties.length() > 0) {
                    jSONObject.put(Defines.Jsonkey.CustomData.getKey(), (Object)BranchEvent.this.customProperties);
                }
                if (BranchEvent.this.standardProperties.length() > 0) {
                    jSONObject.put(Defines.Jsonkey.EventData.getKey(), (Object)BranchEvent.this.standardProperties);
                }
                if (BranchEvent.this.topLevelProperties.size() > 0) {
                    for (Map.Entry entry : BranchEvent.this.topLevelProperties.entrySet()) {
                        jSONObject.put((String)entry.getKey(), entry.getValue());
                    }
                }
                if (BranchEvent.this.buoList.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    jSONObject.put(Defines.Jsonkey.ContentItems.getKey(), (Object)jSONArray);
                    Iterator iterator = BranchEvent.this.buoList.iterator();
                    while (iterator.hasNext()) {
                        jSONArray.put((Object)((BranchUniversalObject)iterator.next()).convertToJson());
                    }
                }
                this.setPost(jSONObject);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            this.updateEnvironment(context, jSONObject);
        }

        @Override
        public void clearCallbacks() {
        }

        @Override
        public ServerRequest.BRANCH_API_VERSION getBranchRemoteAPIVersion() {
            return ServerRequest.BRANCH_API_VERSION.V2;
        }

        @Override
        public boolean handleErrors(Context context) {
            return false;
        }

        @Override
        public void handleFailure(int n, String string2) {
        }

        @Override
        public boolean isGetRequest() {
            return false;
        }

        @Override
        public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        }

        @Override
        public boolean shouldRetryOnFail() {
            return true;
        }

        @Override
        protected boolean shouldUpdateLimitFacebookTracking() {
            return true;
        }
    }

}

