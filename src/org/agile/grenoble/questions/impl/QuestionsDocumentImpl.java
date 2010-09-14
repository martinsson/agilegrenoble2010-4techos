/*
 * An XML document type.
 * Localname: Questions
 * Namespace: http://grenoble.agile.org/questions
 * Java type: org.agile.grenoble.questions.QuestionsDocument
 *
 * Automatically generated - do not modify.
 */
package org.agile.grenoble.questions.impl;
/**
 * A document containing one Questions(@http://grenoble.agile.org/questions) element.
 *
 * This is a complex type.
 */
public class QuestionsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.agile.grenoble.questions.QuestionsDocument
{
    private static final long serialVersionUID = 1L;
    
    public QuestionsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName QUESTIONS$0 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "Questions");
    
    
    /**
     * Gets the "Questions" element
     */
    public org.agile.grenoble.questions.QuestionsType getQuestions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.QuestionsType target = null;
            target = (org.agile.grenoble.questions.QuestionsType)get_store().find_element_user(QUESTIONS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Questions" element
     */
    public void setQuestions(org.agile.grenoble.questions.QuestionsType questions)
    {
        generatedSetterHelperImpl(questions, QUESTIONS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Questions" element
     */
    public org.agile.grenoble.questions.QuestionsType addNewQuestions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.QuestionsType target = null;
            target = (org.agile.grenoble.questions.QuestionsType)get_store().add_element_user(QUESTIONS$0);
            return target;
        }
    }
}
