/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.data.model;

import com.google.gson.annotations.SerializedName;

public class UploadImage {
    @SerializedName(value="data")
    private Data data;
    @SerializedName(value="status")
    private String status;

    public Data getData() {
        return this.data;
    }

    public String getStatus() {
        return this.status;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setStatus(String string2) {
        this.status = string2;
    }

    public class Data {
        @SerializedName(value="data")
        public ChildData childData;

        public ChildData getChildData() {
            return this.childData;
        }

        public void setChildData(ChildData childData) {
            this.childData = childData;
        }

        public class ChildData {
            @SerializedName(value="file")
            public String file;
            @SerializedName(value="id")
            public String id;

            public String getFile() {
                return this.file;
            }

            public String getId() {
                return this.id;
            }

            public void setFile(String string2) {
                this.file = string2;
            }

            public void setId(String string2) {
                this.id = string2;
            }
        }

    }

}

