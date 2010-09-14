/*
 * XML Type:  QuestionsType
 * Namespace: http://grenoble.agile.org/questions
 * Java type: org.agile.grenoble.questions.QuestionsType
 *
 * Automatically generated - do not modify.
 */
package org.agile.grenoble.questions.impl;
/**
 * An XML QuestionsType(@http://grenoble.agile.org/questions).
 *
 * This is a complex type.
 */
public class QuestionsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.agile.grenoble.questions.QuestionsType
{
    private static final long serialVersionUID = 1L;
    
    public QuestionsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName QUESTION$0 = 
        new javax.xml.namespace.QName("http://grenoble.agile.org/questions", "Question");
    
    
    /**
     * Gets array of all "Question" elements
     */
    public org.agile.grenoble.questions.QuestionType[] getQuestionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(QUESTION$0, targetList);
            org.agile.grenoble.questions.QuestionType[] result = new org.agile.grenoble.questions.QuestionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Question" element
     */
    public org.agile.grenoble.questions.QuestionType getQuestionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.QuestionType target = null;
            target = (org.agile.grenoble.questions.QuestionType)get_store().find_element_user(QUESTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Question" element
     */
    public int sizeOfQuestionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(QUESTION$0);
        }
    }
    
    /**
     * Sets array of all "Question" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setQuestionArray(org.agile.grenoble.questions.QuestionType[] questionArray)
    {
        check_orphaned();
        arraySetterHelper(questionArray, QUESTION$0);
    }
    
    /**
     * Sets ith "Question" element
     */
    public void setQuestionArray(int i, org.agile.grenoble.questions.QuestionType question)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.QuestionType target = null;
            target = (org.agile.grenoble.questions.QuestionType)get_store().find_element_user(QUESTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(question);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Question" element
     */
    public org.agile.grenoble.questions.QuestionType insertNewQuestion(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.QuestionType target = null;
            target = (org.agile.grenoble.questions.QuestionType)get_store().insert_element_user(QUESTION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Question" element
     */
    public org.agile.grenoble.questions.QuestionType addNewQuestion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.agile.grenoble.questions.QuestionType target = null;
            target = (org.agile.grenoble.questions.QuestionType)get_store().add_element_user(QUESTION$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Question" element
     */
    public void removeQuestion(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(QUESTION$0, i);
        }
    }
}
