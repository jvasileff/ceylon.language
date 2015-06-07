"An interface model that you can inspect."
shared sealed interface Interface<Type=Anything>
    satisfies InterfaceModel<Type> {}
