import ceylon.language.meta.model { Type, UnionType }

native class AppliedUnionType<Union=Anything>(shared Anything tipo, caseTypes) satisfies UnionType<Union> {
  shared actual List<Type<out Union>> caseTypes;

  shared native actual Boolean typeOf(Anything instance);
  shared native actual Boolean supertypeOf(Type<out Anything> type);
  shared native actual Boolean exactly(Type<out Anything> type);
  shared native actual String string;
  shared native actual Integer hash;
  shared native actual Boolean equals(Object other);

  shared actual native Type<out Union|Other> union<Other>(Type<out Other> other);
  shared actual native Type<out Union&Other> intersection<Other>(Type<out Other> other);
}
