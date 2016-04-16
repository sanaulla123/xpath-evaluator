package info.sanaulla.component;

import info.sanaulla.util.XPathUtil;

import java.io.InputStream;
import java.util.Scanner;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

@Component
public class XpathEvaluatorRunner implements CommandLineRunner{

  private static final Logger log = LoggerFactory.getLogger(XpathEvaluatorRunner.class);
  
  @Autowired XPathUtil xpathUtil;
  
  public void run(String... args) throws Exception {
    try(Scanner reader = new Scanner(System.in)){
      System.out.println("Enter xpath");
      String expression = reader.nextLine();
      InputStream xmlStream = this.getClass().getClassLoader().getResourceAsStream("sample.xml");
      try{
        XPathExpression xpathExpression = xpathUtil.getXpathExpression(expression);
        InputSource source = new InputSource(xmlStream);
        xpathExpression.evaluate(source);
      }catch(XPathExpressionException ex){
        log.error("XPath expression: {} is not valid", expression, ex);
      }
    }
  }

}
