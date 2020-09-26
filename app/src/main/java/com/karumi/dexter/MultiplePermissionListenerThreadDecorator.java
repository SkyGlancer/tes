/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.List
 */
package app.dukhaan.src.java.com.karumi.dexter;

import com.karumi.dexter.MultiplePermissionListenerThreadDecorator;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.Thread;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.util.List;

final class MultiplePermissionListenerThreadDecorator
implements MultiplePermissionsListener {
    private final MultiplePermissionsListener listener;
    private final java.lang.Thread thread;

    MultiplePermissionListenerThreadDecorator(MultiplePermissionsListener multiplePermissionsListener, java.lang.Thread thread) {
        this.thread = thread;
        this.listener = multiplePermissionsListener;
    }

    static /* synthetic */ MultiplePermissionsListener access$000(MultiplePermissionListenerThreadDecorator multiplePermissionListenerThreadDecorator) {
        return multiplePermissionListenerThreadDecorator.listener;
    }

    @Override
    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
        this.thread.execute(new Runnable(this, list, permissionToken){
            final /* synthetic */ MultiplePermissionListenerThreadDecorator this$0;
            final /* synthetic */ List val$permissions;
            final /* synthetic */ PermissionToken val$token;
            {
                this.this$0 = multiplePermissionListenerThreadDecorator;
                this.val$permissions = list;
                this.val$token = permissionToken;
            }

            public void run() {
                MultiplePermissionListenerThreadDecorator.access$000(this.this$0).onPermissionRationaleShouldBeShown((List<PermissionRequest>)this.val$permissions, this.val$token);
            }
        });
    }

    @Override
    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
        this.thread.execute(new Runnable(this, multiplePermissionsReport){
            final /* synthetic */ MultiplePermissionListenerThreadDecorator this$0;
            final /* synthetic */ MultiplePermissionsReport val$report;
            {
                this.this$0 = multiplePermissionListenerThreadDecorator;
                this.val$report = multiplePermissionsReport;
            }

            public void run() {
                MultiplePermissionListenerThreadDecorator.access$000(this.this$0).onPermissionsChecked(this.val$report);
            }
        });
    }
}

