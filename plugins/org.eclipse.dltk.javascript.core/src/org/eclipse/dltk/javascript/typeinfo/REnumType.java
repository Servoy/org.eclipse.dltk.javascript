package org.eclipse.dltk.javascript.typeinfo;

import java.util.Map;
import java.util.Set;

import org.eclipse.dltk.compiler.problem.IValidationStatus;
import org.eclipse.dltk.internal.javascript.ti.ConstantValue;
import org.eclipse.dltk.internal.javascript.validation.JavaScriptValidations;
import org.eclipse.dltk.javascript.typeinference.IValueReference;
import org.eclipse.dltk.javascript.typeinference.ReferenceLocation;
import org.eclipse.dltk.javascript.typeinfo.IModelBuilder.IVariable;

public class REnumType implements IRLocalType {

	private final IRRecordType recordType;
	private final String name;
	private final ReferenceLocation location;

	public REnumType(String name, IRRecordType recordType,
			ReferenceLocation location) {
		this.name = name;
		this.recordType = recordType;
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
		if (type instanceof IRSimpleType simpleType) {
			// if it assigned to a simple type then we check if the member type
			// is of this type.
			// all members should be of the same type so we can just check the
			// first one.
			if (recordType.getMembers().size() > 0) {
				IRRecordMember member = recordType.getMembers().iterator()
						.next();
				return member.getType().isAssignableFrom(simpleType);
			}

		}
		return TypeCompatibility.FALSE;
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
		IRRecordMember member = recordType.getMember(name);
		if (member != null) {
			IValueReference memberType = ConstantValue.of(this);
			ReferenceLocation memberLocation = member
					.getSource() instanceof IVariable variable
							? variable.getLocation()
							: location;
			memberType.setLocation(memberLocation);
			return memberType;
		}
		return null;
	}

	@Override
	public ReferenceLocation getReferenceLocation() {
		return location;
	}

	@Override
	public Set<String> getDirectChildren() {
		return recordType.getMembers().stream().map(member -> member.getName())
				.collect(java.util.stream.Collectors.toSet());
	}

}
