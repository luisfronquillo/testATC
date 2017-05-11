package com.test.testvlsxml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author luis.f.ronquillo
 */
public class TestXml {

    private static final String TEMPLATE_PRUEBA = "TemplatePrueba2.vm";

    public static void main(String[] args) {

        //mapa de valores para la plantilla
        Map<String, String> values = new HashMap<String, String>();
        values.put("props1", "value 1");
        values.put("props2", "value 2");

        //Clase configuracion velocity
        confVelocity conf = new confVelocity();

        // Devuelve en string el template con los valores
        String xml = conf.templateTostring(TEMPLATE_PRUEBA, values);


        //Se busca un nodo o path dentro del xml. La ruta sigue una forma jerarquica segun los nodos presentes en el xml.
        findNodeforPath(xml, "/Ticket_RetrieveListOfTSMReply/detailsOfRetrievedTSMs/tattooAndTypeOfTSM/uniqueReference");
    }
    public static void findNodeforPath(String xml, String path) {
        try {
            //Se realiza un marshall del XML
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            Document dom = db.parse(bais);

            //Se compila la ruta a buscar
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression nodeExpr = (XPathExpression) xpath.compile(path);

            //Extrae los valores de dicha ruta, tener en cuenta que la ruta puede aparecer varias veces por eso el NodeList
            NodeList nodelist = (NodeList) nodeExpr.evaluate(dom, XPathConstants.NODESET);

            System.out.println("length --> " + nodelist.getLength());
            //Imprimo la lista de valores
            for (int i = 0; i < nodelist.getLength(); i++) {
                System.out.println("text content --> " + nodelist.item(i).getTextContent());

            }

        } catch (XPathExpressionException ex) {
            Logger.getLogger(TestXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TestXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TestXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestXml.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
