/*******************************************************************************
 * Copyright (c) 2009 xored software, Inc.  
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html  
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Vladimir Belov)
 *******************************************************************************/

package org.eclipse.dltk.javascript.ast;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.ASTVisitor;

public class CatchClause extends JSNode implements ISourceable {

    private Keyword catchKeyword;
    private Identifier exception;
    private Keyword ifKeyword = null;
    private Expression filterExpression = null;
    private Statement statement;
    private int LP = -1;
    private int RP = -1;

    public CatchClause(JSNode parent) {
        super(parent);
    }

    /**
     * @see org.eclipse.dltk.ast.ASTNode#traverse(org.eclipse.dltk.ast.ASTVisitor)
     */
    @Override
    public void traverse(ASTVisitor visitor) throws Exception {
        if (visitor.visit(this)) {
            if (catchKeyword != null)
                catchKeyword.traverse(visitor);
            if (exception != null)
                exception.traverse(visitor);
            if (ifKeyword != null)
                ifKeyword.traverse(visitor);
            if (filterExpression != null)
                filterExpression.traverse(visitor);
            if (statement != null)
                statement.traverse(visitor);

            visitor.endvisit(this);
        }
    }

    public Identifier getException() {
        return this.exception;
    }

    public void setException(Identifier exception) {
        this.exception = exception;
    }

    public Keyword getIfKeyword() {
        return this.ifKeyword;
    }

    public void setIfKeyword(Keyword ifKeyword) {
        this.ifKeyword = ifKeyword;
    }

    public Expression getFilterExpression() {
        return filterExpression;
    }

    public void setFilterExpression(Expression filterExpression) {
        this.filterExpression = filterExpression;
    }

    public Statement getStatement() {
        return this.statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Keyword getCatchKeyword() {
        return this.catchKeyword;
    }

    public void setCatchKeyword(Keyword keyword) {
        this.catchKeyword = keyword;
    }

    public int getLP() {
        return this.LP;
    }

    public void setLP(int LP) {
        this.LP = LP;
    }

    public int getRP() {
        return this.RP;
    }

    public void setRP(int RP) {
        this.RP = RP;
    }

    @Override
    public String toSourceString(String indentationString) {

        Assert.isTrue(sourceStart() > 0);
        Assert.isTrue(sourceEnd() > 0);

        StringBuffer buffer = new StringBuffer();

        buffer.append(indentationString);
        buffer.append(Keywords.CATCH);
       if (LP > 0) buffer.append(" (");
        if (this.exception != null) {
        	buffer.append(this.exception.toSourceString(indentationString));
        }
        if (ifKeyword != null && filterExpression != null) {
            buffer.append(' ');
            buffer.append(Keywords.IF);
            buffer.append(' ');
            buffer.append(filterExpression.toSourceString(indentationString));
        }
       if (RP > 0) buffer.append(")\n");

        buffer.append(statement.toSourceString(indentationString));

        return buffer.toString();
    }

}
