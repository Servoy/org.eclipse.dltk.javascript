/**
 * <copyright>
 * </copyright>
 *
 * $Id: BinaryOperator.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Binary Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getBinaryOperator()
 * @model
 * @generated
 */
public enum BinaryOperator implements Enumerator {
	/**
	 * The '<em><b>Mul</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUL_VALUE
	 * @generated
	 * @ordered
	 */
	MUL(1, "mul", "*"),

	/**
	 * The '<em><b>Div</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIV_VALUE
	 * @generated
	 * @ordered
	 */
	DIV(2, "div", "/"),

	/**
	 * The '<em><b>Mod</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOD_VALUE
	 * @generated
	 * @ordered
	 */
	MOD(3, "mod", "%"),

	/**
	 * The '<em><b>Add</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_VALUE
	 * @generated
	 * @ordered
	 */
	ADD(4, "add", "+"),

	/**
	 * The '<em><b>Sub</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUB_VALUE
	 * @generated
	 * @ordered
	 */
	SUB(5, "sub", "-"),

	/**
	 * The '<em><b>Lsh</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LSH_VALUE
	 * @generated
	 * @ordered
	 */
	LSH(6, "lsh", "<<"),

	/**
	 * The '<em><b>Rsh</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RSH_VALUE
	 * @generated
	 * @ordered
	 */
	RSH(7, "rsh", ">>"),

	/**
	 * The '<em><b>Ursh</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #URSH_VALUE
	 * @generated
	 * @ordered
	 */
	URSH(8, "ursh", ">>>"),

	/**
	 * The '<em><b>Less</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LESS_VALUE
	 * @generated
	 * @ordered
	 */
	LESS(9, "less", "<"),

	/**
	 * The '<em><b>Greater</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER(10, "greater", ">"),

	/**
	 * The '<em><b>Leq</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEQ_VALUE
	 * @generated
	 * @ordered
	 */
	LEQ(11, "leq", "<="),

	/**
	 * The '<em><b>Geq</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GEQ_VALUE
	 * @generated
	 * @ordered
	 */
	GEQ(12, "geq", ">="),

	/**
	 * The '<em><b>Instanceof</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANCEOF_VALUE
	 * @generated
	 * @ordered
	 */
	INSTANCEOF(13, "instanceof", "instanceof"),

	/**
	 * The '<em><b>In</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN_VALUE
	 * @generated
	 * @ordered
	 */
	IN(14, "in", "in"),

	/**
	 * The '<em><b>Eq</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQ_VALUE
	 * @generated
	 * @ordered
	 */
	EQ(15, "eq", "=="),

	/**
	 * The '<em><b>Neq</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEQ_VALUE
	 * @generated
	 * @ordered
	 */
	NEQ(16, "neq", "!="),

	/**
	 * The '<em><b>Same</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAME_VALUE
	 * @generated
	 * @ordered
	 */
	SAME(17, "same", "==="),

	/**
	 * The '<em><b>Nsame</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NSAME_VALUE
	 * @generated
	 * @ordered
	 */
	NSAME(18, "nsame", "!=="),

	/**
	 * The '<em><b>Bw And</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BW_AND_VALUE
	 * @generated
	 * @ordered
	 */
	BW_AND(19, "bwAnd", "&"),

	/**
	 * The '<em><b>Bw Xor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BW_XOR_VALUE
	 * @generated
	 * @ordered
	 */
	BW_XOR(20, "bwXor", "^"),

	/**
	 * The '<em><b>Bw Or</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BW_OR_VALUE
	 * @generated
	 * @ordered
	 */
	BW_OR(21, "bwOr", "|"),

