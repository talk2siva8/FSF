package com.thesis.dataserviceprovider;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThriftService {

  public interface Iface {

    public boolean pushSDQML(String xml) throws InvalidSDQML, org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void pushSDQML(String xml, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public boolean pushSDQML(String xml) throws InvalidSDQML, org.apache.thrift.TException
    {
      send_pushSDQML(xml);
      return recv_pushSDQML();
    }

    public void send_pushSDQML(String xml) throws org.apache.thrift.TException
    {
      pushSDQML_args args = new pushSDQML_args();
      args.setXml(xml);
      sendBase("pushSDQML", args);
    }

    public boolean recv_pushSDQML() throws InvalidSDQML, org.apache.thrift.TException
    {
      pushSDQML_result result = new pushSDQML_result();
      receiveBase(result, "pushSDQML");
      if (result.isSetSuccess()) {
        return result.success;
      }
      if (result.ouch != null) {
        throw result.ouch;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "pushSDQML failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void pushSDQML(String xml, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
      checkReady();
      pushSDQML_call method_call = new pushSDQML_call(xml, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class pushSDQML_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String xml;
      public pushSDQML_call(String xml, org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.xml = xml;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("pushSDQML", org.apache.thrift.protocol.TMessageType.CALL, 0));
        pushSDQML_args args = new pushSDQML_args();
        args.setXml(xml);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public boolean getResult() throws InvalidSDQML, org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_pushSDQML();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("pushSDQML", new pushSDQML());
      return processMap;
    }

    public static class pushSDQML<I extends Iface> extends org.apache.thrift.ProcessFunction<I, pushSDQML_args> {
      public pushSDQML() {
        super("pushSDQML");
      }

      public pushSDQML_args getEmptyArgsInstance() {
        return new pushSDQML_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public pushSDQML_result getResult(I iface, pushSDQML_args args) throws org.apache.thrift.TException {
        pushSDQML_result result = new pushSDQML_result();
        try {
          result.success = iface.pushSDQML(args.xml);
          result.setSuccessIsSet(true);
        } catch (InvalidSDQML ouch) {
          result.ouch = ouch;
        }
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("pushSDQML", new pushSDQML());
      return processMap;
    }

    public static class pushSDQML<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, pushSDQML_args, Boolean> {
      public pushSDQML() {
        super("pushSDQML");
      }

      public pushSDQML_args getEmptyArgsInstance() {
        return new pushSDQML_args();
      }

      public AsyncMethodCallback<Boolean> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new AsyncMethodCallback<Boolean>() { 
          public void onComplete(Boolean o) {
            pushSDQML_result result = new pushSDQML_result();
            result.success = o;
            result.setSuccessIsSet(true);
            try {
              fcall.sendResponse(fb,result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
              return;
            } catch (Exception e) {
              LOGGER.error("Exception writing to internal frame buffer", e);
            }
            fb.close();
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TBase msg;
            pushSDQML_result result = new pushSDQML_result();
            if (e instanceof InvalidSDQML) {
                        result.ouch = (InvalidSDQML) e;
                        result.setOuchIsSet(true);
                        msg = result;
            }
             else 
            {
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TBase)new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
              return;
            } catch (Exception ex) {
              LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            fb.close();
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, pushSDQML_args args, org.apache.thrift.async.AsyncMethodCallback<Boolean> resultHandler) throws TException {
        iface.pushSDQML(args.xml,resultHandler);
      }
    }

  }

  public static class pushSDQML_args implements org.apache.thrift.TBase<pushSDQML_args, pushSDQML_args._Fields>, java.io.Serializable, Cloneable, Comparable<pushSDQML_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("pushSDQML_args");

    private static final org.apache.thrift.protocol.TField XML_FIELD_DESC = new org.apache.thrift.protocol.TField("xml", org.apache.thrift.protocol.TType.STRING, (short)1);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new pushSDQML_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new pushSDQML_argsTupleSchemeFactory());
    }

    public String xml; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      XML((short)1, "xml");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // XML
            return XML;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.XML, new org.apache.thrift.meta_data.FieldMetaData("xml", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(pushSDQML_args.class, metaDataMap);
    }

    public pushSDQML_args() {
    }

    public pushSDQML_args(
      String xml)
    {
      this();
      this.xml = xml;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public pushSDQML_args(pushSDQML_args other) {
      if (other.isSetXml()) {
        this.xml = other.xml;
      }
    }

    public pushSDQML_args deepCopy() {
      return new pushSDQML_args(this);
    }

    @Override
    public void clear() {
      this.xml = null;
    }

    public String getXml() {
      return this.xml;
    }

    public pushSDQML_args setXml(String xml) {
      this.xml = xml;
      return this;
    }

    public void unsetXml() {
      this.xml = null;
    }

    /** Returns true if field xml is set (has been assigned a value) and false otherwise */
    public boolean isSetXml() {
      return this.xml != null;
    }

    public void setXmlIsSet(boolean value) {
      if (!value) {
        this.xml = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case XML:
        if (value == null) {
          unsetXml();
        } else {
          setXml((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case XML:
        return getXml();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case XML:
        return isSetXml();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof pushSDQML_args)
        return this.equals((pushSDQML_args)that);
      return false;
    }

    public boolean equals(pushSDQML_args that) {
      if (that == null)
        return false;

      boolean this_present_xml = true && this.isSetXml();
      boolean that_present_xml = true && that.isSetXml();
      if (this_present_xml || that_present_xml) {
        if (!(this_present_xml && that_present_xml))
          return false;
        if (!this.xml.equals(that.xml))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    @Override
    public int compareTo(pushSDQML_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetXml()).compareTo(other.isSetXml());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetXml()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.xml, other.xml);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("pushSDQML_args(");
      boolean first = true;

      sb.append("xml:");
      if (this.xml == null) {
        sb.append("null");
      } else {
        sb.append(this.xml);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class pushSDQML_argsStandardSchemeFactory implements SchemeFactory {
      public pushSDQML_argsStandardScheme getScheme() {
        return new pushSDQML_argsStandardScheme();
      }
    }

    private static class pushSDQML_argsStandardScheme extends StandardScheme<pushSDQML_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, pushSDQML_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // XML
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.xml = iprot.readString();
                struct.setXmlIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, pushSDQML_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.xml != null) {
          oprot.writeFieldBegin(XML_FIELD_DESC);
          oprot.writeString(struct.xml);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class pushSDQML_argsTupleSchemeFactory implements SchemeFactory {
      public pushSDQML_argsTupleScheme getScheme() {
        return new pushSDQML_argsTupleScheme();
      }
    }

    private static class pushSDQML_argsTupleScheme extends TupleScheme<pushSDQML_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, pushSDQML_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetXml()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetXml()) {
          oprot.writeString(struct.xml);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, pushSDQML_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.xml = iprot.readString();
          struct.setXmlIsSet(true);
        }
      }
    }

  }

  public static class pushSDQML_result implements org.apache.thrift.TBase<pushSDQML_result, pushSDQML_result._Fields>, java.io.Serializable, Cloneable, Comparable<pushSDQML_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("pushSDQML_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.BOOL, (short)0);
    private static final org.apache.thrift.protocol.TField OUCH_FIELD_DESC = new org.apache.thrift.protocol.TField("ouch", org.apache.thrift.protocol.TType.STRUCT, (short)1);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new pushSDQML_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new pushSDQML_resultTupleSchemeFactory());
    }

    public boolean success; // required
    public InvalidSDQML ouch; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success"),
      OUCH((short)1, "ouch");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          case 1: // OUCH
            return OUCH;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    private static final int __SUCCESS_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
      tmpMap.put(_Fields.OUCH, new org.apache.thrift.meta_data.FieldMetaData("ouch", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(pushSDQML_result.class, metaDataMap);
    }

    public pushSDQML_result() {
    }

    public pushSDQML_result(
      boolean success,
      InvalidSDQML ouch)
    {
      this();
      this.success = success;
      setSuccessIsSet(true);
      this.ouch = ouch;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public pushSDQML_result(pushSDQML_result other) {
      __isset_bitfield = other.__isset_bitfield;
      this.success = other.success;
      if (other.isSetOuch()) {
        this.ouch = new InvalidSDQML(other.ouch);
      }
    }

    public pushSDQML_result deepCopy() {
      return new pushSDQML_result(this);
    }

    @Override
    public void clear() {
      setSuccessIsSet(false);
      this.success = false;
      this.ouch = null;
    }

    public boolean isSuccess() {
      return this.success;
    }

    public pushSDQML_result setSuccess(boolean success) {
      this.success = success;
      setSuccessIsSet(true);
      return this;
    }

    public void unsetSuccess() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SUCCESS_ISSET_ID);
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return EncodingUtils.testBit(__isset_bitfield, __SUCCESS_ISSET_ID);
    }

    public void setSuccessIsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SUCCESS_ISSET_ID, value);
    }

    public InvalidSDQML getOuch() {
      return this.ouch;
    }

    public pushSDQML_result setOuch(InvalidSDQML ouch) {
      this.ouch = ouch;
      return this;
    }

    public void unsetOuch() {
      this.ouch = null;
    }

    /** Returns true if field ouch is set (has been assigned a value) and false otherwise */
    public boolean isSetOuch() {
      return this.ouch != null;
    }

    public void setOuchIsSet(boolean value) {
      if (!value) {
        this.ouch = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((Boolean)value);
        }
        break;

      case OUCH:
        if (value == null) {
          unsetOuch();
        } else {
          setOuch((InvalidSDQML)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return Boolean.valueOf(isSuccess());

      case OUCH:
        return getOuch();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      case OUCH:
        return isSetOuch();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof pushSDQML_result)
        return this.equals((pushSDQML_result)that);
      return false;
    }

    public boolean equals(pushSDQML_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true;
      boolean that_present_success = true;
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (this.success != that.success)
          return false;
      }

      boolean this_present_ouch = true && this.isSetOuch();
      boolean that_present_ouch = true && that.isSetOuch();
      if (this_present_ouch || that_present_ouch) {
        if (!(this_present_ouch && that_present_ouch))
          return false;
        if (!this.ouch.equals(that.ouch))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    @Override
    public int compareTo(pushSDQML_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetOuch()).compareTo(other.isSetOuch());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetOuch()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ouch, other.ouch);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("pushSDQML_result(");
      boolean first = true;

      sb.append("success:");
      sb.append(this.success);
      first = false;
      if (!first) sb.append(", ");
      sb.append("ouch:");
      if (this.ouch == null) {
        sb.append("null");
      } else {
        sb.append(this.ouch);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class pushSDQML_resultStandardSchemeFactory implements SchemeFactory {
      public pushSDQML_resultStandardScheme getScheme() {
        return new pushSDQML_resultStandardScheme();
      }
    }

    private static class pushSDQML_resultStandardScheme extends StandardScheme<pushSDQML_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, pushSDQML_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
                struct.success = iprot.readBool();
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 1: // OUCH
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.ouch = new InvalidSDQML();
                struct.ouch.read(iprot);
                struct.setOuchIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, pushSDQML_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.isSetSuccess()) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          oprot.writeBool(struct.success);
          oprot.writeFieldEnd();
        }
        if (struct.ouch != null) {
          oprot.writeFieldBegin(OUCH_FIELD_DESC);
          struct.ouch.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class pushSDQML_resultTupleSchemeFactory implements SchemeFactory {
      public pushSDQML_resultTupleScheme getScheme() {
        return new pushSDQML_resultTupleScheme();
      }
    }

    private static class pushSDQML_resultTupleScheme extends TupleScheme<pushSDQML_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, pushSDQML_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        if (struct.isSetOuch()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetSuccess()) {
          oprot.writeBool(struct.success);
        }
        if (struct.isSetOuch()) {
          struct.ouch.write(oprot);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, pushSDQML_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.success = iprot.readBool();
          struct.setSuccessIsSet(true);
        }
        if (incoming.get(1)) {
          struct.ouch = new InvalidSDQML();
          struct.ouch.read(iprot);
          struct.setOuchIsSet(true);
        }
      }
    }

  }

}
