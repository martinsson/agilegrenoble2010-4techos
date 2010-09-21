/*
 * XML Type:  answerType
 * Namespace: http://grenoble.agile.org/questions
 * Java type: org.agile.grenoble.questions.AnswerType
 *
 * Automatically generated - do not modify.
 */
package org.agile.grenoble.questions.impl;
/**
 * An XML answerType(@http://grenoble.agile.org/questions).
 *
 * This is a complex type.
 */
public class AnswerTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.agile.grenoble.questions.AnswerType
{
    private static final long serialVersionUID = 1L;
    
    public AnswerTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LABEL$0 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "label");
    private static final javax.xml.namespace.QName POINT$2 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "point");
    
    
    /**
     * Gets the "label" element
     */
    public java.lang.String getLabel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LABEL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "label" element
     */
    public org.apache.xmlbeans.XmlString xgetLabel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LABEL$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "label" element
     */
    public void setLabel(java.lang.String label)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LABEL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LABEL$0);
            }
            target.setStringValue(label);
        }
    }
    
    /**
     * Sets (as xml) the "label" element
     */
    public void xsetLabel(org.apache.xmlbeans.XmlString label)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LABEL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LABEL$0);
            }
            target.set(label);
        }
    }
    
    /**
     * Gets the "point" element
     */
    public java.lang.String getPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "point" element
     */
    public org.apache.xmlbeans.XmlString xgetPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POINT$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "point" element
     */
    public boolean isSetPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(POINT$2) != 0;
        }
    }
    
    /**
     * Sets the "point" element
     */
    public void setPoint(java.lang.String point)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINT$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POINT$2);
            }
            target.setStringValue(point);
        }
    }
    
    /**
     * Sets (as xml) the "point" element
     */
    public void xsetPoint(org.apache.xmlbeans.XmlString point)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POINT$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POINT$2);
            }
            target.set(point);
        }
    }
    
    /**
     * Unsets the "point" element
     */
    public void unsetPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(POINT$2, 0);
        }
    }
}
