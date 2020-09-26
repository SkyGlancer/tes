/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ir.mirrajabi.rxcontacts.Contact
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Set
 */
package app.dukhaan.network.model;

import ir.mirrajabi.rxcontacts.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SyncContactPayload {
    public Data data;
    public String name;

    public SyncContactPayload(Contact contact) {
        this.name = contact.getDisplayName();
        this.data = new Data((Set<String>)contact.getPhoneNumbers(), (Set<String>)contact.getEmails());
    }

    public class Data {
        public List<String> email = new ArrayList();
        public List<String> phone = new ArrayList();

        public Data(Set<String> set, Set<String> set2) {
            if (set2 != null && set2.size() > 0) {
                this.email.addAll(set2);
            }
            if (set != null && set.size() > 0) {
                this.phone.addAll(set);
            }
        }
    }

}

