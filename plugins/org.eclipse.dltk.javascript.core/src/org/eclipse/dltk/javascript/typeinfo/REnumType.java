package org.eclipse.dltk.javascript.typeinfo;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IValidationStatus;
import org.eclipse.dltk.internal.javascript.ti.AnonymousValue;
import org.eclipse.dltk.internal.javascript.ti.ConstantValue;
import org.eclipse.dltk.internal.javascript.ti.ElementValue;
import org.eclipse.dltk.internal.javascript.ti.IValue;
import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IVariable;

public class REnumType implements IRLocalType {

	private final IRType type;
	private final String name;
	private final ReferenceLocation location;

	public REnumType(String name, IRType recordType,
			ReferenceLocation location) {
		this.name = name;
		this.type = recordType;
		this.location = location;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IValidationStatus isAssignableFrom(IValueReference argument) {

		return isAssignableFrom(JavaScriptValidations.typeOf(argument));
	}

	@Override
	public TypeCompatibility isAssignableFrom(IRType type) {
		if (type == this) {
			return TypeCompatibility.TRUE;
		}
		if (type instanceof REnumType other) {
			other.getReferenceLocation().equals(getReferenceLocation());
			return TypeCompatibility.TRUE;
		}
		if (type instanceof IRUnionType union) {
			return union.getTargets().stream().map(t -> isAssignableFrom(t))
					.filter(tc -> tc != TypeCompatibility.TRUE).findAny()
					.orElse(TypeCompatibility.TRUE);
		}
		return this.type.isAssignableFrom(type);
	}

	@Override
	public boolean isExtensible() {
		return false;
	}

	@Override
	public boolean isJavaScriptObject() {
		return true;
	}

	@Override
	public boolean isSynthetic() {
		return false;
	}

	@Override
	public IRType transform(IRTypeTransformer function) {
		return this;
	}

	@Override
	public IRType normalize() {
		return this;
	}

	@Override
	public IRLocalType makeImmutable(Map<Object, Object> visited) {
		return this;
	}

	@Override
	public IValueReference getValue() {
		return ConstantValue.of(this);
	}

	@Override
	public IValueReference getDirectChild(String name) {

		if (type instanceof IRRecordType recordType) {
			// if this is a record type then we assume this is the assignment of
			// the enum this could potentially also be a enum having record type
			// members.. so then we need to know this and just return the member
			// type
			IRRecordMember member = recordType.getMember(name);
			if (member != null) {
				IValueReference memberType = ConstantValue
						.of(new REnumType(name, member.getType(), location));
				ReferenceLocation memberLocation = member
						.getSource() instanceof IVariable variable
								? variable.getLocation()
								: location;
				memberType.setLocation(memberLocation);
				return memberType;
			}

		} else if (type instanceof IRSimpleType simple) {
			IValue member = ElementValue.findMember(simple, name);
			if (member != null) {
				return new AnonymousValue(member);
			}
		} else if (type instanceof IRLocalType localType) {
			return localType.getDirectChild(name);
		}
		return null;
	}

	@Override
	public ReferenceLocation getReferenceLocation() {
		return location;
	}

	@Override
	public Set<String> getDirectChildren() {

		if (type instanceof IRRecordType recordType) {
			return recordType.getMembers().stream()
					.map(member -> member.getName())
					.collect(java.util.stream.Collectors.toSet());

		} else if (type instanceof IRSimpleType simple) {
			return simple.getDeclaration().getMembers().stream()
					.map(member -> member.getName())
					.collect(java.util.stream.Collectors.toSet());
		} else if (type instanceof IRLocalType localType) {
			return localType.getDirectChildren();
		}
		return Collections.emptySet();
	}

}
