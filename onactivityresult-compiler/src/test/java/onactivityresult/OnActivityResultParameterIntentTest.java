package onactivityresult;

import org.junit.Test;

@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class OnActivityResultParameterIntentTest {
    @Test
    public void testOnActivityResult() {
        //@formatter:off
        TestActivity.create().hasIntent().build(
            "@OnActivityResult(requestCode = 3) public void test(final Intent intent) {}"
        ).generatesBody(
            "if (requestCode == 3) {",
                "t.test(intent);",

                "didHandle = true;",
            "}"
        );
        //@formatter:on
    }

    @Test
    public void testOnActivityResultSameRequestCode() {
        //@formatter:off
        TestActivity.create().hasIntent().build(
            "@OnActivityResult(requestCode = 10) public void bar(final Intent intent) {}",
            "@OnActivityResult(requestCode = 10) public void foo(final Intent intent) {}"
        ).generatesBody(
            "if (requestCode == 10) {",
                "t.bar(intent);",
                "t.foo(intent);",

                "didHandle = true;",
            "}"
        );
        //@formatter:on
    }

    @Test
    public void testOnActivityResultDifferentRequestCode() {
        //@formatter:off
        TestActivity.create().hasIntent().build(
            "@OnActivityResult(requestCode = 10) public void bar(final Intent intent) {}",
            "@OnActivityResult(requestCode = 11) public void foo(final Intent intent) {}",
            "@OnActivityResult(requestCode = 12) public void abc(final Intent intent) {}"
        ).generatesBody(
            "if (requestCode == 10) {",
                "t.bar(intent);",

                "didHandle = true;",
            "} else if (requestCode == 11) {",
                "t.foo(intent);",

                "didHandle = true;",
            "} else if (requestCode == 12) {",
                "t.abc(intent);",

                "didHandle = true;",
            "}"
        );
        //@formatter:on
    }
}
