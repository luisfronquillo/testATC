/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.testvlsxml;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

/**
 *
 * @author luis.f.ronquillo
 */
public class confVelocity {

    private static VelocityEngine ve;

    public confVelocity() {
    }

    public String templateTostring(String templateName, Map<String, String> values) {

        String value = new String();
        try {

            //Configuro la ruta/recurso donde estan los templates
            String path = TestXml.class.getResource("/velocity/" + templateName).getPath().replace(templateName, "");            
            // Se inicializa el engine con la ruta anterior
            setPropsVelocity(path);
            //Se mapea el template enviado
            Template t = ve.getTemplate(templateName, "UTF-8");
            // Se crea un contexto de velocity para introducir los datos a la plantilla
            VelocityContext context = new VelocityContext();
            if (values != null) {
                values.forEach((k, v) -> {
                    context.put(k, v);
                });
            }

            // Se renderiza el template con un StringWriter, al final se devuelve un string
            StringWriter writer = new StringWriter();
            t.merge(context, writer);
            value = writer.toString();
            writer.flush();
            writer.close();

        } catch (ResourceNotFoundException e) {
            System.out.println("Error Resource --> " + e.getMessage());
        } catch (ParseErrorException e) {
            System.out.println("Error parse --> " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error write close --> " + e.getMessage());
        }
        return value;
    }

    private static void setPropsVelocity(String templatePath) {
        ve = new VelocityEngine();
        ve.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, templatePath);
        ve.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_CACHE, false);
        ve.init();
    }

}
