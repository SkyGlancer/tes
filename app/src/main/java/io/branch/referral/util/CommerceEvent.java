/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral.util;

import io.branch.referral.util.CurrencyType;
import io.branch.referral.util.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CommerceEvent {
    private String affiliation;
    private String coupon;
    private CurrencyType currencyType;
    private List<Product> products;
    private Double revenue;
    private Double shipping;
    private Double tax;
    private String transactionID;

    public CommerceEvent() {
    }

    public CommerceEvent(Double d, CurrencyType currencyType, String string2, Double d2, Double d3, String string3, String string4, Product product) {
        ArrayList arrayList;
        this.revenue = d;
        this.currencyType = currencyType;
        this.transactionID = string2;
        this.shipping = d2;
        this.tax = d3;
        this.coupon = string3;
        this.affiliation = string4;
        this.products = arrayList = new ArrayList();
        arrayList.add((Object)product);
    }

    public CommerceEvent(Double d, CurrencyType currencyType, String string2, Double d2, Double d3, String string3, String string4, List<Product> list) {
        this.revenue = d;
        this.currencyType = currencyType;
        this.transactionID = string2;
        this.shipping = d2;
        this.tax = d3;
        this.coupon = string3;
        this.affiliation = string4;
        this.products = list;
    }

    public void addProduct(Product product) {
        if (this.products == null) {
            this.products = new ArrayList();
        }
        this.products.add((Object)product);
    }

    public String getAffiliation() {
        return this.affiliation;
    }

    /*
     * Exception decompiling
     */
    public JSONObject getCommerceJSONObject() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public String getCoupon() {
        return this.coupon;
    }

    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public List<JSONObject> getProducts() {
        if (this.products == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.products.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((Product)iterator.next()).getProductJSONObject());
        }
        return arrayList;
    }

    public Double getRevenue() {
        return this.revenue;
    }

    public Double getShipping() {
        return this.shipping;
    }

    public Double getTax() {
        return this.tax;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setAffiliation(String string2) {
        this.affiliation = string2;
    }

    public void setCoupon(String string2) {
        this.coupon = string2;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public void setProducts(List<Product> list) {
        this.products = list;
    }

    public void setRevenue(Double d) {
        this.revenue = d;
    }

    public void setShipping(Double d) {
        this.shipping = d;
    }

    public void setTax(Double d) {
        this.tax = d;
    }

    public void setTransactionID(String string2) {
        this.transactionID = string2;
    }
}

