import ceylon.language.meta.model {
  ClosedType=Type,
  ClassOrInterface, Method, Function
}
import ceylon.language.meta.declaration {
  FunctionDeclaration,
  TypeParameter
}

shared native class AppliedMethod<in Container, out Type=Anything, in Arguments=Nothing>()
    satisfies Method<Container,Type,Arguments>
    given Arguments satisfies Anything[] {

  shared actual native ClosedType<out Anything>[] parameterTypes;
  shared actual native Function<Type, Arguments> bind(Object container);

  shared actual native FunctionDeclaration declaration;
  shared actual native ClosedType<out Type> type;
  shared actual native ClassOrInterface<out Anything> declaringType;

  shared actual native ClassOrInterface<out Anything>? container;

  shared actual native Map<TypeParameter, ClosedType<out Anything>> typeArguments;
  shared actual native ClosedType<out Anything>[] typeArgumentList;

  shared actual native String string;
  shared actual native Integer hash;
  shared actual native Boolean equals(Object other);
}
