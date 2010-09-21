/*
 * XML Type:  configurationType
 * Namespace: http://grenoble.agile.org/questions
 * Java type: org.agile.grenoble.questions.ConfigurationType
 *
 * Automatically generated - do not modify.
 */
package org.agile.grenoble.questions.impl;
/**
 * An XML configurationType(@http://grenoble.agile.org/questions).
 *
 * This is a complex type.
 */
public class ConfigurationTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.agile.grenoble.questions.ConfigurationType
{
    private static final long serialVersionUID = 1L;
    
    public ConfigurationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TYPE$0 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "type");
    private static final javax.xml.namespace.QName NUMBER$2 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "number");
    
    
    /**
     * Gets the "type" element
     */
    public org.agile.grenoble.questions.ConfigurationType.Type.Enum getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (org.agile.grenoble.questions.ConfigurationType.Type.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "type" element
     */
    public org.agile.grenoble.questions.ConfigurationType.Type xgetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.ConfigurationType.Type target = null;
            target = (org.agile.grenoble.questions.ConfigurationType.Type)get_store().find_element_user(TYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "type" element
     */
    public void setType(org.agile.grenoble.questions.ConfigurationType.Type.Enum type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$0);
            }
            target.setEnumValue(type);
        }
    }
    
    /**
     * Sets (as xml) the "type" element
     */
    public void xsetType(org.agile.grenoble.questions.ConfigurationType.Type type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.ConfigurationType.Type target = null;
            target = (org.agile.grenoble.questions.ConfigurationType.Type)get_store().find_element_user(TYPE$0, 0);
            if (target == null)
            {
                target = (org.agile.grenoble.questions.ConfigurationType.Type)get_store().add_element_user(TYPE$0);
            }
            target.set(type);
        }
    }
    
    /**
     * Gets the "number" element
     */
    public byte getNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMBER$2, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getByteValue();
        }
    }
    
    /**
     * Gets (as xml) the "number" element
     */
    public org.apache.xmlbeans.XmlByte xgetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlByte target = null;
            target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(NUMBER$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "number" element
     */
    public boolean isSetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NUMBER$2) != 0;
        }
    }
    
    /**
     * Sets the "number" element
     */
    public void setNumber(byte number)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMBER$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NUMBER$2);
            }
            target.setByteValue(number);
        }
    }
    
    /**
     * Sets (as xml) the "number" element
     */
    public void xsetNumber(org.apache.xmlbeans.XmlByte number)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlByte target = null;
            target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(NUMBER$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlByte)get_store().add_element_user(NUMBER$2);
            }
            target.set(number);
        }
    }
    
    /**
     * Unsets the "number" element
     */
    public void unsetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NUMBER$2, 0);
        }
    }
    /**
     * An XML type(@http://grenoble.agile.org/questions).
     *
     * This is an atomic type that is a restriction of org.agile.grenoble.questions.ConfigurationType$Type.
     */
    public static class TypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements org.agile.grenoble.questions.ConfigurationType.Type
    {
        private static final long serialVersionUID = 1L;
        
        public TypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected TypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