	/**
	 * The '<em><b>Log And</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_AND_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_AND(22, "logAnd", "&&"),

	/**
	 * The '<em><b>Log Or</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_OR_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_OR(23, "logOr", "||"),

	/**
	 * The '<em><b>Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	ASSIGN(24, "assign", "="),

	/**
	 * The '<em><b>Mul Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUL_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	MUL_ASSIGN(25, "mulAssign", "*="),

	/**
	 * The '<em><b>Div Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIV_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	DIV_ASSIGN(26, "divAssign", "/="),

	/**
	 * The '<em><b>Mod Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOD_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	MOD_ASSIGN(27, "modAssign", "%="),

	/**
	 * The '<em><b>Add Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	ADD_ASSIGN(28, "addAssign", "+="),

	/**
	 * The '<em><b>Sub Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUB_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	SUB_ASSIGN(29, "subAssign", "-="),

	/**
	 * The '<em><b>Lsh Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LSH_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	LSH_ASSIGN(30, "lshAssign", "<<="),

	/**
	 * The '<em><b>Rsh Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RSH_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	RSH_ASSIGN(31, "rshAssign", ">>="),

	/**
	 * The '<em><b>Ursh Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #URSH_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	URSH_ASSIGN(32, "urshAssign", ">>>="),

	/**
	 * The '<em><b>And Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AND_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	AND_ASSIGN(33, "andAssign", "&="),

	/**
	 * The '<em><b>Xor Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XOR_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	XOR_ASSIGN(34, "xorAssign", "^="),

	/**
	 * The '<em><b>Or Assign</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OR_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	OR_ASSIGN(35, "orAssign", "|="),

	/**
	 * The '<em><b>Comma</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMA_VALUE
	 * @generated
	 * @ordered
	 */
	COMMA(36, "comma", ",");

	/**
	 * The '<em><b>Mul</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mul</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUL
	 * @model name="mul" literal="*"
	 * @generated
	 * @ordered
	 */
	public static final int MUL_VALUE = 1;

	/**
	 * The '<em><b>Div</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Div</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIV
	 * @model name="div" literal="/"
	 * @generated
	 * @ordered
	 */
	public static final int DIV_VALUE = 2;

	/**
	 * The '<em><b>Mod</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mod</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOD
	 * @model name="mod" literal="%"
	 * @generated
	 * @ordered
	 */
	public static final int MOD_VALUE = 3;

	/**
	 * The '<em><b>Add</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Add</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADD
	 * @model name="add" literal="+"
	 * @generated
	 * @ordered
	 */
	public static final int ADD_VALUE = 4;

	/**
	 * The '<em><b>Sub</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sub</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUB
	 * @model name="sub" literal="-"
	 * @generated
	 * @ordered
	 */
	public static final int SUB_VALUE = 5;

	/**
	 * The '<em><b>Lsh</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lsh</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSH
	 * @model name="lsh" literal="&lt;&lt;"
	 * @generated
	 * @ordered
	 */
	public static final int LSH_VALUE = 6;

	/**
	 * The '<em><b>Rsh</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rsh</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RSH
	 * @model name="rsh" literal="&gt;&gt;"
	 * @generated
	 * @ordered
	 */
	public static final int RSH_VALUE = 7;

	/**
	 * The '<em><b>Ursh</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ursh</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #URSH
	 * @model name="ursh" literal="&gt;&gt;&gt;"
	 * @generated
	 * @ordered
	 */
	public static final int URSH_VALUE = 8;

	/**
	 * The '<em><b>Less</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Less</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LESS
	 * @model name="less" literal="&lt;"
	 * @generated
	 * @ordered
	 */
	public static final int LESS_VALUE = 9;

	/**
	 * The '<em><b>Greater</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Greater</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER
	 * @model name="greater" literal="&gt;"
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_VALUE = 10;

	/**
	 * The '<em><b>Leq</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Leq</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LEQ
	 * @model name="leq" literal="&lt;="
	 * @generated
	 * @ordered
	 */
	public static final int LEQ_VALUE = 11;

	/**
	 * The '<em><b>Geq</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Geq</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GEQ
	 * @model name="geq" literal="&gt;="
	 * @generated
	 * @ordered
	 */
	public static final int GEQ_VALUE = 12;

	/**
	 * The '<em><b>Instanceof</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Instanceof</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTANCEOF
	 * @model name="instanceof"
	 * @generated
	 * @ordered
	 */
	public static final int INSTANCEOF_VALUE = 13;

	/**
	 * The '<em><b>In</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>In</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IN
	 * @model name="in"
	 * @generated
	 * @ordered
	 */
	public static final int IN_VALUE = 14;

