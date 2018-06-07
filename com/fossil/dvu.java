package com.fossil;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;

public class dvu {
    private static final dvu dwF = azN();

    static class C3234a extends dvu {
        private final dvt<Socket> dwG;
        private final dvt<Socket> dwH;
        private final Method dwI;
        private final Method dwJ;
        private final dvt<Socket> dwK;
        private final dvt<Socket> dwL;

        public C3234a(dvt<Socket> com_fossil_dvt_java_net_Socket, dvt<Socket> com_fossil_dvt_java_net_Socket2, Method method, Method method2, dvt<Socket> com_fossil_dvt_java_net_Socket3, dvt<Socket> com_fossil_dvt_java_net_Socket4) {
            this.dwG = com_fossil_dvt_java_net_Socket;
            this.dwH = com_fossil_dvt_java_net_Socket2;
            this.dwI = method;
            this.dwJ = method2;
            this.dwK = com_fossil_dvt_java_net_Socket3;
            this.dwL = com_fossil_dvt_java_net_Socket4;
        }

        public void mo2711a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (Throwable e) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e);
                throw iOException;
            }
        }

        public void mo2712a(SSLSocket sSLSocket, String str, List<Protocol> list) {
            if (str != null) {
                this.dwG.m9949c(sSLSocket, Boolean.valueOf(true));
                this.dwH.m9949c(sSLSocket, str);
            }
            if (this.dwL != null && this.dwL.cS(sSLSocket)) {
                this.dwL.m9950d(sSLSocket, dvu.ax(list));
            }
        }

        public String mo2713e(SSLSocket sSLSocket) {
            if (this.dwK == null || !this.dwK.cS(sSLSocket)) {
                return null;
            }
            byte[] bArr = (byte[]) this.dwK.m9950d(sSLSocket, new Object[0]);
            return bArr != null ? new String(bArr, dvw.UTF_8) : null;
        }

        public void tagSocket(Socket socket) throws SocketException {
            if (this.dwI != null) {
                try {
                    this.dwI.invoke(null, new Object[]{socket});
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }

        public void untagSocket(Socket socket) throws SocketException {
            if (this.dwJ != null) {
                try {
                    this.dwJ.invoke(null, new Object[]{socket});
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }
    }

    static class C3235b extends dvu {
        private final Method dwM;
        private final Method dwN;
        private final Method dwO;
        private final Class<?> dwP;
        private final Class<?> dwQ;

        public C3235b(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
            this.dwM = method;
            this.dwN = method2;
            this.dwO = method3;
            this.dwP = cls;
            this.dwQ = cls2;
        }

        public void mo2712a(SSLSocket sSLSocket, String str, List<Protocol> list) {
            Object newProxyInstance;
            List arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = (Protocol) list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                newProxyInstance = Proxy.newProxyInstance(dvu.class.getClassLoader(), new Class[]{this.dwP, this.dwQ}, new C3236c(arrayList));
                this.dwM.invoke(null, new Object[]{sSLSocket, newProxyInstance});
            } catch (InvocationTargetException e) {
                newProxyInstance = e;
                throw new AssertionError(newProxyInstance);
            } catch (IllegalAccessException e2) {
                newProxyInstance = e2;
                throw new AssertionError(newProxyInstance);
            }
        }

        public void mo2716d(SSLSocket sSLSocket) {
            try {
                this.dwO.invoke(null, new Object[]{sSLSocket});
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new AssertionError();
            }
        }

        public String mo2713e(SSLSocket sSLSocket) {
            try {
                C3236c c3236c = (C3236c) Proxy.getInvocationHandler(this.dwN.invoke(null, new Object[]{sSLSocket}));
                if (c3236c.dwR || c3236c.dwS != null) {
                    return c3236c.dwR ? null : c3236c.dwS;
                }
                dvp.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            } catch (InvocationTargetException e) {
                throw new AssertionError();
            } catch (IllegalAccessException e2) {
                throw new AssertionError();
            }
        }
    }

    static class C3236c implements InvocationHandler {
        private final List<String> dup;
        private boolean dwR;
        private String dwS;

        public C3236c(List<String> list) {
            this.dup = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class returnType = method.getReturnType();
            if (objArr == null) {
                objArr = dvw.bqJ;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.dwR = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.dup;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.dup.contains(list.get(i))) {
                            name = (String) list.get(i);
                            this.dwS = name;
                            return name;
                        }
                    }
                    name = (String) this.dup.get(0);
                    this.dwS = name;
                    return name;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.dwS = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    public static dvu azM() {
        return dwF;
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public void kP(String str) {
        System.out.println(str);
    }

    public void tagSocket(Socket socket) throws SocketException {
    }

    public void untagSocket(Socket socket) throws SocketException {
    }

    public void mo2712a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void mo2716d(SSLSocket sSLSocket) {
    }

    public String mo2713e(SSLSocket sSLSocket) {
        return null;
    }

    public void mo2711a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    private static dvu azN() {
        Method method;
        Method method2;
        dvt com_fossil_dvt;
        dvt com_fossil_dvt2;
        Method method3;
        dvt com_fossil_dvt3;
        dvt com_fossil_dvt4;
        Method method4;
        try {
            Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        try {
            dvt com_fossil_dvt5 = new dvt(null, "setUseSessionTickets", Boolean.TYPE);
            dvt com_fossil_dvt6 = new dvt(null, "setHostname", String.class);
            try {
                Class cls = Class.forName("android.net.TrafficStats");
                Method method5 = cls.getMethod("tagSocket", new Class[]{Socket.class});
                try {
                    method = cls.getMethod("untagSocket", new Class[]{Socket.class});
                    method2 = method;
                    com_fossil_dvt = com_fossil_dvt2;
                    method3 = method5;
                    com_fossil_dvt3 = com_fossil_dvt4;
                } catch (ClassNotFoundException e2) {
                    method4 = method5;
                    method2 = null;
                    method = method4;
                    com_fossil_dvt4 = null;
                    com_fossil_dvt3 = null;
                    method3 = method;
                    com_fossil_dvt = com_fossil_dvt4;
                    return new C3234a(com_fossil_dvt5, com_fossil_dvt6, method3, method2, com_fossil_dvt, com_fossil_dvt3);
                } catch (NoSuchMethodException e3) {
                    com_fossil_dvt4 = null;
                    method2 = null;
                    method = method5;
                    com_fossil_dvt3 = null;
                    method3 = method;
                    com_fossil_dvt = com_fossil_dvt4;
                    return new C3234a(com_fossil_dvt5, com_fossil_dvt6, method3, method2, com_fossil_dvt, com_fossil_dvt3);
                }
                try {
                    Class.forName("android.net.Network");
                    dvt com_fossil_dvt7 = new dvt(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        com_fossil_dvt4 = new dvt(null, "setAlpnProtocols", byte[].class);
                        com_fossil_dvt2 = com_fossil_dvt7;
                    } catch (ClassNotFoundException e4) {
                        com_fossil_dvt4 = com_fossil_dvt7;
                        com_fossil_dvt2 = com_fossil_dvt4;
                        com_fossil_dvt4 = null;
                        method2 = method;
                        com_fossil_dvt = com_fossil_dvt2;
                        method3 = method5;
                        com_fossil_dvt3 = com_fossil_dvt4;
                        return new C3234a(com_fossil_dvt5, com_fossil_dvt6, method3, method2, com_fossil_dvt, com_fossil_dvt3);
                    } catch (NoSuchMethodException e5) {
                        com_fossil_dvt4 = com_fossil_dvt7;
                        method2 = method;
                        method = method5;
                        com_fossil_dvt3 = null;
                        method3 = method;
                        com_fossil_dvt = com_fossil_dvt4;
                        return new C3234a(com_fossil_dvt5, com_fossil_dvt6, method3, method2, com_fossil_dvt, com_fossil_dvt3);
                    }
                } catch (ClassNotFoundException e6) {
                    com_fossil_dvt4 = null;
                    com_fossil_dvt2 = com_fossil_dvt4;
                    com_fossil_dvt4 = null;
                    method2 = method;
                    com_fossil_dvt = com_fossil_dvt2;
                    method3 = method5;
                    com_fossil_dvt3 = com_fossil_dvt4;
                    return new C3234a(com_fossil_dvt5, com_fossil_dvt6, method3, method2, com_fossil_dvt, com_fossil_dvt3);
                } catch (NoSuchMethodException e7) {
                    com_fossil_dvt4 = null;
                    method2 = method;
                    method = method5;
                    com_fossil_dvt3 = null;
                    method3 = method;
                    com_fossil_dvt = com_fossil_dvt4;
                    return new C3234a(com_fossil_dvt5, com_fossil_dvt6, method3, method2, com_fossil_dvt, com_fossil_dvt3);
                }
            } catch (ClassNotFoundException e8) {
                method4 = null;
                method2 = null;
                method = method4;
                com_fossil_dvt4 = null;
                com_fossil_dvt3 = null;
                method3 = method;
                com_fossil_dvt = com_fossil_dvt4;
                return new C3234a(com_fossil_dvt5, com_fossil_dvt6, method3, method2, com_fossil_dvt, com_fossil_dvt3);
            } catch (NoSuchMethodException e9) {
                com_fossil_dvt4 = null;
                method2 = null;
                method = null;
                com_fossil_dvt3 = null;
                method3 = method;
                com_fossil_dvt = com_fossil_dvt4;
                return new C3234a(com_fossil_dvt5, com_fossil_dvt6, method3, method2, com_fossil_dvt, com_fossil_dvt3);
            }
            return new C3234a(com_fossil_dvt5, com_fossil_dvt6, method3, method2, com_fossil_dvt, com_fossil_dvt3);
        } catch (ClassNotFoundException e10) {
            try {
                String str = "org.eclipse.jetty.alpn.ALPN";
                Class cls2 = Class.forName(str);
                Class cls3 = Class.forName(str + "$Provider");
                Class cls4 = Class.forName(str + "$ClientProvider");
                Class cls5 = Class.forName(str + "$ServerProvider");
                return new C3235b(cls2.getMethod("put", new Class[]{SSLSocket.class, cls3}), cls2.getMethod("get", new Class[]{SSLSocket.class}), cls2.getMethod("remove", new Class[]{SSLSocket.class}), cls4, cls5);
            } catch (ClassNotFoundException e11) {
                return new dvu();
            } catch (NoSuchMethodException e12) {
                return new dvu();
            }
        }
    }

    static byte[] ax(List<Protocol> list) {
        eth com_fossil_eth = new eth();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                com_fossil_eth.pr(protocol.toString().length());
                com_fossil_eth.mH(protocol.toString());
            }
        }
        return com_fossil_eth.aHq();
    }
}
