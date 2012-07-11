 package ceylon.language;

import com.redhat.ceylon.compiler.java.metadata.Annotation;
import com.redhat.ceylon.compiler.java.metadata.Annotations;
import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.Name;
import com.redhat.ceylon.compiler.java.metadata.SatisfiedTypes;
import com.redhat.ceylon.compiler.java.metadata.Sequenced;
import com.redhat.ceylon.compiler.java.metadata.TypeInfo;
import com.redhat.ceylon.compiler.java.metadata.TypeParameter;
import com.redhat.ceylon.compiler.java.metadata.TypeParameters;
import com.redhat.ceylon.compiler.java.metadata.Variance;

@Ceylon(major = 2)
@TypeParameters(@TypeParameter(value = "Element", variance = Variance.OUT))
@SatisfiedTypes({
    "ceylon.language.List<Element>",
    "ceylon.language.Some<Element>",
    "ceylon.language.Ranged<ceylon.language.Integer,ceylon.language.Empty|ceylon.language.Sequence<Element>>",
    "ceylon.language.Cloneable<ceylon.language.Sequence<Element>>"
})
public interface Sequence<Element> 
        extends List<Element>, Some<Element> {
    
    @Annotations({@Annotation("actual"), @Annotation("default")})
    @Override
    @TypeInfo("ceylon.language.Integer")
    public Integer getLastIndex();
    
    @Annotations({@Annotation("actual"), @Annotation("formal")})
    @Override
    public Element getFirst();
    
    @Annotations(@Annotation("default"))
    public Element getLast();

    @Annotations({@Annotation("actual"), @Annotation("formal")})
    @Override
    @TypeInfo("ceylon.language.Empty|ceylon.language.Sequence<Element>")
    public FixedSized<? extends Element> getRest();
    
    @Annotations({@Annotation("actual"), @Annotation("formal")})
    @Override
    public Sequence<? extends Element> getReversed();
    
    @Annotations({@Annotation("actual")})
    @Override
    public Sequence<? extends Element> getSequence();
    
    /*@Override
    @TypeInfo("ceylon.language.Empty|ceylon.language.Sequence<Element>")
    public List<? extends Element> span(@Name("from") Integer from, 
            @TypeInfo("ceylon.language.Nothing|ceylon.language.Integer")
            @Name("to") Integer to);
    
    @Override
    @TypeInfo("ceylon.language.Empty|ceylon.language.Sequence<Element>")
    public List<? extends Element> segment(@Name("from") Integer from, 
            @Name("length") Integer length);*/
    
    @SuppressWarnings("rawtypes")
    @Annotations({@Annotation("actual"), @Annotation("default")})
    @TypeParameters(@TypeParameter("Other"))
    @TypeInfo("ceylon.language.Sequence<Element|Other>")
    public <Other> Sequence withLeading(@Name("elements")
            @TypeInfo("ceylon.language.Iterable<Other>")
            @Sequenced Iterable<? extends Other> elements);

    @SuppressWarnings("rawtypes")
    @Annotations({@Annotation("actual"), @Annotation("default")})
    @TypeParameters(@TypeParameter("Other"))
    @TypeInfo("ceylon.language.Sequence<Element|Other>")
    public <Other> Sequence withTrailing(@Name("elements")
            @TypeInfo("ceylon.language.Iterable<Other>")
            @Sequenced Iterable<? extends Other> elements);

    @SuppressWarnings("rawtypes")
    @Ignore public <Other>Sequence withLeading();
    @SuppressWarnings("rawtypes")
    @Ignore public <Other>Sequence withTrailing();

    @Ignore public <Other>Iterable<? extends Other> withLeading$elements();
    @Ignore public <Other>Iterable<? extends Other> withTrailing$elements();

}