	/**
	 * The '<em><b>Eq</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Eq</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQ
	 * @model name="eq" literal="=="
	 * @generated
	 * @ordered
	 */
	public static final int EQ_VALUE = 15;

	/**
	 * The '<em><b>Neq</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Neq</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEQ
	 * @model name="neq" literal="!="
	 * @generated
	 * @ordered
	 */
	public static final int NEQ_VALUE = 16;

	/**
	 * The '<em><b>Same</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Same</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAME
	 * @model name="same" literal="==="
	 * @generated
	 * @ordered
	 */
	public static final int SAME_VALUE = 17;

	/**
	 * The '<em><b>Nsame</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nsame</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NSAME
	 * @model name="nsame" literal="!=="
	 * @generated
	 * @ordered
	 */
	public static final int NSAME_VALUE = 18;

	/**
	 * The '<em><b>Bw And</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bw And</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BW_AND
	 * @model name="bwAnd" literal="&amp;"
	 * @generated
	 * @ordered
	 */
	public static final int BW_AND_VALUE = 19;

	/**
	 * The '<em><b>Bw Xor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bw Xor</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BW_XOR
	 * @model name="bwXor" literal="^"
	 * @generated
	 * @ordered
	 */
	public static final int BW_XOR_VALUE = 20;

	/**
	 * The '<em><b>Bw Or</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bw Or</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BW_OR
	 * @model name="bwOr" literal="|"
	 * @generated
	 * @ordered
	 */
	public static final int BW_OR_VALUE = 21;

	/**
	 * The '<em><b>Log And</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Log And</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOG_AND
	 * @model name="logAnd" literal="&amp;&amp;"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_AND_VALUE = 22;

	/**
	 * The '<em><b>Log Or</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Log Or</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOG_OR
	 * @model name="logOr" literal="||"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_OR_VALUE = 23;

	/**
	 * The '<em><b>Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSIGN
	 * @model name="assign" literal="="
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGN_VALUE = 24;

	/**
	 * The '<em><b>Mul Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mul Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUL_ASSIGN
	 * @model name="mulAssign" literal="*="
	 * @generated
	 * @ordered
	 */
	public static final int MUL_ASSIGN_VALUE = 25;

	/**
	 * The '<em><b>Div Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Div Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIV_ASSIGN
	 * @model name="divAssign" literal="/="
	 * @generated
	 * @ordered
	 */
	public static final int DIV_ASSIGN_VALUE = 26;

	/**
	 * The '<em><b>Mod Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mod Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOD_ASSIGN
	 * @model name="modAssign" literal="%="
	 * @generated
	 * @ordered
	 */
	public static final int MOD_ASSIGN_VALUE = 27;

	/**
	 * The '<em><b>Add Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Add Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADD_ASSIGN
	 * @model name="addAssign" literal="+="
	 * @generated
	 * @ordered
	 */
	public static final int ADD_ASSIGN_VALUE = 28;

	/**
	 * The '<em><b>Sub Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sub Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUB_ASSIGN
	 * @model name="subAssign" literal="-="
	 * @generated
	 * @ordered
	 */
	public static final int SUB_ASSIGN_VALUE = 29;

	/**
	 * The '<em><b>Lsh Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lsh Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSH_ASSIGN
	 * @model name="lshAssign" literal="&lt;&lt;="
	 * @generated
	 * @ordered
	 */
	public static final int LSH_ASSIGN_VALUE = 30;

	/**
	 * The '<em><b>Rsh Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rsh Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RSH_ASSIGN
	 * @model name="rshAssign" literal="&gt;&gt;="
	 * @generated
	 * @ordered
	 */
	public static final int RSH_ASSIGN_VALUE = 31;

	/**
	 * The '<em><b>Ursh Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ursh Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #URSH_ASSIGN
	 * @model name="urshAssign" literal="&gt;&gt;&gt;="
	 * @generated
	 * @ordered
	 */
	public static final int URSH_ASSIGN_VALUE = 32;

	/**
	 * The '<em><b>And Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>And Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AND_ASSIGN
	 * @model name="andAssign" literal="&amp;="
	 * @generated
	 * @ordered
	 */
	public static final int AND_ASSIGN_VALUE = 33;

