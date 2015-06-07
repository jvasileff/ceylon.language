"A closed union type."
shared sealed interface UnionType<Union=Anything>
        satisfies Type<Union> {
    
    "The list of closed case types of this union."
    shared formal List<AnyType> caseTypes;
}
