/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.Path$Op
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.ListIterator
 */
package app.dukhaan.src.java.com.airbnb.lottie.animation.content;

import android.graphics.Matrix;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.content.GreedyContent;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MergePathsContent
implements PathContent,
GreedyContent {
    private final Path firstPath = new Path();
    private final MergePaths mergePaths;
    private final String name;
    private final Path path = new Path();
    private final List<PathContent> pathContents = new ArrayList();
    private final Path remainderPath = new Path();

    public MergePathsContent(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.name = mergePaths.getName();
            this.mergePaths = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    private void addPaths() {
        for (int i = 0; i < this.pathContents.size(); ++i) {
            this.path.addPath(((PathContent)this.pathContents.get(i)).getPath());
        }
    }

    private void opFirstPathWithRest(Path.Op op) {
        this.remainderPath.reset();
        this.firstPath.reset();
        for (int i = this.pathContents.size() - 1; i >= 1; --i) {
            PathContent pathContent = (PathContent)this.pathContents.get(i);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup)pathContent;
                List<PathContent> list = contentGroup.getPathList();
                for (int j = list.size() - 1; j >= 0; --j) {
                    Path path = ((PathContent)list.get(j)).getPath();
                    path.transform(contentGroup.getTransformationMatrix());
                    this.remainderPath.addPath(path);
                }
                continue;
            }
            this.remainderPath.addPath(pathContent.getPath());
        }
        List<PathContent> list = this.pathContents;
        PathContent pathContent = (PathContent)list.get(0);
        if (pathContent instanceof ContentGroup) {
            ContentGroup contentGroup = (ContentGroup)pathContent;
            List<PathContent> list2 = contentGroup.getPathList();
            for (int i = 0; i < list2.size(); ++i) {
                Path path = ((PathContent)list2.get(i)).getPath();
                path.transform(contentGroup.getTransformationMatrix());
                this.firstPath.addPath(path);
            }
        } else {
            this.firstPath.set(pathContent.getPath());
        }
        this.path.op(this.firstPath, this.remainderPath, op);
    }

    @Override
    public void absorbContent(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content content = (Content)listIterator.previous();
            if (!(content instanceof PathContent)) continue;
            this.pathContents.add((Object)((PathContent)content));
            listIterator.remove();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Path getPath() {
        this.path.reset();
        if (this.mergePaths.isHidden()) {
            return this.path;
        }
        int n = 1.$SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[this.mergePaths.getMode().ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n == 5) {
                            this.opFirstPathWithRest(Path.Op.XOR);
                        }
                    } else {
                        this.opFirstPathWithRest(Path.Op.INTERSECT);
                    }
                } else {
                    this.opFirstPathWithRest(Path.Op.REVERSE_DIFFERENCE);
                }
            } else {
                this.opFirstPathWithRest(Path.Op.UNION);
            }
        } else {
            this.addPaths();
        }
        return this.path;
    }

    @Override
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.pathContents.size(); ++i) {
            ((PathContent)this.pathContents.get(i)).setContents(list, list2);
        }
    }
}

