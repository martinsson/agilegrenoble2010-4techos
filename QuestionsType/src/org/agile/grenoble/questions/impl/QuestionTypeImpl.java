/*
 * XML Type:  QuestionType
 * Namespace: http://grenoble.agile.org/questions
 * Java type: org.agile.grenoble.questions.QuestionType
 *
 * Automatically generated - do not modify.
 */
package org.agile.grenoble.questions.impl;
/**
 * An XML QuestionType(@http://grenoble.agile.org/questions).
 *
 * This is a complex type.
 */
public class QuestionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.agile.grenoble.questions.QuestionType
{
    private static final long serialVersionUID = 1L;
    
    public QuestionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LABEL$0 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "label");
    private static final javax.xml.namespace.QName CONFIGURATION$2 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "configuration");
    private static final javax.xml.namespace.QName ANSWERS$4 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "answers");
    
    
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
     * Gets the "configuration" element
     */
    public org.agile.grenoble.questions.ConfigurationType getConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.ConfigurationType target = null;
            target = (org.agile.grenoble.questions.ConfigurationType)get_store().find_element_user(CONFIGURATION$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "configuration" element
     */
    public boolean isSetConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONFIGURATION$2) != 0;
        }
    }
    
    /**
     * Sets the "configuration" element
     */
    public void setConfiguration(org.agile.grenoble.questions.ConfigurationType configuration)
    {
        generatedSetterHelperImpl(configuration, CONFIGURATION$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "configuration" element
     */
    public org.agile.grenoble.questions.ConfigurationType addNewConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.ConfigurationType target = null;
            target = (org.agile.grenoble.questions.ConfigurationType)get_store().add_element_user(CONFIGURATION$2);
            return target;
        }
    }
    
    /**
     * Unsets the "configuration" element
     */
    public void unsetConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONFIGURATION$2, 0);
        }
    }
    
    /**
     * Gets the "answers" element
     */
    public org.agile.grenoble.questions.AnswersType getAnswers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.AnswersType target = null;
            target = (org.agile.grenoble.questions.AnswersType)get_store().find_element_user(ANSWERS$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "answers" element
     */
    public void setAnswers(org.agile.grenoble.questions.AnswersType answers)
    {
        generatedSetterHelperImpl(answers, ANSWERS$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "answers" element
     */
    public org.agile.grenoble.questions.AnswersType addNewAnswers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.AnswersType target = null;
            target = (org.agile.grenoble.questions.AnswersType)get_store().add_element_user(ANSWERS$4);
            return target;
        }
    }
}
