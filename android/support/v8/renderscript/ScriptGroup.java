package android.support.v8.renderscript;

import android.os.Build.VERSION;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.Script.FieldID;
import android.support.v8.renderscript.Script.InvokeID;
import android.support.v8.renderscript.Script.KernelID;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ScriptGroup extends BaseObj {
    private static final int MIN_API_VERSION = 23;
    private static final String TAG = "ScriptGroup";
    private List<Closure> mClosures;
    IO[] mInputs;
    private List<Input> mInputs2;
    private String mName;
    private ArrayList<Node> mNodes = new ArrayList();
    IO[] mOutputs;
    private Future[] mOutputs2;
    private boolean mUseIncSupp = false;

    public static final class Binding {
        private final FieldID mField;
        private final Object mValue;

        public Binding(FieldID fieldID, Object obj) {
            this.mField = fieldID;
            this.mValue = obj;
        }

        public FieldID getField() {
            return this.mField;
        }

        public Object getValue() {
            return this.mValue;
        }
    }

    public static final class Builder2 {
        private static final String TAG = "ScriptGroup.Builder2";
        List<Closure> mClosures = new ArrayList();
        List<Input> mInputs = new ArrayList();
        RenderScript mRS;

        public Builder2(RenderScript renderScript) {
            this.mRS = renderScript;
        }

        private Closure addKernelInternal(KernelID kernelID, Type type, Object[] objArr, Map<FieldID, Object> map) {
            Closure closure = new Closure(this.mRS, kernelID, type, objArr, map);
            this.mClosures.add(closure);
            return closure;
        }

        private Closure addInvokeInternal(InvokeID invokeID, Object[] objArr, Map<FieldID, Object> map) {
            Closure closure = new Closure(this.mRS, invokeID, objArr, map);
            this.mClosures.add(closure);
            return closure;
        }

        public Input addInput() {
            Input input = new Input();
            this.mInputs.add(input);
            return input;
        }

        public Closure addKernel(KernelID kernelID, Type type, Object... objArr) {
            ArrayList arrayList = new ArrayList();
            Map hashMap = new HashMap();
            if (seperateArgsAndBindings(objArr, arrayList, hashMap)) {
                return addKernelInternal(kernelID, type, arrayList.toArray(), hashMap);
            }
            return null;
        }

        public Closure addInvoke(InvokeID invokeID, Object... objArr) {
            ArrayList arrayList = new ArrayList();
            Map hashMap = new HashMap();
            if (seperateArgsAndBindings(objArr, arrayList, hashMap)) {
                return addInvokeInternal(invokeID, arrayList.toArray(), hashMap);
            }
            return null;
        }

        public ScriptGroup create(String str, Future... futureArr) {
            if (str == null || str.isEmpty() || str.length() > 100 || !str.equals(str.replaceAll("[^a-zA-Z0-9-]", "_"))) {
                throw new RSIllegalArgumentException("invalid script group name");
            }
            return new ScriptGroup(this.mRS, str, this.mClosures, this.mInputs, futureArr);
        }

        private boolean seperateArgsAndBindings(Object[] objArr, ArrayList<Object> arrayList, Map<FieldID, Object> map) {
            int i;
            int i2 = 0;
            while (i2 < objArr.length) {
                if (objArr[i2] instanceof Binding) {
                    i = i2;
                    break;
                }
                arrayList.add(objArr[i2]);
                i2++;
            }
            i = i2;
            while (i < objArr.length) {
                if (!(objArr[i] instanceof Binding)) {
                    return false;
                }
                Binding binding = (Binding) objArr[i];
                map.put(binding.getField(), binding.getValue());
                i++;
            }
            return true;
        }
    }

    @Deprecated
    public static final class Builder {
        private int mKernelCount;
        private ArrayList<ConnectLine> mLines = new ArrayList();
        private ArrayList<Node> mNodes = new ArrayList();
        private RenderScript mRS;
        private boolean mUseIncSupp = false;

        class C12891 implements Comparator<Node> {
            C12891() {
            }

            public int compare(Node node, Node node2) {
                return node.mOrder - node2.mOrder;
            }
        }

        public Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }

        private void validateCycle(Node node, Node node2) {
            for (int i = 0; i < node.mOutputs.size(); i++) {
                ConnectLine connectLine = (ConnectLine) node.mOutputs.get(i);
                if (connectLine.mToK != null) {
                    Node findNode = findNode(connectLine.mToK.mScript);
                    if (findNode.equals(node2)) {
                        throw new RSInvalidStateException("Loops in group not allowed.");
                    }
                    validateCycle(findNode, node2);
                }
                if (connectLine.mToF != null) {
                    Node findNode2 = findNode(connectLine.mToF.mScript);
                    if (findNode2.equals(node2)) {
                        throw new RSInvalidStateException("Loops in group not allowed.");
                    }
                    validateCycle(findNode2, node2);
                }
            }
        }

        private void mergeDAGs(int i, int i2) {
            for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
                if (((Node) this.mNodes.get(i3)).dagNumber == i2) {
                    ((Node) this.mNodes.get(i3)).dagNumber = i;
                }
            }
        }

        private void validateDAGRecurse(Node node, int i) {
            if (node.dagNumber == 0 || node.dagNumber == i) {
                node.dagNumber = i;
                for (int i2 = 0; i2 < node.mOutputs.size(); i2++) {
                    ConnectLine connectLine = (ConnectLine) node.mOutputs.get(i2);
                    if (connectLine.mToK != null) {
                        validateDAGRecurse(findNode(connectLine.mToK.mScript), i);
                    }
                    if (connectLine.mToF != null) {
                        validateDAGRecurse(findNode(connectLine.mToF.mScript), i);
                    }
                }
                return;
            }
            mergeDAGs(node.dagNumber, i);
        }

        private void validateDAG() {
            int i;
            int i2 = 0;
            for (i = 0; i < this.mNodes.size(); i++) {
                Node node = (Node) this.mNodes.get(i);
                if (node.mInputs.size() == 0) {
                    if (node.mOutputs.size() != 0 || this.mNodes.size() <= 1) {
                        validateDAGRecurse(node, i + 1);
                    } else {
                        throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
                    }
                }
            }
            i = ((Node) this.mNodes.get(0)).dagNumber;
            while (i2 < this.mNodes.size()) {
                if (((Node) this.mNodes.get(i2)).dagNumber != i) {
                    throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
                }
                i2++;
            }
        }

        private Node findNode(Script script) {
            for (int i = 0; i < this.mNodes.size(); i++) {
                if (script == ((Node) this.mNodes.get(i)).mScript) {
                    return (Node) this.mNodes.get(i);
                }
            }
            return null;
        }

        private Node findNode(KernelID kernelID) {
            for (int i = 0; i < this.mNodes.size(); i++) {
                Node node = (Node) this.mNodes.get(i);
                for (int i2 = 0; i2 < node.mKernels.size(); i2++) {
                    if (kernelID == node.mKernels.get(i2)) {
                        return node;
                    }
                }
            }
            return null;
        }

        public Builder addKernel(KernelID kernelID) {
            if (this.mLines.size() != 0) {
                throw new RSInvalidStateException("Kernels may not be added once connections exist.");
            }
            if (kernelID.mScript.isIncSupp()) {
                this.mUseIncSupp = true;
            }
            if (findNode(kernelID) == null) {
                this.mKernelCount++;
                Node findNode = findNode(kernelID.mScript);
                if (findNode == null) {
                    findNode = new Node(kernelID.mScript);
                    this.mNodes.add(findNode);
                }
                findNode.mKernels.add(kernelID);
            }
            return this;
        }

        public Builder addConnection(Type type, KernelID kernelID, FieldID fieldID) {
            Node findNode = findNode(kernelID);
            if (findNode == null) {
                throw new RSInvalidStateException("From script not found.");
            }
            Node findNode2 = findNode(fieldID.mScript);
            if (findNode2 == null) {
                throw new RSInvalidStateException("To script not found.");
            }
            ConnectLine connectLine = new ConnectLine(type, kernelID, fieldID);
            this.mLines.add(new ConnectLine(type, kernelID, fieldID));
            findNode.mOutputs.add(connectLine);
            findNode2.mInputs.add(connectLine);
            validateCycle(findNode, findNode);
            return this;
        }

        public Builder addConnection(Type type, KernelID kernelID, KernelID kernelID2) {
            Node findNode = findNode(kernelID);
            if (findNode == null) {
                throw new RSInvalidStateException("From script not found.");
            }
            Node findNode2 = findNode(kernelID2);
            if (findNode2 == null) {
                throw new RSInvalidStateException("To script not found.");
            }
            ConnectLine connectLine = new ConnectLine(type, kernelID, kernelID2);
            this.mLines.add(new ConnectLine(type, kernelID, kernelID2));
            findNode.mOutputs.add(connectLine);
            findNode2.mInputs.add(connectLine);
            validateCycle(findNode, findNode);
            return this;
        }

        private boolean calcOrderRecurse(Node node, int i) {
            node.mSeen = true;
            if (node.mOrder < i) {
                node.mOrder = i;
            }
            Iterator it = node.mOutputs.iterator();
            boolean z = true;
            while (it.hasNext()) {
                Node findNode;
                ConnectLine connectLine = (ConnectLine) it.next();
                if (connectLine.mToF != null) {
                    findNode = findNode(connectLine.mToF.mScript);
                } else {
                    findNode = findNode(connectLine.mToK.mScript);
                }
                if (findNode.mSeen) {
                    return false;
                }
                z = calcOrderRecurse(findNode, node.mOrder + 1) & z;
            }
            return z;
        }

        private boolean calcOrder() {
            Iterator it = this.mNodes.iterator();
            boolean z = true;
            while (it.hasNext()) {
                boolean calcOrderRecurse;
                Node node = (Node) it.next();
                if (node.mInputs.size() == 0) {
                    Iterator it2 = this.mNodes.iterator();
                    while (it2.hasNext()) {
                        ((Node) it2.next()).mSeen = false;
                    }
                    calcOrderRecurse = calcOrderRecurse(node, 1) & z;
                } else {
                    calcOrderRecurse = z;
                }
                z = calcOrderRecurse;
            }
            Collections.sort(this.mNodes, new C12891());
            return z;
        }

        public ScriptGroup create() {
            if (this.mNodes.size() == 0) {
                throw new RSInvalidStateException("Empty script groups are not allowed");
            }
            int i;
            for (i = 0; i < this.mNodes.size(); i++) {
                ((Node) this.mNodes.get(i)).dagNumber = 0;
            }
            validateDAG();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            long[] jArr = new long[this.mKernelCount];
            int i2 = 0;
            int i3 = 0;
            while (i3 < this.mNodes.size()) {
                Node node = (Node) this.mNodes.get(i3);
                int i4 = 0;
                int i5 = i2;
                while (i4 < node.mKernels.size()) {
                    int i6;
                    KernelID kernelID = (KernelID) node.mKernels.get(i4);
                    int i7 = i5 + 1;
                    jArr[i5] = kernelID.getID(this.mRS);
                    Object obj = null;
                    Object obj2 = null;
                    for (i6 = 0; i6 < node.mInputs.size(); i6++) {
                        if (((ConnectLine) node.mInputs.get(i6)).mToK == kernelID) {
                            obj2 = 1;
                        }
                    }
                    for (i6 = 0; i6 < node.mOutputs.size(); i6++) {
                        if (((ConnectLine) node.mOutputs.get(i6)).mFrom == kernelID) {
                            obj = 1;
                        }
                    }
                    if (obj2 == null) {
                        arrayList.add(new IO(kernelID));
                    }
                    if (obj == null) {
                        arrayList2.add(new IO(kernelID));
                    }
                    i4++;
                    i5 = i7;
                }
                i3++;
                i2 = i5;
            }
            if (i2 != this.mKernelCount) {
                throw new RSRuntimeException("Count mismatch, should not happen.");
            }
            long j;
            if (this.mUseIncSupp) {
                calcOrder();
                j = 0;
            } else {
                long[] jArr2 = new long[this.mLines.size()];
                long[] jArr3 = new long[this.mLines.size()];
                long[] jArr4 = new long[this.mLines.size()];
                long[] jArr5 = new long[this.mLines.size()];
                for (i7 = 0; i7 < this.mLines.size(); i7++) {
                    ConnectLine connectLine = (ConnectLine) this.mLines.get(i7);
                    jArr2[i7] = connectLine.mFrom.getID(this.mRS);
                    if (connectLine.mToK != null) {
                        jArr3[i7] = connectLine.mToK.getID(this.mRS);
                    }
                    if (connectLine.mToF != null) {
                        jArr4[i7] = connectLine.mToF.getID(this.mRS);
                    }
                    jArr5[i7] = connectLine.mAllocationType.getID(this.mRS);
                }
                j = this.mRS.nScriptGroupCreate(jArr, jArr2, jArr3, jArr4, jArr5);
                if (j == 0) {
                    throw new RSRuntimeException("Object creation error, should not happen.");
                }
            }
            ScriptGroup scriptGroup = new ScriptGroup(j, this.mRS);
            scriptGroup.mOutputs = new IO[arrayList2.size()];
            for (i = 0; i < arrayList2.size(); i++) {
                scriptGroup.mOutputs[i] = (IO) arrayList2.get(i);
            }
            scriptGroup.mInputs = new IO[arrayList.size()];
            for (i = 0; i < arrayList.size(); i++) {
                scriptGroup.mInputs[i] = (IO) arrayList.get(i);
            }
            scriptGroup.mNodes = this.mNodes;
            scriptGroup.mUseIncSupp = this.mUseIncSupp;
            return scriptGroup;
        }
    }

    public static final class Closure extends BaseObj {
        private static final String TAG = "Closure";
        private Object[] mArgs;
        private Map<FieldID, Object> mBindings;
        private FieldPacker mFP;
        private Map<FieldID, Future> mGlobalFuture;
        private Future mReturnFuture;
        private Allocation mReturnValue;

        static final class ValueAndSize {
            public int size;
            public long value;

            public ValueAndSize(RenderScript renderScript, Object obj) {
                if (obj instanceof Allocation) {
                    this.value = ((Allocation) obj).getID(renderScript);
                    this.size = -1;
                } else if (obj instanceof Boolean) {
                    this.value = ((Boolean) obj).booleanValue() ? 1 : 0;
                    this.size = 4;
                } else if (obj instanceof Integer) {
                    this.value = ((Integer) obj).longValue();
                    this.size = 4;
                } else if (obj instanceof Long) {
                    this.value = ((Long) obj).longValue();
                    this.size = 8;
                } else if (obj instanceof Float) {
                    this.value = (long) Float.floatToRawIntBits(((Float) obj).floatValue());
                    this.size = 4;
                } else if (obj instanceof Double) {
                    this.value = Double.doubleToRawLongBits(((Double) obj).doubleValue());
                    this.size = 8;
                }
            }
        }

        Closure(long j, RenderScript renderScript) {
            super(j, renderScript);
        }

        Closure(RenderScript renderScript, KernelID kernelID, Type type, Object[] objArr, Map<FieldID, Object> map) {
            super(0, renderScript);
            if (VERSION.SDK_INT >= 23 || !renderScript.isUseNative()) {
                this.mArgs = objArr;
                this.mReturnValue = Allocation.createTyped(renderScript, type);
                this.mBindings = map;
                this.mGlobalFuture = new HashMap();
                int length = objArr.length + map.size();
                long[] jArr = new long[length];
                long[] jArr2 = new long[length];
                int[] iArr = new int[length];
                long[] jArr3 = new long[length];
                long[] jArr4 = new long[length];
                int i = 0;
                while (i < objArr.length) {
                    jArr[i] = 0;
                    retrieveValueAndDependenceInfo(renderScript, i, null, objArr[i], jArr2, iArr, jArr3, jArr4);
                    i++;
                }
                for (Entry entry : map.entrySet()) {
                    Object value = entry.getValue();
                    FieldID fieldID = (FieldID) entry.getKey();
                    jArr[i] = fieldID.getID(renderScript);
                    retrieveValueAndDependenceInfo(renderScript, i, fieldID, value, jArr2, iArr, jArr3, jArr4);
                    i++;
                }
                setID(renderScript.nClosureCreate(kernelID.getID(renderScript), this.mReturnValue.getID(renderScript), jArr, jArr2, iArr, jArr3, jArr4));
                return;
            }
            throw new RSRuntimeException("ScriptGroup2 not supported in this API level");
        }

        Closure(RenderScript renderScript, InvokeID invokeID, Object[] objArr, Map<FieldID, Object> map) {
            super(0, renderScript);
            if (VERSION.SDK_INT >= 23 || !renderScript.isUseNative()) {
                this.mFP = FieldPacker.createFromArray(objArr);
                this.mArgs = objArr;
                this.mBindings = map;
                this.mGlobalFuture = new HashMap();
                int size = map.size();
                long[] jArr = new long[size];
                long[] jArr2 = new long[size];
                int[] iArr = new int[size];
                long[] jArr3 = new long[size];
                long[] jArr4 = new long[size];
                int i = 0;
                for (Entry entry : map.entrySet()) {
                    Object value = entry.getValue();
                    FieldID fieldID = (FieldID) entry.getKey();
                    jArr[i] = fieldID.getID(renderScript);
                    retrieveValueAndDependenceInfo(renderScript, i, fieldID, value, jArr2, iArr, jArr3, jArr4);
                    i++;
                }
                setID(renderScript.nInvokeClosureCreate(invokeID.getID(renderScript), this.mFP.getData(), jArr, jArr2, iArr));
                return;
            }
            throw new RSRuntimeException("ScriptGroup2 not supported in this API level");
        }

        private void retrieveValueAndDependenceInfo(RenderScript renderScript, int i, FieldID fieldID, Object obj, long[] jArr, int[] iArr, long[] jArr2, long[] jArr3) {
            Object obj2;
            if (obj instanceof Future) {
                Future future = (Future) obj;
                Object value = future.getValue();
                jArr2[i] = future.getClosure().getID(renderScript);
                FieldID fieldID2 = future.getFieldID();
                jArr3[i] = fieldID2 != null ? fieldID2.getID(renderScript) : 0;
                obj2 = value;
            } else {
                jArr2[i] = 0;
                jArr3[i] = 0;
                obj2 = obj;
            }
            if (obj2 instanceof Input) {
                Input input = (Input) obj2;
                if (i < this.mArgs.length) {
                    input.addReference(this, i);
                } else {
                    input.addReference(this, fieldID);
                }
                jArr[i] = 0;
                iArr[i] = 0;
                return;
            }
            ValueAndSize valueAndSize = new ValueAndSize(renderScript, obj2);
            jArr[i] = valueAndSize.value;
            iArr[i] = valueAndSize.size;
        }

        public Future getReturn() {
            if (this.mReturnFuture == null) {
                this.mReturnFuture = new Future(this, null, this.mReturnValue);
            }
            return this.mReturnFuture;
        }

        public Future getGlobal(FieldID fieldID) {
            Future future = (Future) this.mGlobalFuture.get(fieldID);
            if (future != null) {
                return future;
            }
            Object obj = this.mBindings.get(fieldID);
            if (obj instanceof Future) {
                obj = ((Future) obj).getValue();
            }
            Future future2 = new Future(this, fieldID, obj);
            this.mGlobalFuture.put(fieldID, future2);
            return future2;
        }

        void setArg(int i, Object obj) {
            if (obj instanceof Future) {
                obj = ((Future) obj).getValue();
            }
            this.mArgs[i] = obj;
            ValueAndSize valueAndSize = new ValueAndSize(this.mRS, obj);
            this.mRS.nClosureSetArg(getID(this.mRS), i, valueAndSize.value, valueAndSize.size);
        }

        void setGlobal(FieldID fieldID, Object obj) {
            if (obj instanceof Future) {
                obj = ((Future) obj).getValue();
            }
            this.mBindings.put(fieldID, obj);
            ValueAndSize valueAndSize = new ValueAndSize(this.mRS, obj);
            this.mRS.nClosureSetGlobal(getID(this.mRS), fieldID.getID(this.mRS), valueAndSize.value, valueAndSize.size);
        }
    }

    static class ConnectLine {
        Allocation mAllocation;
        Type mAllocationType;
        KernelID mFrom;
        FieldID mToF;
        KernelID mToK;

        ConnectLine(Type type, KernelID kernelID, KernelID kernelID2) {
            this.mFrom = kernelID;
            this.mToK = kernelID2;
            this.mAllocationType = type;
        }

        ConnectLine(Type type, KernelID kernelID, FieldID fieldID) {
            this.mFrom = kernelID;
            this.mToF = fieldID;
            this.mAllocationType = type;
        }
    }

    public static final class Future {
        Closure mClosure;
        FieldID mFieldID;
        Object mValue;

        Future(Closure closure, FieldID fieldID, Object obj) {
            this.mClosure = closure;
            this.mFieldID = fieldID;
            this.mValue = obj;
        }

        Closure getClosure() {
            return this.mClosure;
        }

        FieldID getFieldID() {
            return this.mFieldID;
        }

        Object getValue() {
            return this.mValue;
        }
    }

    static class IO {
        Allocation mAllocation;
        KernelID mKID;

        IO(KernelID kernelID) {
            this.mKID = kernelID;
        }
    }

    public static final class Input {
        List<Pair<Closure, Integer>> mArgIndex = new ArrayList();
        List<Pair<Closure, FieldID>> mFieldID = new ArrayList();
        Object mValue;

        Input() {
        }

        void addReference(Closure closure, int i) {
            this.mArgIndex.add(Pair.create(closure, Integer.valueOf(i)));
        }

        void addReference(Closure closure, FieldID fieldID) {
            this.mFieldID.add(Pair.create(closure, fieldID));
        }

        void set(Object obj) {
            this.mValue = obj;
            for (Pair pair : this.mArgIndex) {
                ((Closure) pair.first).setArg(((Integer) pair.second).intValue(), obj);
            }
            for (Pair pair2 : this.mFieldID) {
                ((Closure) pair2.first).setGlobal((FieldID) pair2.second, obj);
            }
        }

        Object get() {
            return this.mValue;
        }
    }

    static class Node {
        int dagNumber;
        ArrayList<ConnectLine> mInputs = new ArrayList();
        ArrayList<KernelID> mKernels = new ArrayList();
        Node mNext;
        int mOrder;
        ArrayList<ConnectLine> mOutputs = new ArrayList();
        Script mScript;
        boolean mSeen;

        Node(Script script) {
            this.mScript = script;
        }
    }

    ScriptGroup(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    ScriptGroup(RenderScript renderScript, String str, List<Closure> list, List<Input> list2, Future[] futureArr) {
        super(0, renderScript);
        if (VERSION.SDK_INT >= 23 || !renderScript.isUseNative()) {
            this.mName = str;
            this.mClosures = list;
            this.mInputs2 = list2;
            this.mOutputs2 = futureArr;
            long[] jArr = new long[list.size()];
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = ((Closure) list.get(i)).getID(renderScript);
            }
            setID(renderScript.nScriptGroup2Create(str, renderScript.getApplicationContext().getCacheDir().toString(), jArr));
            return;
        }
        throw new RSRuntimeException("ScriptGroup2 not supported in this API level");
    }

    public Object[] execute(Object... objArr) {
        int i = 0;
        if (objArr.length < this.mInputs2.size()) {
            Log.e(TAG, toString() + " receives " + objArr.length + " inputs, " + "less than expected " + this.mInputs2.size());
            return null;
        }
        if (objArr.length > this.mInputs2.size()) {
            Log.i(TAG, toString() + " receives " + objArr.length + " inputs, " + "more than expected " + this.mInputs2.size());
        }
        for (int i2 = 0; i2 < this.mInputs2.size(); i2++) {
            Object obj = objArr[i2];
            if ((obj instanceof Future) || (obj instanceof Input)) {
                Log.e(TAG, toString() + ": input " + i2 + " is a future or unbound value");
                return null;
            }
            ((Input) this.mInputs2.get(i2)).set(obj);
        }
        this.mRS.nScriptGroup2Execute(getID(this.mRS));
        Object[] objArr2 = new Object[this.mOutputs2.length];
        Future[] futureArr = this.mOutputs2;
        int length = futureArr.length;
        int i3 = 0;
        while (i < length) {
            Object value = futureArr[i].getValue();
            if (value instanceof Input) {
                value = ((Input) value).get();
            }
            int i4 = i3 + 1;
            objArr2[i3] = value;
            i++;
            i3 = i4;
        }
        return objArr2;
    }

    @Deprecated
    public void setInput(KernelID kernelID, Allocation allocation) {
        for (int i = 0; i < this.mInputs.length; i++) {
            if (this.mInputs[i].mKID == kernelID) {
                this.mInputs[i].mAllocation = allocation;
                if (!this.mUseIncSupp) {
                    this.mRS.nScriptGroupSetInput(getID(this.mRS), kernelID.getID(this.mRS), this.mRS.safeID(allocation));
                    return;
                }
                return;
            }
        }
        throw new RSIllegalArgumentException("Script not found");
    }

    @Deprecated
    public void setOutput(KernelID kernelID, Allocation allocation) {
        for (int i = 0; i < this.mOutputs.length; i++) {
            if (this.mOutputs[i].mKID == kernelID) {
                this.mOutputs[i].mAllocation = allocation;
                if (!this.mUseIncSupp) {
                    this.mRS.nScriptGroupSetOutput(getID(this.mRS), kernelID.getID(this.mRS), this.mRS.safeID(allocation));
                    return;
                }
                return;
            }
        }
        throw new RSIllegalArgumentException("Script not found");
    }

    @Deprecated
    public void execute() {
        if (this.mUseIncSupp) {
            Node node;
            int i;
            for (int i2 = 0; i2 < this.mNodes.size(); i2++) {
                node = (Node) this.mNodes.get(i2);
                for (i = 0; i < node.mOutputs.size(); i++) {
                    ConnectLine connectLine = (ConnectLine) node.mOutputs.get(i);
                    if (connectLine.mAllocation == null) {
                        Allocation createTyped = Allocation.createTyped(this.mRS, connectLine.mAllocationType, MipmapControl.MIPMAP_NONE, 1);
                        connectLine.mAllocation = createTyped;
                        for (int i3 = i + 1; i3 < node.mOutputs.size(); i3++) {
                            if (((ConnectLine) node.mOutputs.get(i3)).mFrom == connectLine.mFrom) {
                                ((ConnectLine) node.mOutputs.get(i3)).mAllocation = createTyped;
                            }
                        }
                    }
                }
            }
            Iterator it = this.mNodes.iterator();
            while (it.hasNext()) {
                node = (Node) it.next();
                Iterator it2 = node.mKernels.iterator();
                while (it2.hasNext()) {
                    ConnectLine connectLine2;
                    Allocation allocation;
                    KernelID kernelID = (KernelID) it2.next();
                    Iterator it3 = node.mInputs.iterator();
                    Allocation allocation2 = null;
                    while (it3.hasNext()) {
                        connectLine2 = (ConnectLine) it3.next();
                        if (connectLine2.mToK == kernelID) {
                            allocation = connectLine2.mAllocation;
                        } else {
                            allocation = allocation2;
                        }
                        allocation2 = allocation;
                    }
                    IO[] ioArr = this.mInputs;
                    int length = ioArr.length;
                    i = 0;
                    while (i < length) {
                        IO io = ioArr[i];
                        if (io.mKID == kernelID) {
                            allocation = io.mAllocation;
                        } else {
                            allocation = allocation2;
                        }
                        i++;
                        allocation2 = allocation;
                    }
                    Iterator it4 = node.mOutputs.iterator();
                    FieldPacker fieldPacker = null;
                    while (it4.hasNext()) {
                        connectLine2 = (ConnectLine) it4.next();
                        if (connectLine2.mFrom == kernelID) {
                            allocation = connectLine2.mAllocation;
                        } else {
                            Object obj = fieldPacker;
                        }
                        Object obj2 = allocation;
                    }
                    allocation = fieldPacker;
                    for (IO io2 : this.mOutputs) {
                        if (io2.mKID == kernelID) {
                            allocation = io2.mAllocation;
                        }
                    }
                    kernelID.mScript.forEach(kernelID.mSlot, allocation2, allocation, null);
                }
            }
            return;
        }
        this.mRS.nScriptGroupExecute(getID(this.mRS));
    }
}
