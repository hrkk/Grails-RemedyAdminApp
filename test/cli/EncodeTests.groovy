import grails.test.AbstractCliTestCase

class EncodeTests extends AbstractCliTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testEncode() {

        execute(["encode"])

        assertEquals 0, waitForProcess()
        verifyHeader()
    }
}
