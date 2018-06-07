package com.fossil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class etp {
    private static final Logger logger = Logger.getLogger(etp.class.getName());

    private etp() {
    }

    public static etj m11180c(etv com_fossil_etv) {
        if (com_fossil_etv != null) {
            return new etr(com_fossil_etv);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static eti m11179c(etu com_fossil_etu) {
        if (com_fossil_etu != null) {
            return new etq(com_fossil_etu);
        }
        throw new IllegalArgumentException("sink == null");
    }

    private static etu m11176a(final OutputStream outputStream, final etw com_fossil_etw) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (com_fossil_etw != null) {
            return new etu() {
                public void mo2728a(eth com_fossil_eth, long j) throws IOException {
                    etx.m11198b(com_fossil_eth.Fs, 0, j);
                    while (j > 0) {
                        com_fossil_etw.aHA();
                        ets com_fossil_ets = com_fossil_eth.dTh;
                        int min = (int) Math.min(j, (long) (com_fossil_ets.limit - com_fossil_ets.pos));
                        outputStream.write(com_fossil_ets.data, com_fossil_ets.pos, min);
                        com_fossil_ets.pos += min;
                        j -= (long) min;
                        com_fossil_eth.Fs -= (long) min;
                        if (com_fossil_ets.pos == com_fossil_ets.limit) {
                            com_fossil_eth.dTh = com_fossil_ets.aHG();
                            ett.m11195b(com_fossil_ets);
                        }
                    }
                }

                public void flush() throws IOException {
                    outputStream.flush();
                }

                public void close() throws IOException {
                    outputStream.close();
                }

                public etw aAf() {
                    return com_fossil_etw;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static etu m11178b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        etw d = m11182d(socket);
        return d.m10065b(m11176a(socket.getOutputStream(), d));
    }

    public static etv m11183y(InputStream inputStream) {
        return m11177a(inputStream, new etw());
    }

    private static etv m11177a(final InputStream inputStream, final etw com_fossil_etw) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (com_fossil_etw != null) {
            return new etv() {
                public long mo2733b(eth com_fossil_eth, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        com_fossil_etw.aHA();
                        ets pu = com_fossil_eth.pu(1);
                        int read = inputStream.read(pu.data, pu.limit, (int) Math.min(j, (long) (2048 - pu.limit)));
                        if (read == -1) {
                            return -1;
                        }
                        pu.limit += read;
                        com_fossil_eth.Fs += (long) read;
                        return (long) read;
                    }
                }

                public void close() throws IOException {
                    inputStream.close();
                }

                public etw aAf() {
                    return com_fossil_etw;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static etv m11175E(File file) throws FileNotFoundException {
        if (file != null) {
            return m11183y(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static etv m11181c(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        etw d = m11182d(socket);
        return d.m10064a(m11177a(socket.getInputStream(), d));
    }

    private static etf m11182d(final Socket socket) {
        return new etf() {
            protected IOException mo2736c(IOException iOException) {
                IOException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            protected void aAh() {
                try {
                    socket.close();
                } catch (Throwable e) {
                    etp.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, e);
                } catch (Throwable e2) {
                    if (e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) {
                        throw e2;
                    }
                    etp.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, e2);
                }
            }
        };
    }
}
