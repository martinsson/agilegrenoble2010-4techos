/*
 * XML Type:  answersType
 * Namespace: http://grenoble.agile.org/questions
 * Java type: org.agile.grenoble.questions.AnswersType
 *
 * Automatically generated - do not modify.
 */
package org.agile.grenoble.questions.impl;
/**
 * An XML answersType(@http://grenoble.agile.org/questions).
 *
 * This is a complex type.
 */
public class AnswersTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.agile.grenoble.questions.AnswersType
{
    private static final long serialVersionUID = 1L;
    
    public AnswersTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANSWER$0 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "answer");
    
    
    /**
     * Gets array of all "answer" elements
     */
    public org.agile.grenoble.questions.AnswerType[] getAnswerArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ANSWER$0, targetList);
            org.agile.grenoble.questions.AnswerType[] result = new org.agile.grenoble.questions.AnswerType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "answer" element
     */
    public org.agile.grenoble.questions.AnswerType getAnswerArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.AnswerType target = null;
            target = (org.agile.grenoble.questions.AnswerType)get_store().find_element_user(ANSWER$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "answer" element
     */
    public int sizeOfAnswerArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANSWER$0);
        }
    }
    
    /**
     * Sets array of all "answer" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setAnswerArray(org.agile.grenoble.questions.AnswerType[] answerArray)
    {
        check_orphaned();
        arraySetterHelper(answerArray, ANSWER$0);
    }
    
    /**
     * Sets ith "answer" element
     */
    public void setAnswerArray(int i, org.agile.grenoble.questions.AnswerType answer)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.AnswerType target = null;
            target = (org.agile.grenoble.questions.AnswerType)get_store().find_element_user(ANSWER$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(answer);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "answer" element
     */
    public org.agile.grenoble.questions.AnswerType insertNewAnswer(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.AnswerType target = null;
            target = (org.agile.grenoble.questions.AnswerType)get_store().insert_element_user(ANSWER$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "answer" element
     */
    public org.agile.grenoble.questions.AnswerType addNewAnswer()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.AnswerType target = null;
            target = (org.agile.grenoble.questions.AnswerType)get_store().add_element_user(ANSWER$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "answer" element
     */
    public void removeAnswer(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANSWER$0, i);
        }
    }
}
