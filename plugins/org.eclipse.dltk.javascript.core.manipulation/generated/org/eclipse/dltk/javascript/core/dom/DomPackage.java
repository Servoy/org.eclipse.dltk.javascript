/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomPackage.java,v 1.5 2011/04/18 08:29:43 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.dltk.javascript.core.dom.DomFactory
 * @model kind="package"
 * @generated
 */
public interface DomPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dom";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/dltk/javascript/core/dom/dom.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.dltk.javascript.core.dom";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomPackage eINSTANCE = org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.NodeImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 0;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__BEGIN = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__END = 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.CommentImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__TEXT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.IdentifierImpl <em>Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.IdentifierImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIdentifier()
	 * @generated
	 */
	int IDENTIFIER = 2;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__NAME = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__END = NODE__END;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.VariableReferenceImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__VARIABLE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.LabelImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 4;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__NAME = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.NullLiteralImpl <em>Null Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.NullLiteralImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getNullLiteral()
	 * @generated
	 */
	int NULL_LITERAL = 6;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL__END = EXPRESSION__END;

	/**
	 * The number of structural features of the '<em>Null Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.BooleanLiteralImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBooleanLiteral()
	 * @generated
	 */
	int BOOLEAN_LITERAL = 7;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__TEXT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.NumericLiteralImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getNumericLiteral()
	 * @generated
	 */
	int NUMERIC_LITERAL = 8;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__TEXT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.StringLiteralImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 9;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__TEXT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.RegularExpressionLiteralImpl <em>Regular Expression Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.RegularExpressionLiteralImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getRegularExpressionLiteral()
	 * @generated
	 */
	int REGULAR_EXPRESSION_LITERAL = 10;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULAR_EXPRESSION_LITERAL__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULAR_EXPRESSION_LITERAL__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULAR_EXPRESSION_LITERAL__TEXT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regular Expression Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULAR_EXPRESSION_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ThisExpressionImpl <em>This Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ThisExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getThisExpression()
	 * @generated
	 */
	int THIS_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The number of structural features of the '<em>This Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ArrayLiteralImpl <em>Array Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ArrayLiteralImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getArrayLiteral()
	 * @generated
	 */
	int ARRAY_LITERAL = 12;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL__ELEMENTS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.IArrayElement <em>IArray Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.IArrayElement
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIArrayElement()
	 * @generated
	 */
	int IARRAY_ELEMENT = 13;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARRAY_ELEMENT__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARRAY_ELEMENT__END = NODE__END;

	/**
	 * The number of structural features of the '<em>IArray Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARRAY_ELEMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ElisionImpl <em>Elision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ElisionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getElision()
	 * @generated
	 */
	int ELISION = 14;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELISION__BEGIN = IARRAY_ELEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELISION__END = IARRAY_ELEMENT__END;

	/**
	 * The number of structural features of the '<em>Elision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELISION_FEATURE_COUNT = IARRAY_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ObjectLiteralImpl <em>Object Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ObjectLiteralImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getObjectLiteral()
	 * @generated
	 */
	int OBJECT_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LITERAL__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LITERAL__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LITERAL__PROPERTIES = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.PropertyAssignmentImpl <em>Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.PropertyAssignmentImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getPropertyAssignment()
	 * @generated
	 */
	int PROPERTY_ASSIGNMENT = 16;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__NAME = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.IPropertyName <em>IProperty Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.IPropertyName
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIPropertyName()
	 * @generated
	 */
	int IPROPERTY_NAME = 17;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROPERTY_NAME__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROPERTY_NAME__END = NODE__END;

	/**
	 * The number of structural features of the '<em>IProperty Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROPERTY_NAME_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SimplePropertyAssignmentImpl <em>Simple Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.SimplePropertyAssignmentImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSimplePropertyAssignment()
	 * @generated
	 */
	int SIMPLE_PROPERTY_ASSIGNMENT = 18;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_ASSIGNMENT__BEGIN = PROPERTY_ASSIGNMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_ASSIGNMENT__END = PROPERTY_ASSIGNMENT__END;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_ASSIGNMENT__NAME = PROPERTY_ASSIGNMENT__NAME;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_ASSIGNMENT__INITIALIZER = PROPERTY_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_ASSIGNMENT_FEATURE_COUNT = PROPERTY_ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.AccessorAssignmentImpl <em>Accessor Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.AccessorAssignmentImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getAccessorAssignment()
	 * @generated
	 */
	int ACCESSOR_ASSIGNMENT = 19;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSOR_ASSIGNMENT__BEGIN = PROPERTY_ASSIGNMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSOR_ASSIGNMENT__END = PROPERTY_ASSIGNMENT__END;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSOR_ASSIGNMENT__NAME = PROPERTY_ASSIGNMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSOR_ASSIGNMENT__BODY = PROPERTY_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Accessor Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESSOR_ASSIGNMENT_FEATURE_COUNT = PROPERTY_ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.GetterAssignmentImpl <em>Getter Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.GetterAssignmentImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getGetterAssignment()
	 * @generated
	 */
	int GETTER_ASSIGNMENT = 20;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETTER_ASSIGNMENT__BEGIN = ACCESSOR_ASSIGNMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETTER_ASSIGNMENT__END = ACCESSOR_ASSIGNMENT__END;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETTER_ASSIGNMENT__NAME = ACCESSOR_ASSIGNMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETTER_ASSIGNMENT__BODY = ACCESSOR_ASSIGNMENT__BODY;

	/**
	 * The number of structural features of the '<em>Getter Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GETTER_ASSIGNMENT_FEATURE_COUNT = ACCESSOR_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SetterAssignmentImpl <em>Setter Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.SetterAssignmentImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSetterAssignment()
	 * @generated
	 */
	int SETTER_ASSIGNMENT = 21;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTER_ASSIGNMENT__BEGIN = ACCESSOR_ASSIGNMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTER_ASSIGNMENT__END = ACCESSOR_ASSIGNMENT__END;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTER_ASSIGNMENT__NAME = ACCESSOR_ASSIGNMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTER_ASSIGNMENT__BODY = ACCESSOR_ASSIGNMENT__BODY;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTER_ASSIGNMENT__PARAMETER = ACCESSOR_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Setter Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTER_ASSIGNMENT_FEATURE_COUNT = ACCESSOR_ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ParenthesizedExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getParenthesizedExpression()
	 * @generated
	 */
	int PARENTHESIZED_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTHESIZED_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTHESIZED_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Enclosed</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTHESIZED_EXPRESSION__ENCLOSED = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parenthesized Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTHESIZED_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ArrayAccessExpressionImpl <em>Array Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ArrayAccessExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getArrayAccessExpression()
	 * @generated
	 */
	int ARRAY_ACCESS_EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS_EXPRESSION__ARRAY = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS_EXPRESSION__INDEX = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Array Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.PropertyAccessExpressionImpl <em>Property Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.PropertyAccessExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getPropertyAccessExpression()
	 * @generated
	 */
	int PROPERTY_ACCESS_EXPRESSION = 24;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ACCESS_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ACCESS_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ACCESS_EXPRESSION__OBJECT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ACCESS_EXPRESSION__PROPERTY = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ACCESS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.NewExpressionImpl <em>New Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.NewExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getNewExpression()
	 * @generated
	 */
	int NEW_EXPRESSION = 25;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__CONSTRUCTOR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__ARGUMENTS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>New Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.CallExpressionImpl <em>Call Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.CallExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getCallExpression()
	 * @generated
	 */
	int CALL_EXPRESSION = 26;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Applicant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXPRESSION__APPLICANT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXPRESSION__ARGUMENTS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.UnaryExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getUnaryExpression()
	 * @generated
	 */
	int UNARY_EXPRESSION = 27;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__ARGUMENT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERATION = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.BinaryExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBinaryExpression()
	 * @generated
	 */
	int BINARY_EXPRESSION = 28;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__OPERATION = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operator Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__OPERATOR_POSITION = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ConditionalExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getConditionalExpression()
	 * @generated
	 */
	int CONDITIONAL_EXPRESSION = 29;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION__PREDICATE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Consequent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION__CONSEQUENT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alternative</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION__ALTERNATIVE = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Conditional Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.StatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 30;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__END = NODE__END;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.BlockStatementImpl <em>Block Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.BlockStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBlockStatement()
	 * @generated
	 */
	int BLOCK_STATEMENT = 31;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.VariableStatementImpl <em>Variable Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.VariableStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getVariableStatement()
	 * @generated
	 */
	int VARIABLE_STATEMENT = 32;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__DECLARATIONS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.VariableDeclarationImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 33;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__IDENTIFIER = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__INITIALIZER = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.EmptyStatementImpl <em>Empty Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.EmptyStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getEmptyStatement()
	 * @generated
	 */
	int EMPTY_STATEMENT = 34;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_STATEMENT__END = STATEMENT__END;

	/**
	 * The number of structural features of the '<em>Empty Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ExpressionStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getExpressionStatement()
	 * @generated
	 */
	int EXPRESSION_STATEMENT = 35;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.IfStatementImpl <em>If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.IfStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIfStatement()
	 * @generated
	 */
	int IF_STATEMENT = 36;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__PREDICATE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Consequent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__CONSEQUENT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alternative</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__ALTERNATIVE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.IterationStatementImpl <em>Iteration Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.IterationStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIterationStatement()
	 * @generated
	 */
	int ITERATION_STATEMENT = 37;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iteration Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.DoStatementImpl <em>Do Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DoStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getDoStatement()
	 * @generated
	 */
	int DO_STATEMENT = 38;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_STATEMENT__BEGIN = ITERATION_STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_STATEMENT__END = ITERATION_STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_STATEMENT__BODY = ITERATION_STATEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_STATEMENT__CONDITION = ITERATION_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Do Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_STATEMENT_FEATURE_COUNT = ITERATION_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.WhileStatementImpl <em>While Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.WhileStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getWhileStatement()
	 * @generated
	 */
	int WHILE_STATEMENT = 39;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__BEGIN = ITERATION_STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__END = ITERATION_STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__BODY = ITERATION_STATEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__CONDITION = ITERATION_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>While Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT_FEATURE_COUNT = ITERATION_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ForStatementImpl <em>For Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ForStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getForStatement()
	 * @generated
	 */
	int FOR_STATEMENT = 40;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__BEGIN = ITERATION_STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__END = ITERATION_STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__BODY = ITERATION_STATEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Initialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__INITIALIZATION = ITERATION_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__CONDITION = ITERATION_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Increment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__INCREMENT = ITERATION_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_FEATURE_COUNT = ITERATION_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.IForInitializer <em>IFor Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.IForInitializer
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIForInitializer()
	 * @generated
	 */
	int IFOR_INITIALIZER = 41;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFOR_INITIALIZER__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFOR_INITIALIZER__END = NODE__END;

	/**
	 * The number of structural features of the '<em>IFor Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFOR_INITIALIZER_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ForInStatementImpl <em>For In Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ForInStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getForInStatement()
	 * @generated
	 */
	int FOR_IN_STATEMENT = 42;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_IN_STATEMENT__BEGIN = ITERATION_STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_IN_STATEMENT__END = ITERATION_STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_IN_STATEMENT__BODY = ITERATION_STATEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_IN_STATEMENT__ITEM = ITERATION_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_IN_STATEMENT__COLLECTION = ITERATION_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>For In Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_IN_STATEMENT_FEATURE_COUNT = ITERATION_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.ISelector <em>ISelector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.ISelector
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getISelector()
	 * @generated
	 */
	int ISELECTOR = 64;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ContinueStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getContinueStatement()
	 * @generated
	 */
	int CONTINUE_STATEMENT = 43;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__LABEL = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Continue Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.BreakStatementImpl <em>Break Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.BreakStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBreakStatement()
	 * @generated
	 */
	int BREAK_STATEMENT = 44;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__LABEL = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Break Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ReturnStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getReturnStatement()
	 * @generated
	 */
	int RETURN_STATEMENT = 45;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.WithStatementImpl <em>With Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.WithStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getWithStatement()
	 * @generated
	 */
	int WITH_STATEMENT = 46;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_STATEMENT__STATEMENT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>With Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.SwitchStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSwitchStatement()
	 * @generated
	 */
	int SWITCH_STATEMENT = 47;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__SELECTOR = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__ELEMENTS = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Switch Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SwitchElementImpl <em>Switch Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.SwitchElementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSwitchElement()
	 * @generated
	 */
	int SWITCH_ELEMENT = 48;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ELEMENT__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ELEMENT__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ELEMENT__STATEMENTS = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Switch Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_ELEMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.CaseClauseImpl <em>Case Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.CaseClauseImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getCaseClause()
	 * @generated
	 */
	int CASE_CLAUSE = 49;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_CLAUSE__BEGIN = SWITCH_ELEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_CLAUSE__END = SWITCH_ELEMENT__END;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_CLAUSE__STATEMENTS = SWITCH_ELEMENT__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_CLAUSE__EXPRESSION = SWITCH_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_CLAUSE_FEATURE_COUNT = SWITCH_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.DefaultClauseImpl <em>Default Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DefaultClauseImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getDefaultClause()
	 * @generated
	 */
	int DEFAULT_CLAUSE = 50;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CLAUSE__BEGIN = SWITCH_ELEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CLAUSE__END = SWITCH_ELEMENT__END;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CLAUSE__STATEMENTS = SWITCH_ELEMENT__STATEMENTS;

	/**
	 * The number of structural features of the '<em>Default Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CLAUSE_FEATURE_COUNT = SWITCH_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.LabeledStatementImpl <em>Labeled Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.LabeledStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getLabeledStatement()
	 * @generated
	 */
	int LABELED_STATEMENT = 51;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_STATEMENT__LABEL = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_STATEMENT__STATEMENT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Labeled Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ThrowStatementImpl <em>Throw Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ThrowStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getThrowStatement()
	 * @generated
	 */
	int THROW_STATEMENT = 52;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT__EXCEPTION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Throw Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.TryStatementImpl <em>Try Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.TryStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getTryStatement()
	 * @generated
	 */
	int TRY_STATEMENT = 53;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Catches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STATEMENT__CATCHES = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Finally Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STATEMENT__FINALLY_CLAUSE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Try Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.CatchClauseImpl <em>Catch Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.CatchClauseImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getCatchClause()
	 * @generated
	 */
	int CATCH_CLAUSE = 54;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_CLAUSE__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_CLAUSE__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_CLAUSE__EXCEPTION = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_CLAUSE__FILTER = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_CLAUSE__BODY = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Catch Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_CLAUSE_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.FinallyClauseImpl <em>Finally Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.FinallyClauseImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getFinallyClause()
	 * @generated
	 */
	int FINALLY_CLAUSE = 55;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY_CLAUSE__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY_CLAUSE__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY_CLAUSE__BODY = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Finally Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINALLY_CLAUSE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.FunctionExpressionImpl <em>Function Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.FunctionExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getFunctionExpression()
	 * @generated
	 */
	int FUNCTION_EXPRESSION = 56;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_EXPRESSION__DOCUMENTATION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_EXPRESSION__IDENTIFIER = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_EXPRESSION__PARAMETERS = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_EXPRESSION__BODY = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameters Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_EXPRESSION__PARAMETERS_POSITION = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Function Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ParameterImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 57;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SourceImpl <em>Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.SourceImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSource()
	 * @generated
	 */
	int SOURCE = 58;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE__END = NODE__END;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE__STATEMENTS = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ConstStatementImpl <em>Const Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ConstStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getConstStatement()
	 * @generated
	 */
	int CONST_STATEMENT = 59;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_STATEMENT__DECLARATIONS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Const Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.PropertyIdentifierImpl <em>Property Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.PropertyIdentifierImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getPropertyIdentifier()
	 * @generated
	 */
	int PROPERTY_IDENTIFIER = 60;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_IDENTIFIER__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_IDENTIFIER__END = EXPRESSION__END;

	/**
	 * The number of structural features of the '<em>Property Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_IDENTIFIER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.IProperty <em>IProperty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.IProperty
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIProperty()
	 * @generated
	 */
	int IPROPERTY = 61;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROPERTY__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROPERTY__END = NODE__END;

	/**
	 * The number of structural features of the '<em>IProperty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROPERTY_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.XmlInitializerImpl <em>Xml Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.XmlInitializerImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getXmlInitializer()
	 * @generated
	 */
	int XML_INITIALIZER = 62;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_INITIALIZER__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_INITIALIZER__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_INITIALIZER__FRAGMENTS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xml Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_INITIALIZER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.AttributeIdentifierImpl <em>Attribute Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.AttributeIdentifierImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getAttributeIdentifier()
	 * @generated
	 */
	int ATTRIBUTE_IDENTIFIER = 63;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_IDENTIFIER__BEGIN = PROPERTY_IDENTIFIER__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_IDENTIFIER__END = PROPERTY_IDENTIFIER__END;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_IDENTIFIER__SELECTOR = PROPERTY_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_IDENTIFIER_FEATURE_COUNT = PROPERTY_IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISELECTOR__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISELECTOR__END = NODE__END;

	/**
	 * The number of structural features of the '<em>ISelector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISELECTOR_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.QualifiedIdentifierImpl <em>Qualified Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.QualifiedIdentifierImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getQualifiedIdentifier()
	 * @generated
	 */
	int QUALIFIED_IDENTIFIER = 65;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_IDENTIFIER__BEGIN = PROPERTY_IDENTIFIER__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_IDENTIFIER__END = PROPERTY_IDENTIFIER__END;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_IDENTIFIER__NAMESPACE = PROPERTY_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_IDENTIFIER__MEMBER = PROPERTY_IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Qualified Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_IDENTIFIER_FEATURE_COUNT = PROPERTY_IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector <em>IUnqualified Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIUnqualifiedSelector()
	 * @generated
	 */
	int IUNQUALIFIED_SELECTOR = 66;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUNQUALIFIED_SELECTOR__BEGIN = ISELECTOR__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUNQUALIFIED_SELECTOR__END = ISELECTOR__END;

	/**
	 * The number of structural features of the '<em>IUnqualified Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUNQUALIFIED_SELECTOR_FEATURE_COUNT = ISELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.WildcardIdentifierImpl <em>Wildcard Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.WildcardIdentifierImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getWildcardIdentifier()
	 * @generated
	 */
	int WILDCARD_IDENTIFIER = 67;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_IDENTIFIER__BEGIN = PROPERTY_IDENTIFIER__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_IDENTIFIER__END = PROPERTY_IDENTIFIER__END;

	/**
	 * The number of structural features of the '<em>Wildcard Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_IDENTIFIER_FEATURE_COUNT = PROPERTY_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.IPropertySelector <em>IProperty Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.IPropertySelector
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIPropertySelector()
	 * @generated
	 */
	int IPROPERTY_SELECTOR = 68;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROPERTY_SELECTOR__BEGIN = IUNQUALIFIED_SELECTOR__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROPERTY_SELECTOR__END = IUNQUALIFIED_SELECTOR__END;

	/**
	 * The number of structural features of the '<em>IProperty Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROPERTY_SELECTOR_FEATURE_COUNT = IUNQUALIFIED_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ExpressionSelectorImpl <em>Expression Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ExpressionSelectorImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getExpressionSelector()
	 * @generated
	 */
	int EXPRESSION_SELECTOR = 69;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SELECTOR__BEGIN = IUNQUALIFIED_SELECTOR__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SELECTOR__END = IUNQUALIFIED_SELECTOR__END;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SELECTOR__INDEX = IUNQUALIFIED_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SELECTOR_FEATURE_COUNT = IUNQUALIFIED_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.XmlFragmentImpl <em>Xml Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.XmlFragmentImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getXmlFragment()
	 * @generated
	 */
	int XML_FRAGMENT = 70;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_FRAGMENT__BEGIN = NODE__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_FRAGMENT__END = NODE__END;

	/**
	 * The number of structural features of the '<em>Xml Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_FRAGMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.XmlTextFragmentImpl <em>Xml Text Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.XmlTextFragmentImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getXmlTextFragment()
	 * @generated
	 */
	int XML_TEXT_FRAGMENT = 71;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_TEXT_FRAGMENT__BEGIN = XML_FRAGMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_TEXT_FRAGMENT__END = XML_FRAGMENT__END;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_TEXT_FRAGMENT__TEXT = XML_FRAGMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xml Text Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_TEXT_FRAGMENT_FEATURE_COUNT = XML_FRAGMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.XmlExpressionFragmentImpl <em>Xml Expression Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.XmlExpressionFragmentImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getXmlExpressionFragment()
	 * @generated
	 */
	int XML_EXPRESSION_FRAGMENT = 72;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_EXPRESSION_FRAGMENT__BEGIN = XML_FRAGMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_EXPRESSION_FRAGMENT__END = XML_FRAGMENT__END;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_EXPRESSION_FRAGMENT__EXPRESSION = XML_FRAGMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xml Expression Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_EXPRESSION_FRAGMENT_FEATURE_COUNT = XML_FRAGMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.DescendantAccessExpressionImpl <em>Descendant Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DescendantAccessExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getDescendantAccessExpression()
	 * @generated
	 */
	int DESCENDANT_ACCESS_EXPRESSION = 73;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCENDANT_ACCESS_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCENDANT_ACCESS_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCENDANT_ACCESS_EXPRESSION__OBJECT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCENDANT_ACCESS_EXPRESSION__PROPERTY = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Descendant Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCENDANT_ACCESS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.FilterExpressionImpl <em>Filter Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.FilterExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getFilterExpression()
	 * @generated
	 */
	int FILTER_EXPRESSION = 74;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_EXPRESSION__OBJECT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_EXPRESSION__FILTER = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Filter Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.DefaultXmlNamespaceStatementImpl <em>Default Xml Namespace Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DefaultXmlNamespaceStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getDefaultXmlNamespaceStatement()
	 * @generated
	 */
	int DEFAULT_XML_NAMESPACE_STATEMENT = 75;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_XML_NAMESPACE_STATEMENT__BEGIN = STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_XML_NAMESPACE_STATEMENT__END = STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_XML_NAMESPACE_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Default Xml Namespace Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_XML_NAMESPACE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ForEachInStatementImpl <em>For Each In Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ForEachInStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getForEachInStatement()
	 * @generated
	 */
	int FOR_EACH_IN_STATEMENT = 76;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_IN_STATEMENT__BEGIN = ITERATION_STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_IN_STATEMENT__END = ITERATION_STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_IN_STATEMENT__BODY = ITERATION_STATEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_IN_STATEMENT__ITEM = ITERATION_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_IN_STATEMENT__COLLECTION = ITERATION_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>For Each In Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_IN_STATEMENT_FEATURE_COUNT = ITERATION_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ArrowFunctionImpl <em>Arrow Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ArrowFunctionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getArrowFunction()
	 * @generated
	 */
	int ARROW_FUNCTION = 77;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_FUNCTION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_FUNCTION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_FUNCTION__DOCUMENTATION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_FUNCTION__PARAMETERS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_FUNCTION__BODY = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameters Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_FUNCTION__PARAMETERS_POSITION = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Arrow Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.TemplateStringLiteralImpl <em>Template String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.TemplateStringLiteralImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getTemplateStringLiteral()
	 * @generated
	 */
	int TEMPLATE_STRING_LITERAL = 78;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_STRING_LITERAL__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_STRING_LITERAL__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_STRING_LITERAL__TEXT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_STRING_LITERAL__TEMPLATE_EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.TemplateStringExpressionImpl <em>Template String Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.TemplateStringExpressionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getTemplateStringExpression()
	 * @generated
	 */
	int TEMPLATE_STRING_EXPRESSION = 79;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_STRING_EXPRESSION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_STRING_EXPRESSION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_STRING_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template String Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_STRING_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.TagFunctionImpl <em>Tag Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.TagFunctionImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getTagFunction()
	 * @generated
	 */
	int TAG_FUNCTION = 80;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FUNCTION__BEGIN = EXPRESSION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FUNCTION__END = EXPRESSION__END;

	/**
	 * The feature id for the '<em><b>Tag Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FUNCTION__TAG_FUNCTION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template String Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FUNCTION__TEMPLATE_STRING_LITERAL = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tag Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ForOfStatementImpl <em>For Of Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.impl.ForOfStatementImpl
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getForOfStatement()
	 * @generated
	 */
	int FOR_OF_STATEMENT = 81;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OF_STATEMENT__BEGIN = ITERATION_STATEMENT__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OF_STATEMENT__END = ITERATION_STATEMENT__END;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OF_STATEMENT__BODY = ITERATION_STATEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OF_STATEMENT__ITEM = ITERATION_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OF_STATEMENT__COLLECTION = ITERATION_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>For Of Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_OF_STATEMENT_FEATURE_COUNT = ITERATION_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.UnaryOperator <em>Unary Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.UnaryOperator
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getUnaryOperator()
	 * @generated
	 */
	int UNARY_OPERATOR = 82;

	/**
	 * The meta object id for the '{@link org.eclipse.dltk.javascript.core.dom.BinaryOperator <em>Binary Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryOperator
	 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBinaryOperator()
	 * @generated
	 */
	int BINARY_OPERATOR = 83;


	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.Node#getBegin <em>Begin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Begin</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Node#getBegin()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Begin();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.Node#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Node#getEnd()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_End();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.Comment#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Comment#getText()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Identifier
	 * @generated
	 */
	EClass getIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.Identifier#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Identifier#getName()
	 * @see #getIdentifier()
	 * @generated
	 */
	EAttribute getIdentifier_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.VariableReference#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableReference#getVariable()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_Variable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.Label#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Label#getName()
	 * @see #getLabel()
	 * @generated
	 */
	EAttribute getLabel_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.NullLiteral <em>Null Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.NullLiteral
	 * @generated
	 */
	EClass getNullLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.BooleanLiteral#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BooleanLiteral#getText()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.NumericLiteral <em>Numeric Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.NumericLiteral
	 * @generated
	 */
	EClass getNumericLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.NumericLiteral#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.NumericLiteral#getText()
	 * @see #getNumericLiteral()
	 * @generated
	 */
	EAttribute getNumericLiteral_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.StringLiteral#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.StringLiteral#getText()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.RegularExpressionLiteral <em>Regular Expression Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regular Expression Literal</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.RegularExpressionLiteral
	 * @generated
	 */
	EClass getRegularExpressionLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.RegularExpressionLiteral#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.RegularExpressionLiteral#getText()
	 * @see #getRegularExpressionLiteral()
	 * @generated
	 */
	EAttribute getRegularExpressionLiteral_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ThisExpression <em>This Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ThisExpression
	 * @generated
	 */
	EClass getThisExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ArrayLiteral <em>Array Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Literal</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrayLiteral
	 * @generated
	 */
	EClass getArrayLiteral();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.ArrayLiteral#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrayLiteral#getElements()
	 * @see #getArrayLiteral()
	 * @generated
	 */
	EReference getArrayLiteral_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.IArrayElement <em>IArray Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IArray Element</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IArrayElement
	 * @generated
	 */
	EClass getIArrayElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.Elision <em>Elision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Elision</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Elision
	 * @generated
	 */
	EClass getElision();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ObjectLiteral <em>Object Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Literal</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ObjectLiteral
	 * @generated
	 */
	EClass getObjectLiteral();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.ObjectLiteral#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ObjectLiteral#getProperties()
	 * @see #getObjectLiteral()
	 * @generated
	 */
	EReference getObjectLiteral_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.PropertyAssignment <em>Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Assignment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.PropertyAssignment
	 * @generated
	 */
	EClass getPropertyAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.PropertyAssignment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.PropertyAssignment#getName()
	 * @see #getPropertyAssignment()
	 * @generated
	 */
	EReference getPropertyAssignment_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.IPropertyName <em>IProperty Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProperty Name</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IPropertyName
	 * @generated
	 */
	EClass getIPropertyName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.SimplePropertyAssignment <em>Simple Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Property Assignment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.SimplePropertyAssignment
	 * @generated
	 */
	EClass getSimplePropertyAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.SimplePropertyAssignment#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.SimplePropertyAssignment#getInitializer()
	 * @see #getSimplePropertyAssignment()
	 * @generated
	 */
	EReference getSimplePropertyAssignment_Initializer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.AccessorAssignment <em>Accessor Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Accessor Assignment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.AccessorAssignment
	 * @generated
	 */
	EClass getAccessorAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.AccessorAssignment#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.AccessorAssignment#getBody()
	 * @see #getAccessorAssignment()
	 * @generated
	 */
	EReference getAccessorAssignment_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.GetterAssignment <em>Getter Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Getter Assignment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.GetterAssignment
	 * @generated
	 */
	EClass getGetterAssignment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.SetterAssignment <em>Setter Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Setter Assignment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.SetterAssignment
	 * @generated
	 */
	EClass getSetterAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.SetterAssignment#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.SetterAssignment#getParameter()
	 * @see #getSetterAssignment()
	 * @generated
	 */
	EReference getSetterAssignment_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parenthesized Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ParenthesizedExpression
	 * @generated
	 */
	EClass getParenthesizedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ParenthesizedExpression#getEnclosed <em>Enclosed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enclosed</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ParenthesizedExpression#getEnclosed()
	 * @see #getParenthesizedExpression()
	 * @generated
	 */
	EReference getParenthesizedExpression_Enclosed();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression <em>Array Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Access Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression
	 * @generated
	 */
	EClass getArrayAccessExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression#getArray <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Array</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression#getArray()
	 * @see #getArrayAccessExpression()
	 * @generated
	 */
	EReference getArrayAccessExpression_Array();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression#getIndex()
	 * @see #getArrayAccessExpression()
	 * @generated
	 */
	EReference getArrayAccessExpression_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.PropertyAccessExpression <em>Property Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Access Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.PropertyAccessExpression
	 * @generated
	 */
	EClass getPropertyAccessExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.PropertyAccessExpression#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.PropertyAccessExpression#getObject()
	 * @see #getPropertyAccessExpression()
	 * @generated
	 */
	EReference getPropertyAccessExpression_Object();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.PropertyAccessExpression#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.PropertyAccessExpression#getProperty()
	 * @see #getPropertyAccessExpression()
	 * @generated
	 */
	EReference getPropertyAccessExpression_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.NewExpression <em>New Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.NewExpression
	 * @generated
	 */
	EClass getNewExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.NewExpression#getConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constructor</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.NewExpression#getConstructor()
	 * @see #getNewExpression()
	 * @generated
	 */
	EReference getNewExpression_Constructor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.NewExpression#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.NewExpression#getArguments()
	 * @see #getNewExpression()
	 * @generated
	 */
	EReference getNewExpression_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.CallExpression <em>Call Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.CallExpression
	 * @generated
	 */
	EClass getCallExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.CallExpression#getApplicant <em>Applicant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Applicant</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.CallExpression#getApplicant()
	 * @see #getCallExpression()
	 * @generated
	 */
	EReference getCallExpression_Applicant();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.CallExpression#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.CallExpression#getArguments()
	 * @see #getCallExpression()
	 * @generated
	 */
	EReference getCallExpression_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.UnaryExpression
	 * @generated
	 */
	EClass getUnaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.UnaryExpression#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Argument</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.UnaryExpression#getArgument()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EReference getUnaryExpression_Argument();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.UnaryExpression#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.UnaryExpression#getOperation()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EAttribute getUnaryExpression_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryExpression
	 * @generated
	 */
	EClass getBinaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryExpression#getLeft()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryExpression#getRight()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Right();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryExpression#getOperation()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EAttribute getBinaryExpression_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.BinaryExpression#getOperatorPosition <em>Operator Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Position</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryExpression#getOperatorPosition()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EAttribute getBinaryExpression_OperatorPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression <em>Conditional Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ConditionalExpression
	 * @generated
	 */
	EClass getConditionalExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getPredicate()
	 * @see #getConditionalExpression()
	 * @generated
	 */
	EReference getConditionalExpression_Predicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getConsequent <em>Consequent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Consequent</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getConsequent()
	 * @see #getConditionalExpression()
	 * @generated
	 */
	EReference getConditionalExpression_Consequent();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getAlternative <em>Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Alternative</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ConditionalExpression#getAlternative()
	 * @see #getConditionalExpression()
	 * @generated
	 */
	EReference getConditionalExpression_Alternative();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.BlockStatement <em>Block Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BlockStatement
	 * @generated
	 */
	EClass getBlockStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.BlockStatement#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BlockStatement#getStatements()
	 * @see #getBlockStatement()
	 * @generated
	 */
	EReference getBlockStatement_Statements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.VariableStatement <em>Variable Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableStatement
	 * @generated
	 */
	EClass getVariableStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.VariableStatement#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableStatement#getDeclarations()
	 * @see #getVariableStatement()
	 * @generated
	 */
	EReference getVariableStatement_Declarations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.VariableDeclaration#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableDeclaration#getIdentifier()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.VariableDeclaration#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.VariableDeclaration#getInitializer()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Initializer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.EmptyStatement <em>Empty Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.EmptyStatement
	 * @generated
	 */
	EClass getEmptyStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ExpressionStatement <em>Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ExpressionStatement
	 * @generated
	 */
	EClass getExpressionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ExpressionStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ExpressionStatement#getExpression()
	 * @see #getExpressionStatement()
	 * @generated
	 */
	EReference getExpressionStatement_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IfStatement
	 * @generated
	 */
	EClass getIfStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.IfStatement#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IfStatement#getPredicate()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_Predicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.IfStatement#getConsequent <em>Consequent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Consequent</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IfStatement#getConsequent()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_Consequent();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.IfStatement#getAlternative <em>Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Alternative</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IfStatement#getAlternative()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_Alternative();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.IterationStatement <em>Iteration Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IterationStatement
	 * @generated
	 */
	EClass getIterationStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.IterationStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IterationStatement#getBody()
	 * @see #getIterationStatement()
	 * @generated
	 */
	EReference getIterationStatement_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.DoStatement <em>Do Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Do Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.DoStatement
	 * @generated
	 */
	EClass getDoStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.DoStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.DoStatement#getCondition()
	 * @see #getDoStatement()
	 * @generated
	 */
	EReference getDoStatement_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.WhileStatement
	 * @generated
	 */
	EClass getWhileStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.WhileStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.WhileStatement#getCondition()
	 * @see #getWhileStatement()
	 * @generated
	 */
	EReference getWhileStatement_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForStatement
	 * @generated
	 */
	EClass getForStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ForStatement#getInitialization <em>Initialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialization</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForStatement#getInitialization()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Initialization();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ForStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForStatement#getCondition()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ForStatement#getIncrement <em>Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Increment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForStatement#getIncrement()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Increment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.IForInitializer <em>IFor Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IFor Initializer</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IForInitializer
	 * @generated
	 */
	EClass getIForInitializer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ForInStatement <em>For In Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For In Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForInStatement
	 * @generated
	 */
	EClass getForInStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ForInStatement#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForInStatement#getItem()
	 * @see #getForInStatement()
	 * @generated
	 */
	EReference getForInStatement_Item();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ForInStatement#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForInStatement#getCollection()
	 * @see #getForInStatement()
	 * @generated
	 */
	EReference getForInStatement_Collection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ContinueStatement <em>Continue Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continue Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ContinueStatement
	 * @generated
	 */
	EClass getContinueStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ContinueStatement#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Label</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ContinueStatement#getLabel()
	 * @see #getContinueStatement()
	 * @generated
	 */
	EReference getContinueStatement_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.BreakStatement <em>Break Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Break Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BreakStatement
	 * @generated
	 */
	EClass getBreakStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.BreakStatement#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Label</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BreakStatement#getLabel()
	 * @see #getBreakStatement()
	 * @generated
	 */
	EReference getBreakStatement_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ReturnStatement <em>Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ReturnStatement
	 * @generated
	 */
	EClass getReturnStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ReturnStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ReturnStatement#getExpression()
	 * @see #getReturnStatement()
	 * @generated
	 */
	EReference getReturnStatement_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.WithStatement <em>With Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.WithStatement
	 * @generated
	 */
	EClass getWithStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.WithStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.WithStatement#getExpression()
	 * @see #getWithStatement()
	 * @generated
	 */
	EReference getWithStatement_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.WithStatement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.WithStatement#getStatement()
	 * @see #getWithStatement()
	 * @generated
	 */
	EReference getWithStatement_Statement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.SwitchStatement
	 * @generated
	 */
	EClass getSwitchStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.SwitchStatement#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Selector</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.SwitchStatement#getSelector()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Selector();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.SwitchStatement#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.SwitchStatement#getElements()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.SwitchElement <em>Switch Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Element</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.SwitchElement
	 * @generated
	 */
	EClass getSwitchElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.SwitchElement#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.SwitchElement#getStatements()
	 * @see #getSwitchElement()
	 * @generated
	 */
	EReference getSwitchElement_Statements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.CaseClause <em>Case Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Clause</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.CaseClause
	 * @generated
	 */
	EClass getCaseClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.CaseClause#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.CaseClause#getExpression()
	 * @see #getCaseClause()
	 * @generated
	 */
	EReference getCaseClause_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.DefaultClause <em>Default Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Clause</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.DefaultClause
	 * @generated
	 */
	EClass getDefaultClause();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.LabeledStatement <em>Labeled Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labeled Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.LabeledStatement
	 * @generated
	 */
	EClass getLabeledStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.LabeledStatement#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Label</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.LabeledStatement#getLabel()
	 * @see #getLabeledStatement()
	 * @generated
	 */
	EReference getLabeledStatement_Label();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.LabeledStatement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.LabeledStatement#getStatement()
	 * @see #getLabeledStatement()
	 * @generated
	 */
	EReference getLabeledStatement_Statement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ThrowStatement <em>Throw Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throw Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ThrowStatement
	 * @generated
	 */
	EClass getThrowStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ThrowStatement#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exception</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ThrowStatement#getException()
	 * @see #getThrowStatement()
	 * @generated
	 */
	EReference getThrowStatement_Exception();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.TryStatement <em>Try Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Try Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TryStatement
	 * @generated
	 */
	EClass getTryStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.TryStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TryStatement#getBody()
	 * @see #getTryStatement()
	 * @generated
	 */
	EReference getTryStatement_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.TryStatement#getCatches <em>Catches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Catches</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TryStatement#getCatches()
	 * @see #getTryStatement()
	 * @generated
	 */
	EReference getTryStatement_Catches();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.TryStatement#getFinallyClause <em>Finally Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Finally Clause</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TryStatement#getFinallyClause()
	 * @see #getTryStatement()
	 * @generated
	 */
	EReference getTryStatement_FinallyClause();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.CatchClause <em>Catch Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catch Clause</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.CatchClause
	 * @generated
	 */
	EClass getCatchClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.CatchClause#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exception</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.CatchClause#getException()
	 * @see #getCatchClause()
	 * @generated
	 */
	EReference getCatchClause_Exception();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.CatchClause#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.CatchClause#getFilter()
	 * @see #getCatchClause()
	 * @generated
	 */
	EReference getCatchClause_Filter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.CatchClause#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.CatchClause#getBody()
	 * @see #getCatchClause()
	 * @generated
	 */
	EReference getCatchClause_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.FinallyClause <em>Finally Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finally Clause</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FinallyClause
	 * @generated
	 */
	EClass getFinallyClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.FinallyClause#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FinallyClause#getBody()
	 * @see #getFinallyClause()
	 * @generated
	 */
	EReference getFinallyClause_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression <em>Function Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FunctionExpression
	 * @generated
	 */
	EClass getFunctionExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Documentation</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FunctionExpression#getDocumentation()
	 * @see #getFunctionExpression()
	 * @generated
	 */
	EReference getFunctionExpression_Documentation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FunctionExpression#getIdentifier()
	 * @see #getFunctionExpression()
	 * @generated
	 */
	EReference getFunctionExpression_Identifier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FunctionExpression#getParameters()
	 * @see #getFunctionExpression()
	 * @generated
	 */
	EReference getFunctionExpression_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FunctionExpression#getBody()
	 * @see #getFunctionExpression()
	 * @generated
	 */
	EReference getFunctionExpression_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.FunctionExpression#getParametersPosition <em>Parameters Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameters Position</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FunctionExpression#getParametersPosition()
	 * @see #getFunctionExpression()
	 * @generated
	 */
	EAttribute getFunctionExpression_ParametersPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.Source <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Source
	 * @generated
	 */
	EClass getSource();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.Source#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.Source#getStatements()
	 * @see #getSource()
	 * @generated
	 */
	EReference getSource_Statements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ConstStatement <em>Const Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ConstStatement
	 * @generated
	 */
	EClass getConstStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.ConstStatement#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ConstStatement#getDeclarations()
	 * @see #getConstStatement()
	 * @generated
	 */
	EReference getConstStatement_Declarations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.PropertyIdentifier <em>Property Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Identifier</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.PropertyIdentifier
	 * @generated
	 */
	EClass getPropertyIdentifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.IProperty <em>IProperty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProperty</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IProperty
	 * @generated
	 */
	EClass getIProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.XmlInitializer <em>Xml Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Initializer</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlInitializer
	 * @generated
	 */
	EClass getXmlInitializer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.XmlInitializer#getFragments <em>Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragments</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlInitializer#getFragments()
	 * @see #getXmlInitializer()
	 * @generated
	 */
	EReference getXmlInitializer_Fragments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.AttributeIdentifier <em>Attribute Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Identifier</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.AttributeIdentifier
	 * @generated
	 */
	EClass getAttributeIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.AttributeIdentifier#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Selector</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.AttributeIdentifier#getSelector()
	 * @see #getAttributeIdentifier()
	 * @generated
	 */
	EReference getAttributeIdentifier_Selector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ISelector <em>ISelector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISelector</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ISelector
	 * @generated
	 */
	EClass getISelector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier <em>Qualified Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Identifier</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier
	 * @generated
	 */
	EClass getQualifiedIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Namespace</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier#getNamespace()
	 * @see #getQualifiedIdentifier()
	 * @generated
	 */
	EReference getQualifiedIdentifier_Namespace();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Member</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier#getMember()
	 * @see #getQualifiedIdentifier()
	 * @generated
	 */
	EReference getQualifiedIdentifier_Member();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector <em>IUnqualified Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IUnqualified Selector</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector
	 * @generated
	 */
	EClass getIUnqualifiedSelector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.WildcardIdentifier <em>Wildcard Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Identifier</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.WildcardIdentifier
	 * @generated
	 */
	EClass getWildcardIdentifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.IPropertySelector <em>IProperty Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProperty Selector</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.IPropertySelector
	 * @generated
	 */
	EClass getIPropertySelector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ExpressionSelector <em>Expression Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Selector</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ExpressionSelector
	 * @generated
	 */
	EClass getExpressionSelector();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ExpressionSelector#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ExpressionSelector#getIndex()
	 * @see #getExpressionSelector()
	 * @generated
	 */
	EReference getExpressionSelector_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.XmlFragment <em>Xml Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Fragment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlFragment
	 * @generated
	 */
	EClass getXmlFragment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.XmlTextFragment <em>Xml Text Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Text Fragment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlTextFragment
	 * @generated
	 */
	EClass getXmlTextFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.XmlTextFragment#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlTextFragment#getText()
	 * @see #getXmlTextFragment()
	 * @generated
	 */
	EAttribute getXmlTextFragment_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.XmlExpressionFragment <em>Xml Expression Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Expression Fragment</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlExpressionFragment
	 * @generated
	 */
	EClass getXmlExpressionFragment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.XmlExpressionFragment#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.XmlExpressionFragment#getExpression()
	 * @see #getXmlExpressionFragment()
	 * @generated
	 */
	EReference getXmlExpressionFragment_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.DescendantAccessExpression <em>Descendant Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descendant Access Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.DescendantAccessExpression
	 * @generated
	 */
	EClass getDescendantAccessExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.DescendantAccessExpression#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.DescendantAccessExpression#getObject()
	 * @see #getDescendantAccessExpression()
	 * @generated
	 */
	EReference getDescendantAccessExpression_Object();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.DescendantAccessExpression#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.DescendantAccessExpression#getProperty()
	 * @see #getDescendantAccessExpression()
	 * @generated
	 */
	EReference getDescendantAccessExpression_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.FilterExpression <em>Filter Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FilterExpression
	 * @generated
	 */
	EClass getFilterExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.FilterExpression#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FilterExpression#getObject()
	 * @see #getFilterExpression()
	 * @generated
	 */
	EReference getFilterExpression_Object();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.FilterExpression#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.FilterExpression#getFilter()
	 * @see #getFilterExpression()
	 * @generated
	 */
	EReference getFilterExpression_Filter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.DefaultXmlNamespaceStatement <em>Default Xml Namespace Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Xml Namespace Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.DefaultXmlNamespaceStatement
	 * @generated
	 */
	EClass getDefaultXmlNamespaceStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.DefaultXmlNamespaceStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.DefaultXmlNamespaceStatement#getExpression()
	 * @see #getDefaultXmlNamespaceStatement()
	 * @generated
	 */
	EReference getDefaultXmlNamespaceStatement_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ForEachInStatement <em>For Each In Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Each In Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForEachInStatement
	 * @generated
	 */
	EClass getForEachInStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ForEachInStatement#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForEachInStatement#getItem()
	 * @see #getForEachInStatement()
	 * @generated
	 */
	EReference getForEachInStatement_Item();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ForEachInStatement#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForEachInStatement#getCollection()
	 * @see #getForEachInStatement()
	 * @generated
	 */
	EReference getForEachInStatement_Collection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction <em>Arrow Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arrow Function</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrowFunction
	 * @generated
	 */
	EClass getArrowFunction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Documentation</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrowFunction#getDocumentation()
	 * @see #getArrowFunction()
	 * @generated
	 */
	EReference getArrowFunction_Documentation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrowFunction#getParameters()
	 * @see #getArrowFunction()
	 * @generated
	 */
	EReference getArrowFunction_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrowFunction#getBody()
	 * @see #getArrowFunction()
	 * @generated
	 */
	EReference getArrowFunction_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.ArrowFunction#getParametersPosition <em>Parameters Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameters Position</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ArrowFunction#getParametersPosition()
	 * @see #getArrowFunction()
	 * @generated
	 */
	EAttribute getArrowFunction_ParametersPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral <em>Template String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template String Literal</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral
	 * @generated
	 */
	EClass getTemplateStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral#getText()
	 * @see #getTemplateStringLiteral()
	 * @generated
	 */
	EAttribute getTemplateStringLiteral_Text();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral#getTemplateExpressions <em>Template Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Expressions</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral#getTemplateExpressions()
	 * @see #getTemplateStringLiteral()
	 * @generated
	 */
	EReference getTemplateStringLiteral_TemplateExpressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.TemplateStringExpression <em>Template String Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template String Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TemplateStringExpression
	 * @generated
	 */
	EClass getTemplateStringExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.TemplateStringExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TemplateStringExpression#getExpression()
	 * @see #getTemplateStringExpression()
	 * @generated
	 */
	EReference getTemplateStringExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.TagFunction <em>Tag Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Function</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TagFunction
	 * @generated
	 */
	EClass getTagFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.TagFunction#getTagFunction <em>Tag Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tag Function</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TagFunction#getTagFunction()
	 * @see #getTagFunction()
	 * @generated
	 */
	EReference getTagFunction_TagFunction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.dltk.javascript.core.dom.TagFunction#getTemplateStringLiteral <em>Template String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Template String Literal</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.TagFunction#getTemplateStringLiteral()
	 * @see #getTagFunction()
	 * @generated
	 */
	EReference getTagFunction_TemplateStringLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.dltk.javascript.core.dom.ForOfStatement <em>For Of Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Of Statement</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForOfStatement
	 * @generated
	 */
	EClass getForOfStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ForOfStatement#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForOfStatement#getItem()
	 * @see #getForOfStatement()
	 * @generated
	 */
	EReference getForOfStatement_Item();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.dltk.javascript.core.dom.ForOfStatement#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.ForOfStatement#getCollection()
	 * @see #getForOfStatement()
	 * @generated
	 */
	EReference getForOfStatement_Collection();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.dltk.javascript.core.dom.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Operator</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.UnaryOperator
	 * @generated
	 */
	EEnum getUnaryOperator();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.dltk.javascript.core.dom.BinaryOperator <em>Binary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Operator</em>'.
	 * @see org.eclipse.dltk.javascript.core.dom.BinaryOperator
	 * @generated
	 */
	EEnum getBinaryOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DomFactory getDomFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.NodeImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Begin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__BEGIN = eINSTANCE.getNode_Begin();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__END = eINSTANCE.getNode_End();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.CommentImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__TEXT = eINSTANCE.getComment_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.IdentifierImpl <em>Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.IdentifierImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIdentifier()
		 * @generated
		 */
		EClass IDENTIFIER = eINSTANCE.getIdentifier();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER__NAME = eINSTANCE.getIdentifier_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.VariableReferenceImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__VARIABLE = eINSTANCE.getVariableReference_Variable();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.LabelImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL__NAME = eINSTANCE.getLabel_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.NullLiteralImpl <em>Null Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.NullLiteralImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getNullLiteral()
		 * @generated
		 */
		EClass NULL_LITERAL = eINSTANCE.getNullLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.BooleanLiteralImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBooleanLiteral()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL__TEXT = eINSTANCE.getBooleanLiteral_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.NumericLiteralImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getNumericLiteral()
		 * @generated
		 */
		EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_LITERAL__TEXT = eINSTANCE.getNumericLiteral_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.StringLiteralImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__TEXT = eINSTANCE.getStringLiteral_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.RegularExpressionLiteralImpl <em>Regular Expression Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.RegularExpressionLiteralImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getRegularExpressionLiteral()
		 * @generated
		 */
		EClass REGULAR_EXPRESSION_LITERAL = eINSTANCE.getRegularExpressionLiteral();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGULAR_EXPRESSION_LITERAL__TEXT = eINSTANCE.getRegularExpressionLiteral_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ThisExpressionImpl <em>This Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ThisExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getThisExpression()
		 * @generated
		 */
		EClass THIS_EXPRESSION = eINSTANCE.getThisExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ArrayLiteralImpl <em>Array Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ArrayLiteralImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getArrayLiteral()
		 * @generated
		 */
		EClass ARRAY_LITERAL = eINSTANCE.getArrayLiteral();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_LITERAL__ELEMENTS = eINSTANCE.getArrayLiteral_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.IArrayElement <em>IArray Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.IArrayElement
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIArrayElement()
		 * @generated
		 */
		EClass IARRAY_ELEMENT = eINSTANCE.getIArrayElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ElisionImpl <em>Elision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ElisionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getElision()
		 * @generated
		 */
		EClass ELISION = eINSTANCE.getElision();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ObjectLiteralImpl <em>Object Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ObjectLiteralImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getObjectLiteral()
		 * @generated
		 */
		EClass OBJECT_LITERAL = eINSTANCE.getObjectLiteral();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_LITERAL__PROPERTIES = eINSTANCE.getObjectLiteral_Properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.PropertyAssignmentImpl <em>Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.PropertyAssignmentImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getPropertyAssignment()
		 * @generated
		 */
		EClass PROPERTY_ASSIGNMENT = eINSTANCE.getPropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ASSIGNMENT__NAME = eINSTANCE.getPropertyAssignment_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.IPropertyName <em>IProperty Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.IPropertyName
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIPropertyName()
		 * @generated
		 */
		EClass IPROPERTY_NAME = eINSTANCE.getIPropertyName();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SimplePropertyAssignmentImpl <em>Simple Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.SimplePropertyAssignmentImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSimplePropertyAssignment()
		 * @generated
		 */
		EClass SIMPLE_PROPERTY_ASSIGNMENT = eINSTANCE.getSimplePropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PROPERTY_ASSIGNMENT__INITIALIZER = eINSTANCE.getSimplePropertyAssignment_Initializer();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.AccessorAssignmentImpl <em>Accessor Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.AccessorAssignmentImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getAccessorAssignment()
		 * @generated
		 */
		EClass ACCESSOR_ASSIGNMENT = eINSTANCE.getAccessorAssignment();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESSOR_ASSIGNMENT__BODY = eINSTANCE.getAccessorAssignment_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.GetterAssignmentImpl <em>Getter Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.GetterAssignmentImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getGetterAssignment()
		 * @generated
		 */
		EClass GETTER_ASSIGNMENT = eINSTANCE.getGetterAssignment();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SetterAssignmentImpl <em>Setter Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.SetterAssignmentImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSetterAssignment()
		 * @generated
		 */
		EClass SETTER_ASSIGNMENT = eINSTANCE.getSetterAssignment();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTER_ASSIGNMENT__PARAMETER = eINSTANCE.getSetterAssignment_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ParenthesizedExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getParenthesizedExpression()
		 * @generated
		 */
		EClass PARENTHESIZED_EXPRESSION = eINSTANCE.getParenthesizedExpression();

		/**
		 * The meta object literal for the '<em><b>Enclosed</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENTHESIZED_EXPRESSION__ENCLOSED = eINSTANCE.getParenthesizedExpression_Enclosed();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ArrayAccessExpressionImpl <em>Array Access Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ArrayAccessExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getArrayAccessExpression()
		 * @generated
		 */
		EClass ARRAY_ACCESS_EXPRESSION = eINSTANCE.getArrayAccessExpression();

		/**
		 * The meta object literal for the '<em><b>Array</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_ACCESS_EXPRESSION__ARRAY = eINSTANCE.getArrayAccessExpression_Array();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_ACCESS_EXPRESSION__INDEX = eINSTANCE.getArrayAccessExpression_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.PropertyAccessExpressionImpl <em>Property Access Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.PropertyAccessExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getPropertyAccessExpression()
		 * @generated
		 */
		EClass PROPERTY_ACCESS_EXPRESSION = eINSTANCE.getPropertyAccessExpression();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ACCESS_EXPRESSION__OBJECT = eINSTANCE.getPropertyAccessExpression_Object();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ACCESS_EXPRESSION__PROPERTY = eINSTANCE.getPropertyAccessExpression_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.NewExpressionImpl <em>New Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.NewExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getNewExpression()
		 * @generated
		 */
		EClass NEW_EXPRESSION = eINSTANCE.getNewExpression();

		/**
		 * The meta object literal for the '<em><b>Constructor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_EXPRESSION__CONSTRUCTOR = eINSTANCE.getNewExpression_Constructor();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_EXPRESSION__ARGUMENTS = eINSTANCE.getNewExpression_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.CallExpressionImpl <em>Call Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.CallExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getCallExpression()
		 * @generated
		 */
		EClass CALL_EXPRESSION = eINSTANCE.getCallExpression();

		/**
		 * The meta object literal for the '<em><b>Applicant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXPRESSION__APPLICANT = eINSTANCE.getCallExpression_Applicant();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXPRESSION__ARGUMENTS = eINSTANCE.getCallExpression_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.UnaryExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getUnaryExpression()
		 * @generated
		 */
		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION__ARGUMENT = eINSTANCE.getUnaryExpression_Argument();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_EXPRESSION__OPERATION = eINSTANCE.getUnaryExpression_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.BinaryExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBinaryExpression()
		 * @generated
		 */
		EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__LEFT = eINSTANCE.getBinaryExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__RIGHT = eINSTANCE.getBinaryExpression_Right();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_EXPRESSION__OPERATION = eINSTANCE.getBinaryExpression_Operation();

		/**
		 * The meta object literal for the '<em><b>Operator Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_EXPRESSION__OPERATOR_POSITION = eINSTANCE.getBinaryExpression_OperatorPosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ConditionalExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getConditionalExpression()
		 * @generated
		 */
		EClass CONDITIONAL_EXPRESSION = eINSTANCE.getConditionalExpression();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_EXPRESSION__PREDICATE = eINSTANCE.getConditionalExpression_Predicate();

		/**
		 * The meta object literal for the '<em><b>Consequent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_EXPRESSION__CONSEQUENT = eINSTANCE.getConditionalExpression_Consequent();

		/**
		 * The meta object literal for the '<em><b>Alternative</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_EXPRESSION__ALTERNATIVE = eINSTANCE.getConditionalExpression_Alternative();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.StatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.BlockStatementImpl <em>Block Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.BlockStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBlockStatement()
		 * @generated
		 */
		EClass BLOCK_STATEMENT = eINSTANCE.getBlockStatement();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_STATEMENT__STATEMENTS = eINSTANCE.getBlockStatement_Statements();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.VariableStatementImpl <em>Variable Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.VariableStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getVariableStatement()
		 * @generated
		 */
		EClass VARIABLE_STATEMENT = eINSTANCE.getVariableStatement();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_STATEMENT__DECLARATIONS = eINSTANCE.getVariableStatement_Declarations();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.VariableDeclarationImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__IDENTIFIER = eINSTANCE.getVariableDeclaration_Identifier();

		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__INITIALIZER = eINSTANCE.getVariableDeclaration_Initializer();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.EmptyStatementImpl <em>Empty Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.EmptyStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getEmptyStatement()
		 * @generated
		 */
		EClass EMPTY_STATEMENT = eINSTANCE.getEmptyStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ExpressionStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getExpressionStatement()
		 * @generated
		 */
		EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getExpressionStatement_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.IfStatementImpl <em>If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.IfStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIfStatement()
		 * @generated
		 */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__PREDICATE = eINSTANCE.getIfStatement_Predicate();

		/**
		 * The meta object literal for the '<em><b>Consequent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__CONSEQUENT = eINSTANCE.getIfStatement_Consequent();

		/**
		 * The meta object literal for the '<em><b>Alternative</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__ALTERNATIVE = eINSTANCE.getIfStatement_Alternative();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.IterationStatementImpl <em>Iteration Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.IterationStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIterationStatement()
		 * @generated
		 */
		EClass ITERATION_STATEMENT = eINSTANCE.getIterationStatement();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_STATEMENT__BODY = eINSTANCE.getIterationStatement_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.DoStatementImpl <em>Do Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DoStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getDoStatement()
		 * @generated
		 */
		EClass DO_STATEMENT = eINSTANCE.getDoStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DO_STATEMENT__CONDITION = eINSTANCE.getDoStatement_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.WhileStatementImpl <em>While Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.WhileStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getWhileStatement()
		 * @generated
		 */
		EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ForStatementImpl <em>For Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ForStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getForStatement()
		 * @generated
		 */
		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		/**
		 * The meta object literal for the '<em><b>Initialization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__INITIALIZATION = eINSTANCE.getForStatement_Initialization();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__CONDITION = eINSTANCE.getForStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Increment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__INCREMENT = eINSTANCE.getForStatement_Increment();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.IForInitializer <em>IFor Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.IForInitializer
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIForInitializer()
		 * @generated
		 */
		EClass IFOR_INITIALIZER = eINSTANCE.getIForInitializer();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ForInStatementImpl <em>For In Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ForInStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getForInStatement()
		 * @generated
		 */
		EClass FOR_IN_STATEMENT = eINSTANCE.getForInStatement();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_IN_STATEMENT__ITEM = eINSTANCE.getForInStatement_Item();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_IN_STATEMENT__COLLECTION = eINSTANCE.getForInStatement_Collection();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ContinueStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getContinueStatement()
		 * @generated
		 */
		EClass CONTINUE_STATEMENT = eINSTANCE.getContinueStatement();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTINUE_STATEMENT__LABEL = eINSTANCE.getContinueStatement_Label();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.BreakStatementImpl <em>Break Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.BreakStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBreakStatement()
		 * @generated
		 */
		EClass BREAK_STATEMENT = eINSTANCE.getBreakStatement();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BREAK_STATEMENT__LABEL = eINSTANCE.getBreakStatement_Label();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ReturnStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getReturnStatement()
		 * @generated
		 */
		EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN_STATEMENT__EXPRESSION = eINSTANCE.getReturnStatement_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.WithStatementImpl <em>With Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.WithStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getWithStatement()
		 * @generated
		 */
		EClass WITH_STATEMENT = eINSTANCE.getWithStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH_STATEMENT__EXPRESSION = eINSTANCE.getWithStatement_Expression();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH_STATEMENT__STATEMENT = eINSTANCE.getWithStatement_Statement();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.SwitchStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSwitchStatement()
		 * @generated
		 */
		EClass SWITCH_STATEMENT = eINSTANCE.getSwitchStatement();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__SELECTOR = eINSTANCE.getSwitchStatement_Selector();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__ELEMENTS = eINSTANCE.getSwitchStatement_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SwitchElementImpl <em>Switch Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.SwitchElementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSwitchElement()
		 * @generated
		 */
		EClass SWITCH_ELEMENT = eINSTANCE.getSwitchElement();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_ELEMENT__STATEMENTS = eINSTANCE.getSwitchElement_Statements();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.CaseClauseImpl <em>Case Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.CaseClauseImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getCaseClause()
		 * @generated
		 */
		EClass CASE_CLAUSE = eINSTANCE.getCaseClause();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_CLAUSE__EXPRESSION = eINSTANCE.getCaseClause_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.DefaultClauseImpl <em>Default Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DefaultClauseImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getDefaultClause()
		 * @generated
		 */
		EClass DEFAULT_CLAUSE = eINSTANCE.getDefaultClause();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.LabeledStatementImpl <em>Labeled Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.LabeledStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getLabeledStatement()
		 * @generated
		 */
		EClass LABELED_STATEMENT = eINSTANCE.getLabeledStatement();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABELED_STATEMENT__LABEL = eINSTANCE.getLabeledStatement_Label();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABELED_STATEMENT__STATEMENT = eINSTANCE.getLabeledStatement_Statement();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ThrowStatementImpl <em>Throw Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ThrowStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getThrowStatement()
		 * @generated
		 */
		EClass THROW_STATEMENT = eINSTANCE.getThrowStatement();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROW_STATEMENT__EXCEPTION = eINSTANCE.getThrowStatement_Exception();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.TryStatementImpl <em>Try Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.TryStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getTryStatement()
		 * @generated
		 */
		EClass TRY_STATEMENT = eINSTANCE.getTryStatement();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_STATEMENT__BODY = eINSTANCE.getTryStatement_Body();

		/**
		 * The meta object literal for the '<em><b>Catches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_STATEMENT__CATCHES = eINSTANCE.getTryStatement_Catches();

		/**
		 * The meta object literal for the '<em><b>Finally Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_STATEMENT__FINALLY_CLAUSE = eINSTANCE.getTryStatement_FinallyClause();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.CatchClauseImpl <em>Catch Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.CatchClauseImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getCatchClause()
		 * @generated
		 */
		EClass CATCH_CLAUSE = eINSTANCE.getCatchClause();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_CLAUSE__EXCEPTION = eINSTANCE.getCatchClause_Exception();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_CLAUSE__FILTER = eINSTANCE.getCatchClause_Filter();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_CLAUSE__BODY = eINSTANCE.getCatchClause_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.FinallyClauseImpl <em>Finally Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.FinallyClauseImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getFinallyClause()
		 * @generated
		 */
		EClass FINALLY_CLAUSE = eINSTANCE.getFinallyClause();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINALLY_CLAUSE__BODY = eINSTANCE.getFinallyClause_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.FunctionExpressionImpl <em>Function Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.FunctionExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getFunctionExpression()
		 * @generated
		 */
		EClass FUNCTION_EXPRESSION = eINSTANCE.getFunctionExpression();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_EXPRESSION__DOCUMENTATION = eINSTANCE.getFunctionExpression_Documentation();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_EXPRESSION__IDENTIFIER = eINSTANCE.getFunctionExpression_Identifier();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_EXPRESSION__PARAMETERS = eINSTANCE.getFunctionExpression_Parameters();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_EXPRESSION__BODY = eINSTANCE.getFunctionExpression_Body();

		/**
		 * The meta object literal for the '<em><b>Parameters Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_EXPRESSION__PARAMETERS_POSITION = eINSTANCE.getFunctionExpression_ParametersPosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ParameterImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.SourceImpl <em>Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.SourceImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getSource()
		 * @generated
		 */
		EClass SOURCE = eINSTANCE.getSource();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE__STATEMENTS = eINSTANCE.getSource_Statements();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ConstStatementImpl <em>Const Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ConstStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getConstStatement()
		 * @generated
		 */
		EClass CONST_STATEMENT = eINSTANCE.getConstStatement();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONST_STATEMENT__DECLARATIONS = eINSTANCE.getConstStatement_Declarations();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.PropertyIdentifierImpl <em>Property Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.PropertyIdentifierImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getPropertyIdentifier()
		 * @generated
		 */
		EClass PROPERTY_IDENTIFIER = eINSTANCE.getPropertyIdentifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.IProperty <em>IProperty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.IProperty
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIProperty()
		 * @generated
		 */
		EClass IPROPERTY = eINSTANCE.getIProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.XmlInitializerImpl <em>Xml Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.XmlInitializerImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getXmlInitializer()
		 * @generated
		 */
		EClass XML_INITIALIZER = eINSTANCE.getXmlInitializer();

		/**
		 * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_INITIALIZER__FRAGMENTS = eINSTANCE.getXmlInitializer_Fragments();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.AttributeIdentifierImpl <em>Attribute Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.AttributeIdentifierImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getAttributeIdentifier()
		 * @generated
		 */
		EClass ATTRIBUTE_IDENTIFIER = eINSTANCE.getAttributeIdentifier();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_IDENTIFIER__SELECTOR = eINSTANCE.getAttributeIdentifier_Selector();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.ISelector <em>ISelector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.ISelector
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getISelector()
		 * @generated
		 */
		EClass ISELECTOR = eINSTANCE.getISelector();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.QualifiedIdentifierImpl <em>Qualified Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.QualifiedIdentifierImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getQualifiedIdentifier()
		 * @generated
		 */
		EClass QUALIFIED_IDENTIFIER = eINSTANCE.getQualifiedIdentifier();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALIFIED_IDENTIFIER__NAMESPACE = eINSTANCE.getQualifiedIdentifier_Namespace();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALIFIED_IDENTIFIER__MEMBER = eINSTANCE.getQualifiedIdentifier_Member();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector <em>IUnqualified Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIUnqualifiedSelector()
		 * @generated
		 */
		EClass IUNQUALIFIED_SELECTOR = eINSTANCE.getIUnqualifiedSelector();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.WildcardIdentifierImpl <em>Wildcard Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.WildcardIdentifierImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getWildcardIdentifier()
		 * @generated
		 */
		EClass WILDCARD_IDENTIFIER = eINSTANCE.getWildcardIdentifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.IPropertySelector <em>IProperty Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.IPropertySelector
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getIPropertySelector()
		 * @generated
		 */
		EClass IPROPERTY_SELECTOR = eINSTANCE.getIPropertySelector();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ExpressionSelectorImpl <em>Expression Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ExpressionSelectorImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getExpressionSelector()
		 * @generated
		 */
		EClass EXPRESSION_SELECTOR = eINSTANCE.getExpressionSelector();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_SELECTOR__INDEX = eINSTANCE.getExpressionSelector_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.XmlFragmentImpl <em>Xml Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.XmlFragmentImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getXmlFragment()
		 * @generated
		 */
		EClass XML_FRAGMENT = eINSTANCE.getXmlFragment();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.XmlTextFragmentImpl <em>Xml Text Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.XmlTextFragmentImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getXmlTextFragment()
		 * @generated
		 */
		EClass XML_TEXT_FRAGMENT = eINSTANCE.getXmlTextFragment();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XML_TEXT_FRAGMENT__TEXT = eINSTANCE.getXmlTextFragment_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.XmlExpressionFragmentImpl <em>Xml Expression Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.XmlExpressionFragmentImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getXmlExpressionFragment()
		 * @generated
		 */
		EClass XML_EXPRESSION_FRAGMENT = eINSTANCE.getXmlExpressionFragment();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_EXPRESSION_FRAGMENT__EXPRESSION = eINSTANCE.getXmlExpressionFragment_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.DescendantAccessExpressionImpl <em>Descendant Access Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DescendantAccessExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getDescendantAccessExpression()
		 * @generated
		 */
		EClass DESCENDANT_ACCESS_EXPRESSION = eINSTANCE.getDescendantAccessExpression();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCENDANT_ACCESS_EXPRESSION__OBJECT = eINSTANCE.getDescendantAccessExpression_Object();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCENDANT_ACCESS_EXPRESSION__PROPERTY = eINSTANCE.getDescendantAccessExpression_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.FilterExpressionImpl <em>Filter Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.FilterExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getFilterExpression()
		 * @generated
		 */
		EClass FILTER_EXPRESSION = eINSTANCE.getFilterExpression();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER_EXPRESSION__OBJECT = eINSTANCE.getFilterExpression_Object();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER_EXPRESSION__FILTER = eINSTANCE.getFilterExpression_Filter();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.DefaultXmlNamespaceStatementImpl <em>Default Xml Namespace Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DefaultXmlNamespaceStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getDefaultXmlNamespaceStatement()
		 * @generated
		 */
		EClass DEFAULT_XML_NAMESPACE_STATEMENT = eINSTANCE.getDefaultXmlNamespaceStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_XML_NAMESPACE_STATEMENT__EXPRESSION = eINSTANCE.getDefaultXmlNamespaceStatement_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ForEachInStatementImpl <em>For Each In Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ForEachInStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getForEachInStatement()
		 * @generated
		 */
		EClass FOR_EACH_IN_STATEMENT = eINSTANCE.getForEachInStatement();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH_IN_STATEMENT__ITEM = eINSTANCE.getForEachInStatement_Item();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH_IN_STATEMENT__COLLECTION = eINSTANCE.getForEachInStatement_Collection();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ArrowFunctionImpl <em>Arrow Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ArrowFunctionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getArrowFunction()
		 * @generated
		 */
		EClass ARROW_FUNCTION = eINSTANCE.getArrowFunction();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW_FUNCTION__DOCUMENTATION = eINSTANCE.getArrowFunction_Documentation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW_FUNCTION__PARAMETERS = eINSTANCE.getArrowFunction_Parameters();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW_FUNCTION__BODY = eINSTANCE.getArrowFunction_Body();

		/**
		 * The meta object literal for the '<em><b>Parameters Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARROW_FUNCTION__PARAMETERS_POSITION = eINSTANCE.getArrowFunction_ParametersPosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.TemplateStringLiteralImpl <em>Template String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.TemplateStringLiteralImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getTemplateStringLiteral()
		 * @generated
		 */
		EClass TEMPLATE_STRING_LITERAL = eINSTANCE.getTemplateStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_STRING_LITERAL__TEXT = eINSTANCE.getTemplateStringLiteral_Text();

		/**
		 * The meta object literal for the '<em><b>Template Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_STRING_LITERAL__TEMPLATE_EXPRESSIONS = eINSTANCE.getTemplateStringLiteral_TemplateExpressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.TemplateStringExpressionImpl <em>Template String Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.TemplateStringExpressionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getTemplateStringExpression()
		 * @generated
		 */
		EClass TEMPLATE_STRING_EXPRESSION = eINSTANCE.getTemplateStringExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_STRING_EXPRESSION__EXPRESSION = eINSTANCE.getTemplateStringExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.TagFunctionImpl <em>Tag Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.TagFunctionImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getTagFunction()
		 * @generated
		 */
		EClass TAG_FUNCTION = eINSTANCE.getTagFunction();

		/**
		 * The meta object literal for the '<em><b>Tag Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_FUNCTION__TAG_FUNCTION = eINSTANCE.getTagFunction_TagFunction();

		/**
		 * The meta object literal for the '<em><b>Template String Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_FUNCTION__TEMPLATE_STRING_LITERAL = eINSTANCE.getTagFunction_TemplateStringLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.impl.ForOfStatementImpl <em>For Of Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.impl.ForOfStatementImpl
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getForOfStatement()
		 * @generated
		 */
		EClass FOR_OF_STATEMENT = eINSTANCE.getForOfStatement();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_OF_STATEMENT__ITEM = eINSTANCE.getForOfStatement_Item();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_OF_STATEMENT__COLLECTION = eINSTANCE.getForOfStatement_Collection();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.UnaryOperator <em>Unary Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.UnaryOperator
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getUnaryOperator()
		 * @generated
		 */
		EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

		/**
		 * The meta object literal for the '{@link org.eclipse.dltk.javascript.core.dom.BinaryOperator <em>Binary Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.dltk.javascript.core.dom.BinaryOperator
		 * @see org.eclipse.dltk.javascript.core.dom.impl.DomPackageImpl#getBinaryOperator()
		 * @generated
		 */
		EEnum BINARY_OPERATOR = eINSTANCE.getBinaryOperator();

	}

} //DomPackage
