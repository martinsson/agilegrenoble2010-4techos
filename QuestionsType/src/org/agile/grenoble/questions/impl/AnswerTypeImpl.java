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
    private static final javax.xml.namespace.QName SELECTED$4 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "selected");
    
    
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
    
    /**
     * Gets the "selected" element
     */
    public org.agile.grenoble.questions.AnswerType.Selected.Enum getSelected()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SELECTED$4, 0);
            if (target == null)
            {
                return null;
            }
            return (org.agile.grenoble.questions.AnswerType.Selected.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "selected" element
     */
    public org.agile.grenoble.questions.AnswerType.Selected xgetSelected()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.AnswerType.Selected target = null;
            target = (org.agile.grenoble.questions.AnswerType.Selected)get_store().find_element_user(SELECTED$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "selected" element
     */
    public boolean isSetSelected()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SELECTED$4) != 0;
        }
    }
    
    /**
     * Sets the "selected" element
     */
    public void setSelected(org.agile.grenoble.questions.AnswerType.Selected.Enum selected)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SELECTED$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SELECTED$4);
            }
            target.setEnumValue(selected);
        }
    }
    
    /**
     * Sets (as xml) the "selected" element
     */
    public void xsetSelected(org.agile.grenoble.questions.AnswerType.Selected selected)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.AnswerType.Selected target = null;
            target = (org.agile.grenoble.questions.AnswerType.Selected)get_store().find_element_user(SELECTED$4, 0);
            if (target == null)
            {
                target = (org.agile.grenoble.questions.AnswerType.Selected)get_store().add_element_user(SELECTED$4);
            }
            target.set(selected);
        }
    }
    
    /**
     * Unsets the "selected" element
     */
    public void unsetSelected()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SELECTED$4, 0);
        }
    }
    /**
     * An XML selected(@http://grenoble.agile.org/questions).
     *
     * This is an atomic type that is a restriction of org.agile.grenoble.questions.AnswerType$Selected.
     */
    public static class SelectedImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements org.agile.grenoble.questions.AnswerType.Selected
    {
        private static final long serialVersionUID = 1L;
        
        public SelectedImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected SelectedImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
