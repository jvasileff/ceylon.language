package ceylon.language;

import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Method;

@Ceylon(major = 2)
@Method
public final class actual {
    public static Nothing actual(){
        return null;
    }
    private actual(){}
}
