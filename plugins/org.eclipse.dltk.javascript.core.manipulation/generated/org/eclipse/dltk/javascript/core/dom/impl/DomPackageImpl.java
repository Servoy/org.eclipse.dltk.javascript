/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomPackageImpl.java,v 1.5 2011/04/18 08:29:42 apanchenk Exp $
 */
package org.eclipse.dltk.javascript.core.dom.impl;

import org.eclipse.dltk.javascript.core.dom.AccessorAssignment;
import org.eclipse.dltk.javascript.core.dom.ArrayAccessExpression;
import org.eclipse.dltk.javascript.core.dom.ArrayLiteral;
import org.eclipse.dltk.javascript.core.dom.ArrowFunction;
import org.eclipse.dltk.javascript.core.dom.AttributeIdentifier;
import org.eclipse.dltk.javascript.core.dom.BinaryExpression;
import org.eclipse.dltk.javascript.core.dom.BinaryOperator;
import org.eclipse.dltk.javascript.core.dom.BlockStatement;
import org.eclipse.dltk.javascript.core.dom.BooleanLiteral;
import org.eclipse.dltk.javascript.core.dom.BreakStatement;
import org.eclipse.dltk.javascript.core.dom.CallExpression;
import org.eclipse.dltk.javascript.core.dom.CaseClause;
import org.eclipse.dltk.javascript.core.dom.CatchClause;
import org.eclipse.dltk.javascript.core.dom.Comment;
import org.eclipse.dltk.javascript.core.dom.ConditionalExpression;
import org.eclipse.dltk.javascript.core.dom.ConstStatement;
import org.eclipse.dltk.javascript.core.dom.ContinueStatement;
import org.eclipse.dltk.javascript.core.dom.DefaultClause;
import org.eclipse.dltk.javascript.core.dom.DefaultXmlNamespaceStatement;
import org.eclipse.dltk.javascript.core.dom.DescendantAccessExpression;
import org.eclipse.dltk.javascript.core.dom.DoStatement;
import org.eclipse.dltk.javascript.core.dom.DomFactory;
import org.eclipse.dltk.javascript.core.dom.DomPackage;
import org.eclipse.dltk.javascript.core.dom.Elision;
import org.eclipse.dltk.javascript.core.dom.EmptyStatement;
import org.eclipse.dltk.javascript.core.dom.Expression;
import org.eclipse.dltk.javascript.core.dom.ExpressionSelector;
import org.eclipse.dltk.javascript.core.dom.ExpressionStatement;
import org.eclipse.dltk.javascript.core.dom.FilterExpression;
import org.eclipse.dltk.javascript.core.dom.FinallyClause;
import org.eclipse.dltk.javascript.core.dom.ForEachInStatement;
import org.eclipse.dltk.javascript.core.dom.ForInStatement;
import org.eclipse.dltk.javascript.core.dom.ForStatement;
import org.eclipse.dltk.javascript.core.dom.FunctionExpression;
import org.eclipse.dltk.javascript.core.dom.GetterAssignment;
import org.eclipse.dltk.javascript.core.dom.IArrayElement;
import org.eclipse.dltk.javascript.core.dom.IForInitializer;
import org.eclipse.dltk.javascript.core.dom.IProperty;
import org.eclipse.dltk.javascript.core.dom.IPropertyName;
import org.eclipse.dltk.javascript.core.dom.IPropertySelector;
import org.eclipse.dltk.javascript.core.dom.ISelector;
import org.eclipse.dltk.javascript.core.dom.IUnqualifiedSelector;
import org.eclipse.dltk.javascript.core.dom.Identifier;
import org.eclipse.dltk.javascript.core.dom.IfStatement;
import org.eclipse.dltk.javascript.core.dom.IterationStatement;
import org.eclipse.dltk.javascript.core.dom.Label;
import org.eclipse.dltk.javascript.core.dom.LabeledStatement;
import org.eclipse.dltk.javascript.core.dom.NewExpression;
import org.eclipse.dltk.javascript.core.dom.Node;
import org.eclipse.dltk.javascript.core.dom.NullLiteral;
import org.eclipse.dltk.javascript.core.dom.NumericLiteral;
import org.eclipse.dltk.javascript.core.dom.ObjectLiteral;
import org.eclipse.dltk.javascript.core.dom.Parameter;
import org.eclipse.dltk.javascript.core.dom.ParenthesizedExpression;
import org.eclipse.dltk.javascript.core.dom.PropertyAccessExpression;
import org.eclipse.dltk.javascript.core.dom.PropertyAssignment;
import org.eclipse.dltk.javascript.core.dom.PropertyIdentifier;
import org.eclipse.dltk.javascript.core.dom.QualifiedIdentifier;
import org.eclipse.dltk.javascript.core.dom.RegularExpressionLiteral;
import org.eclipse.dltk.javascript.core.dom.ReturnStatement;
import org.eclipse.dltk.javascript.core.dom.SetterAssignment;
import org.eclipse.dltk.javascript.core.dom.SimplePropertyAssignment;
import org.eclipse.dltk.javascript.core.dom.Source;
import org.eclipse.dltk.javascript.core.dom.Statement;
import org.eclipse.dltk.javascript.core.dom.StringLiteral;
import org.eclipse.dltk.javascript.core.dom.SwitchElement;
import org.eclipse.dltk.javascript.core.dom.SwitchStatement;
import org.eclipse.dltk.javascript.core.dom.TagFunction;
import org.eclipse.dltk.javascript.core.dom.TemplateStringExpression;
import org.eclipse.dltk.javascript.core.dom.TemplateStringLiteral;
import org.eclipse.dltk.javascript.core.dom.ThisExpression;
import org.eclipse.dltk.javascript.core.dom.ThrowStatement;
import org.eclipse.dltk.javascript.core.dom.TryStatement;
import org.eclipse.dltk.javascript.core.dom.UnaryExpression;
import org.eclipse.dltk.javascript.core.dom.UnaryOperator;
import org.eclipse.dltk.javascript.core.dom.VariableDeclaration;
import org.eclipse.dltk.javascript.core.dom.VariableReference;
import org.eclipse.dltk.javascript.core.dom.VariableStatement;
import org.eclipse.dltk.javascript.core.dom.WhileStatement;
import org.eclipse.dltk.javascript.core.dom.WildcardIdentifier;
import org.eclipse.dltk.javascript.core.dom.WithStatement;
import org.eclipse.dltk.javascript.core.dom.XmlExpressionFragment;
import org.eclipse.dltk.javascript.core.dom.XmlFragment;
import org.eclipse.dltk.javascript.core.dom.XmlInitializer;
import org.eclipse.dltk.javascript.core.dom.XmlTextFragment;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomPackageImpl extends EPackageImpl implements DomPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regularExpressionLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thisExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iArrayElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPropertyNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplePropertyAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessorAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getterAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setterAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parenthesizedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterationStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iForInitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forInStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continueStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass withStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labeledStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throwStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tryStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catchClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finallyClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlInitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iUnqualifiedSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wildcardIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPropertySelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlTextFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlExpressionFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descendantAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultXmlNamespaceStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachInStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrowFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateStringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateStringExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryOperatorEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.dltk.javascript.core.dom.DomPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DomPackageImpl() {
		super(eNS_URI, DomFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DomPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DomPackage init() {
		if (isInited) return (DomPackage)EPackage.Registry.INSTANCE.getEPackage(DomPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDomPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DomPackageImpl theDomPackage = registeredDomPackage instanceof DomPackageImpl ? (DomPackageImpl)registeredDomPackage : new DomPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theDomPackage.createPackageContents();

		// Initialize created meta-data
		theDomPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDomPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DomPackage.eNS_URI, theDomPackage);
		return theDomPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_Begin() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_End() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComment() {
		return commentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComment_Text() {
		return (EAttribute)commentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIdentifier() {
		return identifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIdentifier_Name() {
		return (EAttribute)identifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableReference() {
		return variableReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableReference_Variable() {
		return (EReference)variableReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLabel() {
		return labelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLabel_Name() {
		return (EAttribute)labelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNullLiteral() {
		return nullLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanLiteral() {
		return booleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanLiteral_Text() {
		return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNumericLiteral() {
		return numericLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNumericLiteral_Text() {
		return (EAttribute)numericLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringLiteral() {
		return stringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringLiteral_Text() {
		return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRegularExpressionLiteral() {
		return regularExpressionLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRegularExpressionLiteral_Text() {
		return (EAttribute)regularExpressionLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThisExpression() {
		return thisExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArrayLiteral() {
		return arrayLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrayLiteral_Elements() {
		return (EReference)arrayLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIArrayElement() {
		return iArrayElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElision() {
		return elisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectLiteral() {
		return objectLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectLiteral_Properties() {
		return (EReference)objectLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyAssignment() {
		return propertyAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyAssignment_Name() {
		return (EReference)propertyAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPropertyName() {
		return iPropertyNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimplePropertyAssignment() {
		return simplePropertyAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimplePropertyAssignment_Initializer() {
		return (EReference)simplePropertyAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAccessorAssignment() {
		return accessorAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessorAssignment_Body() {
		return (EReference)accessorAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGetterAssignment() {
		return getterAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSetterAssignment() {
		return setterAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSetterAssignment_Parameter() {
		return (EReference)setterAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParenthesizedExpression() {
		return parenthesizedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParenthesizedExpression_Enclosed() {
		return (EReference)parenthesizedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArrayAccessExpression() {
		return arrayAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrayAccessExpression_Array() {
		return (EReference)arrayAccessExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrayAccessExpression_Index() {
		return (EReference)arrayAccessExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyAccessExpression() {
		return propertyAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyAccessExpression_Object() {
		return (EReference)propertyAccessExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyAccessExpression_Property() {
		return (EReference)propertyAccessExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNewExpression() {
		return newExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNewExpression_Constructor() {
		return (EReference)newExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNewExpression_Arguments() {
		return (EReference)newExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCallExpression() {
		return callExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCallExpression_Applicant() {
		return (EReference)callExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCallExpression_Arguments() {
		return (EReference)callExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnaryExpression_Argument() {
		return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnaryExpression_Operation() {
		return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBinaryExpression() {
		return binaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryExpression_Left() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryExpression_Right() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBinaryExpression_Operation() {
		return (EAttribute)binaryExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBinaryExpression_OperatorPosition() {
		return (EAttribute)binaryExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConditionalExpression() {
		return conditionalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConditionalExpression_Predicate() {
		return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConditionalExpression_Consequent() {
		return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConditionalExpression_Alternative() {
		return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBlockStatement() {
		return blockStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBlockStatement_Statements() {
		return (EReference)blockStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableStatement() {
		return variableStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableStatement_Declarations() {
		return (EReference)variableStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableDeclaration_Identifier() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableDeclaration_Initializer() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEmptyStatement() {
		return emptyStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpressionStatement() {
		return expressionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpressionStatement_Expression() {
		return (EReference)expressionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIfStatement() {
		return ifStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfStatement_Predicate() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfStatement_Consequent() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfStatement_Alternative() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIterationStatement() {
		return iterationStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIterationStatement_Body() {
		return (EReference)iterationStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDoStatement() {
		return doStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDoStatement_Condition() {
		return (EReference)doStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWhileStatement() {
		return whileStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWhileStatement_Condition() {
		return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForStatement() {
		return forStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForStatement_Initialization() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForStatement_Condition() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForStatement_Increment() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIForInitializer() {
		return iForInitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForInStatement() {
		return forInStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForInStatement_Item() {
		return (EReference)forInStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForInStatement_Collection() {
		return (EReference)forInStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContinueStatement() {
		return continueStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContinueStatement_Label() {
		return (EReference)continueStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBreakStatement() {
		return breakStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBreakStatement_Label() {
		return (EReference)breakStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReturnStatement() {
		return returnStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReturnStatement_Expression() {
		return (EReference)returnStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWithStatement() {
		return withStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWithStatement_Expression() {
		return (EReference)withStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWithStatement_Statement() {
		return (EReference)withStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSwitchStatement() {
		return switchStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSwitchStatement_Selector() {
		return (EReference)switchStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSwitchStatement_Elements() {
		return (EReference)switchStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSwitchElement() {
		return switchElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSwitchElement_Statements() {
		return (EReference)switchElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCaseClause() {
		return caseClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCaseClause_Expression() {
		return (EReference)caseClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDefaultClause() {
		return defaultClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLabeledStatement() {
		return labeledStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLabeledStatement_Label() {
		return (EReference)labeledStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLabeledStatement_Statement() {
		return (EReference)labeledStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThrowStatement() {
		return throwStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThrowStatement_Exception() {
		return (EReference)throwStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTryStatement() {
		return tryStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTryStatement_Body() {
		return (EReference)tryStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTryStatement_Catches() {
		return (EReference)tryStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTryStatement_FinallyClause() {
		return (EReference)tryStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCatchClause() {
		return catchClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCatchClause_Exception() {
		return (EReference)catchClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCatchClause_Filter() {
		return (EReference)catchClauseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCatchClause_Body() {
		return (EReference)catchClauseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFinallyClause() {
		return finallyClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFinallyClause_Body() {
		return (EReference)finallyClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionExpression() {
		return functionExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionExpression_Documentation() {
		return (EReference)functionExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionExpression_Identifier() {
		return (EReference)functionExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionExpression_Parameters() {
		return (EReference)functionExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionExpression_Body() {
		return (EReference)functionExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionExpression_ParametersPosition() {
		return (EAttribute)functionExpressionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_Name() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSource() {
		return sourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSource_Statements() {
		return (EReference)sourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstStatement() {
		return constStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstStatement_Declarations() {
		return (EReference)constStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyIdentifier() {
		return propertyIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIProperty() {
		return iPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXmlInitializer() {
		return xmlInitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXmlInitializer_Fragments() {
		return (EReference)xmlInitializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeIdentifier() {
		return attributeIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeIdentifier_Selector() {
		return (EReference)attributeIdentifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getISelector() {
		return iSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQualifiedIdentifier() {
		return qualifiedIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQualifiedIdentifier_Namespace() {
		return (EReference)qualifiedIdentifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQualifiedIdentifier_Member() {
		return (EReference)qualifiedIdentifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIUnqualifiedSelector() {
		return iUnqualifiedSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWildcardIdentifier() {
		return wildcardIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPropertySelector() {
		return iPropertySelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpressionSelector() {
		return expressionSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpressionSelector_Index() {
		return (EReference)expressionSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXmlFragment() {
		return xmlFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXmlTextFragment() {
		return xmlTextFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXmlTextFragment_Text() {
		return (EAttribute)xmlTextFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXmlExpressionFragment() {
		return xmlExpressionFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXmlExpressionFragment_Expression() {
		return (EReference)xmlExpressionFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescendantAccessExpression() {
		return descendantAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescendantAccessExpression_Object() {
		return (EReference)descendantAccessExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescendantAccessExpression_Property() {
		return (EReference)descendantAccessExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFilterExpression() {
		return filterExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFilterExpression_Object() {
		return (EReference)filterExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFilterExpression_Filter() {
		return (EReference)filterExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDefaultXmlNamespaceStatement() {
		return defaultXmlNamespaceStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDefaultXmlNamespaceStatement_Expression() {
		return (EReference)defaultXmlNamespaceStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForEachInStatement() {
		return forEachInStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForEachInStatement_Item() {
		return (EReference)forEachInStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForEachInStatement_Collection() {
		return (EReference)forEachInStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArrowFunction() {
		return arrowFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrowFunction_Documentation() {
		return (EReference)arrowFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrowFunction_Parameters() {
		return (EReference)arrowFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrowFunction_Body() {
		return (EReference)arrowFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArrowFunction_ParametersPosition() {
		return (EAttribute)arrowFunctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateStringLiteral() {
		return templateStringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemplateStringLiteral_Text() {
		return (EAttribute)templateStringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateStringLiteral_TemplateExpressions() {
		return (EReference)templateStringLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateStringExpression() {
		return templateStringExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateStringExpression_Expression() {
		return (EReference)templateStringExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTagFunction() {
		return tagFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTagFunction_TagFunction() {
		return (EReference)tagFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTagFunction_TemplateStringLiteral() {
		return (EReference)tagFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getUnaryOperator() {
		return unaryOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getBinaryOperator() {
		return binaryOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomFactory getDomFactory() {
		return (DomFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__BEGIN);
		createEAttribute(nodeEClass, NODE__END);

		commentEClass = createEClass(COMMENT);
		createEAttribute(commentEClass, COMMENT__TEXT);

		identifierEClass = createEClass(IDENTIFIER);
		createEAttribute(identifierEClass, IDENTIFIER__NAME);

		variableReferenceEClass = createEClass(VARIABLE_REFERENCE);
		createEReference(variableReferenceEClass, VARIABLE_REFERENCE__VARIABLE);

		labelEClass = createEClass(LABEL);
		createEAttribute(labelEClass, LABEL__NAME);

		expressionEClass = createEClass(EXPRESSION);

		nullLiteralEClass = createEClass(NULL_LITERAL);

		booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
		createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__TEXT);

		numericLiteralEClass = createEClass(NUMERIC_LITERAL);
		createEAttribute(numericLiteralEClass, NUMERIC_LITERAL__TEXT);

		stringLiteralEClass = createEClass(STRING_LITERAL);
		createEAttribute(stringLiteralEClass, STRING_LITERAL__TEXT);

		regularExpressionLiteralEClass = createEClass(REGULAR_EXPRESSION_LITERAL);
		createEAttribute(regularExpressionLiteralEClass, REGULAR_EXPRESSION_LITERAL__TEXT);

		thisExpressionEClass = createEClass(THIS_EXPRESSION);

		arrayLiteralEClass = createEClass(ARRAY_LITERAL);
		createEReference(arrayLiteralEClass, ARRAY_LITERAL__ELEMENTS);

		iArrayElementEClass = createEClass(IARRAY_ELEMENT);

		elisionEClass = createEClass(ELISION);

		objectLiteralEClass = createEClass(OBJECT_LITERAL);
		createEReference(objectLiteralEClass, OBJECT_LITERAL__PROPERTIES);

		propertyAssignmentEClass = createEClass(PROPERTY_ASSIGNMENT);
		createEReference(propertyAssignmentEClass, PROPERTY_ASSIGNMENT__NAME);

		iPropertyNameEClass = createEClass(IPROPERTY_NAME);

		simplePropertyAssignmentEClass = createEClass(SIMPLE_PROPERTY_ASSIGNMENT);
		createEReference(simplePropertyAssignmentEClass, SIMPLE_PROPERTY_ASSIGNMENT__INITIALIZER);

		accessorAssignmentEClass = createEClass(ACCESSOR_ASSIGNMENT);
		createEReference(accessorAssignmentEClass, ACCESSOR_ASSIGNMENT__BODY);

		getterAssignmentEClass = createEClass(GETTER_ASSIGNMENT);

		setterAssignmentEClass = createEClass(SETTER_ASSIGNMENT);
		createEReference(setterAssignmentEClass, SETTER_ASSIGNMENT__PARAMETER);

		parenthesizedExpressionEClass = createEClass(PARENTHESIZED_EXPRESSION);
		createEReference(parenthesizedExpressionEClass, PARENTHESIZED_EXPRESSION__ENCLOSED);

		arrayAccessExpressionEClass = createEClass(ARRAY_ACCESS_EXPRESSION);
		createEReference(arrayAccessExpressionEClass, ARRAY_ACCESS_EXPRESSION__ARRAY);
		createEReference(arrayAccessExpressionEClass, ARRAY_ACCESS_EXPRESSION__INDEX);

		propertyAccessExpressionEClass = createEClass(PROPERTY_ACCESS_EXPRESSION);
		createEReference(propertyAccessExpressionEClass, PROPERTY_ACCESS_EXPRESSION__OBJECT);
		createEReference(propertyAccessExpressionEClass, PROPERTY_ACCESS_EXPRESSION__PROPERTY);

		newExpressionEClass = createEClass(NEW_EXPRESSION);
		createEReference(newExpressionEClass, NEW_EXPRESSION__CONSTRUCTOR);
		createEReference(newExpressionEClass, NEW_EXPRESSION__ARGUMENTS);

		callExpressionEClass = createEClass(CALL_EXPRESSION);
		createEReference(callExpressionEClass, CALL_EXPRESSION__APPLICANT);
		createEReference(callExpressionEClass, CALL_EXPRESSION__ARGUMENTS);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__ARGUMENT);
		createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OPERATION);

		binaryExpressionEClass = createEClass(BINARY_EXPRESSION);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__LEFT);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__RIGHT);
		createEAttribute(binaryExpressionEClass, BINARY_EXPRESSION__OPERATION);
		createEAttribute(binaryExpressionEClass, BINARY_EXPRESSION__OPERATOR_POSITION);

		conditionalExpressionEClass = createEClass(CONDITIONAL_EXPRESSION);
		createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__PREDICATE);
		createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__CONSEQUENT);
		createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__ALTERNATIVE);

		statementEClass = createEClass(STATEMENT);

		blockStatementEClass = createEClass(BLOCK_STATEMENT);
		createEReference(blockStatementEClass, BLOCK_STATEMENT__STATEMENTS);

		variableStatementEClass = createEClass(VARIABLE_STATEMENT);
		createEReference(variableStatementEClass, VARIABLE_STATEMENT__DECLARATIONS);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__IDENTIFIER);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__INITIALIZER);

		emptyStatementEClass = createEClass(EMPTY_STATEMENT);

		expressionStatementEClass = createEClass(EXPRESSION_STATEMENT);
		createEReference(expressionStatementEClass, EXPRESSION_STATEMENT__EXPRESSION);

		ifStatementEClass = createEClass(IF_STATEMENT);
		createEReference(ifStatementEClass, IF_STATEMENT__PREDICATE);
		createEReference(ifStatementEClass, IF_STATEMENT__CONSEQUENT);
		createEReference(ifStatementEClass, IF_STATEMENT__ALTERNATIVE);

		iterationStatementEClass = createEClass(ITERATION_STATEMENT);
		createEReference(iterationStatementEClass, ITERATION_STATEMENT__BODY);

		doStatementEClass = createEClass(DO_STATEMENT);
		createEReference(doStatementEClass, DO_STATEMENT__CONDITION);

		whileStatementEClass = createEClass(WHILE_STATEMENT);
		createEReference(whileStatementEClass, WHILE_STATEMENT__CONDITION);

		forStatementEClass = createEClass(FOR_STATEMENT);
		createEReference(forStatementEClass, FOR_STATEMENT__INITIALIZATION);
		createEReference(forStatementEClass, FOR_STATEMENT__CONDITION);
		createEReference(forStatementEClass, FOR_STATEMENT__INCREMENT);

		iForInitializerEClass = createEClass(IFOR_INITIALIZER);

		forInStatementEClass = createEClass(FOR_IN_STATEMENT);
		createEReference(forInStatementEClass, FOR_IN_STATEMENT__ITEM);
		createEReference(forInStatementEClass, FOR_IN_STATEMENT__COLLECTION);

		continueStatementEClass = createEClass(CONTINUE_STATEMENT);
		createEReference(continueStatementEClass, CONTINUE_STATEMENT__LABEL);

		breakStatementEClass = createEClass(BREAK_STATEMENT);
		createEReference(breakStatementEClass, BREAK_STATEMENT__LABEL);

		returnStatementEClass = createEClass(RETURN_STATEMENT);
		createEReference(returnStatementEClass, RETURN_STATEMENT__EXPRESSION);

		withStatementEClass = createEClass(WITH_STATEMENT);
		createEReference(withStatementEClass, WITH_STATEMENT__EXPRESSION);
		createEReference(withStatementEClass, WITH_STATEMENT__STATEMENT);

		switchStatementEClass = createEClass(SWITCH_STATEMENT);
		createEReference(switchStatementEClass, SWITCH_STATEMENT__SELECTOR);
		createEReference(switchStatementEClass, SWITCH_STATEMENT__ELEMENTS);

		switchElementEClass = createEClass(SWITCH_ELEMENT);
		createEReference(switchElementEClass, SWITCH_ELEMENT__STATEMENTS);

		caseClauseEClass = createEClass(CASE_CLAUSE);
		createEReference(caseClauseEClass, CASE_CLAUSE__EXPRESSION);

		defaultClauseEClass = createEClass(DEFAULT_CLAUSE);

		labeledStatementEClass = createEClass(LABELED_STATEMENT);
		createEReference(labeledStatementEClass, LABELED_STATEMENT__LABEL);
		createEReference(labeledStatementEClass, LABELED_STATEMENT__STATEMENT);

		throwStatementEClass = createEClass(THROW_STATEMENT);
		createEReference(throwStatementEClass, THROW_STATEMENT__EXCEPTION);

		tryStatementEClass = createEClass(TRY_STATEMENT);
		createEReference(tryStatementEClass, TRY_STATEMENT__BODY);
		createEReference(tryStatementEClass, TRY_STATEMENT__CATCHES);
		createEReference(tryStatementEClass, TRY_STATEMENT__FINALLY_CLAUSE);

		catchClauseEClass = createEClass(CATCH_CLAUSE);
		createEReference(catchClauseEClass, CATCH_CLAUSE__EXCEPTION);
		createEReference(catchClauseEClass, CATCH_CLAUSE__FILTER);
		createEReference(catchClauseEClass, CATCH_CLAUSE__BODY);

		finallyClauseEClass = createEClass(FINALLY_CLAUSE);
		createEReference(finallyClauseEClass, FINALLY_CLAUSE__BODY);

		functionExpressionEClass = createEClass(FUNCTION_EXPRESSION);
		createEReference(functionExpressionEClass, FUNCTION_EXPRESSION__DOCUMENTATION);
		createEReference(functionExpressionEClass, FUNCTION_EXPRESSION__IDENTIFIER);
		createEReference(functionExpressionEClass, FUNCTION_EXPRESSION__PARAMETERS);
		createEReference(functionExpressionEClass, FUNCTION_EXPRESSION__BODY);
		createEAttribute(functionExpressionEClass, FUNCTION_EXPRESSION__PARAMETERS_POSITION);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__NAME);

		sourceEClass = createEClass(SOURCE);
		createEReference(sourceEClass, SOURCE__STATEMENTS);

		constStatementEClass = createEClass(CONST_STATEMENT);
		createEReference(constStatementEClass, CONST_STATEMENT__DECLARATIONS);

		propertyIdentifierEClass = createEClass(PROPERTY_IDENTIFIER);

		iPropertyEClass = createEClass(IPROPERTY);

		xmlInitializerEClass = createEClass(XML_INITIALIZER);
		createEReference(xmlInitializerEClass, XML_INITIALIZER__FRAGMENTS);

		attributeIdentifierEClass = createEClass(ATTRIBUTE_IDENTIFIER);
		createEReference(attributeIdentifierEClass, ATTRIBUTE_IDENTIFIER__SELECTOR);

		iSelectorEClass = createEClass(ISELECTOR);

		qualifiedIdentifierEClass = createEClass(QUALIFIED_IDENTIFIER);
		createEReference(qualifiedIdentifierEClass, QUALIFIED_IDENTIFIER__NAMESPACE);
		createEReference(qualifiedIdentifierEClass, QUALIFIED_IDENTIFIER__MEMBER);

		iUnqualifiedSelectorEClass = createEClass(IUNQUALIFIED_SELECTOR);

		wildcardIdentifierEClass = createEClass(WILDCARD_IDENTIFIER);

		iPropertySelectorEClass = createEClass(IPROPERTY_SELECTOR);

		expressionSelectorEClass = createEClass(EXPRESSION_SELECTOR);
		createEReference(expressionSelectorEClass, EXPRESSION_SELECTOR__INDEX);

		xmlFragmentEClass = createEClass(XML_FRAGMENT);

		xmlTextFragmentEClass = createEClass(XML_TEXT_FRAGMENT);
		createEAttribute(xmlTextFragmentEClass, XML_TEXT_FRAGMENT__TEXT);

		xmlExpressionFragmentEClass = createEClass(XML_EXPRESSION_FRAGMENT);
		createEReference(xmlExpressionFragmentEClass, XML_EXPRESSION_FRAGMENT__EXPRESSION);

		descendantAccessExpressionEClass = createEClass(DESCENDANT_ACCESS_EXPRESSION);
		createEReference(descendantAccessExpressionEClass, DESCENDANT_ACCESS_EXPRESSION__OBJECT);
		createEReference(descendantAccessExpressionEClass, DESCENDANT_ACCESS_EXPRESSION__PROPERTY);

		filterExpressionEClass = createEClass(FILTER_EXPRESSION);
		createEReference(filterExpressionEClass, FILTER_EXPRESSION__OBJECT);
		createEReference(filterExpressionEClass, FILTER_EXPRESSION__FILTER);

		defaultXmlNamespaceStatementEClass = createEClass(DEFAULT_XML_NAMESPACE_STATEMENT);
		createEReference(defaultXmlNamespaceStatementEClass, DEFAULT_XML_NAMESPACE_STATEMENT__EXPRESSION);

		forEachInStatementEClass = createEClass(FOR_EACH_IN_STATEMENT);
		createEReference(forEachInStatementEClass, FOR_EACH_IN_STATEMENT__ITEM);
		createEReference(forEachInStatementEClass, FOR_EACH_IN_STATEMENT__COLLECTION);

		arrowFunctionEClass = createEClass(ARROW_FUNCTION);
		createEReference(arrowFunctionEClass, ARROW_FUNCTION__DOCUMENTATION);
		createEReference(arrowFunctionEClass, ARROW_FUNCTION__PARAMETERS);
		createEReference(arrowFunctionEClass, ARROW_FUNCTION__BODY);
		createEAttribute(arrowFunctionEClass, ARROW_FUNCTION__PARAMETERS_POSITION);

		templateStringLiteralEClass = createEClass(TEMPLATE_STRING_LITERAL);
		createEAttribute(templateStringLiteralEClass, TEMPLATE_STRING_LITERAL__TEXT);
		createEReference(templateStringLiteralEClass, TEMPLATE_STRING_LITERAL__TEMPLATE_EXPRESSIONS);

		templateStringExpressionEClass = createEClass(TEMPLATE_STRING_EXPRESSION);
		createEReference(templateStringExpressionEClass, TEMPLATE_STRING_EXPRESSION__EXPRESSION);

		tagFunctionEClass = createEClass(TAG_FUNCTION);
		createEReference(tagFunctionEClass, TAG_FUNCTION__TAG_FUNCTION);
		createEReference(tagFunctionEClass, TAG_FUNCTION__TEMPLATE_STRING_LITERAL);

		// Create enums
		unaryOperatorEEnum = createEEnum(UNARY_OPERATOR);
		binaryOperatorEEnum = createEEnum(BINARY_OPERATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		commentEClass.getESuperTypes().add(this.getNode());
		identifierEClass.getESuperTypes().add(this.getNode());
		identifierEClass.getESuperTypes().add(this.getIPropertyName());
		identifierEClass.getESuperTypes().add(this.getIPropertySelector());
		identifierEClass.getESuperTypes().add(this.getIProperty());
		variableReferenceEClass.getESuperTypes().add(this.getExpression());
		labelEClass.getESuperTypes().add(this.getNode());
		expressionEClass.getESuperTypes().add(this.getNode());
		expressionEClass.getESuperTypes().add(this.getIArrayElement());
		expressionEClass.getESuperTypes().add(this.getIForInitializer());
		nullLiteralEClass.getESuperTypes().add(this.getExpression());
		booleanLiteralEClass.getESuperTypes().add(this.getExpression());
		numericLiteralEClass.getESuperTypes().add(this.getExpression());
		numericLiteralEClass.getESuperTypes().add(this.getIPropertyName());
		stringLiteralEClass.getESuperTypes().add(this.getExpression());
		stringLiteralEClass.getESuperTypes().add(this.getIPropertyName());
		regularExpressionLiteralEClass.getESuperTypes().add(this.getExpression());
		thisExpressionEClass.getESuperTypes().add(this.getExpression());
		arrayLiteralEClass.getESuperTypes().add(this.getExpression());
		iArrayElementEClass.getESuperTypes().add(this.getNode());
		elisionEClass.getESuperTypes().add(this.getIArrayElement());
		objectLiteralEClass.getESuperTypes().add(this.getExpression());
		propertyAssignmentEClass.getESuperTypes().add(this.getNode());
		iPropertyNameEClass.getESuperTypes().add(this.getNode());
		simplePropertyAssignmentEClass.getESuperTypes().add(this.getPropertyAssignment());
		accessorAssignmentEClass.getESuperTypes().add(this.getPropertyAssignment());
		getterAssignmentEClass.getESuperTypes().add(this.getAccessorAssignment());
		setterAssignmentEClass.getESuperTypes().add(this.getAccessorAssignment());
		parenthesizedExpressionEClass.getESuperTypes().add(this.getExpression());
		arrayAccessExpressionEClass.getESuperTypes().add(this.getExpression());
		propertyAccessExpressionEClass.getESuperTypes().add(this.getExpression());
		newExpressionEClass.getESuperTypes().add(this.getExpression());
		callExpressionEClass.getESuperTypes().add(this.getExpression());
		unaryExpressionEClass.getESuperTypes().add(this.getExpression());
		binaryExpressionEClass.getESuperTypes().add(this.getExpression());
		conditionalExpressionEClass.getESuperTypes().add(this.getExpression());
		statementEClass.getESuperTypes().add(this.getNode());
		blockStatementEClass.getESuperTypes().add(this.getStatement());
		variableStatementEClass.getESuperTypes().add(this.getStatement());
		variableStatementEClass.getESuperTypes().add(this.getIForInitializer());
		variableDeclarationEClass.getESuperTypes().add(this.getNode());
		emptyStatementEClass.getESuperTypes().add(this.getStatement());
		expressionStatementEClass.getESuperTypes().add(this.getStatement());
		ifStatementEClass.getESuperTypes().add(this.getStatement());
		iterationStatementEClass.getESuperTypes().add(this.getStatement());
		doStatementEClass.getESuperTypes().add(this.getIterationStatement());
		whileStatementEClass.getESuperTypes().add(this.getIterationStatement());
		forStatementEClass.getESuperTypes().add(this.getIterationStatement());
		iForInitializerEClass.getESuperTypes().add(this.getNode());
		forInStatementEClass.getESuperTypes().add(this.getIterationStatement());
		continueStatementEClass.getESuperTypes().add(this.getStatement());
		breakStatementEClass.getESuperTypes().add(this.getStatement());
		returnStatementEClass.getESuperTypes().add(this.getStatement());
		withStatementEClass.getESuperTypes().add(this.getStatement());
		switchStatementEClass.getESuperTypes().add(this.getStatement());
		switchElementEClass.getESuperTypes().add(this.getNode());
		caseClauseEClass.getESuperTypes().add(this.getSwitchElement());
		defaultClauseEClass.getESuperTypes().add(this.getSwitchElement());
		labeledStatementEClass.getESuperTypes().add(this.getStatement());
		throwStatementEClass.getESuperTypes().add(this.getStatement());
		tryStatementEClass.getESuperTypes().add(this.getStatement());
		catchClauseEClass.getESuperTypes().add(this.getNode());
		finallyClauseEClass.getESuperTypes().add(this.getNode());
		functionExpressionEClass.getESuperTypes().add(this.getExpression());
		parameterEClass.getESuperTypes().add(this.getNode());
		sourceEClass.getESuperTypes().add(this.getNode());
		constStatementEClass.getESuperTypes().add(this.getStatement());
		propertyIdentifierEClass.getESuperTypes().add(this.getExpression());
		propertyIdentifierEClass.getESuperTypes().add(this.getIProperty());
		iPropertyEClass.getESuperTypes().add(this.getNode());
		xmlInitializerEClass.getESuperTypes().add(this.getExpression());
		attributeIdentifierEClass.getESuperTypes().add(this.getPropertyIdentifier());
		iSelectorEClass.getESuperTypes().add(this.getNode());
		qualifiedIdentifierEClass.getESuperTypes().add(this.getPropertyIdentifier());
		qualifiedIdentifierEClass.getESuperTypes().add(this.getISelector());
		iUnqualifiedSelectorEClass.getESuperTypes().add(this.getISelector());
		wildcardIdentifierEClass.getESuperTypes().add(this.getPropertyIdentifier());
		wildcardIdentifierEClass.getESuperTypes().add(this.getIPropertySelector());
		iPropertySelectorEClass.getESuperTypes().add(this.getIUnqualifiedSelector());
		expressionSelectorEClass.getESuperTypes().add(this.getIUnqualifiedSelector());
		xmlFragmentEClass.getESuperTypes().add(this.getNode());
		xmlTextFragmentEClass.getESuperTypes().add(this.getXmlFragment());
		xmlExpressionFragmentEClass.getESuperTypes().add(this.getXmlFragment());
		descendantAccessExpressionEClass.getESuperTypes().add(this.getExpression());
		filterExpressionEClass.getESuperTypes().add(this.getExpression());
		defaultXmlNamespaceStatementEClass.getESuperTypes().add(this.getStatement());
		forEachInStatementEClass.getESuperTypes().add(this.getIterationStatement());
		arrowFunctionEClass.getESuperTypes().add(this.getExpression());
		templateStringLiteralEClass.getESuperTypes().add(this.getExpression());
		templateStringLiteralEClass.getESuperTypes().add(this.getIPropertyName());
		templateStringExpressionEClass.getESuperTypes().add(this.getExpression());
		tagFunctionEClass.getESuperTypes().add(this.getExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Begin(), ecorePackage.getEInt(), "begin", "-1", 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_End(), ecorePackage.getEInt(), "end", "-1", 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComment_Text(), ecorePackage.getEString(), "text", null, 1, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifier_Name(), ecorePackage.getEString(), "name", null, 1, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableReferenceEClass, VariableReference.class, "VariableReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableReference_Variable(), this.getIdentifier(), null, "variable", null, 1, 1, VariableReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(labelEClass, Label.class, "Label", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLabel_Name(), ecorePackage.getEString(), "name", null, 1, 1, Label.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nullLiteralEClass, NullLiteral.class, "NullLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteral_Text(), ecorePackage.getEString(), "text", null, 1, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericLiteralEClass, NumericLiteral.class, "NumericLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericLiteral_Text(), ecorePackage.getEString(), "text", null, 1, 1, NumericLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteral_Text(), ecorePackage.getEString(), "text", null, 1, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(regularExpressionLiteralEClass, RegularExpressionLiteral.class, "RegularExpressionLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegularExpressionLiteral_Text(), ecorePackage.getEString(), "text", null, 1, 1, RegularExpressionLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thisExpressionEClass, ThisExpression.class, "ThisExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(arrayLiteralEClass, ArrayLiteral.class, "ArrayLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayLiteral_Elements(), this.getIArrayElement(), null, "elements", null, 0, -1, ArrayLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iArrayElementEClass, IArrayElement.class, "IArrayElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elisionEClass, Elision.class, "Elision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectLiteralEClass, ObjectLiteral.class, "ObjectLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectLiteral_Properties(), this.getPropertyAssignment(), null, "properties", null, 0, -1, ObjectLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyAssignmentEClass, PropertyAssignment.class, "PropertyAssignment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyAssignment_Name(), this.getIPropertyName(), null, "name", null, 1, 1, PropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iPropertyNameEClass, IPropertyName.class, "IPropertyName", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simplePropertyAssignmentEClass, SimplePropertyAssignment.class, "SimplePropertyAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimplePropertyAssignment_Initializer(), this.getExpression(), null, "initializer", null, 1, 1, SimplePropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessorAssignmentEClass, AccessorAssignment.class, "AccessorAssignment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccessorAssignment_Body(), this.getBlockStatement(), null, "body", null, 1, 1, AccessorAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getterAssignmentEClass, GetterAssignment.class, "GetterAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setterAssignmentEClass, SetterAssignment.class, "SetterAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetterAssignment_Parameter(), this.getIdentifier(), null, "parameter", null, 1, 1, SetterAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parenthesizedExpressionEClass, ParenthesizedExpression.class, "ParenthesizedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParenthesizedExpression_Enclosed(), this.getExpression(), null, "enclosed", null, 1, 1, ParenthesizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayAccessExpressionEClass, ArrayAccessExpression.class, "ArrayAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayAccessExpression_Array(), this.getExpression(), null, "array", null, 1, 1, ArrayAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayAccessExpression_Index(), this.getExpression(), null, "index", null, 1, 1, ArrayAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyAccessExpressionEClass, PropertyAccessExpression.class, "PropertyAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyAccessExpression_Object(), this.getExpression(), null, "object", null, 1, 1, PropertyAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyAccessExpression_Property(), this.getIProperty(), null, "property", null, 1, 1, PropertyAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newExpressionEClass, NewExpression.class, "NewExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewExpression_Constructor(), this.getExpression(), null, "constructor", null, 1, 1, NewExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewExpression_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, NewExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callExpressionEClass, CallExpression.class, "CallExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallExpression_Applicant(), this.getExpression(), null, "applicant", null, 1, 1, CallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallExpression_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, CallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryExpression_Argument(), this.getExpression(), null, "argument", null, 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnaryExpression_Operation(), this.getUnaryOperator(), "operation", null, 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryExpressionEClass, BinaryExpression.class, "BinaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryExpression_Left(), this.getExpression(), null, "left", null, 1, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryExpression_Right(), this.getExpression(), null, "right", null, 1, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryExpression_Operation(), this.getBinaryOperator(), "operation", null, 1, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryExpression_OperatorPosition(), ecorePackage.getEInt(), "operatorPosition", null, 1, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalExpressionEClass, ConditionalExpression.class, "ConditionalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionalExpression_Predicate(), this.getExpression(), null, "predicate", null, 1, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalExpression_Consequent(), this.getExpression(), null, "consequent", null, 1, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalExpression_Alternative(), this.getExpression(), null, "alternative", null, 1, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockStatementEClass, BlockStatement.class, "BlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockStatement_Statements(), this.getStatement(), null, "statements", null, 0, -1, BlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableStatementEClass, VariableStatement.class, "VariableStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableStatement_Declarations(), this.getVariableDeclaration(), null, "declarations", null, 1, -1, VariableStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDeclaration_Identifier(), this.getIdentifier(), null, "identifier", null, 1, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_Initializer(), this.getExpression(), null, "initializer", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emptyStatementEClass, EmptyStatement.class, "EmptyStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionStatementEClass, ExpressionStatement.class, "ExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionStatement_Expression(), this.getExpression(), null, "expression", null, 1, 1, ExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfStatement_Predicate(), this.getExpression(), null, "predicate", null, 1, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_Consequent(), this.getStatement(), null, "consequent", null, 1, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_Alternative(), this.getStatement(), null, "alternative", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterationStatementEClass, IterationStatement.class, "IterationStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIterationStatement_Body(), this.getStatement(), null, "body", null, 1, 1, IterationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doStatementEClass, DoStatement.class, "DoStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDoStatement_Condition(), this.getExpression(), null, "condition", null, 1, 1, DoStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileStatement_Condition(), this.getExpression(), null, "condition", null, 1, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForStatement_Initialization(), this.getIForInitializer(), null, "initialization", null, 1, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Condition(), this.getExpression(), null, "condition", null, 1, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Increment(), this.getExpression(), null, "increment", null, 1, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iForInitializerEClass, IForInitializer.class, "IForInitializer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forInStatementEClass, ForInStatement.class, "ForInStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForInStatement_Item(), this.getIForInitializer(), null, "item", null, 1, 1, ForInStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForInStatement_Collection(), this.getExpression(), null, "collection", null, 1, 1, ForInStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(continueStatementEClass, ContinueStatement.class, "ContinueStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContinueStatement_Label(), this.getLabel(), null, "label", null, 0, 1, ContinueStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(breakStatementEClass, BreakStatement.class, "BreakStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBreakStatement_Label(), this.getLabel(), null, "label", null, 0, 1, BreakStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(returnStatementEClass, ReturnStatement.class, "ReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, ReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(withStatementEClass, WithStatement.class, "WithStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWithStatement_Expression(), this.getExpression(), null, "expression", null, 1, 1, WithStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWithStatement_Statement(), this.getStatement(), null, "statement", null, 1, 1, WithStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchStatementEClass, SwitchStatement.class, "SwitchStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchStatement_Selector(), this.getExpression(), null, "selector", null, 1, 1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchStatement_Elements(), this.getSwitchElement(), null, "elements", null, 0, -1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchElementEClass, SwitchElement.class, "SwitchElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchElement_Statements(), this.getStatement(), null, "statements", null, 0, -1, SwitchElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseClauseEClass, CaseClause.class, "CaseClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseClause_Expression(), this.getExpression(), null, "expression", null, 1, 1, CaseClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultClauseEClass, DefaultClause.class, "DefaultClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(labeledStatementEClass, LabeledStatement.class, "LabeledStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLabeledStatement_Label(), this.getLabel(), null, "label", null, 1, 1, LabeledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLabeledStatement_Statement(), this.getStatement(), null, "statement", null, 1, 1, LabeledStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throwStatementEClass, ThrowStatement.class, "ThrowStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThrowStatement_Exception(), this.getExpression(), null, "exception", null, 1, 1, ThrowStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tryStatementEClass, TryStatement.class, "TryStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTryStatement_Body(), this.getBlockStatement(), null, "body", null, 1, 1, TryStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTryStatement_Catches(), this.getCatchClause(), null, "catches", null, 0, -1, TryStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTryStatement_FinallyClause(), this.getFinallyClause(), null, "finallyClause", null, 0, 1, TryStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(catchClauseEClass, CatchClause.class, "CatchClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCatchClause_Exception(), this.getIdentifier(), null, "exception", null, 1, 1, CatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCatchClause_Filter(), this.getExpression(), null, "filter", null, 0, 1, CatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCatchClause_Body(), this.getBlockStatement(), null, "body", null, 1, 1, CatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(finallyClauseEClass, FinallyClause.class, "FinallyClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFinallyClause_Body(), this.getBlockStatement(), null, "body", null, 1, 1, FinallyClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionExpressionEClass, FunctionExpression.class, "FunctionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionExpression_Documentation(), this.getComment(), null, "documentation", null, 0, 1, FunctionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionExpression_Identifier(), this.getIdentifier(), null, "identifier", null, 0, 1, FunctionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionExpression_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, FunctionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionExpression_Body(), this.getBlockStatement(), null, "body", null, 1, 1, FunctionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionExpression_ParametersPosition(), ecorePackage.getEInt(), "parametersPosition", null, 1, 1, FunctionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Name(), this.getIdentifier(), null, "name", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceEClass, Source.class, "Source", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSource_Statements(), this.getStatement(), null, "statements", null, 0, -1, Source.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constStatementEClass, ConstStatement.class, "ConstStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstStatement_Declarations(), this.getVariableDeclaration(), null, "declarations", null, 1, -1, ConstStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyIdentifierEClass, PropertyIdentifier.class, "PropertyIdentifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iPropertyEClass, IProperty.class, "IProperty", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xmlInitializerEClass, XmlInitializer.class, "XmlInitializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXmlInitializer_Fragments(), this.getXmlFragment(), null, "fragments", null, 1, -1, XmlInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeIdentifierEClass, AttributeIdentifier.class, "AttributeIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeIdentifier_Selector(), this.getISelector(), null, "selector", null, 1, 1, AttributeIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iSelectorEClass, ISelector.class, "ISelector", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(qualifiedIdentifierEClass, QualifiedIdentifier.class, "QualifiedIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualifiedIdentifier_Namespace(), this.getIPropertySelector(), null, "namespace", null, 1, 1, QualifiedIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualifiedIdentifier_Member(), this.getIUnqualifiedSelector(), null, "member", null, 1, 1, QualifiedIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iUnqualifiedSelectorEClass, IUnqualifiedSelector.class, "IUnqualifiedSelector", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wildcardIdentifierEClass, WildcardIdentifier.class, "WildcardIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iPropertySelectorEClass, IPropertySelector.class, "IPropertySelector", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionSelectorEClass, ExpressionSelector.class, "ExpressionSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionSelector_Index(), this.getExpression(), null, "index", null, 1, 1, ExpressionSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlFragmentEClass, XmlFragment.class, "XmlFragment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xmlTextFragmentEClass, XmlTextFragment.class, "XmlTextFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXmlTextFragment_Text(), ecorePackage.getEString(), "text", null, 1, 1, XmlTextFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlExpressionFragmentEClass, XmlExpressionFragment.class, "XmlExpressionFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXmlExpressionFragment_Expression(), this.getExpression(), null, "expression", null, 1, 1, XmlExpressionFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descendantAccessExpressionEClass, DescendantAccessExpression.class, "DescendantAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescendantAccessExpression_Object(), this.getExpression(), null, "object", null, 1, 1, DescendantAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescendantAccessExpression_Property(), this.getIProperty(), null, "property", null, 1, 1, DescendantAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterExpressionEClass, FilterExpression.class, "FilterExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilterExpression_Object(), this.getExpression(), null, "object", null, 1, 1, FilterExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterExpression_Filter(), this.getExpression(), null, "filter", null, 1, 1, FilterExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultXmlNamespaceStatementEClass, DefaultXmlNamespaceStatement.class, "DefaultXmlNamespaceStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefaultXmlNamespaceStatement_Expression(), this.getExpression(), null, "expression", null, 1, 1, DefaultXmlNamespaceStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forEachInStatementEClass, ForEachInStatement.class, "ForEachInStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForEachInStatement_Item(), this.getIForInitializer(), null, "item", null, 1, 1, ForEachInStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachInStatement_Collection(), this.getExpression(), null, "collection", null, 1, 1, ForEachInStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrowFunctionEClass, ArrowFunction.class, "ArrowFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrowFunction_Documentation(), this.getComment(), null, "documentation", null, 0, 1, ArrowFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrowFunction_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, ArrowFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrowFunction_Body(), this.getStatement(), null, "body", null, 1, 1, ArrowFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrowFunction_ParametersPosition(), ecorePackage.getEInt(), "parametersPosition", null, 1, 1, ArrowFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateStringLiteralEClass, TemplateStringLiteral.class, "TemplateStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemplateStringLiteral_Text(), ecorePackage.getEString(), "text", null, 1, 1, TemplateStringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplateStringLiteral_TemplateExpressions(), this.getTemplateStringExpression(), null, "templateExpressions", null, 0, -1, TemplateStringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateStringExpressionEClass, TemplateStringExpression.class, "TemplateStringExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateStringExpression_Expression(), this.getExpression(), null, "expression", null, 1, 1, TemplateStringExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagFunctionEClass, TagFunction.class, "TagFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTagFunction_TagFunction(), this.getExpression(), null, "tagFunction", null, 1, 1, TagFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTagFunction_TemplateStringLiteral(), this.getTemplateStringLiteral(), null, "templateStringLiteral", null, 0, 1, TagFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(unaryOperatorEEnum, UnaryOperator.class, "UnaryOperator");
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.POSTFIX_INC);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.POSTFIX_DEC);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.DELETE);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.VOID);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.TYPEOF);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.PREFIX_INC);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.PREFIX_DEC);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.UNARY_PLUS);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.NUM_NEG);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.BW_NOT);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.NOT);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.YIELD);

		initEEnum(binaryOperatorEEnum, BinaryOperator.class, "BinaryOperator");
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.MUL);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.DIV);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.MOD);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.ADD);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.SUB);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.LSH);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.RSH);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.URSH);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.LESS);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.GREATER);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.LEQ);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.GEQ);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.INSTANCEOF);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.IN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.EQ);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.NEQ);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.SAME);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.NSAME);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.BW_AND);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.BW_XOR);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.BW_OR);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.LOG_AND);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.LOG_OR);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.MUL_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.DIV_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.MOD_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.ADD_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.SUB_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.LSH_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.RSH_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.URSH_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.AND_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.XOR_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.OR_ASSIGN);
		addEEnumLiteral(binaryOperatorEEnum, BinaryOperator.COMMA);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// null
		createNullAnnotations();
	}

    /**
	 * Initializes the annotations for <b>null</b>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void createNullAnnotations() {
		String source = null;
		addAnnotation
		  (getIdentifier_Name(),
		   source,
		   new String[] {
			   "value", "1"
		   });
		addAnnotation
		  (getLabel_Name(),
		   source,
		   new String[] {
			   "value", "1"
		   });
		addAnnotation
		  (getBooleanLiteral_Text(),
		   source,
		   new String[] {
			   "value", "1"
		   });
		addAnnotation
		  (getNumericLiteral_Text(),
		   source,
		   new String[] {
			   "value", "1"
		   });
		addAnnotation
		  (getStringLiteral_Text(),
		   source,
		   new String[] {
			   "value", "1"
		   });
		addAnnotation
		  (getRegularExpressionLiteral_Text(),
		   source,
		   new String[] {
			   "value", "1"
		   });
		addAnnotation
		  (getTemplateStringLiteral_Text(),
		   source,
		   new String[] {
			   "value", "1"
		   });
	}

} //DomPackageImpl
