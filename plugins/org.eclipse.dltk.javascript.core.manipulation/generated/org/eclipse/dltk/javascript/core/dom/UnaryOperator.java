/**
 * <copyright>
 * </copyright>
 *
 * $Id: UnaryOperator.java,v 1.3 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Unary Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#getUnaryOperator()
 * @model
 * @generated
 */
public enum UnaryOperator implements Enumerator {
	/**
	 * The '<em><b>Postfix Inc</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSTFIX_INC_VALUE
	 * @generated
	 * @ordered
	 */
	POSTFIX_INC(1, "postfixInc", "postfixInc"),

	/**
	 * The '<em><b>Postfix Dec</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSTFIX_DEC_VALUE
	 * @generated
	 * @ordered
	 */
	POSTFIX_DEC(2, "postfixDec", "postfixDec"),

	/**
	 * The '<em><b>Delete</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE(3, "delete", "delete"),

	/**
	 * The '<em><b>Void</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOID_VALUE
	 * @generated
	 * @ordered
	 */
	VOID(4, "void", "void"),

	/**
	 * The '<em><b>Typeof</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPEOF_VALUE
	 * @generated
	 * @ordered
	 */
	TYPEOF(5, "typeof", "typeof"),

	/**
	 * The '<em><b>Prefix Inc</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFIX_INC_VALUE
	 * @generated
	 * @ordered
	 */
	PREFIX_INC(6, "prefixInc", "++"),

	/**
	 * The '<em><b>Prefix Dec</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFIX_DEC_VALUE
	 * @generated
	 * @ordered
	 */
	PREFIX_DEC(7, "prefixDec", "--"),

	/**
	 * The '<em><b>Unary Plus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNARY_PLUS_VALUE
	 * @generated
	 * @ordered
	 */
	UNARY_PLUS(8, "unaryPlus", "+"),

	/**
	 * The '<em><b>Num Neg</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUM_NEG_VALUE
	 * @generated
	 * @ordered
	 */
	NUM_NEG(9, "numNeg", "-"),

	/**
	 * The '<em><b>Bw Not</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BW_NOT_VALUE
	 * @generated
	 * @ordered
	 */
	BW_NOT(10, "bwNot", "~"),

	/**
	 * The '<em><b>Not</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_VALUE
	 * @generated
	 * @ordered
	 */
	NOT(11, "not", "!"),

	/**
	 * The '<em><b>Yield</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YIELD_VALUE
	 * @generated
	 * @ordered
	 */
	YIELD(12, "yield", "yield");

	/**
	 * The '<em><b>Postfix Inc</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Postfix Inc</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POSTFIX_INC
	 * @model name="postfixInc"
	 * @generated
	 * @ordered
	 */
	public static final int POSTFIX_INC_VALUE = 1;

	/**
	 * The '<em><b>Postfix Dec</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Postfix Dec</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POSTFIX_DEC
	 * @model name="postfixDec"
	 * @generated
	 * @ordered
	 */
	public static final int POSTFIX_DEC_VALUE = 2;

	/**
	 * The '<em><b>Delete</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Delete</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELETE
	 * @model name="delete"
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_VALUE = 3;

	/**
	 * The '<em><b>Void</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Void</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOID
	 * @model name="void"
	 * @generated
	 * @ordered
	 */
	public static final int VOID_VALUE = 4;

	/**
	 * The '<em><b>Typeof</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Typeof</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TYPEOF
	 * @model name="typeof"
	 * @generated
	 * @ordered
	 */
	public static final int TYPEOF_VALUE = 5;

	/**
	 * The '<em><b>Prefix Inc</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Prefix Inc</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREFIX_INC
	 * @model name="prefixInc" literal="++"
	 * @generated
	 * @ordered
	 */
	public static final int PREFIX_INC_VALUE = 6;

	/**
	 * The '<em><b>Prefix Dec</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Prefix Dec</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREFIX_DEC
	 * @model name="prefixDec" literal="--"
	 * @generated
	 * @ordered
	 */
	public static final int PREFIX_DEC_VALUE = 7;

	/**
	 * The '<em><b>Unary Plus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unary Plus</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNARY_PLUS
	 * @model name="unaryPlus" literal="+"
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_PLUS_VALUE = 8;

	/**
	 * The '<em><b>Num Neg</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Num Neg</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NUM_NEG
	 * @model name="numNeg" literal="-"
	 * @generated
	 * @ordered
	 */
	public static final int NUM_NEG_VALUE = 9;

	/**
	 * The '<em><b>Bw Not</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bw Not</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BW_NOT
	 * @model name="bwNot" literal="~"
	 * @generated
	 * @ordered
	 */
	public static final int BW_NOT_VALUE = 10;

	/**
	 * The '<em><b>Not</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT
	 * @model name="not" literal="!"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_VALUE = 11;

	/**
	 * The '<em><b>Yield</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Yield</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #YIELD
	 * @model name="yield"
	 * @generated
	 * @ordered
	 */
	public static final int YIELD_VALUE = 12;

	/**
	 * An array of all the '<em><b>Unary Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UnaryOperator[] VALUES_ARRAY =
		new UnaryOperator[] {
			POSTFIX_INC,
			POSTFIX_DEC,
			DELETE,
			VOID,
			TYPEOF,
			PREFIX_INC,
			PREFIX_DEC,
			UNARY_PLUS,
			NUM_NEG,
			BW_NOT,
			NOT,
			YIELD,
		};

	/**
	 * A public read-only list of all the '<em><b>Unary Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<UnaryOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Unary Operator</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static UnaryOperator get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnaryOperator result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unary Operator</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static UnaryOperator getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnaryOperator result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unary Operator</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static UnaryOperator get(int value) {
		switch (value) {
			case POSTFIX_INC_VALUE: return POSTFIX_INC;
			case POSTFIX_DEC_VALUE: return POSTFIX_DEC;
			case DELETE_VALUE: return DELETE;
			case VOID_VALUE: return VOID;
			case TYPEOF_VALUE: return TYPEOF;
			case PREFIX_INC_VALUE: return PREFIX_INC;
			case PREFIX_DEC_VALUE: return PREFIX_DEC;
			case UNARY_PLUS_VALUE: return UNARY_PLUS;
			case NUM_NEG_VALUE: return NUM_NEG;
			case BW_NOT_VALUE: return BW_NOT;
			case NOT_VALUE: return NOT;
			case YIELD_VALUE: return YIELD;
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
	private UnaryOperator(int value, String name, String literal) {
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
	
} //UnaryOperator