	/**
	 * The '<em><b>Xor Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Xor Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XOR_ASSIGN
	 * @model name="xorAssign" literal="^="
	 * @generated
	 * @ordered
	 */
	public static final int XOR_ASSIGN_VALUE = 34;

	/**
	 * The '<em><b>Or Assign</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Or Assign</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OR_ASSIGN
	 * @model name="orAssign" literal="|="
	 * @generated
	 * @ordered
	 */
	public static final int OR_ASSIGN_VALUE = 35;

	/**
	 * The '<em><b>Comma</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Comma</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMA
	 * @model name="comma" literal=","
	 * @generated
	 * @ordered
	 */
	public static final int COMMA_VALUE = 36;

	/**
	 * An array of all the '<em><b>Binary Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BinaryOperator[] VALUES_ARRAY =
		new BinaryOperator[] {
			MUL,
			DIV,
			MOD,
			ADD,
			SUB,
			LSH,
			RSH,
			URSH,
			LESS,
			GREATER,
			LEQ,
			GEQ,
			INSTANCEOF,
			IN,
			EQ,
			NEQ,
			SAME,
			NSAME,
			BW_AND,
			BW_XOR,
			BW_OR,
			LOG_AND,
			LOG_OR,
			ASSIGN,
			MUL_ASSIGN,
			DIV_ASSIGN,
			MOD_ASSIGN,
			ADD_ASSIGN,
			SUB_ASSIGN,
			LSH_ASSIGN,
			RSH_ASSIGN,
			URSH_ASSIGN,
			AND_ASSIGN,
			XOR_ASSIGN,
			OR_ASSIGN,
			COMMA,
		};

	/**
	 * A public read-only list of all the '<em><b>Binary Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BinaryOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Binary Operator</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BinaryOperator get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BinaryOperator result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Binary Operator</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BinaryOperator getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BinaryOperator result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Binary Operator</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BinaryOperator get(int value) {
		switch (value) {
			case MUL_VALUE: return MUL;
			case DIV_VALUE: return DIV;
			case MOD_VALUE: return MOD;
			case ADD_VALUE: return ADD;
			case SUB_VALUE: return SUB;
			case LSH_VALUE: return LSH;
			case RSH_VALUE: return RSH;
			case URSH_VALUE: return URSH;
			case LESS_VALUE: return LESS;
			case GREATER_VALUE: return GREATER;
			case LEQ_VALUE: return LEQ;
			case GEQ_VALUE: return GEQ;
			case INSTANCEOF_VALUE: return INSTANCEOF;
			case IN_VALUE: return IN;
			case EQ_VALUE: return EQ;
			case NEQ_VALUE: return NEQ;
			case SAME_VALUE: return SAME;
			case NSAME_VALUE: return NSAME;
			case BW_AND_VALUE: return BW_AND;
			case BW_XOR_VALUE: return BW_XOR;
			case BW_OR_VALUE: return BW_OR;
			case LOG_AND_VALUE: return LOG_AND;
			case LOG_OR_VALUE: return LOG_OR;
			case ASSIGN_VALUE: return ASSIGN;
			case MUL_ASSIGN_VALUE: return MUL_ASSIGN;
			case DIV_ASSIGN_VALUE: return DIV_ASSIGN;
			case MOD_ASSIGN_VALUE: return MOD_ASSIGN;
			case ADD_ASSIGN_VALUE: return ADD_ASSIGN;
			case SUB_ASSIGN_VALUE: return SUB_ASSIGN;
			case LSH_ASSIGN_VALUE: return LSH_ASSIGN;
			case RSH_ASSIGN_VALUE: return RSH_ASSIGN;
			case URSH_ASSIGN_VALUE: return URSH_ASSIGN;
			case AND_ASSIGN_VALUE: return AND_ASSIGN;
			case XOR_ASSIGN_VALUE: return XOR_ASSIGN;
			case OR_ASSIGN_VALUE: return OR_ASSIGN;
			case COMMA_VALUE: return COMMA;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BinaryOperator(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //BinaryOperator
