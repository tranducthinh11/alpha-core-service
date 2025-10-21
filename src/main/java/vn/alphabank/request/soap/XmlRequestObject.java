package vn.alphabank.request.soap;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;
import java.lang.reflect.Method;
import java.util.Objects;

public abstract class XmlRequestObject {
    protected SOAPMessage reqMsg;

    public static final String WSIN = "http://www.openwaygroup.com/wsint";
    public static final String TEM = "http://tempuri.org/";

    public SOAPMessage getMessage(){
        return reqMsg;
    }

    public abstract void createMessage() throws Throwable;

    protected void createNodeElements(SOAPElement element, String nameSpace, String[] nodeNames) throws Throwable {
        String nameSpaceUri = "";
        // detect namespace
        switch (nameSpace) {
            case "wsin":
                nameSpaceUri = WSIN;
                break;
            case "tem":
                nameSpaceUri = TEM;
                break;
        }

        for (String nodeName : nodeNames) {
            SOAPElement child = null;
            if (Objects.equals(nameSpace,"")) { // node without namespace
                child = element.addChildElement(nodeName);
            } else {    // node with namespace
                child = element.addChildElement(nodeName,nameSpace, nameSpaceUri);
            }

            // set content for node by get method
            String methodName = "get" + nodeName.substring(0, 1).toUpperCase() + nodeName.substring(1);
            Method method = this.getClass().getMethod(methodName);
            child.setTextContent(Objects.toString(method.invoke(this),""));
        }
    }
}
