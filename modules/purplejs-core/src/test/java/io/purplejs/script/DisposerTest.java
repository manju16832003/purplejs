package io.purplejs.script;

import org.junit.Test;

import io.purplejs.core.resource.ResourcePath;
import io.purplejs.core.value.ScriptExports;

import static org.junit.Assert.*;

public class DisposerTest
    extends AbstractScriptTest
{
    @Test
    public void testDispose()
    {
        setRunDisposer( false );

        final ResourcePath path = ResourcePath.from( "/disposer/disposer-test.js" );
        final ScriptExports exports = run(  "/disposer/disposer-test.js" );

        assertNotNull( exports );
        assertEquals( path, exports.getResource() );
        assertEquals( false, exports.executeMethod( "isExecuted" ).getValue() );

        getEngine().dispose();
        assertEquals( true, exports.executeMethod( "isExecuted" ).getValue() );
    }
}
