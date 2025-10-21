package vn.alphabank.symbolapi.soap;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import vn.alphabank.request.soap.XmlRequestObject;
import vn.alphabank.web.controller.BaseException;

import javax.net.ssl.*;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public abstract class XmlSoapService {
    private static final Logger logger = LoggerFactory.getLogger(XmlSoapService.class);
    private static SOAPConnectionFactory factory;
    private static SOAPConnection conn;

    @Value("${backend.endPoint}")
    protected String endPoint;
    private String messageRequest;
    private String messageResponse;

    public String getMessageRequest() {
        return messageRequest;
    }

    private void setMessageRequest(SOAPMessage message) throws Throwable {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        this.messageRequest = out.toString();
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    private void setMessageResponse(SOAPMessage message) throws Throwable {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);

        this.messageResponse = out.toString();
    }

    private static void createFactory() throws Throwable {
        factory = SOAPConnectionFactory.newInstance();
    }

    private static SOAPConnection getConnection() throws Throwable {
        if (conn == null) {
            if (factory == null) {
                factory = SOAPConnectionFactory.newInstance();
            }
            conn = factory.createConnection();
        }
        return conn;
    }


    private KeyStore readStore() throws Throwable{
        try (InputStream keyStoreStream = new FileInputStream("E:\\Tools\\Java\\jdk-11.0.11\\bin\\cardkeystore.jks")) {
            KeyStore keyStore = KeyStore.getInstance("PKCS12"); // or "JKS"
            keyStore.load(keyStoreStream, "123456".toCharArray());
            return keyStore;
        }
    }

    @SneakyThrows
    public SOAPMessage callService(XmlRequestObject request){
        SOAPMessage response = null;

        //disableSslVerification();
//            final KeyStore truststore = readStore();
//            final SSLContext sslContext;
//            try {
//                sslContext = SSLContexts.custom()
//                        .loadTrustMaterial(truststore, new TrustAllStrategy())
//                        .loadKeyMaterial(truststore, "123456".toCharArray(), (aliases, socket) -> "wsruntime")
//                        .build();
//            } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | UnrecoverableKeyException e) {
//                throw new RuntimeException("Failed to read keystore", e);
//            }

        if(endPoint.contains("https"))
            disableSslVerification();

        try {
            SOAPConnection connection = getConnection();
            request.createMessage();
            SOAPMessage message = request.getMessage();
            setMessageRequest(message);
            logger.info(this.getMessageRequest());
            response = (endPoint != null) ? connection.call(message, endPoint) : null;
            setMessageResponse(response);
            logger.info(this.getMessageResponse());
        } catch (Throwable e) {
            throw BaseException.setErrorBackendTimeout(e);
        }
        return response;
    }

    @SneakyThrows
    private static void disableSslVerification() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (Throwable e) {
            throw BaseException.setGenericError("SSL Verification error", e);
        }
    }
}
