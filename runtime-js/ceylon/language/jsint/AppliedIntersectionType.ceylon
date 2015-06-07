import ceylon.language.meta.model { Type, IntersectionType, AnyType }

native class AppliedIntersectionType<Union=Anything>(shared Anything tipo, satisfiedTypes) satisfies IntersectionType<Union> {
  shared actual List<Type<Union>> satisfiedTypes;

  shared native actual Boolean typeOf(Anything instance);
  shared native actual Boolean supertypeOf(AnyType type);
  shared native actual Boolean exactly(AnyType type);

  shared native actual String string;
  shared native actual Integer hash;
  shared native actual Boolean equals(Object other);

  shared actual native Type<out Union|Other> union<Other>(Type<out Other> other);
  shared actual native Type<out Union&Other> intersection<Other>(Type<out Other> other);
}
