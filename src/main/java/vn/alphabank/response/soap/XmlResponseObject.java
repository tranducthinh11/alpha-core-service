package vn.alphabank.response.soap;

import lombok.SneakyThrows;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import vn.alphabank.web.controller.BaseException;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class XmlResponseObject {

    /**
     * Map data from SoapMessage into object properties
     *
     * @param message SoapMessage response from core
     * @param nodeStr Name of element which mapped into object
     */
    @SneakyThrows
    protected void mapData(SOAPMessage message, String nodeStr) {
        try {
            this.mapData(message, nodeStr, 0);
        } catch (Throwable e) {
            throw BaseException.setGenericError("Mapping data error", e);
        }
    }

    /**
     * Map data from SoapMessage into object properties by specify index of node element
     *
     * @param message SoapMessage response from core
     * @param nodeStr Name of element which mapped into object
     * @param index   index of node element
     */
    @SneakyThrows
    protected void mapData(SOAPMessage message, String nodeStr, int index){
        SOAPBody soapBody = null;

        try {
            soapBody = message.getSOAPBody();
            NodeList node = soapBody.getElementsByTagName(nodeStr);
            if (node.getLength() > 0) {
                NodeList childNodes = node.item(index).getChildNodes();
                Map<String, Method> methods = Arrays.stream(this.getClass().getDeclaredMethods()).collect(Collectors.toMap(Method::getName, e -> e));   // Get all methods from class

                for (int i = 0; i < childNodes.getLength(); i++) {
                    Node item = childNodes.item(i);

                    String nodeName = item.getLocalName();
                    if(Objects.isNull(nodeName))
                        nodeName = item.getNodeName();

                    // MethodName should be named as setXxxx
                    String methodName = "set" + nodeName.substring(0, 1).toUpperCase() + nodeName.substring(1);
                    Method method = methods.get(methodName);
                    if (method != null) {
                        NodeList children = item.getChildNodes();
                        if(Objects.nonNull(children.item(0))){
                            if (children.item(0).getNodeType() == Node.TEXT_NODE)
                                method.invoke(this, item.getTextContent()); // Call method by name
                            else
                                method.invoke(this, children);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            throw BaseException.setGenericError("Mapping data error", e);
        }
    }

    /**
     * Count records by node name in SoapMessage
     *
     * @param message SoapMessage response from core
     * @param nodeStr Name of element which mapped into object
     * @return number of records
     */
    @SneakyThrows
    public static int countData(SOAPMessage message, String nodeStr) {
        int count = 0;
        SOAPBody soapBody = null;
        try {
            soapBody = message.getSOAPBody();

            NodeList node = soapBody.getElementsByTagName(nodeStr);
            count = node.getLength();

        } catch (Throwable e) {
            throw BaseException.setGenericError("Mapping data error", e);
        }

        return count;
    }
}
