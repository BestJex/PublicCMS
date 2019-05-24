package com.publiccms.common.handler;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 *
 * ShortMessageTemplateExceptionHandler
 * 
 */
public class ShortMessageTemplateExceptionHandler implements TemplateExceptionHandler {
    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public void handleTemplateException(TemplateException templateexception, Environment environment, Writer writer)
            throws TemplateException {
        try {
            String code = templateexception.getMessageWithoutStackTop();
            if (null != code) {
                writer.write(code);
            } else {
                writer.write("[some errors occurred!]");
            }
        } catch (IOException e) {
            log.error(environment.getCurrentTemplate().getSourceName(), e);
        }
    }

}
