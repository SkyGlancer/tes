/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.protobuf.AbstractMessageLite
 *  com.google.protobuf.ByteString
 *  com.google.protobuf.CodedInputStream
 *  com.google.protobuf.ExtensionRegistryLite
 *  com.google.protobuf.GeneratedMessageLite
 *  com.google.protobuf.GeneratedMessageLite$Builder
 *  com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser
 *  com.google.protobuf.GeneratedMessageLite$MethodToInvoke
 *  com.google.protobuf.Internal
 *  com.google.protobuf.Internal$EnumLite
 *  com.google.protobuf.Internal$EnumLiteMap
 *  com.google.protobuf.Internal$EnumVerifier
 *  com.google.protobuf.Internal$ProtobufList
 *  com.google.protobuf.InvalidProtocolBufferException
 *  com.google.protobuf.MessageLite
 *  com.google.protobuf.MessageLiteOrBuilder
 *  com.google.protobuf.Parser
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.nio.ByteBuffer
 *  java.util.Collections
 *  java.util.List
 */
package app.dukhaan.src.java.developers.mobile.abt;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import developers.mobile.abt.FirebaseAbt;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class FirebaseAbt {
    private FirebaseAbt() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    public static final class ExperimentLite
    extends GeneratedMessageLite<ExperimentLite, Builder>
    implements ExperimentLiteOrBuilder {
        private static final ExperimentLite DEFAULT_INSTANCE;
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        private static volatile Parser<ExperimentLite> PARSER;
        private String experimentId_ = "";

        static {
            ExperimentLite experimentLite;
            DEFAULT_INSTANCE = experimentLite = new ExperimentLite();
            GeneratedMessageLite.registerDefaultInstance(ExperimentLite.class, (GeneratedMessageLite)experimentLite);
        }

        private ExperimentLite() {
        }

        private void clearExperimentId() {
            this.experimentId_ = ExperimentLite.getDefaultInstance().getExperimentId();
        }

        public static ExperimentLite getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder)DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ExperimentLite experimentLite) {
            return (Builder)DEFAULT_INSTANCE.createBuilder((GeneratedMessageLite)experimentLite);
        }

        public static ExperimentLite parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExperimentLite)ExperimentLite.parseDelimitedFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (InputStream)inputStream);
        }

        public static ExperimentLite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExperimentLite)ExperimentLite.parseDelimitedFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (InputStream)inputStream, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (ByteString)byteString);
        }

        public static ExperimentLite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (ByteString)byteString, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (CodedInputStream)codedInputStream);
        }

        public static ExperimentLite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (CodedInputStream)codedInputStream, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(InputStream inputStream) throws IOException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (InputStream)inputStream);
        }

        public static ExperimentLite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (InputStream)inputStream, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (ByteBuffer)byteBuffer);
        }

        public static ExperimentLite parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (ByteBuffer)byteBuffer, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentLite parseFrom(byte[] arrby) throws InvalidProtocolBufferException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (byte[])arrby);
        }

        public static ExperimentLite parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExperimentLite)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (byte[])arrby, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static Parser<ExperimentLite> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void setExperimentId(String string2) {
            string2.getClass();
            this.experimentId_ = string2;
        }

        private void setExperimentIdBytes(ByteString byteString) {
            ExperimentLite.checkByteStringIsUtf8((ByteString)byteString);
            this.experimentId_ = byteString.toStringUtf8();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        protected final Object dynamicMethod(MethodToInvoke methodToInvoke, Object object, Object object2) {
            switch (1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                default: {
                    throw new UnsupportedOperationException();
                }
                case 7: {
                    return null;
                }
                case 6: {
                    return (byte)1;
                }
                case 5: {
                    Parser<ExperimentLite> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    Class<ExperimentLite> class_ = ExperimentLite.class;
                    synchronized (ExperimentLite.class) {
                        DefaultInstanceBasedParser defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            PARSER = defaultInstanceBasedParser = new DefaultInstanceBasedParser((GeneratedMessageLite)DEFAULT_INSTANCE);
                        }
                        // ** MonitorExit[var8_5] (shouldn't be in output)
                        return defaultInstanceBasedParser;
                    }
                }
                case 4: {
                    return DEFAULT_INSTANCE;
                }
                case 3: {
                    Object[] arrobject = new Object[]{"experimentId_"};
                    return ExperimentLite.newMessageInfo((MessageLite)DEFAULT_INSTANCE, (String)"\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0208", (Object[])arrobject);
                }
                case 2: {
                    return new Builder();
                }
                case 1: 
            }
            return new ExperimentLite();
        }

        @Override
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override
        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8((String)this.experimentId_);
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<ExperimentLite, Builder>
        implements ExperimentLiteOrBuilder {
            private Builder() {
                super((GeneratedMessageLite)DEFAULT_INSTANCE);
            }

            public Builder clearExperimentId() {
                this.copyOnWrite();
                ((ExperimentLite)this.instance).clearExperimentId();
                return this;
            }

            @Override
            public String getExperimentId() {
                return ((ExperimentLite)this.instance).getExperimentId();
            }

            @Override
            public ByteString getExperimentIdBytes() {
                return ((ExperimentLite)this.instance).getExperimentIdBytes();
            }

            public Builder setExperimentId(String string2) {
                this.copyOnWrite();
                ((ExperimentLite)this.instance).setExperimentId(string2);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                this.copyOnWrite();
                ((ExperimentLite)this.instance).setExperimentIdBytes(byteString);
                return this;
            }
        }

    }

    public static interface ExperimentLiteOrBuilder
    extends MessageLiteOrBuilder {
        public String getExperimentId();

        public ByteString getExperimentIdBytes();
    }

    public static final class ExperimentPayload
    extends GeneratedMessageLite<ExperimentPayload, Builder>
    implements ExperimentPayloadOrBuilder {
        public static final int ACTIVATE_EVENT_TO_LOG_FIELD_NUMBER = 8;
        public static final int CLEAR_EVENT_TO_LOG_FIELD_NUMBER = 9;
        private static final ExperimentPayload DEFAULT_INSTANCE;
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        public static final int EXPERIMENT_START_TIME_MILLIS_FIELD_NUMBER = 3;
        public static final int ONGOING_EXPERIMENTS_FIELD_NUMBER = 13;
        public static final int OVERFLOW_POLICY_FIELD_NUMBER = 12;
        private static volatile Parser<ExperimentPayload> PARSER;
        public static final int SET_EVENT_TO_LOG_FIELD_NUMBER = 7;
        public static final int TIMEOUT_EVENT_TO_LOG_FIELD_NUMBER = 10;
        public static final int TIME_TO_LIVE_MILLIS_FIELD_NUMBER = 6;
        public static final int TRIGGER_EVENT_FIELD_NUMBER = 4;
        public static final int TRIGGER_TIMEOUT_MILLIS_FIELD_NUMBER = 5;
        public static final int TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER = 11;
        public static final int VARIANT_ID_FIELD_NUMBER = 2;
        private String activateEventToLog_ = "";
        private String clearEventToLog_ = "";
        private String experimentId_ = "";
        private long experimentStartTimeMillis_;
        private Internal.ProtobufList<ExperimentLite> ongoingExperiments_ = ExperimentPayload.emptyProtobufList();
        private int overflowPolicy_;
        private String setEventToLog_ = "";
        private long timeToLiveMillis_;
        private String timeoutEventToLog_ = "";
        private String triggerEvent_ = "";
        private long triggerTimeoutMillis_;
        private String ttlExpiryEventToLog_ = "";
        private String variantId_ = "";

        static {
            ExperimentPayload experimentPayload;
            DEFAULT_INSTANCE = experimentPayload = new ExperimentPayload();
            GeneratedMessageLite.registerDefaultInstance(ExperimentPayload.class, (GeneratedMessageLite)experimentPayload);
        }

        private ExperimentPayload() {
        }

        private void addAllOngoingExperiments(Iterable<? extends ExperimentLite> iterable) {
            this.ensureOngoingExperimentsIsMutable();
            AbstractMessageLite.addAll(iterable, this.ongoingExperiments_);
        }

        private void addOngoingExperiments(int n, ExperimentLite experimentLite) {
            experimentLite.getClass();
            this.ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add(n, (Object)experimentLite);
        }

        private void addOngoingExperiments(ExperimentLite experimentLite) {
            experimentLite.getClass();
            this.ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add((Object)experimentLite);
        }

        private void clearActivateEventToLog() {
            this.activateEventToLog_ = ExperimentPayload.getDefaultInstance().getActivateEventToLog();
        }

        private void clearClearEventToLog() {
            this.clearEventToLog_ = ExperimentPayload.getDefaultInstance().getClearEventToLog();
        }

        private void clearExperimentId() {
            this.experimentId_ = ExperimentPayload.getDefaultInstance().getExperimentId();
        }

        private void clearExperimentStartTimeMillis() {
            this.experimentStartTimeMillis_ = 0L;
        }

        private void clearOngoingExperiments() {
            this.ongoingExperiments_ = ExperimentPayload.emptyProtobufList();
        }

        private void clearOverflowPolicy() {
            this.overflowPolicy_ = 0;
        }

        private void clearSetEventToLog() {
            this.setEventToLog_ = ExperimentPayload.getDefaultInstance().getSetEventToLog();
        }

        private void clearTimeToLiveMillis() {
            this.timeToLiveMillis_ = 0L;
        }

        private void clearTimeoutEventToLog() {
            this.timeoutEventToLog_ = ExperimentPayload.getDefaultInstance().getTimeoutEventToLog();
        }

        private void clearTriggerEvent() {
            this.triggerEvent_ = ExperimentPayload.getDefaultInstance().getTriggerEvent();
        }

        private void clearTriggerTimeoutMillis() {
            this.triggerTimeoutMillis_ = 0L;
        }

        private void clearTtlExpiryEventToLog() {
            this.ttlExpiryEventToLog_ = ExperimentPayload.getDefaultInstance().getTtlExpiryEventToLog();
        }

        private void clearVariantId() {
            this.variantId_ = ExperimentPayload.getDefaultInstance().getVariantId();
        }

        private void ensureOngoingExperimentsIsMutable() {
            if (!this.ongoingExperiments_.isModifiable()) {
                this.ongoingExperiments_ = GeneratedMessageLite.mutableCopy(this.ongoingExperiments_);
            }
        }

        public static ExperimentPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder)DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ExperimentPayload experimentPayload) {
            return (Builder)DEFAULT_INSTANCE.createBuilder((GeneratedMessageLite)experimentPayload);
        }

        public static ExperimentPayload parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExperimentPayload)ExperimentPayload.parseDelimitedFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (InputStream)inputStream);
        }

        public static ExperimentPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExperimentPayload)ExperimentPayload.parseDelimitedFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (InputStream)inputStream, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (ByteString)byteString);
        }

        public static ExperimentPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (ByteString)byteString, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (CodedInputStream)codedInputStream);
        }

        public static ExperimentPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (CodedInputStream)codedInputStream, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(InputStream inputStream) throws IOException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (InputStream)inputStream);
        }

        public static ExperimentPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (InputStream)inputStream, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (ByteBuffer)byteBuffer);
        }

        public static ExperimentPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (ByteBuffer)byteBuffer, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static ExperimentPayload parseFrom(byte[] arrby) throws InvalidProtocolBufferException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (byte[])arrby);
        }

        public static ExperimentPayload parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExperimentPayload)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, (byte[])arrby, (ExtensionRegistryLite)extensionRegistryLite);
        }

        public static Parser<ExperimentPayload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void removeOngoingExperiments(int n) {
            this.ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.remove(n);
        }

        private void setActivateEventToLog(String string2) {
            string2.getClass();
            this.activateEventToLog_ = string2;
        }

        private void setActivateEventToLogBytes(ByteString byteString) {
            ExperimentPayload.checkByteStringIsUtf8((ByteString)byteString);
            this.activateEventToLog_ = byteString.toStringUtf8();
        }

        private void setClearEventToLog(String string2) {
            string2.getClass();
            this.clearEventToLog_ = string2;
        }

        private void setClearEventToLogBytes(ByteString byteString) {
            ExperimentPayload.checkByteStringIsUtf8((ByteString)byteString);
            this.clearEventToLog_ = byteString.toStringUtf8();
        }

        private void setExperimentId(String string2) {
            string2.getClass();
            this.experimentId_ = string2;
        }

        private void setExperimentIdBytes(ByteString byteString) {
            ExperimentPayload.checkByteStringIsUtf8((ByteString)byteString);
            this.experimentId_ = byteString.toStringUtf8();
        }

        private void setExperimentStartTimeMillis(long l) {
            this.experimentStartTimeMillis_ = l;
        }

        private void setOngoingExperiments(int n, ExperimentLite experimentLite) {
            experimentLite.getClass();
            this.ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.set(n, (Object)experimentLite);
        }

        private void setOverflowPolicy(ExperimentOverflowPolicy experimentOverflowPolicy) {
            this.overflowPolicy_ = experimentOverflowPolicy.getNumber();
        }

        private void setOverflowPolicyValue(int n) {
            this.overflowPolicy_ = n;
        }

        private void setSetEventToLog(String string2) {
            string2.getClass();
            this.setEventToLog_ = string2;
        }

        private void setSetEventToLogBytes(ByteString byteString) {
            ExperimentPayload.checkByteStringIsUtf8((ByteString)byteString);
            this.setEventToLog_ = byteString.toStringUtf8();
        }

        private void setTimeToLiveMillis(long l) {
            this.timeToLiveMillis_ = l;
        }

        private void setTimeoutEventToLog(String string2) {
            string2.getClass();
            this.timeoutEventToLog_ = string2;
        }

        private void setTimeoutEventToLogBytes(ByteString byteString) {
            ExperimentPayload.checkByteStringIsUtf8((ByteString)byteString);
            this.timeoutEventToLog_ = byteString.toStringUtf8();
        }

        private void setTriggerEvent(String string2) {
            string2.getClass();
            this.triggerEvent_ = string2;
        }

        private void setTriggerEventBytes(ByteString byteString) {
            ExperimentPayload.checkByteStringIsUtf8((ByteString)byteString);
            this.triggerEvent_ = byteString.toStringUtf8();
        }

        private void setTriggerTimeoutMillis(long l) {
            this.triggerTimeoutMillis_ = l;
        }

        private void setTtlExpiryEventToLog(String string2) {
            string2.getClass();
            this.ttlExpiryEventToLog_ = string2;
        }

        private void setTtlExpiryEventToLogBytes(ByteString byteString) {
            ExperimentPayload.checkByteStringIsUtf8((ByteString)byteString);
            this.ttlExpiryEventToLog_ = byteString.toStringUtf8();
        }

        private void setVariantId(String string2) {
            string2.getClass();
            this.variantId_ = string2;
        }

        private void setVariantIdBytes(ByteString byteString) {
            ExperimentPayload.checkByteStringIsUtf8((ByteString)byteString);
            this.variantId_ = byteString.toStringUtf8();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        protected final Object dynamicMethod(MethodToInvoke methodToInvoke, Object object, Object object2) {
            switch (1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                default: {
                    throw new UnsupportedOperationException();
                }
                case 7: {
                    return null;
                }
                case 6: {
                    return (byte)1;
                }
                case 5: {
                    Parser<ExperimentPayload> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    Class<ExperimentPayload> class_ = ExperimentPayload.class;
                    synchronized (ExperimentPayload.class) {
                        DefaultInstanceBasedParser defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            PARSER = defaultInstanceBasedParser = new DefaultInstanceBasedParser((GeneratedMessageLite)DEFAULT_INSTANCE);
                        }
                        // ** MonitorExit[var8_5] (shouldn't be in output)
                        return defaultInstanceBasedParser;
                    }
                }
                case 4: {
                    return DEFAULT_INSTANCE;
                }
                case 3: {
                    Object[] arrobject = new Object[]{"experimentId_", "variantId_", "experimentStartTimeMillis_", "triggerEvent_", "triggerTimeoutMillis_", "timeToLiveMillis_", "setEventToLog_", "activateEventToLog_", "clearEventToLog_", "timeoutEventToLog_", "ttlExpiryEventToLog_", "overflowPolicy_", "ongoingExperiments_", ExperimentLite.class};
                    return ExperimentPayload.newMessageInfo((MessageLite)DEFAULT_INSTANCE, (String)"\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001\u0208\u0002\u0208\u0003\u0002\u0004\u0208\u0005\u0002\u0006\u0002\u0007\u0208\b\u0208\t\u0208\n\u0208\u000b\u0208\f\f\r\u001b", (Object[])arrobject);
                }
                case 2: {
                    return new Builder();
                }
                case 1: 
            }
            return new ExperimentPayload();
        }

        @Override
        public String getActivateEventToLog() {
            return this.activateEventToLog_;
        }

        @Override
        public ByteString getActivateEventToLogBytes() {
            return ByteString.copyFromUtf8((String)this.activateEventToLog_);
        }

        @Override
        public String getClearEventToLog() {
            return this.clearEventToLog_;
        }

        @Override
        public ByteString getClearEventToLogBytes() {
            return ByteString.copyFromUtf8((String)this.clearEventToLog_);
        }

        @Override
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override
        public ByteString getExperimentIdBytes() {
            return ByteString.copyFromUtf8((String)this.experimentId_);
        }

        @Override
        public long getExperimentStartTimeMillis() {
            return this.experimentStartTimeMillis_;
        }

        @Override
        public ExperimentLite getOngoingExperiments(int n) {
            return (ExperimentLite)this.ongoingExperiments_.get(n);
        }

        @Override
        public int getOngoingExperimentsCount() {
            return this.ongoingExperiments_.size();
        }

        @Override
        public List<ExperimentLite> getOngoingExperimentsList() {
            return this.ongoingExperiments_;
        }

        public ExperimentLiteOrBuilder getOngoingExperimentsOrBuilder(int n) {
            return (ExperimentLiteOrBuilder)this.ongoingExperiments_.get(n);
        }

        public List<? extends ExperimentLiteOrBuilder> getOngoingExperimentsOrBuilderList() {
            return this.ongoingExperiments_;
        }

        @Override
        public ExperimentOverflowPolicy getOverflowPolicy() {
            ExperimentOverflowPolicy experimentOverflowPolicy = ExperimentOverflowPolicy.forNumber(this.overflowPolicy_);
            if (experimentOverflowPolicy == null) {
                experimentOverflowPolicy = ExperimentOverflowPolicy.UNRECOGNIZED;
            }
            return experimentOverflowPolicy;
        }

        @Override
        public int getOverflowPolicyValue() {
            return this.overflowPolicy_;
        }

        @Override
        public String getSetEventToLog() {
            return this.setEventToLog_;
        }

        @Override
        public ByteString getSetEventToLogBytes() {
            return ByteString.copyFromUtf8((String)this.setEventToLog_);
        }

        @Override
        public long getTimeToLiveMillis() {
            return this.timeToLiveMillis_;
        }

        @Override
        public String getTimeoutEventToLog() {
            return this.timeoutEventToLog_;
        }

        @Override
        public ByteString getTimeoutEventToLogBytes() {
            return ByteString.copyFromUtf8((String)this.timeoutEventToLog_);
        }

        @Override
        public String getTriggerEvent() {
            return this.triggerEvent_;
        }

        @Override
        public ByteString getTriggerEventBytes() {
            return ByteString.copyFromUtf8((String)this.triggerEvent_);
        }

        @Override
        public long getTriggerTimeoutMillis() {
            return this.triggerTimeoutMillis_;
        }

        @Override
        public String getTtlExpiryEventToLog() {
            return this.ttlExpiryEventToLog_;
        }

        @Override
        public ByteString getTtlExpiryEventToLogBytes() {
            return ByteString.copyFromUtf8((String)this.ttlExpiryEventToLog_);
        }

        @Override
        public String getVariantId() {
            return this.variantId_;
        }

        @Override
        public ByteString getVariantIdBytes() {
            return ByteString.copyFromUtf8((String)this.variantId_);
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<ExperimentPayload, Builder>
        implements ExperimentPayloadOrBuilder {
            private Builder() {
                super((GeneratedMessageLite)DEFAULT_INSTANCE);
            }

            public Builder addAllOngoingExperiments(Iterable<? extends ExperimentLite> iterable) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).addAllOngoingExperiments((Iterable<? extends ExperimentLite>)iterable);
                return this;
            }

            public Builder addOngoingExperiments(int n, ExperimentLite.Builder builder) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).addOngoingExperiments(n, (ExperimentLite)builder.build());
                return this;
            }

            public Builder addOngoingExperiments(int n, ExperimentLite experimentLite) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).addOngoingExperiments(n, experimentLite);
                return this;
            }

            public Builder addOngoingExperiments(ExperimentLite.Builder builder) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).addOngoingExperiments((ExperimentLite)builder.build());
                return this;
            }

            public Builder addOngoingExperiments(ExperimentLite experimentLite) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).addOngoingExperiments(experimentLite);
                return this;
            }

            public Builder clearActivateEventToLog() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearActivateEventToLog();
                return this;
            }

            public Builder clearClearEventToLog() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearClearEventToLog();
                return this;
            }

            public Builder clearExperimentId() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearExperimentId();
                return this;
            }

            public Builder clearExperimentStartTimeMillis() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearExperimentStartTimeMillis();
                return this;
            }

            public Builder clearOngoingExperiments() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearOngoingExperiments();
                return this;
            }

            public Builder clearOverflowPolicy() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearOverflowPolicy();
                return this;
            }

            public Builder clearSetEventToLog() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearSetEventToLog();
                return this;
            }

            public Builder clearTimeToLiveMillis() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearTimeToLiveMillis();
                return this;
            }

            public Builder clearTimeoutEventToLog() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearTimeoutEventToLog();
                return this;
            }

            public Builder clearTriggerEvent() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearTriggerEvent();
                return this;
            }

            public Builder clearTriggerTimeoutMillis() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearTriggerTimeoutMillis();
                return this;
            }

            public Builder clearTtlExpiryEventToLog() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearTtlExpiryEventToLog();
                return this;
            }

            public Builder clearVariantId() {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).clearVariantId();
                return this;
            }

            @Override
            public String getActivateEventToLog() {
                return ((ExperimentPayload)this.instance).getActivateEventToLog();
            }

            @Override
            public ByteString getActivateEventToLogBytes() {
                return ((ExperimentPayload)this.instance).getActivateEventToLogBytes();
            }

            @Override
            public String getClearEventToLog() {
                return ((ExperimentPayload)this.instance).getClearEventToLog();
            }

            @Override
            public ByteString getClearEventToLogBytes() {
                return ((ExperimentPayload)this.instance).getClearEventToLogBytes();
            }

            @Override
            public String getExperimentId() {
                return ((ExperimentPayload)this.instance).getExperimentId();
            }

            @Override
            public ByteString getExperimentIdBytes() {
                return ((ExperimentPayload)this.instance).getExperimentIdBytes();
            }

            @Override
            public long getExperimentStartTimeMillis() {
                return ((ExperimentPayload)this.instance).getExperimentStartTimeMillis();
            }

            @Override
            public ExperimentLite getOngoingExperiments(int n) {
                return ((ExperimentPayload)this.instance).getOngoingExperiments(n);
            }

            @Override
            public int getOngoingExperimentsCount() {
                return ((ExperimentPayload)this.instance).getOngoingExperimentsCount();
            }

            @Override
            public List<ExperimentLite> getOngoingExperimentsList() {
                return Collections.unmodifiableList(((ExperimentPayload)this.instance).getOngoingExperimentsList());
            }

            @Override
            public ExperimentOverflowPolicy getOverflowPolicy() {
                return ((ExperimentPayload)this.instance).getOverflowPolicy();
            }

            @Override
            public int getOverflowPolicyValue() {
                return ((ExperimentPayload)this.instance).getOverflowPolicyValue();
            }

            @Override
            public String getSetEventToLog() {
                return ((ExperimentPayload)this.instance).getSetEventToLog();
            }

            @Override
            public ByteString getSetEventToLogBytes() {
                return ((ExperimentPayload)this.instance).getSetEventToLogBytes();
            }

            @Override
            public long getTimeToLiveMillis() {
                return ((ExperimentPayload)this.instance).getTimeToLiveMillis();
            }

            @Override
            public String getTimeoutEventToLog() {
                return ((ExperimentPayload)this.instance).getTimeoutEventToLog();
            }

            @Override
            public ByteString getTimeoutEventToLogBytes() {
                return ((ExperimentPayload)this.instance).getTimeoutEventToLogBytes();
            }

            @Override
            public String getTriggerEvent() {
                return ((ExperimentPayload)this.instance).getTriggerEvent();
            }

            @Override
            public ByteString getTriggerEventBytes() {
                return ((ExperimentPayload)this.instance).getTriggerEventBytes();
            }

            @Override
            public long getTriggerTimeoutMillis() {
                return ((ExperimentPayload)this.instance).getTriggerTimeoutMillis();
            }

            @Override
            public String getTtlExpiryEventToLog() {
                return ((ExperimentPayload)this.instance).getTtlExpiryEventToLog();
            }

            @Override
            public ByteString getTtlExpiryEventToLogBytes() {
                return ((ExperimentPayload)this.instance).getTtlExpiryEventToLogBytes();
            }

            @Override
            public String getVariantId() {
                return ((ExperimentPayload)this.instance).getVariantId();
            }

            @Override
            public ByteString getVariantIdBytes() {
                return ((ExperimentPayload)this.instance).getVariantIdBytes();
            }

            public Builder removeOngoingExperiments(int n) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).removeOngoingExperiments(n);
                return this;
            }

            public Builder setActivateEventToLog(String string2) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setActivateEventToLog(string2);
                return this;
            }

            public Builder setActivateEventToLogBytes(ByteString byteString) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setActivateEventToLogBytes(byteString);
                return this;
            }

            public Builder setClearEventToLog(String string2) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setClearEventToLog(string2);
                return this;
            }

            public Builder setClearEventToLogBytes(ByteString byteString) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setClearEventToLogBytes(byteString);
                return this;
            }

            public Builder setExperimentId(String string2) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setExperimentId(string2);
                return this;
            }

            public Builder setExperimentIdBytes(ByteString byteString) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setExperimentIdBytes(byteString);
                return this;
            }

            public Builder setExperimentStartTimeMillis(long l) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setExperimentStartTimeMillis(l);
                return this;
            }

            public Builder setOngoingExperiments(int n, ExperimentLite.Builder builder) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setOngoingExperiments(n, (ExperimentLite)builder.build());
                return this;
            }

            public Builder setOngoingExperiments(int n, ExperimentLite experimentLite) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setOngoingExperiments(n, experimentLite);
                return this;
            }

            public Builder setOverflowPolicy(ExperimentOverflowPolicy experimentOverflowPolicy) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setOverflowPolicy(experimentOverflowPolicy);
                return this;
            }

            public Builder setOverflowPolicyValue(int n) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setOverflowPolicyValue(n);
                return this;
            }

            public Builder setSetEventToLog(String string2) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setSetEventToLog(string2);
                return this;
            }

            public Builder setSetEventToLogBytes(ByteString byteString) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setSetEventToLogBytes(byteString);
                return this;
            }

            public Builder setTimeToLiveMillis(long l) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setTimeToLiveMillis(l);
                return this;
            }

            public Builder setTimeoutEventToLog(String string2) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setTimeoutEventToLog(string2);
                return this;
            }

            public Builder setTimeoutEventToLogBytes(ByteString byteString) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setTimeoutEventToLogBytes(byteString);
                return this;
            }

            public Builder setTriggerEvent(String string2) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setTriggerEvent(string2);
                return this;
            }

            public Builder setTriggerEventBytes(ByteString byteString) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setTriggerEventBytes(byteString);
                return this;
            }

            public Builder setTriggerTimeoutMillis(long l) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setTriggerTimeoutMillis(l);
                return this;
            }

            public Builder setTtlExpiryEventToLog(String string2) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setTtlExpiryEventToLog(string2);
                return this;
            }

            public Builder setTtlExpiryEventToLogBytes(ByteString byteString) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setTtlExpiryEventToLogBytes(byteString);
                return this;
            }

            public Builder setVariantId(String string2) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setVariantId(string2);
                return this;
            }

            public Builder setVariantIdBytes(ByteString byteString) {
                this.copyOnWrite();
                ((ExperimentPayload)this.instance).setVariantIdBytes(byteString);
                return this;
            }
        }

        public static final class ExperimentOverflowPolicy
        extends Enum<ExperimentOverflowPolicy>
        implements Internal.EnumLite {
            private static final /* synthetic */ ExperimentOverflowPolicy[] $VALUES;
            public static final /* enum */ ExperimentOverflowPolicy DISCARD_OLDEST;
            public static final int DISCARD_OLDEST_VALUE = 1;
            public static final /* enum */ ExperimentOverflowPolicy IGNORE_NEWEST;
            public static final int IGNORE_NEWEST_VALUE = 2;
            public static final /* enum */ ExperimentOverflowPolicy POLICY_UNSPECIFIED;
            public static final int POLICY_UNSPECIFIED_VALUE;
            public static final /* enum */ ExperimentOverflowPolicy UNRECOGNIZED;
            private static final Internal.EnumLiteMap<ExperimentOverflowPolicy> internalValueMap;
            private final int value;

            static {
                ExperimentOverflowPolicy experimentOverflowPolicy;
                POLICY_UNSPECIFIED = new ExperimentOverflowPolicy(0);
                DISCARD_OLDEST = new ExperimentOverflowPolicy(1);
                IGNORE_NEWEST = new ExperimentOverflowPolicy(2);
                UNRECOGNIZED = experimentOverflowPolicy = new ExperimentOverflowPolicy(-1);
                ExperimentOverflowPolicy[] arrexperimentOverflowPolicy = new ExperimentOverflowPolicy[]{POLICY_UNSPECIFIED, DISCARD_OLDEST, IGNORE_NEWEST, experimentOverflowPolicy};
                $VALUES = arrexperimentOverflowPolicy;
                internalValueMap = new Internal.EnumLiteMap<ExperimentOverflowPolicy>(){

                    public ExperimentOverflowPolicy findValueByNumber(int n) {
                        return ExperimentOverflowPolicy.forNumber(n);
                    }
                };
            }

            private ExperimentOverflowPolicy(int n2) {
                this.value = n2;
            }

            public static ExperimentOverflowPolicy forNumber(int n) {
                if (n != 0) {
                    if (n != 1) {
                        if (n != 2) {
                            return null;
                        }
                        return IGNORE_NEWEST;
                    }
                    return DISCARD_OLDEST;
                }
                return POLICY_UNSPECIFIED;
            }

            public static Internal.EnumLiteMap<ExperimentOverflowPolicy> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ExperimentOverflowPolicyVerifier.INSTANCE;
            }

            @Deprecated
            public static ExperimentOverflowPolicy valueOf(int n) {
                return ExperimentOverflowPolicy.forNumber(n);
            }

            public static ExperimentOverflowPolicy valueOf(String string2) {
                return (ExperimentOverflowPolicy)Enum.valueOf(ExperimentOverflowPolicy.class, (String)string2);
            }

            public static ExperimentOverflowPolicy[] values() {
                return (ExperimentOverflowPolicy[])$VALUES.clone();
            }

            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            private static final class ExperimentOverflowPolicyVerifier
            implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new ExperimentOverflowPolicyVerifier();

                private ExperimentOverflowPolicyVerifier() {
                }

                public boolean isInRange(int n) {
                    return ExperimentOverflowPolicy.forNumber(n) != null;
                }
            }

        }

    }

    public static interface ExperimentPayloadOrBuilder
    extends MessageLiteOrBuilder {
        public String getActivateEventToLog();

        public ByteString getActivateEventToLogBytes();

        public String getClearEventToLog();

        public ByteString getClearEventToLogBytes();

        public String getExperimentId();

        public ByteString getExperimentIdBytes();

        public long getExperimentStartTimeMillis();

        public ExperimentLite getOngoingExperiments(int var1);

        public int getOngoingExperimentsCount();

        public List<ExperimentLite> getOngoingExperimentsList();

        public ExperimentPayload.ExperimentOverflowPolicy getOverflowPolicy();

        public int getOverflowPolicyValue();

        public String getSetEventToLog();

        public ByteString getSetEventToLogBytes();

        public long getTimeToLiveMillis();

        public String getTimeoutEventToLog();

        public ByteString getTimeoutEventToLogBytes();

        public String getTriggerEvent();

        public ByteString getTriggerEventBytes();

        public long getTriggerTimeoutMillis();

        public String getTtlExpiryEventToLog();

        public ByteString getTtlExpiryEventToLogBytes();

        public String getVariantId();

        public ByteString getVariantIdBytes();
    }

}

