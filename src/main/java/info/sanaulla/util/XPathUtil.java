package info.sanaulla.util;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class XPathUtil {

  private static final Logger log = LoggerFactory.getLogger(XPathUtil.class);
  
  private final XPathFactory xpathFactory = XPathFactory.newInstance();
  public XPath getXpathObject(){
    return xpathFactory.newXPath();
  }
  
  public XPathExpression getXpathExpression(String expression) throws XPathExpressionException{
    XPathExpression xpExpression = getXpathObject().compile(expression);
    return xpExpression;
  }
}
