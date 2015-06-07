import ceylon.language.meta.model {
  ClosedType=Type, Function, AnyType
}
import ceylon.language.meta.declaration {
  FunctionDeclaration, TypeParameter
}

shared native class AppliedFunction<out Type, in Arguments>()
    satisfies Function<Type,Arguments>
    given Arguments satisfies Anything[] {
  shared actual native ClosedType<Anything>[] parameterTypes;
  shared actual native Type apply(Anything* arguments);
  shared actual native Type namedApply(Iterable<String->Anything> arguments);

  shared actual native FunctionDeclaration declaration;
  shared actual native ClosedType<out Type> type;
  shared actual native AnyType? container;
  shared actual native Map<TypeParameter, AnyType> typeArguments;
  shared actual native AnyType[] typeArgumentList;

  shared actual native String string;
  shared actual native Integer hash;
  shared actual native Boolean equals(Object other);
}
